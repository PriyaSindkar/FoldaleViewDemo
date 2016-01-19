package com.example.priyasindkar.foldaleviewdemo;

/**
 * Created by priyasindkar on 18-01-2016.
 */

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import se.emilsjolander.flipview.FlipView;

/**
 * Created by Admin on 11-12-2015.
 */
public class TabFragment extends Fragment implements FlipView.OnFlipListener {
    private FlipView mFlipView;
    private FlipAdapter mAdapter;
    private TextView txtHeader;
    private ImageView icon;
    int[] images = new int[]{R.drawable.books,/* R.drawable.images, R.drawable.android,*/ R.drawable.android2};

    private static String ARG_PARAM1 = "TAB";
    private static String ARG_PARAM2 = "PAGE_POS";
    private String tabName = "DEFAULT";
    private int selectedPos = -1;
    private Activity activity;
    private boolean isVisible = true;

    Callback _callback;

    public interface Callback {
        public void onPageRequested(int page);
    }

    public TabFragment() {
    }

    public static TabFragment newInstance(String param1, int param2) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        Log.e("TAG", "OnCreate " + tabName);
        activity = getActivity();
        if (getArguments() != null) {
            tabName = getArguments().getString(ARG_PARAM1);
            selectedPos = getArguments().getInt(ARG_PARAM2);
        }
        mAdapter = new FlipAdapter(activity);
        mFlipView = (FlipView) view.findViewById(R.id.flip_view);

        txtHeader = (TextView) view.findViewById(R.id.txtHeader);
        icon = (ImageView) view.findViewById(R.id.icon);
        mFlipView.setOnFlipListener(this);
        mFlipView.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnResume", "onResume "+ tabName);

    }

    /*@Override
    public void onPageRequested(int page) {
        Log.e("TAB", "onPageRequested " + page);
        mFlipView.smoothFlipBy(page);
    }*/

    @Override
    public void onFlippedToPage(FlipView v, int position, long id) {
        Log.e("TAB", "onFlippedToPage " + tabName);
        txtHeader.setText("Page No.: " + position);
        icon.setImageResource(images[position]);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if(mFlipView !=null)
            mFlipView.flipTo(0);
        if (isVisibleToUser) {
            Log.e("TAG", "VISIBLE " + tabName);

        } else {
            Log.e("TAG", "INVISIBLE " + tabName);
        }
    }

}
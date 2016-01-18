package com.example.priyasindkar.foldaleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import se.emilsjolander.flipview.FlipView;

public class MainActivity extends AppCompatActivity implements FlipView.OnFlipListener {

    private FlipView mFlipView;
    private FlipAdapter mAdapter;
    private TextView txtHeader;
    private ImageView icon;
    int[] images = new int[] {R.drawable.books, R.drawable.images, R.drawable.android, R.drawable.android2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new FlipAdapter(this);
        mFlipView = (FlipView) findViewById(R.id.flip_view);
        txtHeader = (TextView) findViewById(R.id.txtHeader);
        icon  =(ImageView) findViewById(R.id.icon);
        mFlipView.setOnFlipListener(this);
        //mAdapter.setCallback(this);
        mFlipView.setAdapter(mAdapter);

    }

    @Override
    public void onFlippedToPage(FlipView v, int position, long id) {
        Log.e("pageflip", "Page: " + position);
        txtHeader.setText("Page No.: " + position);
        icon.setImageResource(images[position]);
        /*if(position > mFlipView.getPageCount()-3 && mFlipView.getPageCount()<30){
            mAdapter.addItems(5);
        }*/
    }

    /*@Override
    public void onPageRequested(int page) {
        mFlipView.smoothFlipTo(page);
    }*/
}

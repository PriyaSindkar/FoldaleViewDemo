package com.example.priyasindkar.foldaleviewdemo;

/**
 * Created by priyasindkar on 18-01-2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by Admin on 11-12-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int sp;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      /*  switch (position) {
            case 0:*/
                //TabFragment fragment = TabFragment.newInstance("TAB " + (position + 1), position);

                return TabFragment.newInstance("TAB " + (position + 1), 0);
            /*case 1:
                return TabFragment.newInstance("TAB " + (position + 1), 1);
            case 2:
                return TabFragment.newInstance("TAB " + (position + 1), 2);
            case 3:
                return TabFragment.newInstance("TAB " + (position + 1), 3);
            default:
                return TabFragment.newInstance("TAB " + (position + 1), 0);
        } */
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(POSITION_NONE);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}

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
    String[] tabTitles ;

    public ViewPagerAdapter(FragmentManager fm, String[] _titles) {
        super(fm);
        tabTitles = _titles;
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
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
         return tabTitles[position];
    }

    @Override
    public int getCount() {
        return 3;
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

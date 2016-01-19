package com.example.priyasindkar.foldaleviewdemo;

/**
 * Created by priyasindkar on 18-01-2016.
 */
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PagerActivity extends AppCompatActivity {

    //Declaring All The Variables Needed

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pager);

        /*
        Assigning view variables to thier respective view in xml
        by findViewByID method
         */

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        /*
        Creating Adapter and setting that adapter to the viewPager
        setSupportActionBar method takes the toolbar and sets it as
        the default action bar thus making the toolbar work like a normal
        action bar.
         */
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), new String[] {"Tab 1","Tab 2","Tab 3"});
        viewPager.setAdapter(viewPagerAdapter);

        /*
        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
        which is below the tabs, its the tab itself.
         */

        /*final TabLayout.Tab tab1 = tabLayout.newTab();
        final TabLayout.Tab tab2 = tabLayout.newTab();*/
       /* final TabLayout.Tab tab3 = tabLayout.newTab();
        final TabLayout.Tab tab4 = tabLayout.newTab()*/;

        /*
        Setting Title text for our tabs respectively
         */

     /*   tab1.setText("Tab 1");
        tab2.setText("Tab 2");*/
       /* tab3.setText("Tab 3");
        tab4.setText("Tab 4");
*/
        /*
        Adding the tab view to our tablayout at appropriate positions
        As I want home at first position I am passing home and 0 as argument to
        the tablayout and like wise for other tabs as well
         */
       /* tabLayout.addTab(tab1, 0);
        tabLayout.addTab(tab2, 1);*/
       /* tabLayout.addTab(tab3, 2);
        tabLayout.addTab(tab4, 3);*/

        /*
        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
        tab change colors in different situations such as selected, active, inactive etc

        TabIndicatorColor sets the color for the indiactor below the tabs
         */


        //divider
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(Color.parseColor("#ff0000"));
        for (int i = 0; i < tabLayout.getTabCount(); i++) {

           // if(i!=0) {
                TabLayout.Tab tab = tabLayout.getTabAt(i);
                RelativeLayout relativeLayout = (RelativeLayout)
                        LayoutInflater.from(this).inflate(R.layout.tab_item, tabLayout, false);
            View line = (View) relativeLayout.findViewById(R.id.line);

            if(i==0){
                    line.setVisibility(View.GONE);
                }else{
                    line.setVisibility(View.VISIBLE);
                }

                TextView tabTextView = (TextView) relativeLayout.findViewById(R.id.tab_title);
                tabTextView.setText(tab.getText());
                tab.setCustomView(relativeLayout);
                 tab.select();

            //
          //  }
        }
        viewPager.setCurrentItem(0);


        /*
        Adding a onPageChangeListener to the viewPager
        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
        changes when a viewpager page changes.
         */

        //viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("PAGE_SELECTED", position + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}
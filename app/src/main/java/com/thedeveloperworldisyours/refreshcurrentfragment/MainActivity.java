package com.thedeveloperworldisyours.refreshcurrentfragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thedeveloperworldisyours.refreshcurrentfragment.adapter.MyPagerAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    MyPagerAdapter mAdapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_main_view_pager);
        mAdapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapterViewPager);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        Fragment fragment = mAdapterViewPager.getFragment(position);
        if (fragment != null) {
            fragment.onResume();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

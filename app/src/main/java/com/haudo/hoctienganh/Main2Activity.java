package com.haudo.hoctienganh;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.haudo.indicatorlibrary.IndicatorInterface;
import com.haudo.indicatorlibrary.IndicatorView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ViewPager viewPager;
    IndicatorView indicatorView;
    AdapterViewPager adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicatorView = (IndicatorView) findViewById(R.id.indicator);

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapterViewPager = new AdapterViewPager(fragmentManager);

        adapterViewPager.addFragment(new FragmentEx(), "Fragment 1");
        adapterViewPager.addFragment(new FragmentEx(), "Fragment 2");
        adapterViewPager.addFragment(new FragmentEx(), "Fragment 3");
        adapterViewPager.addFragment(new FragmentEx(), "Fragment 4");
        adapterViewPager.addFragment(new FragmentEx(), "Fragment 5");
        adapterViewPager.addFragment(new FragmentEx(), "Fragment 6");

        viewPager.setAdapter(adapterViewPager);

        try {
            indicatorView.setViewPager(viewPager);

        } catch (IndicatorInterface.PagesLessException e) {
            e.printStackTrace();
        }

    }

    private class AdapterViewPager extends FragmentStatePagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> listTitle = new ArrayList<>();

        public AdapterViewPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listTitle.get(position);
        }

        public void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            listTitle.add(title);
        }
    }
}

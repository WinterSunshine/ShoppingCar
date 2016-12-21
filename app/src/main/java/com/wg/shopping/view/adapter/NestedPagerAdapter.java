package com.wg.shopping.view.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wg.shopping.view.fragment.NestedFragment;

/**
 * Created by Mark on 16/5/7.
 */
public class NestedPagerAdapter extends FragmentPagerAdapter
{
    private FragmentManager fm;
    private String[] titles = {"电子", "食品", "日用品", "酒类"};
    private NestedFragment[] fragments = {new NestedFragment("电子"), new NestedFragment("食品"),new NestedFragment("日用品"), new NestedFragment("酒类")};

    public NestedPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position)
    {
        return fragments[position];
    }

    @Override
    public int getCount()
    {
        return titles.length;
    }
}

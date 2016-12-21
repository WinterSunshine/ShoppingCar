package com.wg.shopping.view.fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wg.shopping.R;
import com.wg.shopping.view.adapter.NestedPagerAdapter;
import com.wg.shopping.view.base.BaseFragment;

import static com.wg.shopping.R.id.tabLayout;
import static com.wg.shopping.R.id.viewPager;

public class HomeFragment extends BaseFragment
{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return super.createView(inflater.inflate(R.layout.fragment_home, container, false));
    }

    @Override
    protected void findWidgets()
    {
        mViewPager = findView(viewPager);
        mTabLayout = findView(tabLayout);
    }

    @Override
    protected void initComponent()
    {
        NestedPagerAdapter myPagerAdapter = new NestedPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}

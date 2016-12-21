package com.wg.shopping.view.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wg.shopping.view.fragment.DiscountFragment;
import com.wg.shopping.view.fragment.FullCutFragment;

/**
 * Created by Mark on 16/5/7.
 */
public class UserPagerAdapter extends FragmentPagerAdapter
{
    private FragmentManager fm;
    private String[] titles = {"折扣", "优惠"};
    private Fragment[] fragments = {new DiscountFragment(), new FullCutFragment()};

    public UserPagerAdapter(FragmentManager fm)
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

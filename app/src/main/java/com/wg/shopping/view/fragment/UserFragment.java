package com.wg.shopping.view.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wg.shopping.R;
import com.wg.shopping.view.activity.AddDiscountActivity;
import com.wg.shopping.view.adapter.UserPagerAdapter;
import com.wg.shopping.view.base.BaseFragment;

import static com.wg.shopping.R.id.iv_add;
import static com.wg.shopping.R.id.user_pager;
import static com.wg.shopping.R.id.user_tab;

public class UserFragment extends BaseFragment
{
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mAddImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return super.createView(inflater.inflate(R.layout.fragment_user, container, false));
    }

    @Override
    protected void findWidgets()
    {
        mViewPager = findView(user_pager);
        mTabLayout = findView(user_tab);
        mAddImg = findView(iv_add);
    }

    @Override
    protected void initComponent()
    {
        UserPagerAdapter myPagerAdapter = new UserPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.setOffscreenPageLimit(1);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initListener()
    {
        mAddImg.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), AddDiscountActivity.class);
                startActivity(intent);
            }
        });
    }
}

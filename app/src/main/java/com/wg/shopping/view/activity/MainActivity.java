package com.wg.shopping.view.activity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.wg.shopping.R;
import com.wg.shopping.base.tools.ToastUtils;
import com.wg.shopping.view.base.BaseActivity;
import com.wg.shopping.view.custom.FragmentTabHost;
import com.wg.shopping.view.fragment.HomeFragment;
import com.wg.shopping.view.fragment.ShoppingCarFragment;
import com.wg.shopping.view.fragment.UserFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity
{
    private FragmentTabHost mTabHost;
    private long exitTime = 0;
    private static final String ALPHA_NORMAL = "normal";
    private static final String ALPHA_SELECTED = "selected";
    private static final int TAB_COUNT = 3;
    private List<Map<String, View>> tabViews = new ArrayList<Map<String, View>>();

    @Override
    protected void onResume()
    {
        super.onResume();
        setTabSelectedState(mTabHost.getCurrentTab(), TAB_COUNT);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.onCreateView(R.layout.activity_main);
    }

    @Override
    protected void findWidgets()
    {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

    @Override
    protected void initComponent()
    {
        initTabHost();
    }

    @Override
    protected void initListener()
    {
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            @Override
            public void onTabChanged(String tabId)
            {
                int index = -1;
                switch(tabId)
                {
                    case "Home":
                        index = 0;
                        break;
                    case "ShoppingCar":
                        index = 1;
                        break;
                    case "User":
                        index = 2;
                        break;
                }
                setTabSelectedState(index, TAB_COUNT);
            }
        });
    }

    public FragmentTabHost getTabHost()
    {
        return mTabHost;
    }

    private void initTabHost()
    {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("Home").setIndicator(createIndicatorView(R.mipmap.m_tab_home_normal, R.mipmap.m_tab_home_selected, "首页")), HomeFragment.class, new Bundle());
        mTabHost.addTab(mTabHost.newTabSpec("ShoppingCar").setIndicator(createIndicatorView(R.mipmap.m_tab_activities_normal, R.mipmap.m_tab_activities_selected, "购物车")), ShoppingCarFragment.class, new Bundle());
        mTabHost.addTab(mTabHost.newTabSpec("User").setIndicator(createIndicatorView(R.mipmap.m_tab_my_normal, R.mipmap.m_tab_my_selected, "个人")), UserFragment.class, new Bundle());
        mTabHost.getTabWidget().setDividerDrawable(R.color.white);
    }

    @SuppressLint("InflateParams")
    private View createIndicatorView(int normalRes, int selectorRes, String indictorName)
    {
        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.item_main_bottom_nav, null);
        TextView normal_tv = (TextView) tabIndicator.findViewById(R.id.normal_tv);
        TextView selected_tv = (TextView) tabIndicator.findViewById(R.id.selected_tv);
        normal_tv.setText(indictorName);
        selected_tv.setText(indictorName);
        ImageView normal_iv = (ImageView) tabIndicator.findViewById(R.id.normal_iv);
        ImageView selected_iv = (ImageView) tabIndicator.findViewById(R.id.selected_iv);
        normal_iv.setImageResource(normalRes);
        selected_iv.setImageResource(selectorRes);
        View normal_layout = tabIndicator.findViewById(R.id.normal_layout);
        normal_layout.setAlpha(1f);
        View selected_layout = tabIndicator.findViewById(R.id.selected_layout);
        selected_layout.setAlpha(0f);
        Map<String, View> map = new HashMap<String, View>();
        map.put(ALPHA_NORMAL, normal_layout);
        map.put(ALPHA_SELECTED, selected_layout);
        tabViews.add(map);
        return tabIndicator;
    }

    private void setTabSelectedState(int index, int tabCount)
    {
        for(int i = 0; i < tabCount; i++)
        {
            if(i == index)
            {
                tabViews.get(i).get(ALPHA_NORMAL).setAlpha(0f);
                tabViews.get(i).get(ALPHA_SELECTED).setAlpha(1f);
            }else
            {
                tabViews.get(i).get(ALPHA_NORMAL).setAlpha(1f);
                tabViews.get(i).get(ALPHA_SELECTED).setAlpha(0f);
            }
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event)
    {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK)
        {
            if(event.getAction() == KeyEvent.ACTION_DOWN&&event.getRepeatCount() == 0)
            {
                if(TextUtils.equals(mTabHost.getCurrentTabTag(), "Home"))
                {
                    exitApp();
                }else
                {
                    mTabHost.setCurrentTabByTag("Home");
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private void exitApp()
    {
        if((System.currentTimeMillis() - exitTime) > 2000)
        {
            ToastUtils.show("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        }else
        {
            getApplication().onTerminate();
        }
    }
}

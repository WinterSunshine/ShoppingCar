package com.wg.shopping.view.base;
import android.support.v4.app.Fragment;
import android.view.View;

import com.wg.shopping.base.tools.ReflectUtils;
import com.wg.shopping.base.tools.ToastUtils;

public abstract class BaseFragment extends Fragment
{
    protected View mView;

    protected abstract void findWidgets();

    @Override
    public void onResume()
    {
        super.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    protected View createView(View view)
    {
        this.mView = view;
        findWidgets();
        initComponent();
        initListener();
        initHandler();
        excuteOther();
        asyncRetrive();
        return mView;
    }

    @SuppressWarnings("unchecked")
    protected <T> T findView(int id)
    {
        return (T) mView.findViewById(id);
    }

    /**
     * 初始化Component，子类根据需要自行重写
     */
    protected void initComponent()
    {
        return;
    }

    /**
     * 初始化Listener，子类根据需要自行重写
     */
    protected void initListener()
    {
        return;
    }

    /**
     * 初始化Handler，子类根据需要自行重写
     */
    protected void initHandler()
    {
        return;
    }

    /**
     * 做一些其他的事情，如开启一个定时器或者线程、getIntentExtra、显示一个WebPage等等..
     */
    protected void excuteOther()
    {
        return;
    }

    /**
     * 异步查询网络数据，子类根据需要自行重写
     */
    protected void asyncRetrive()
    {
        return;
    }

    /**
     * 重试查询网络数据，子类根据需要自行重写
     */
    protected void retryRetrive()
    {
        ReflectUtils.invokeMethod(this, "asyncRetrive");
    }

    /**
     * 显示失败信息，默认显示吐司，子类有需要显示界面可自行重写
     */
    protected void showErrorMessage(Integer errorCode, String errorMessage)
    {
        ToastUtils.show(errorMessage);
    }
}

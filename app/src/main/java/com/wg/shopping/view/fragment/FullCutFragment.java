package com.wg.shopping.view.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wg.shopping.R;
import com.wg.shopping.model.MyFullCutListBean;
import com.wg.shopping.view.adapter.BaseQuickAdapter;
import com.wg.shopping.view.adapter.BaseViewHolder;
import com.wg.shopping.view.base.BaseFragment;
import com.wg.shopping.view.custom.XListView;

public class FullCutFragment extends BaseFragment
{
    private XListView mAvailableCouponXList;
    private BaseQuickAdapter<MyFullCutListBean.MyFullCutBean> mAvailableCouponAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return super.createView(inflater.inflate(R.layout.fragment_full_cut, container, false));
    }

    @Override
    protected void findWidgets()
    {
        mAvailableCouponXList = findView(R.id.xlv_available_coupon);
    }

    @Override
    protected void initComponent()
    {
        mAvailableCouponXList.setPullRefreshEnable(false);
        mAvailableCouponXList.setPullLoadEnable(false);
        initAdapter();
    }

    @Override
    protected void asyncRetrive()
    {
        refresh();
    }

    private void initAdapter()
    {
        mAvailableCouponAdapter = new BaseQuickAdapter<MyFullCutListBean.MyFullCutBean>(getActivity(), mAvailableCouponXList, R.layout.item_my_full_cut)
        {
            @Override
            public void convert(int position, BaseViewHolder helper, MyFullCutListBean.MyFullCutBean item)
            {
                helper.setText(R.id.tv_my_full_cut_title, item.getFullCutTitle());
                helper.setText(R.id.tv_my_full_cut_valid_time_content, item.getValidTime());
            }
        };
        mAvailableCouponXList.setAdapter(mAvailableCouponAdapter);
    }

    private void refresh()
    {
        MyFullCutListBean myFullCutListBean = new MyFullCutListBean();
        MyFullCutListBean.MyFullCutBean bean1 = myFullCutListBean.new MyFullCutBean("满500减100", "截止日期:2016.10.31", "7折");
        MyFullCutListBean.MyFullCutBean bean2 = myFullCutListBean.new MyFullCutBean("满1000减200", "截止日期:2016.10.31", "8折");
        myFullCutListBean.getCoupons().add(bean1);
        myFullCutListBean.getCoupons().add(bean2);
        mAvailableCouponAdapter.pullRefresh(myFullCutListBean.getCoupons());
    }
}

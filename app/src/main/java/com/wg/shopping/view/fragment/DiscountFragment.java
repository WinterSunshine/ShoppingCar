package com.wg.shopping.view.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wg.shopping.R;
import com.wg.shopping.model.MyCouponsListBean;
import com.wg.shopping.view.adapter.BaseQuickAdapter;
import com.wg.shopping.view.adapter.BaseViewHolder;
import com.wg.shopping.view.base.BaseFragment;
import com.wg.shopping.view.custom.XListView;

public class DiscountFragment extends BaseFragment
{
    private XListView mAvailableCouponXList;
    private BaseQuickAdapter<MyCouponsListBean.MyCouponsBean> mAvailableCouponAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return super.createView(inflater.inflate(R.layout.fragment_discount, container, false));
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
        mAvailableCouponAdapter = new BaseQuickAdapter<MyCouponsListBean.MyCouponsBean>(getActivity(), mAvailableCouponXList, R.layout.item_my_coupon)
        {
            @Override
            public void convert(int position, BaseViewHolder helper, MyCouponsListBean.MyCouponsBean item)
            {
                helper.setText(R.id.tv_my_coupon_price, item.getFaceValue());
                helper.setText(R.id.tv_my_coupon_title, item.getCouponTitle());
                helper.setText(R.id.tv_my_coupon_valid_time_content, item.getValidTime());
            }
        };
        mAvailableCouponXList.setAdapter(mAvailableCouponAdapter);
    }

    private void refresh()
    {
        MyCouponsListBean myCouponsListBean = new MyCouponsListBean();
        MyCouponsListBean.MyCouponsBean bean1 = myCouponsListBean.new MyCouponsBean("电子类折扣", "截止日期:2016.10.31", "7折");
        MyCouponsListBean.MyCouponsBean bean2 = myCouponsListBean.new MyCouponsBean("日用品折扣", "截止日期:2016.10.31", "8折");
        myCouponsListBean.getCoupons().add(bean1);
        myCouponsListBean.getCoupons().add(bean2);
        mAvailableCouponAdapter.pullRefresh(myCouponsListBean.getCoupons());
    }
}

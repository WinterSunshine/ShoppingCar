package com.wg.shopping.view.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wg.shopping.R;
import com.wg.shopping.base.tools.CacheUtils;
import com.wg.shopping.base.tools.MathUtils;
import com.wg.shopping.model.NestedListBean;
import com.wg.shopping.view.adapter.BaseQuickAdapter;
import com.wg.shopping.view.adapter.BaseViewHolder;
import com.wg.shopping.view.base.BaseFragment;
import com.wg.shopping.view.custom.ShoppingList;

public class ShoppingCarFragment extends BaseFragment
{
    private ShoppingList mXListView;
    private TextView sumMoneytTxt;
    private BaseQuickAdapter<NestedListBean.NestBean> baseQuickAdapter;

    @Override
    public void onResume()
    {
        super.onResume();
        refreshPageView();
        refreshSumMoney();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return super.createView(inflater.inflate(R.layout.fragment_shopping_car, container, false));
    }

    @Override
    protected void findWidgets()
    {
        mXListView = findView(R.id.xlv_shopping_list);
        sumMoneytTxt = findView(R.id.tv_shoping_cart_sum_money);
    }

    @Override
    protected void initComponent()
    {
        initAdapter();
        refreshPageView();
    }

    private void initAdapter()
    {
        baseQuickAdapter = new BaseQuickAdapter<NestedListBean.NestBean>(getActivity(), R.layout.item_shopping_car)
        {
            @Override
            public void convert(final int positon, final BaseViewHolder helper, final NestedListBean.NestBean item)
            {
                helper.setText(R.id.tv_shopping_title, item.getTitle());
                helper.setText(R.id.tv_shopping_price, item.getPrice());
                helper.setText(R.id.tv_shopping_good_num, item.getAddNum().toString());
                helper.setOnClickListener(R.id.btn_shopping_add, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        item.increase();
                        helper.setText(R.id.tv_shopping_good_num, item.getAddNum().toString());
                        refreshSumMoney();
                    }
                });
                helper.setOnClickListener(R.id.btn_shopping_minus, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        item.discrease();
                        helper.setText(R.id.tv_shopping_good_num, item.getAddNum().toString());
                        refreshSumMoney();
                    }
                });
            }
        };
        mXListView.setAdapter(baseQuickAdapter);
    }

    public void refreshPageView()
    {
        baseQuickAdapter.refreshGridOrListViews(CacheUtils.getAddData().getList());
    }

    public void refreshSumMoney()
    {
        sumMoneytTxt.setText(MathUtils.calcSumMoney(CacheUtils.getAddData()));
    }
}

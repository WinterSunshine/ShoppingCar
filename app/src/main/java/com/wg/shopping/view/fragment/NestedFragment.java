package com.wg.shopping.view.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wg.shopping.R;
import com.wg.shopping.base.tools.CacheUtils;
import com.wg.shopping.base.tools.ToastUtils;
import com.wg.shopping.model.NestedListBean;
import com.wg.shopping.view.adapter.BaseQuickAdapter;
import com.wg.shopping.view.adapter.BaseViewHolder;
import com.wg.shopping.view.base.BaseFragment;
import com.wg.shopping.view.custom.XListView;

public class NestedFragment extends BaseFragment
{
    private XListView mXListView;
    private BaseQuickAdapter<NestedListBean.NestBean> baseQuickAdapter;
    private NestedListBean data;

    public NestedFragment(String title)
    {
        super();
        this.data = CacheUtils.getData(title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return super.createView(inflater.inflate(R.layout.fragment_nested, container, false));
    }

    @Override
    protected void findWidgets()
    {
        mXListView = findView(R.id.xlv_nested_list);
    }

    @Override
    protected void initComponent()
    {
        mXListView.setPullRefreshEnable(false);
        mXListView.setPullLoadEnable(false);
        initAdapter();
        refreshPageView();
    }

    private void initAdapter()
    {
        baseQuickAdapter = new BaseQuickAdapter<NestedListBean.NestBean>(getActivity(), mXListView, R.layout.item_home_goods)
        {
            @Override
            public void convert(final int positon, BaseViewHolder helper, final NestedListBean.NestBean item)
            {
                helper.setText(R.id.tv_item_common_title, item.getTitle());
                helper.setText(R.id.tv_item_common_price, item.getPrice());
                helper.setOnClickListener(R.id.iv_item_common_add, new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        ToastUtils.show("添加商品成功");
                        NestedListBean.NestBean clickItem = baseQuickAdapter.getItem(positon);
                        CacheUtils.add(clickItem);
                    }
                });
            }
        };
        mXListView.setAdapter(baseQuickAdapter);
    }

    public void refreshPageView()
    {
        baseQuickAdapter.pullRefresh(data.getList());
    }
}

package com.wg.shopping.view.activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.wg.shopping.R;
import com.wg.shopping.base.tools.ToastUtils;
import com.wg.shopping.model.BottomListBean;
import com.wg.shopping.view.adapter.BaseQuickAdapter;
import com.wg.shopping.view.adapter.BaseViewHolder;
import com.wg.shopping.view.base.BaseActivity;
import com.wg.shopping.view.custom.BottomPopView;

public class AddDiscountActivity extends BaseActivity
{
    private TextView addDiscountTxt;
    private TextView addFullCutTxt;
    private BottomPopView mBottomPopView;
    private ListView mBottomViewList;
    private BaseQuickAdapter<BottomListBean.BottomItemBean> baseQuickAdapter;
    private BottomListBean disCountBean = new BottomListBean();
    private BottomListBean fullCutBean = new BottomListBean();
    {
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("1折"));
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("2折"));
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("3折"));
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("4折"));
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("5折"));
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("6折"));
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("7折"));
        disCountBean.getTypes().add(disCountBean.new BottomItemBean("8折"));
        fullCutBean.getTypes().add(fullCutBean.new BottomItemBean("满500减100"));
        fullCutBean.getTypes().add(fullCutBean.new BottomItemBean("满1000减200"));
        fullCutBean.getTypes().add(fullCutBean.new BottomItemBean("满2000减300"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.onCreateView(R.layout.activity_add_discount);
    }

    @Override
    protected void findWidgets()
    {
        addDiscountTxt = findView(R.id.add_discount);
        addFullCutTxt = findView(R.id.add_full_cut);
        mBottomPopView = new BottomPopView(this, R.layout.panel_common_bottom_view_list);
        mBottomViewList = (ListView) mBottomPopView.getView().findViewById(R.id.xlv_bottom_view_list);
    }

    @Override
    protected void initComponent()
    {
        initAdapter();
    }

    @Override
    protected void initListener()
    {
        addDiscountTxt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mBottomViewList.setAdapter(baseQuickAdapter);
                baseQuickAdapter.refreshGridOrListViews(disCountBean.getTypes());
                mBottomPopView.showBottomView(true);
            }
        });
        addFullCutTxt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mBottomViewList.setAdapter(baseQuickAdapter);
                baseQuickAdapter.refreshGridOrListViews(fullCutBean.getTypes());
                mBottomPopView.showBottomView(true);
            }
        });
        mBottomViewList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ToastUtils.show("添加优惠成功，时间关系并不做真正添加，以固定优惠演示");
                mBottomPopView.dismissBottomView();
            }
        });
    }

    private void initAdapter()
    {
        baseQuickAdapter = new BaseQuickAdapter<BottomListBean.BottomItemBean>(this, R.layout.item_common_bottom_view)
        {
            @Override
            public void convert(int positon, BaseViewHolder helper, final BottomListBean.BottomItemBean item)
            {
                helper.setText(R.id.tv_bottom_view_item, item.getItem());
            }
        };
        mBottomViewList.setAdapter(baseQuickAdapter);
        baseQuickAdapter.refreshGridOrListViews(disCountBean.getTypes());
    }
}

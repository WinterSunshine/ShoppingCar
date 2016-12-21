package com.wg.shopping.base.tools;
import com.wg.shopping.model.NestedListBean;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Edison on 2016/10/26.
 */
public class MathUtilsTest
{
    @Test
    public void calcSumMoney() throws Exception
    {
        NestedListBean bean = new NestedListBean();
        NestedListBean.NestBean item1 = bean.new NestBean("ipad", "2399.00", 1);
        NestedListBean.NestBean item2 = bean.new NestBean("面包", "3.00", 2);
        NestedListBean.NestBean item3 = bean.new NestBean("蛋糕", "20.00", 1);
        NestedListBean.NestBean item4 = bean.new NestBean("啤酒", "2.00", 5);
        bean.getList().add(item1);
        bean.getList().add(item2);
        bean.getList().add(item3);
        bean.getList().add(item4);
        assertEquals("1715.3", MathUtils.calcSumMoney(bean));
    }
}
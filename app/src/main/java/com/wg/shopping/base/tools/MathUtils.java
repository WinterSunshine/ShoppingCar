package com.wg.shopping.base.tools;
import com.wg.shopping.model.NestedListBean;

import java.math.BigDecimal;

/**
 * Created by Edison on 2016/10/26.
 */
public class MathUtils
{
    private MathUtils()
    {
    }

    public static String calcSumMoney(NestedListBean bean)
    {
        double sum = 0.0;
        for(NestedListBean.NestBean item : bean.getList())
        {
            String title = item.getTitle();
            double price = Double.parseDouble(item.getPrice());
            double num = item.getAddNum();
            if("ipad、iphone、显示器、笔记本电脑、键盘".contains(title))
            {
                sum = sum + price * num * 0.7;
            }else
            {
                sum = sum + price * num;
            }
        }
        return String.valueOf(saveTwoDecimal(sum));
    }

    /**
     * 浮点数加法保留两位小数
     */
    public static double add(double a, double b)
    {
        BigDecimal b1 = new BigDecimal(a);
        BigDecimal b2 = new BigDecimal(b);
        return saveTwoDecimal(b1.add(b2).doubleValue());
    }

    /**
     * 保留两位小数
     */
    public static double saveTwoDecimal(double totalPrice)
    {
        BigDecimal bigDecimal = new BigDecimal(totalPrice);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

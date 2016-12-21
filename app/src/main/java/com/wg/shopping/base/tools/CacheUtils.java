package com.wg.shopping.base.tools;
import com.wg.shopping.model.NestedListBean;

import java.util.HashMap;
import java.util.Map;

public class CacheUtils
{
    private static NestedListBean addCache = new NestedListBean();
    private static Map<String, NestedListBean> cache = new HashMap<>();

    private CacheUtils()
    {
    }

    static
    {
        NestedListBean electronics = new NestedListBean();
        NestedListBean food = new NestedListBean();
        NestedListBean dailyNeeds = new NestedListBean();
        NestedListBean wine = new NestedListBean();
        onstructElectronics(electronics);
        onstructFood(food);
        onstructDailyNeeds(dailyNeeds);
        constructWine(wine);
        cache.put("电子", electronics);
        cache.put("食品", food);
        cache.put("日用品", dailyNeeds);
        cache.put("酒类", wine);
    }
    public static void add(NestedListBean.NestBean item)
    {
        addCache.addItem(item);
    }

    public static NestedListBean getData(String title)
    {
        NestedListBean nestedListBean = cache.get(title);
        return nestedListBean;
    }

    public static NestedListBean getAddData()
    {
        return addCache;
    }

    private static void onstructElectronics(NestedListBean electronics)
    {
        NestedListBean.NestBean electronicsItem1 = electronics.new NestBean("ipad", "2399.00");
        NestedListBean.NestBean electronicsItem2 = electronics.new NestBean("iphone", "5288.00");
        NestedListBean.NestBean electronicsItem3 = electronics.new NestBean("显示器", "899.00");
        NestedListBean.NestBean electronicsItem4 = electronics.new NestBean("笔记本电脑", "4599.00");
        NestedListBean.NestBean electronicsItem5 = electronics.new NestBean("键盘", "68.00");
        electronics.getList().add(electronicsItem1);
        electronics.getList().add(electronicsItem2);
        electronics.getList().add(electronicsItem3);
        electronics.getList().add(electronicsItem4);
        electronics.getList().add(electronicsItem5);
    }

    private static void onstructFood(NestedListBean food)
    {
        NestedListBean.NestBean foodItem1 = food.new NestBean("面包", "3.00");
        NestedListBean.NestBean foodItem2 = food.new NestBean("饼干", "5.00");
        NestedListBean.NestBean foodItem3 = food.new NestBean("蛋糕", "20.00");
        NestedListBean.NestBean foodItem4 = food.new NestBean("牛肉", "25.00");
        NestedListBean.NestBean foodItem5 = food.new NestBean("鱼肉", "13.00");
        NestedListBean.NestBean foodItem6 = food.new NestBean("蔬菜", "3.00");
        food.getList().add(foodItem1);
        food.getList().add(foodItem2);
        food.getList().add(foodItem3);
        food.getList().add(foodItem4);
        food.getList().add(foodItem5);
        food.getList().add(foodItem6);
    }

    private static void onstructDailyNeeds(NestedListBean dailyNeeds)
    {
        NestedListBean.NestBean dailyNeedsItem1 = dailyNeeds.new NestBean("餐巾纸", "10.00");
        NestedListBean.NestBean dailyNeedsItem2 = dailyNeeds.new NestBean("收纳箱", "20.00");
        NestedListBean.NestBean dailyNeedsItem3 = dailyNeeds.new NestBean("咖啡杯", "5.00");
        NestedListBean.NestBean dailyNeedsItem4 = dailyNeeds.new NestBean("雨伞", "45.00");
        dailyNeeds.getList().add(dailyNeedsItem1);
        dailyNeeds.getList().add(dailyNeedsItem2);
        dailyNeeds.getList().add(dailyNeedsItem3);
        dailyNeeds.getList().add(dailyNeedsItem4);
    }

    private static void constructWine(NestedListBean wine)
    {
        NestedListBean.NestBean wineItem1 = wine.new NestBean("啤酒", "2.00");
        NestedListBean.NestBean wineItem2 = wine.new NestBean("白酒", "150.00");
        NestedListBean.NestBean wineItem3 = wine.new NestBean("伏特加", "230.00");
        wine.getList().add(wineItem1);
        wine.getList().add(wineItem2);
        wine.getList().add(wineItem3);
    }
}

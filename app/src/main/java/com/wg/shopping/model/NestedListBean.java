package com.wg.shopping.model;
import com.wg.shopping.base.tools.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edison on 2016/10/24.
 */
public class NestedListBean
{
    private List<NestBean> list = new ArrayList<>();

    public List<NestBean> getList()
    {
        return list;
    }

    public void setList(List<NestBean> list)
    {
        this.list = list;
    }

    public void addItem(NestBean item)
    {
        try
        {
            NestBean bean = findNestBean(item);
            bean.increase();
        }catch(Exception e)
        {
            item.setAddNum(1);
            list.add(item);
        }
    }

    private NestBean findNestBean(NestBean item)
    {
        for(NestBean nestBean : list)
        {
            if(nestBean.equals(item))
            {
                return nestBean;
            }
        }
        throw new IllegalStateException();
    }

    public class NestBean
    {
        private String title;
        private String price;
        private Integer addNum;

        public NestBean(String title, String price)
        {
            this.title = title;
            this.price = price;
        }

        public NestBean(String title, String price, Integer addNum)
        {
            this.title = title;
            this.price = price;
            this.addNum = addNum;
        }

        public Integer getAddNum()
        {
            return addNum;
        }

        public void setAddNum(Integer addNum)
        {
            this.addNum = addNum;
        }

        public void increase()
        {
            this.addNum++;
        }

        public void discrease()
        {
            this.addNum--;
            if(addNum <= 0)
            {
                this.addNum = 1;
                ToastUtils.show("最小数量为1");
            }
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getPrice()
        {
            return price;
        }

        public void setPrice(String price)
        {
            this.price = price;
        }

        @Override
        public boolean equals(Object obj)
        {
            if(obj == null)
            {
                return false;
            }
            if(this == obj)
            {
                return true;
            }
            if(this.title.equals(obj.toString()))
            {
                return true;
            }
            return false;
        }

        @Override
        public String toString()
        {
            return title;
        }
    }
}

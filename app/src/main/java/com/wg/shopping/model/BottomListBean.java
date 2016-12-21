package com.wg.shopping.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edison on 2016/10/26.
 */
public class BottomListBean
{
    private List<BottomItemBean> types = new ArrayList<>();

    public List<BottomItemBean> getTypes()
    {
        return types;
    }

    public void setTypes(List<BottomItemBean> types)
    {
        this.types = types;
    }

    public class BottomItemBean
    {
        private String item;

        public BottomItemBean(String item)
        {
            this.item = item;
        }

        public String getItem()
        {
            return item;
        }

        public void setItem(String item)
        {
            this.item = item;
        }

        @Override
        public String toString()
        {
            return "BottomItemBean{" +
                    "item='" + item + '\'' +
                    '}';
        }
    }
}

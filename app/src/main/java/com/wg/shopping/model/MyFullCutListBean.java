package com.wg.shopping.model;
import java.util.ArrayList;
import java.util.List;

public class MyFullCutListBean
{
    private List<MyFullCutBean> coupons = new ArrayList<MyFullCutBean>();

    public List<MyFullCutBean> getCoupons()
    {
        return coupons;
    }

    public void setCoupons(List<MyFullCutBean> coupons)
    {
        this.coupons = coupons;
    }

    public class MyFullCutBean
    {
        private String fullCutTitle;
        private String validTime;
        private String faceValue;

        public MyFullCutBean(String fullCutTitle, String validTime, String faceValue)
        {
            this.fullCutTitle = fullCutTitle;
            this.validTime = validTime;
            this.faceValue = faceValue;
        }

        public String getFaceValue()
        {
            return faceValue;
        }

        public void setFaceValue(String faceValue)
        {
            this.faceValue = faceValue;
        }

        public String getFullCutTitle()
        {
            return fullCutTitle;
        }

        public void setFullCutTitle(String fullCutTitle)
        {
            this.fullCutTitle = fullCutTitle;
        }

        public String getValidTime()
        {
            return validTime;
        }

        public void setValidTime(String validTime)
        {
            this.validTime = validTime;
        }

        @Override
        public String toString()
        {
            return "MyCouponsBean{" +
                    "fullCutTitle='" + fullCutTitle + '\'' +
                    ", validTime='" + validTime + '\'' +
                    ", faceValue='" + faceValue + '\'' +
                    '}';
        }
    }
}

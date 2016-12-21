package com.wg.shopping.model;
import java.util.ArrayList;
import java.util.List;

public class MyCouponsListBean
{
    private List<MyCouponsBean> coupons = new ArrayList<MyCouponsBean>();

    public List<MyCouponsBean> getCoupons()
    {
        return coupons;
    }

    public void setCoupons(List<MyCouponsBean> coupons)
    {
        this.coupons = coupons;
    }

    public class MyCouponsBean
    {
        private String couponTitle;
        private String validTime;
        private String faceValue;

        public MyCouponsBean(String couponTitle, String validTime, String faceValue)
        {
            this.couponTitle = couponTitle;
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

        public String getCouponTitle()
        {
            return couponTitle;
        }

        public void setCouponTitle(String couponTitle)
        {
            this.couponTitle = couponTitle;
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
                    "couponTitle='" + couponTitle + '\'' +
                    ", validTime='" + validTime + '\'' +
                    ", faceValue='" + faceValue + '\'' +
                    '}';
        }
    }
}

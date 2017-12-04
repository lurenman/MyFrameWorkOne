package com.example.lurenman.myframeworkone.model.entities;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */

public class HzDataClass
{
    private int ResultCode;
    private Object ResultInfo;
    private String CurTime;
    private List<DataBean> Data;

    public int getResultCode() {
        return ResultCode;
    }

    public void setResultCode(int ResultCode) {
        this.ResultCode = ResultCode;
    }

    public Object getResultInfo() {
        return ResultInfo;
    }

    public void setResultInfo(Object ResultInfo) {
        this.ResultInfo = ResultInfo;
    }

    public String getCurTime() {
        return CurTime;
    }

    public void setCurTime(String CurTime) {
        this.CurTime = CurTime;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        private String FID;
        private String Title;
        private String Image;
        private String Address;
        private int BusinessType;
        private String BusinessName;

        public String getFID() {
            return FID;
        }

        public void setFID(String FID) {
            this.FID = FID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public int getBusinessType() {
            return BusinessType;
        }

        public void setBusinessType(int BusinessType) {
            this.BusinessType = BusinessType;
        }

        public String getBusinessName() {
            return BusinessName;
        }

        public void setBusinessName(String BusinessName) {
            this.BusinessName = BusinessName;
        }
    }
}

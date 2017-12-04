package com.example.lurenman.myframeworkone.model.entities;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/30.
 */

public class RefreshRecommendEntity {

    /**
     * CurTime : 1512024902
     * Data : [{"ClassificationName":"模特资讯","FID":"20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1.jpg?ut=20171121174926","Number":108,"ReleaseTime":"2017-11-20 20:03:43","Title":"模城招商","UPDATE_TIME":"2017-11-21 17:49:26"},{"ClassificationName":"模特资讯","FID":"20171119172821917A6C6FC9B83DE44E309BC6418B5A8B6FD3","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119172821917A6C6FC9B83DE44E309BC6418B5A8B6FD3.jpg?ut=20171121171623","Number":132,"ReleaseTime":"2017-11-19 17:28:21","Title":"模特入驻","UPDATE_TIME":"2017-11-21 17:16:23"},{"ClassificationName":"模特资讯","FID":"20171121174600400A686F876396274ABB959B0847D44F46FF","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/21/File/20171121174600400A686F876396274ABB959B0847D44F46FF.jpg?ut=20171127162911","Number":28,"ReleaseTime":"2017-11-21 17:46:00","Title":"测试","UPDATE_TIME":"2017-11-27 16:29:11"},{"ClassificationName":"模特资讯","FID":"20171119180211927AD97FB9DF9E484B658921AEB01306045C","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119180211927AD97FB9DF9E484B658921AEB01306045C.jpg?ut=20171121171526","Number":67,"ReleaseTime":"2017-11-19 18:02:11","Title":"模卡定制","UPDATE_TIME":"2017-11-21 17:15:26"},{"ClassificationName":"模特资讯","FID":"20171119181832607A7D390A9B5E0E45D791FE28AB27471B1F","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119181832607A7D390A9B5E0E45D791FE28AB27471B1F.jpg?ut=20171119184616","Number":51,"ReleaseTime":"2017-11-19 18:18:32","Title":"明星之路","UPDATE_TIME":"2017-11-19 18:46:16"}]
     * ResultCode : 200
     */

    private String CurTime;
    private int ResultCode;
    private List<DataBean> Data;

    public String getCurTime() {
        return CurTime;
    }

    public void setCurTime(String CurTime) {
        this.CurTime = CurTime;
    }

    public int getResultCode() {
        return ResultCode;
    }

    public void setResultCode(int ResultCode) {
        this.ResultCode = ResultCode;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * ClassificationName : 模特资讯
         * FID : 20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1
         * Image : http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1.jpg?ut=20171121174926
         * Number : 108
         * ReleaseTime : 2017-11-20 20:03:43
         * Title : 模城招商
         * UPDATE_TIME : 2017-11-21 17:49:26
         */

        private String ClassificationName;
        private String FID;
        private String Image;
        private int Number;
        private String ReleaseTime;
        private String Title;
        private String UPDATE_TIME;

        public String getClassificationName() {
            return ClassificationName;
        }

        public void setClassificationName(String ClassificationName) {
            this.ClassificationName = ClassificationName;
        }

        public String getFID() {
            return FID;
        }

        public void setFID(String FID) {
            this.FID = FID;
        }

        public String getImage() {
            return Image;
        }

        public void setImage(String Image) {
            this.Image = Image;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public String getReleaseTime() {
            return ReleaseTime;
        }

        public void setReleaseTime(String ReleaseTime) {
            this.ReleaseTime = ReleaseTime;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getUPDATE_TIME() {
            return UPDATE_TIME;
        }

        public void setUPDATE_TIME(String UPDATE_TIME) {
            this.UPDATE_TIME = UPDATE_TIME;
        }
    }
}

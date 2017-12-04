package com.example.lurenman.myframeworkone.model.entities;

import java.util.List;

/**
 * @author: baiyang.
 * Created on 2017/11/30.
 */

public class RecommendClass {

    /**
     * ResultCode : 200
     * ResultInfo : null
     * CurTime : 1512011036
     * Data : {"banner1":[{"FID":"20171120180255940A496C2BA887864991AE6FB19541AC3672","Title":"","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120180255940A496C2BA887864991AE6FB19541AC3672.jpg?ut=20171121150838","ImageHttp":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120180255940A496C2BA887864991AE6FB19541AC3672.jpg?ut=20171121150838","DetailUrl":"{\r\n  \"Mp\": \"1\",\r\n  \"Content\": null,\r\n  \"FID\": null,\r\n  \"Sign\": null,\r\n  \"Time\": null,\r\n  \"Html\": null,\r\n  \"Url\": null\r\n}","UpdateTime":"0001-01-01 00:00:00","Attribute":null,"Data":null},{"FID":"20171120173757730A443A5DE2BA454A55863F9192096C5F78","Title":null,"Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120173757730A443A5DE2BA454A55863F9192096C5F78.jpg?ut=20171120173757","ImageHttp":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120173757730A443A5DE2BA454A55863F9192096C5F78.jpg?ut=20171120173757","DetailUrl":"{\r\n  \"Mp\": \"1\",\r\n  \"Content\": null,\r\n  \"FID\": null,\r\n  \"Sign\": null,\r\n  \"Time\": null,\r\n  \"Html\": null,\r\n  \"Url\": null\r\n}","UpdateTime":"0001-01-01 00:00:00","Attribute":null,"Data":null}],"banner2":[{"Fid":0,"setText1":"视觉人才库","setText2":"模特 摄影师 化妆师","setText3":0},{"Fid":1,"setText1":"通告广场","setText2":"接通告 赚小钱","setText3":1},{"Fid":2,"setText1":"模城","setText2":"模特们专属空间","setText3":1}],"banner3":{"IndustryName":"公告快讯","IndustryList":[{"FID":"20171120161239470A7645713D47BD47CE9B484E611CB74BE4","Name":"model","Url":""}]},"banner4":[{"Time":null,"FID":"20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1","Title":"模城招商","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1.jpg?ut=20171121174926","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-20 20:03:43","Number":107,"UPDATE_TIME":"2017-11-21 17:49:26"},{"Time":null,"FID":"20171119172821917A6C6FC9B83DE44E309BC6418B5A8B6FD3","Title":"模特入驻","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119172821917A6C6FC9B83DE44E309BC6418B5A8B6FD3.jpg?ut=20171121171623","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-19 17:28:21","Number":132,"UPDATE_TIME":"2017-11-21 17:16:23"},{"Time":null,"FID":"20171121174600400A686F876396274ABB959B0847D44F46FF","Title":"测试","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/21/File/20171121174600400A686F876396274ABB959B0847D44F46FF.jpg?ut=20171127162911","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-21 17:46:00","Number":28,"UPDATE_TIME":"2017-11-27 16:29:11"},{"Time":null,"FID":"20171119180211927AD97FB9DF9E484B658921AEB01306045C","Title":"模卡定制","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119180211927AD97FB9DF9E484B658921AEB01306045C.jpg?ut=20171121171526","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-19 18:02:11","Number":67,"UPDATE_TIME":"2017-11-21 17:15:26"},{"Time":null,"FID":"20171119181832607A7D390A9B5E0E45D791FE28AB27471B1F","Title":"明星之路","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119181832607A7D390A9B5E0E45D791FE28AB27471B1F.jpg?ut=20171119184616","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-19 18:18:32","Number":51,"UPDATE_TIME":"2017-11-19 18:46:16"}]}
     */

    private int ResultCode;
    private Object ResultInfo;
    private String CurTime;
    private DataBean Data;

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

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * banner1 : [{"FID":"20171120180255940A496C2BA887864991AE6FB19541AC3672","Title":"","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120180255940A496C2BA887864991AE6FB19541AC3672.jpg?ut=20171121150838","ImageHttp":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120180255940A496C2BA887864991AE6FB19541AC3672.jpg?ut=20171121150838","DetailUrl":"{\r\n  \"Mp\": \"1\",\r\n  \"Content\": null,\r\n  \"FID\": null,\r\n  \"Sign\": null,\r\n  \"Time\": null,\r\n  \"Html\": null,\r\n  \"Url\": null\r\n}","UpdateTime":"0001-01-01 00:00:00","Attribute":null,"Data":null},{"FID":"20171120173757730A443A5DE2BA454A55863F9192096C5F78","Title":null,"Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120173757730A443A5DE2BA454A55863F9192096C5F78.jpg?ut=20171120173757","ImageHttp":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120173757730A443A5DE2BA454A55863F9192096C5F78.jpg?ut=20171120173757","DetailUrl":"{\r\n  \"Mp\": \"1\",\r\n  \"Content\": null,\r\n  \"FID\": null,\r\n  \"Sign\": null,\r\n  \"Time\": null,\r\n  \"Html\": null,\r\n  \"Url\": null\r\n}","UpdateTime":"0001-01-01 00:00:00","Attribute":null,"Data":null}]
         * banner2 : [{"Fid":0,"setText1":"视觉人才库","setText2":"模特 摄影师 化妆师","setText3":0},{"Fid":1,"setText1":"通告广场","setText2":"接通告 赚小钱","setText3":1},{"Fid":2,"setText1":"模城","setText2":"模特们专属空间","setText3":1}]
         * banner3 : {"IndustryName":"公告快讯","IndustryList":[{"FID":"20171120161239470A7645713D47BD47CE9B484E611CB74BE4","Name":"model","Url":""}]}
         * banner4 : [{"Time":null,"FID":"20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1","Title":"模城招商","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1.jpg?ut=20171121174926","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-20 20:03:43","Number":107,"UPDATE_TIME":"2017-11-21 17:49:26"},{"Time":null,"FID":"20171119172821917A6C6FC9B83DE44E309BC6418B5A8B6FD3","Title":"模特入驻","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119172821917A6C6FC9B83DE44E309BC6418B5A8B6FD3.jpg?ut=20171121171623","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-19 17:28:21","Number":132,"UPDATE_TIME":"2017-11-21 17:16:23"},{"Time":null,"FID":"20171121174600400A686F876396274ABB959B0847D44F46FF","Title":"测试","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/21/File/20171121174600400A686F876396274ABB959B0847D44F46FF.jpg?ut=20171127162911","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-21 17:46:00","Number":28,"UPDATE_TIME":"2017-11-27 16:29:11"},{"Time":null,"FID":"20171119180211927AD97FB9DF9E484B658921AEB01306045C","Title":"模卡定制","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119180211927AD97FB9DF9E484B658921AEB01306045C.jpg?ut=20171121171526","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-19 18:02:11","Number":67,"UPDATE_TIME":"2017-11-21 17:15:26"},{"Time":null,"FID":"20171119181832607A7D390A9B5E0E45D791FE28AB27471B1F","Title":"明星之路","ClassificationName":"模特资讯","Image":"http://file.ataw.cn/HospPerformance/Model/Image/2017/11/19/File/20171119181832607A7D390A9B5E0E45D791FE28AB27471B1F.jpg?ut=20171119184616","Introduction":null,"Details":null,"ReleasePeople":null,"ReleaseTime":"2017-11-19 18:18:32","Number":51,"UPDATE_TIME":"2017-11-19 18:46:16"}]
         */

        private Banner3Bean banner3;
        private List<Banner1Bean> banner1;
        private List<Banner2Bean> banner2;
        private List<Banner4Bean> banner4;

        public Banner3Bean getBanner3() {
            return banner3;
        }

        public void setBanner3(Banner3Bean banner3) {
            this.banner3 = banner3;
        }

        public List<Banner1Bean> getBanner1() {
            return banner1;
        }

        public void setBanner1(List<Banner1Bean> banner1) {
            this.banner1 = banner1;
        }

        public List<Banner2Bean> getBanner2() {
            return banner2;
        }

        public void setBanner2(List<Banner2Bean> banner2) {
            this.banner2 = banner2;
        }

        public List<Banner4Bean> getBanner4() {
            return banner4;
        }

        public void setBanner4(List<Banner4Bean> banner4) {
            this.banner4 = banner4;
        }

        public static class Banner3Bean {
            /**
             * IndustryName : 公告快讯
             * IndustryList : [{"FID":"20171120161239470A7645713D47BD47CE9B484E611CB74BE4","Name":"model","Url":""}]
             */

            private String IndustryName;
            private List<IndustryListBean> IndustryList;

            public String getIndustryName() {
                return IndustryName;
            }

            public void setIndustryName(String IndustryName) {
                this.IndustryName = IndustryName;
            }

            public List<IndustryListBean> getIndustryList() {
                return IndustryList;
            }

            public void setIndustryList(List<IndustryListBean> IndustryList) {
                this.IndustryList = IndustryList;
            }

            public static class IndustryListBean {
                /**
                 * FID : 20171120161239470A7645713D47BD47CE9B484E611CB74BE4
                 * Name : model
                 * Url :
                 */

                private String FID;
                private String Name;
                private String Url;

                public String getFID() {
                    return FID;
                }

                public void setFID(String FID) {
                    this.FID = FID;
                }

                public String getName() {
                    return Name;
                }

                public void setName(String Name) {
                    this.Name = Name;
                }

                public String getUrl() {
                    return Url;
                }

                public void setUrl(String Url) {
                    this.Url = Url;
                }
            }
        }

        public static class Banner1Bean {
            /**
             * FID : 20171120180255940A496C2BA887864991AE6FB19541AC3672
             * Title :
             * Image : http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120180255940A496C2BA887864991AE6FB19541AC3672.jpg?ut=20171121150838
             * ImageHttp : http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120180255940A496C2BA887864991AE6FB19541AC3672.jpg?ut=20171121150838
             * DetailUrl : {
             "Mp": "1",
             "Content": null,
             "FID": null,
             "Sign": null,
             "Time": null,
             "Html": null,
             "Url": null
             }
             * UpdateTime : 0001-01-01 00:00:00
             * Attribute : null
             * Data : null
             */

            private String FID;
            private String Title;
            private String Image;
            private String ImageHttp;
            private String DetailUrl;
            private String UpdateTime;
            private Object Attribute;
            private Object Data;

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

            public String getImageHttp() {
                return ImageHttp;
            }

            public void setImageHttp(String ImageHttp) {
                this.ImageHttp = ImageHttp;
            }

            public String getDetailUrl() {
                return DetailUrl;
            }

            public void setDetailUrl(String DetailUrl) {
                this.DetailUrl = DetailUrl;
            }

            public String getUpdateTime() {
                return UpdateTime;
            }

            public void setUpdateTime(String UpdateTime) {
                this.UpdateTime = UpdateTime;
            }

            public Object getAttribute() {
                return Attribute;
            }

            public void setAttribute(Object Attribute) {
                this.Attribute = Attribute;
            }

            public Object getData() {
                return Data;
            }

            public void setData(Object Data) {
                this.Data = Data;
            }
        }

        public static class Banner2Bean {
            /**
             * Fid : 0
             * setText1 : 视觉人才库
             * setText2 : 模特 摄影师 化妆师
             * setText3 : 0
             */

            private int Fid;
            private String setText1;
            private String setText2;
            private int setText3;

            public int getFid() {
                return Fid;
            }

            public void setFid(int Fid) {
                this.Fid = Fid;
            }

            public String getSetText1() {
                return setText1;
            }

            public void setSetText1(String setText1) {
                this.setText1 = setText1;
            }

            public String getSetText2() {
                return setText2;
            }

            public void setSetText2(String setText2) {
                this.setText2 = setText2;
            }

            public int getSetText3() {
                return setText3;
            }

            public void setSetText3(int setText3) {
                this.setText3 = setText3;
            }
        }

        public static class Banner4Bean {
            /**
             * Time : null
             * FID : 20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1
             * Title : 模城招商
             * ClassificationName : 模特资讯
             * Image : http://file.ataw.cn/HospPerformance/Model/Image/2017/11/20/File/20171120200343943A3E30C0E6E2804E8AA9F0520F0E90E5F1.jpg?ut=20171121174926
             * Introduction : null
             * Details : null
             * ReleasePeople : null
             * ReleaseTime : 2017-11-20 20:03:43
             * Number : 107
             * UPDATE_TIME : 2017-11-21 17:49:26
             */

            private Object Time;
            private String FID;
            private String Title;
            private String ClassificationName;
            private String Image;
            private Object Introduction;
            private Object Details;
            private Object ReleasePeople;
            private String ReleaseTime;
            private int Number;
            private String UPDATE_TIME;

            public Object getTime() {
                return Time;
            }

            public void setTime(Object Time) {
                this.Time = Time;
            }

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

            public String getClassificationName() {
                return ClassificationName;
            }

            public void setClassificationName(String ClassificationName) {
                this.ClassificationName = ClassificationName;
            }

            public String getImage() {
                return Image;
            }

            public void setImage(String Image) {
                this.Image = Image;
            }

            public Object getIntroduction() {
                return Introduction;
            }

            public void setIntroduction(Object Introduction) {
                this.Introduction = Introduction;
            }

            public Object getDetails() {
                return Details;
            }

            public void setDetails(Object Details) {
                this.Details = Details;
            }

            public Object getReleasePeople() {
                return ReleasePeople;
            }

            public void setReleasePeople(Object ReleasePeople) {
                this.ReleasePeople = ReleasePeople;
            }

            public String getReleaseTime() {
                return ReleaseTime;
            }

            public void setReleaseTime(String ReleaseTime) {
                this.ReleaseTime = ReleaseTime;
            }

            public int getNumber() {
                return Number;
            }

            public void setNumber(int Number) {
                this.Number = Number;
            }

            public String getUPDATE_TIME() {
                return UPDATE_TIME;
            }

            public void setUPDATE_TIME(String UPDATE_TIME) {
                this.UPDATE_TIME = UPDATE_TIME;
            }
        }
    }
}

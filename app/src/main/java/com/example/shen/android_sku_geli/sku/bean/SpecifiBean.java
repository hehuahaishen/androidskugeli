package com.example.shen.android_sku_geli.sku.bean;

import java.util.Comparator;
import java.util.List;

/**
 * author:  shen
 * date:    2019/1/19
 */
public class SpecifiBean {

    /**
     * code : 100
     * message : ok
     * data : {"spec_attr":[{"spec_id":1,"spec_name":"规格","res":[{"attr_id":30326,"attr_name":"1*1"},{"attr_id":30331,"attr_name":"1*2"},{"attr_id":30332,"attr_name":"1.*2"},{"attr_id":30333,"attr_name":"1*3"}]},{"spec_id":2,"spec_name":"口味","res":[{"attr_id":30328,"attr_name":"甜"},{"attr_id":30329,"attr_name":"酸"}]},{"spec_id":6,"spec_name":"颜色","res":[{"attr_id":30327,"attr_name":"红"},{"attr_id":30330,"attr_name":"黄"}]}],"goods_sku":[{"sku_id":30096,"goods_id":5528,"sku_attr":"{1:30326,6:30327,2:30328}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":417,"sh_price":null},{"sku_id":30097,"goods_id":5528,"sku_attr":"{1:30326,6:30327,2:30329}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":489,"sh_price":null},{"sku_id":30098,"goods_id":5528,"sku_attr":"{1:30326,6:30330,2:30328}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":500,"sh_price":null},{"sku_id":30099,"goods_id":5528,"sku_attr":"{1:30326,6:30330,2:30329}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":405,"sh_price":null},{"sku_id":30100,"goods_id":5528,"sku_attr":"{1:30331,6:30327,2:30328}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":252,"sh_price":null},{"sku_id":30101,"goods_id":5528,"sku_attr":"{1:30331,6:30327,2:30329}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":543,"sh_price":null},{"sku_id":30102,"goods_id":5528,"sku_attr":"{1:30331,6:30330,2:30328}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":571,"sh_price":null},{"sku_id":30103,"goods_id":5528,"sku_attr":"{1:30332,6:30330,2:30329}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":323,"sh_price":null},{"sku_id":30104,"goods_id":5528,"sku_attr":"{1:30333,6:30327,2:30328}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":477,"sh_price":null},{"sku_id":30105,"goods_id":5528,"sku_attr":"{1:30333,6:30330,2:30328}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":253,"sh_price":null},{"sku_id":30106,"goods_id":5528,"sku_attr":"{1:30333,6:30327,2:30329}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":385,"sh_price":null},{"sku_id":30107,"goods_id":5528,"sku_attr":"{1:30333,6:30330,2:30329}","price":"1.00","inventory":10000,"sales":0,"pack_attr":"{\"l\":\"1\",\"w\":\"1\",\"h\":\"1\",\"v\":1,\"wg\":\"1\"}","refrigerate":"-18℃","tiered_pri":"","virtual_sales":543,"sh_price":null}]}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<SpecAttrBean> spec_attr;
        private List<GoodsSkuBean> goods_sku;

        public List<SpecAttrBean> getSpec_attr() {
            return spec_attr;
        }

        public void setSpec_attr(List<SpecAttrBean> spec_attr) {
            this.spec_attr = spec_attr;
        }

        public List<GoodsSkuBean> getGoods_sku() {
            return goods_sku;
        }

        public void setGoods_sku(List<GoodsSkuBean> goods_sku) {
            this.goods_sku = goods_sku;
        }

        public static class SpecAttrBean {
            /**
             * spec_id : 1
             * spec_name : 规格
             * res : [{"attr_id":30326,"attr_name":"1*1"},{"attr_id":30331,"attr_name":"1*2"},{"attr_id":30332,"attr_name":"1.*2"},{"attr_id":30333,"attr_name":"1*3"}]
             */

            private int spec_id;
            private String spec_name;
            private List<ResBean> res;

            public int getSpec_id() {
                return spec_id;
            }

            public void setSpec_id(int spec_id) {
                this.spec_id = spec_id;
            }

            public String getSpec_name() {
                return spec_name;
            }

            public void setSpec_name(String spec_name) {
                this.spec_name = spec_name;
            }

            public List<ResBean> getRes() {
                return res;
            }

            public void setRes(List<ResBean> res) {
                this.res = res;
            }

            public static class ResBean {
                /**
                 * attr_id : 30326
                 * attr_name : 1*1
                 */

                private int attr_id;
                private String attr_name;

                public int getAttr_id() {
                    return attr_id;
                }

                public void setAttr_id(int attr_id) {
                    this.attr_id = attr_id;
                }

                public String getAttr_name() {
                    return attr_name;
                }

                public void setAttr_name(String attr_name) {
                    this.attr_name = attr_name;
                }
            }



            /**
             * 排序 -- 根据"传递进来的经纬度"和"列表中的经纬度"计算出距离，再排序
             */
            public static class SpecifiComparator implements Comparator {

                public int compare(Object o1, Object o2){
                    SpecAttrBean s1 = (SpecAttrBean)o1;
                    SpecAttrBean s2 = (SpecAttrBean)o2;

                    int result = s1.getSpec_id() > s2.getSpec_id() ? 1 :
                            (s1.getSpec_id() == s2.getSpec_id() ? 0 : -1);
                    return result;
                }
            }

        }

        public static class GoodsSkuBean {
            /**
             * sku_id : 30096
             * goods_id : 5528
             * sku_attr : {1:30326,6:30327,2:30328}
             * price : 1.00
             * inventory : 10000
             * sales : 0
             * pack_attr : {"l":"1","w":"1","h":"1","v":1,"wg":"1"}
             * refrigerate : -18℃
             * tiered_pri :
             * virtual_sales : 417
             * sh_price : null
             */

            private int sku_id;
            private int goods_id;
            private String sku_attr;
            private String price;
            private int inventory;
            private int sales;
            private String pack_attr;
            private String refrigerate;
            private String tiered_pri;
            private int virtual_sales;
            private Object sh_price;

            List<SkuAttrBean> mSkuAttrBeans;

            public int getSku_id() {
                return sku_id;
            }

            public void setSku_id(int sku_id) {
                this.sku_id = sku_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getSku_attr() {
                return sku_attr;
            }

            public void setSku_attr(String sku_attr) {
                this.sku_attr = sku_attr;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getInventory() {
                return inventory;
            }

            public void setInventory(int inventory) {
                this.inventory = inventory;
            }

            public int getSales() {
                return sales;
            }

            public void setSales(int sales) {
                this.sales = sales;
            }

            public String getPack_attr() {
                return pack_attr;
            }

            public void setPack_attr(String pack_attr) {
                this.pack_attr = pack_attr;
            }

            public String getRefrigerate() {
                return refrigerate;
            }

            public void setRefrigerate(String refrigerate) {
                this.refrigerate = refrigerate;
            }

            public String getTiered_pri() {
                return tiered_pri;
            }

            public void setTiered_pri(String tiered_pri) {
                this.tiered_pri = tiered_pri;
            }

            public int getVirtual_sales() {
                return virtual_sales;
            }

            public void setVirtual_sales(int virtual_sales) {
                this.virtual_sales = virtual_sales;
            }

            public Object getSh_price() {
                return sh_price;
            }

            public void setSh_price(Object sh_price) {
                this.sh_price = sh_price;
            }

            public List<SkuAttrBean> getSkuAttrBeans() {
                return mSkuAttrBeans;
            }

            public void setSkuAttrBeans(List<SkuAttrBean> skuAttrBeans) {
                this.mSkuAttrBeans = skuAttrBeans;
            }

            @Override
            public String toString() {
                return "GoodsSkuBean{" +
//                        "sku_id=" + sku_id +
//                        ", goods_id=" + goods_id +
//                        ", sku_attr='" + sku_attr + '\'' +
//                        ", price='" + price + '\'' +
//                        ", inventory=" + inventory +
//                        ", sales=" + sales +
//                        ", pack_attr='" + pack_attr + '\'' +
//                        ", refrigerate='" + refrigerate + '\'' +
//                        ", tiered_pri='" + tiered_pri + '\'' +
//                        ", virtual_sales=" + virtual_sales +
//                        ", sh_price=" + sh_price +
                        ", mSkuAttrBeans=" + mSkuAttrBeans.toString() +
                        '}';
            }
        }
    }
}

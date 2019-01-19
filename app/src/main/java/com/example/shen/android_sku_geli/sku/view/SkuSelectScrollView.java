package com.example.shen.android_sku_geli.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import com.example.shen.android_sku_geli.sku.bean.SkuAttribute;
import com.example.shen.android_sku_geli.sku.bean.SpecifiBean;
import com.example.shen.android_sku_geli.sku.utils.ViewUtils;
import com.example.shen.android_sku_geli.sku.widget.SkuMaxHeightScrollView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by wuhenzhizao on 2017/7/31.
 */
public class SkuSelectScrollView extends SkuMaxHeightScrollView implements SkuItemLayout.OnSkuItemSelectListener {

    /** 所有属性的布局 -- 包含多个SkuItemLayout  */
    private LinearLayout mSkuContainerLayout;
    // private List<Sku> mSkuList;

    private SpecifiBean.DataBean mSku;

    /** 存放 -- 当前 -- 选中属性的信息 */
    private List<SkuAttribute> mSelectedAttributeList;
    /** sku选中状态 -- 回调接口 */
    private OnSkuListener mListener;

    public SkuSelectScrollView(Context context) {
        super(context);
        init(context, null);
    }

    public SkuSelectScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setFillViewport(true);                          // 拉伸填满
        setOverScrollMode(OVER_SCROLL_NEVER);

        // 添加一个 "纵向的LinearLayout" -- 所有属性的布局（包含多个SkuItemLayout）
        mSkuContainerLayout = new LinearLayout(context, attrs);
        mSkuContainerLayout.setId(ViewUtils.generateViewId());
        mSkuContainerLayout.setOrientation(LinearLayout.VERTICAL);
        mSkuContainerLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        addView(mSkuContainerLayout);
    }

    /**
     * 设置SkuView委托，MVVM + Databinding模式下使用
     *
     * @param delegate
     */
    public void setSkuViewDelegate(SkuViewDelegate delegate) {
        this.mListener = delegate.getListener();
    }


    /**
     * 设置监听接口
     *
     * @param listener {@link OnSkuListener}
     */
    public void setListener(OnSkuListener listener) {
        this.mListener = listener;
    }


    /**
     * 绑定sku数据
     *
     * @param sku
     */
    public void setSkuList(SpecifiBean.DataBean sku) {
        this.mSku = sku;
        // 清空sku视图
        mSkuContainerLayout.removeAllViews();


        // 获取分组的sku集合
        Map<String, List<String>> dataMap = getSkuGroupByName(sku.getSpec_attr());
        getSkuAttribuit();

        mSelectedAttributeList = new LinkedList<>();
        int index = 0;
        for (Iterator<Map.Entry<String, List<String>>> it = dataMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, List<String>> entry = it.next();

            // 构建sku视图 -- 每一个大属性
            SkuItemLayout itemLayout = new SkuItemLayout(getContext());
            itemLayout.setId(ViewUtils.generateViewId());
            itemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            itemLayout.buildItemLayout(index++, entry.getKey(), entry.getValue());
            itemLayout.setSelectListener(this);
            itemLayout.setTag(getSpecIdByName.get(entry.getKey()));
            mSkuContainerLayout.addView(itemLayout);

            // 初始状态下，"选中列表"中数据都为空
            mSelectedAttributeList.add(new SkuAttribute(getSpecIdByName.get(entry.getKey()),
                    entry.getKey(), -1,  ""));
        }


        // 一个sku时，默认选中
        if (sku.getSpec_attr() != null &&
                sku.getSpec_attr().size() == 1 &&
                sku.getSpec_attr().get(0) != null &&
                sku.getSpec_attr().get(0).getRes() != null) {

            mSelectedAttributeList.clear();
            for (SpecifiBean.DataBean.SpecAttrBean specAttrBean : mSku.getSpec_attr()) {
                mSelectedAttributeList.add(new SkuAttribute(
                        getSpecIdByName.get(specAttrBean.getSpec_name()),
                        specAttrBean.getSpec_name(),
                        getAttributeIdByName.get(specAttrBean.getRes().get(0).getAttr_name()) == null ?
                        -1 : getAttributeIdByName.get(specAttrBean.getRes().get(0).getAttr_name()),
                        specAttrBean.getRes().get(0).getAttr_name()));
            }
        }

        // 清除所有选中状态
        clearAllLayoutStatus();
        // 设置是否可点击
        optionLayoutEnableStatus();
        // 设置选中状态
        optionLayoutSelectStatus();
    }


//    /**
//     * 将sku根据属性名进行分组
//     *
//     * @param list
//     * @return 如{ "颜色": {"白色", "红色", "黑色"}, "尺寸": {"M", "L", "XL", "XXL"}}
//     */
//    private Map<String, List<String>> getSkuGroupByName(List<Sku> list) {
//        Map<String, List<String>> dataMap = new LinkedHashMap<>();
//        for (Sku sku : list) {
//            for (SkuAttribute attribute : sku.getAttributes()) {
//                String attributeName = attribute.getKey();
//                String attributeValue = attribute.getValue();
//
//                if (!dataMap.containsKey(attributeName)) {
//                    dataMap.put(attributeName, new LinkedList<String>());
//                }
//
//                List<String> valueList = dataMap.get(attributeName);
//                if (!valueList.contains(attributeValue)) {
//                    dataMap.get(attributeName).add(attributeValue);
//                }
//            }
//        }
//        return dataMap;
//    }



    /**
     * 整理下属性
     *
     */
    private void getSkuAttribuit() {

        if(mSku == null || mSku.getGoods_sku() == null){
            return;
        }
        int i = 0;
        for(SpecifiBean.DataBean.GoodsSkuBean goodsSkuBean : mSku.getGoods_sku()){
            List<SkuAttribute> list = new ArrayList<>();
            for(String sku_attr : goodsSkuBean.getSku_attr().split(",")) {
                String[] goodsSku = sku_attr
                        .replace("{", "")
                        .replace("}", "").split(":");

//
                int specId = Integer.valueOf(goodsSku[0]);
                int attributeId = Integer.valueOf(goodsSku[1]);

                list.add(new SkuAttribute(specId, getSpecNameById.get(specId),
                        attributeId,getAttributeNameById.get(attributeId)));

            }

            mSku.getGoods_sku().get(i).setSkuAttributes(list);
            i++;
        }
    }


    Map<Integer, String> getSpecNameById = new LinkedHashMap<>();
    Map<String, Integer> getSpecIdByName = new LinkedHashMap<>();
    Map<Integer, String> getAttributeNameById = new LinkedHashMap<>();
    Map<String, Integer> getAttributeIdByName = new LinkedHashMap<>();
    /**
     * 将sku根据属性名进行分组
     *
     * @param list
     * @return 如{ "颜色": {"白色", "红色", "黑色"}, "尺寸": {"M", "L", "XL", "XXL"}}
     */
    private Map<String, List<String>> getSkuGroupByName(List<SpecifiBean.DataBean.SpecAttrBean> list) {
        Map<String, List<String>> dataMap = new LinkedHashMap<>();
        for (SpecifiBean.DataBean.SpecAttrBean sku : list) {
            int specId = sku.getSpec_id();
            String specName = sku.getSpec_name();
            getSpecNameById.put(specId, specName);
            getSpecIdByName.put(specName, specId);

            for (SpecifiBean.DataBean.SpecAttrBean.ResBean attribute : sku.getRes()) {
                int attributeId = attribute.getAttr_id();
                String attributeName = attribute.getAttr_name();

                getAttributeNameById.put(attributeId, attributeName);
                getAttributeIdByName.put(attributeName, attributeId);

                if (!dataMap.containsKey(specName)) {
                    dataMap.put(specName, new LinkedList<String>());
                }

                List<String> valueList = dataMap.get(specName);
                if (!valueList.contains(attributeName)) {
                    dataMap.get(specName).add(attributeName);
                }
            }
        }
        return dataMap;
    }




    /**
     * 重置 "所有属性" 的选中状态
     */
    private void clearAllLayoutStatus() {
        for (int i = 0; i < mSkuContainerLayout.getChildCount(); i++) {  // 一个个大属性循环
            SkuItemLayout itemLayout = (SkuItemLayout) mSkuContainerLayout.getChildAt(i);
            itemLayout.clearItemViewStatus();
        }
    }

    /**
     * 设置所有属性的Enable状态，即是否可点击
     */
    private void optionLayoutEnableStatus() {
        int childCount = mSkuContainerLayout.getChildCount();

        if (childCount <= 1) {                          /* 只有一大类属性 */
            optionLayoutEnableStatusSingleProperty();
        } else {                                        /* 有多种大属性 */
            optionLayoutEnableStatusMultipleProperties();
        }
    }

    /**
     * 只有一大类属性 -- 设置所有属性的Enable状态，即是否可点击
     */
    private void optionLayoutEnableStatusSingleProperty() {
        SkuItemLayout itemLayout = (SkuItemLayout) mSkuContainerLayout.getChildAt(0);

        // 遍历sku列表
        for (int i = 0; i < mSku.getGoods_sku().size(); i++) {
            // 属性值是否可点击flag
            SpecifiBean.DataBean.GoodsSkuBean sku = mSku.getGoods_sku().get(i);
            List<SkuAttribute> attributeBeanList = mSku.getGoods_sku().get(i).getSkuAttributes();

            if (sku.getVirtual_sales() > 0) {
                String attributeValue = attributeBeanList.get(0).getAttributeName();  // 有这个属性的商品
                itemLayout.optionItemViewEnableStatus(attributeValue);        // 设置这个属性可以点击
            }
        }
    }

    /**
     * 有多种大属性 -- 设置所有属性的Enable状态，即是否可点击
     */
    private void optionLayoutEnableStatusMultipleProperties() {

        for (int i = 0; i < mSkuContainerLayout.getChildCount(); i++) {         // 遍历每个大类

            SkuItemLayout itemLayout = (SkuItemLayout) mSkuContainerLayout.getChildAt(i);

            /* 遍历sku列表 */
            for (int j = 0; j < mSku.getGoods_sku().size(); j++) {         // 遍历每个商品
                // 属性值是否可点击flag
                boolean flag = false;

                // 所有 商品
                SpecifiBean.DataBean.GoodsSkuBean sku = mSku.getGoods_sku().get(j);
                List<SkuAttribute> attributeBeanList = sku.getSkuAttributes();     // 每个商品都有多个属性
                /* 遍历”选中信息列表" */
                for (int k = 0; k < mSelectedAttributeList.size(); k++) {       // 每一大类的属性都会放到列表中的 -- 没有选中的是空
                    // i = k，跳过当前属性，避免多次设置是否可点击
                    if (i == k) continue;
//
//                    Log.i("shen", "前(i:"+ i +
//                            "   j:"+j + "   K:" + k +")：" + attributeBeanList.get(k).getAttributeName());
                    // 选中信息为空，则说明未选中，无法判断是否有不可点击的情形，跳过
                    if ("".equals(mSelectedAttributeList.get(k).getAttributeName())) continue;
                    // 选中信息列表中 "不包含" 当前sku的属性，则sku组合不存在，设置为"不可点击"
                    // 库存为0，设置为不可点击
                    if (!mSelectedAttributeList.get(k).getAttributeName()
                            .equals(attributeBeanList.get(k).getAttributeName())
                            || sku.getVirtual_sales() == 0) {
                        flag = true;
                        break;
                    }
                }

                // flag 为false时，可点击
                if (!flag) {
                    int index = 0;
                    for(SkuAttribute skuAttribute : attributeBeanList) {
                        if((int)itemLayout.getTag() == skuAttribute.getSpecId()) {
                            String attributeValue = attributeBeanList.get(index).getAttributeName();  // i 代表这个商品中的第几大类
                            itemLayout.optionItemViewEnableStatus(attributeValue);
                            break;
                        }
                        index++;
                    }
                }
            }

        }
    }

    /**
     * 设置所有属性的选中状态
     */
    private void optionLayoutSelectStatus() {
        for (int i = 0; i < mSkuContainerLayout.getChildCount(); i++) {
            SkuItemLayout itemLayout = (SkuItemLayout) mSkuContainerLayout.getChildAt(i);
            itemLayout.optionItemViewSelectStatus(mSelectedAttributeList.get(i));
        }
    }

    /**
     * 是否有sku选中
     *
     * @return
     */
    private boolean isSkuSelected() {
        for (SkuAttribute attribute : mSelectedAttributeList) {
            if (TextUtils.isEmpty(attribute.getAttributeName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取第一个未选中的属性名
     *
     * @return
     */
    public String getFirstUnelectedAttributeName() {
        for (int i = 0; i < mSkuContainerLayout.getChildCount(); i++) {
            SkuItemLayout itemLayout = (SkuItemLayout) mSkuContainerLayout.getChildAt(i);
            if (!itemLayout.isSelected()) {
                return itemLayout.getAttributeName();
            }
        }
        return "";
    }

    /**
     * 获取选中的Sku
     *
     * @return
     */
    public SpecifiBean.DataBean.GoodsSkuBean getSelectedSku() {
        // 判断是否有选中的sku
        if (!isSkuSelected()) {
            return null;
        }
        for (SpecifiBean.DataBean.GoodsSkuBean sku : mSku.getGoods_sku()) {
            List<SkuAttribute> attributeList = sku.getSkuAttributes();
            // 将sku的属性列表与selectedAttributeList匹配，完全匹配则为已选中sku
            boolean flag = true;
            for (int i = 0; i < attributeList.size(); i++) {

                for(SkuAttribute skuAttribute : mSelectedAttributeList){
                    if(attributeList.get(i).getSpecId() == skuAttribute.getSpecId()) {
                        if (!isSameSkuAttribute(attributeList.get(i), skuAttribute)) {
                            flag = false;
                        }
                        break;
                    }
                }

            }
            if (flag) {
                return sku;
            }
        }
        return null;
    }

    /**
     * 设置选中的sku
     *
     * @param sku
     */
    public void setSelectedSku(SpecifiBean.DataBean.GoodsSkuBean sku) {
        mSelectedAttributeList.clear();
        for (SkuAttribute attribute : sku.getSkuAttributes()) {
            mSelectedAttributeList.add(new SkuAttribute(
                    attribute.getSpecId(),
                    attribute.getSpecName(),
                    attribute.getAttributeId(),
                    attribute.getAttributeName()));
        }
        // 清除所有选中状态
        clearAllLayoutStatus();
        // 设置是否可点击
        optionLayoutEnableStatus();
        // 设置选中状态
        optionLayoutSelectStatus();
    }

    /**
     * 是否为同一个SkuAttribute
     *
     * @param previousAttribute
     * @param nextAttribute
     * @return
     */
    private boolean isSameSkuAttribute(SkuAttribute previousAttribute, SkuAttribute nextAttribute) {
        return previousAttribute.getSpecName().equals(nextAttribute.getSpecName())
                && previousAttribute.getAttributeName().equals(nextAttribute.getAttributeName());
    }

    @Override
    public void onSelect(int position, boolean selected, SkuAttribute attribute) {
        if (selected) {
            // 选中，保存选中信息
            mSelectedAttributeList.set(position, attribute);
        } else {
            // 取消选中，清空保存的选中信息
            mSelectedAttributeList.get(position).setAttributeName("");
        }
        clearAllLayoutStatus();
        // 设置是否可点击
        optionLayoutEnableStatus();
        // 设置选中状态
        optionLayoutSelectStatus();
        // 回调接口
        if (isSkuSelected()) {
            mListener.onSkuSelected(getSelectedSku());
        } else if (selected) {
            mListener.onSelect(attribute);
        } else {
            mListener.onUnselected(attribute);
        }
    }
}
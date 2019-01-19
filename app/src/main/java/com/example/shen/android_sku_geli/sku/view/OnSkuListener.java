package com.example.shen.android_sku_geli.sku.view;


import com.example.shen.android_sku_geli.sku.bean.SkuAttribute;
import com.example.shen.android_sku_geli.sku.bean.SpecifiBean;

/**
 * Created by wuhenzhizao on 2017/8/30.
 */
public interface OnSkuListener {
    /**
     * 属性取消选中
     *
     * @param unselectedAttribute
     */
    void onUnselected(SkuAttribute unselectedAttribute);

    /**
     * 属性选中
     *
     * @param selectAttribute
     */
    void onSelect(SkuAttribute selectAttribute);

    /**
     * sku选中
     *
     * @param sku
     */
    void onSkuSelected(SpecifiBean.DataBean.GoodsSkuBean sku);
}
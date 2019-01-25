package com.example.shen.android_sku_geli.sku.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import com.example.shen.android_sku_geli.R;
import com.example.shen.android_sku_geli.sku.utils.ScreenUtils;

/**
 * Created by wuhenzhizao on 2017/7/31.
 */

public class SkuItemView extends TextView {
    private String attributeName;

    public SkuItemView(Context context) {
        super(context);
        init(context);
    }

    public SkuItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SkuItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        // 设置 字体和背景
        setBackgroundResource(R.drawable.sku_item_selector);
        setTextColor(getResources().getColorStateList(R.color.sku_item_text_selector));
        setTextSize(TypedValue.COMPLEX_UNIT_DIP, 11);
        setSingleLine();
        setGravity(Gravity.CENTER);
        setPadding(ScreenUtils.dp2PxInt(context, 10), 0, ScreenUtils.dp2PxInt(context, 10), 0);

        setMinWidth(ScreenUtils.dp2PxInt(context, 45));
        setMaxWidth(ScreenUtils.dp2PxInt(context, 200));
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
        setText(attributeName);
    }
}

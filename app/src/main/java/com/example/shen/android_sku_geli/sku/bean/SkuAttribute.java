package com.example.shen.android_sku_geli.sku.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wuhenzhizao on 2017/7/20.
 */
public class SkuAttribute implements Parcelable {

    private int specId;
    private String specName;
    private int attributeId;
    private String attributeName;

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public SkuAttribute(int specId, String specName, int attributeId, String attributeName) {
        this.specId = specId;
        this.specName = specName;
        this.attributeId = attributeId;
        this.attributeName = attributeName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.specId);
        dest.writeString(this.specName);
        dest.writeInt(this.attributeId);
        dest.writeString(this.attributeName);
    }

    protected SkuAttribute(Parcel in) {
        this.specId = in.readInt();
        this.specName = in.readString();
        this.attributeId = in.readInt();
        this.attributeName = in.readString();
    }

    public static final Parcelable.Creator<SkuAttribute> CREATOR = new Parcelable.Creator<SkuAttribute>() {
        @Override
        public SkuAttribute createFromParcel(Parcel source) {
            return new SkuAttribute(source);
        }

        @Override
        public SkuAttribute[] newArray(int size) {
            return new SkuAttribute[size];
        }
    };
}

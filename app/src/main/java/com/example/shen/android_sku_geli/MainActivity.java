package com.example.shen.android_sku_geli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shen.android_sku_geli.sku.bean.SkuAttrBean;
import com.example.shen.android_sku_geli.sku.bean.SpecifiBean;
import com.example.shen.android_sku_geli.sku.view.OnSkuListener;
import com.example.shen.android_sku_geli.sku.view.SkuSelectScrollView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SkuSelectScrollView mSkuSelectScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSkuSelectScrollView = findViewById(R.id.sku);

        String sku = "{\"code\":100,\"message\":\"ok\",\"data\":{\"spec_attr\":[{\"spec_id\":1,\"spec_name\":\"规格\",\"res\":[{\"attr_id\":30326,\"attr_name\":\"1*1\"},{\"attr_id\":30331,\"attr_name\":\"1*2\"},{\"attr_id\":30332,\"attr_name\":\"1.*2\"},{\"attr_id\":30333,\"attr_name\":\"1*3\"}]},{\"spec_id\":2,\"spec_name\":\"口味\",\"res\":[{\"attr_id\":30328,\"attr_name\":\"甜\"},{\"attr_id\":30329,\"attr_name\":\"酸\"}]},{\"spec_id\":6,\"spec_name\":\"颜色\",\"res\":[{\"attr_id\":30327,\"attr_name\":\"红\"},{\"attr_id\":30330,\"attr_name\":\"黄\"}]}],\"goods_sku\":[{\"sku_id\":30096,\"goods_id\":5528,\"sku_attr\":\"{1:30326,6:30327,2:30328}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":417,\"sh_price\":null},{\"sku_id\":30097,\"goods_id\":5528,\"sku_attr\":\"{1:30326,6:30327,2:30329}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":489,\"sh_price\":null},{\"sku_id\":30098,\"goods_id\":5528,\"sku_attr\":\"{1:30326,6:30330,2:30328}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":500,\"sh_price\":null},{\"sku_id\":30099,\"goods_id\":5528,\"sku_attr\":\"{1:30326,6:30330,2:30329}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":405,\"sh_price\":null},{\"sku_id\":30100,\"goods_id\":5528,\"sku_attr\":\"{1:30331,6:30327,2:30328}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":252,\"sh_price\":null},{\"sku_id\":30101,\"goods_id\":5528,\"sku_attr\":\"{1:30331,6:30327,2:30329}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":543,\"sh_price\":null},{\"sku_id\":30102,\"goods_id\":5528,\"sku_attr\":\"{1:30331,6:30330,2:30328}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":571,\"sh_price\":null},{\"sku_id\":30103,\"goods_id\":5528,\"sku_attr\":\"{1:30332,6:30330,2:30329}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":323,\"sh_price\":null},{\"sku_id\":30104,\"goods_id\":5528,\"sku_attr\":\"{1:30333,6:30327,2:30328}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":477,\"sh_price\":null},{\"sku_id\":30105,\"goods_id\":5528,\"sku_attr\":\"{1:30333,6:30330,2:30328}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":253,\"sh_price\":null},{\"sku_id\":30106,\"goods_id\":5528,\"sku_attr\":\"{1:30333,6:30327,2:30329}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":385,\"sh_price\":null},{\"sku_id\":30107,\"goods_id\":5528,\"sku_attr\":\"{1:30333,6:30330,2:30329}\",\"price\":\"1.00\",\"inventory\":10000,\"sales\":0,\"pack_attr\":\"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\"refrigerate\":\"-18℃\",\"tiered_pri\":\"\",\"virtual_sales\":543,\"sh_price\":null}]}}\n";
        SpecifiBean specifiBean = new Gson().fromJson(sku, SpecifiBean.class);
        mSkuSelectScrollView.setSkuList(specifiBean.getData());


        mSkuSelectScrollView.setListener(new OnSkuListener() {
            @Override
            public void onUnselected(SkuAttrBean unselectedAttribute) {
                Toast.makeText(MainActivity.this,"取选：" + unselectedAttribute.getAttributeName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSelect(SkuAttrBean selectAttribute) {
                Toast.makeText(MainActivity.this,"已选：" + selectAttribute.getAttributeName(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSkuSelected(SpecifiBean.DataBean.GoodsSkuBean sku) {
                SpecifiBean.DataBean.GoodsSkuBean selectedSku = sku;
                List<SkuAttrBean> attributeList = selectedSku.getSkuAttrBeans();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < attributeList.size(); i++) {
                    if (i != 0) {
                        builder.append("　");
                    }
                    SkuAttrBean attribute = attributeList.get(i);
                    builder.append("\"" + attribute.getAttributeName() + "\"");
                }
                Toast.makeText(MainActivity.this,"已选：" + builder.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }


    String sku1 = "{\n" +
            "  \"code\": 100,\n" +
            "  \"message\": \"ok\",\n" +
            "  \"data\": {\n" +
            "    \"spec_attr\": [\n" +
            "      {\n" +
            "        \"spec_id\": 1,\n" +
            "        \"spec_name\": \"规格\",\n" +
            "        \"res\": [\n" +
            "          {\n" +
            "            \"attr_id\": 30326,\n" +
            "            \"attr_name\": \"1*1\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"attr_id\": 30331,\n" +
            "            \"attr_name\": \"1*2\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"attr_id\": 30332,\n" +
            "            \"attr_name\": \"1.*2\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"attr_id\": 30333,\n" +
            "            \"attr_name\": \"1*3\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"spec_id\": 2,\n" +
            "        \"spec_name\": \"口味\",\n" +
            "        \"res\": [\n" +
            "          {\n" +
            "            \"attr_id\": 30328,\n" +
            "            \"attr_name\": \"甜\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"attr_id\": 30329,\n" +
            "            \"attr_name\": \"酸\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"spec_id\": 6,\n" +
            "        \"spec_name\": \"颜色\",\n" +
            "        \"res\": [\n" +
            "          {\n" +
            "            \"attr_id\": 30327,\n" +
            "            \"attr_name\": \"红\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"attr_id\": 30330,\n" +
            "            \"attr_name\": \"黄\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ],\n" +
            "    \"goods_sku\": [\n" +
            "      {\n" +
            "        \"sku_id\": 30096,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30326,2:30328,6:30327}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 417,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30097,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30326,2:30329,6:30327}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 489,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30098,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30326,2:30328,6:30330}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 500,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30099,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30326,2:30329,6:30330}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 405,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30100,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30331,2:30328,6:30327}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 252,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30101,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30331,2:30329,6:30327}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 543,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30102,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30331,2:30328,6:30330}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 571,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30103,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30332,2:30329,6:30330}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 323,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30104,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30333,2:30328,6:30327}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 477,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30105,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30333,2:30328,6:30330}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 253,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30106,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30333,2:30329,6:30327}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 385,\n" +
            "        \"sh_price\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"sku_id\": 30107,\n" +
            "        \"goods_id\": 5528,\n" +
            "        \"sku_attr\": \"{1:30333,2:30329,6:30330}\",\n" +
            "        \"price\": \"1.00\",\n" +
            "        \"inventory\": 10000,\n" +
            "        \"sales\": 0,\n" +
            "        \"pack_attr\": \"{\\\"l\\\":\\\"1\\\",\\\"w\\\":\\\"1\\\",\\\"h\\\":\\\"1\\\",\\\"v\\\":1,\\\"wg\\\":\\\"1\\\"}\",\n" +
            "        \"refrigerate\": \"-18℃\",\n" +
            "        \"tiered_pri\": \"\",\n" +
            "        \"virtual_sales\": 543,\n" +
            "        \"sh_price\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
}

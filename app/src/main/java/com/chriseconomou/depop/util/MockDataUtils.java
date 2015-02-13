package com.chriseconomou.depop.util;

import android.content.Context;

import com.chriseconomou.depop.data.ProductsResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Utils for obtaining mock json data.
 */
public class MockDataUtils {




    public static  ProductsResponse getCategoriesMenResponse(Context context) {
        return ( ProductsResponse) getMockResponse(context, "products_custom.json",  ProductsResponse.class);
    }


    private static Object getMockResponse(Context context, String fileName, Class className) {
        String jsonString = getJsonString(context, fileName);
        return GsonUtil.deserialize(jsonString, className);
    }


    public static String getJsonString(Context context, String fileName) {
        String jsonString = null;

        StringBuilder builder = new StringBuilder();
        InputStream json;
        try {
            json = context.getAssets().open("mock/" + fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(json));
            String str;

            while ((str = in.readLine()) != null) {
                builder.append(str);
            }

            in.close();
            jsonString = builder.toString();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return jsonString;
    }

}
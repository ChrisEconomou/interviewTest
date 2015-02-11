package com.chriseconomou.depop.util;

import android.content.Context;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.mime.TypedInput;

/**
 * Utils for obtaining mock json data.
 */
public class MockDataUtils {

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
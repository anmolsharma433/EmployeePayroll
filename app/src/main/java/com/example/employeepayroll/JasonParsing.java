package com.example.employeepayroll;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JasonParsing {
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is = context.getAssets().open("userdata.jason");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

package com.yangb66.layoutstudy;

import android.content.Context;
import android.graphics.Typeface;

import java.lang.reflect.Field;

/**
 * Created by 彪 on 2017/11/18.
 */


    public final class FontsOverride {

        public static void setDefaultFont(Context context,
                                          String staticTypefaceFieldName, String fontAssetName) {
            final Typeface regular = Typeface.createFromAsset(context.getAssets(),
                    fontAssetName);
            replaceFont(staticTypefaceFieldName, regular);
        }


        protected static void replaceFont(String staticTypefaceFieldName,
                                          final Typeface newTypeface) {
            try {
                final Field staticField = Typeface.class
                        .getDeclaredField(staticTypefaceFieldName);
                staticField.setAccessible(true);
                staticField.set(null, newTypeface);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


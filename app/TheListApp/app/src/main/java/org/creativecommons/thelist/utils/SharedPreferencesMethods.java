package org.creativecommons.thelist.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by damaris on 2014-11-18.
 */
public class SharedPreferencesMethods {
    public static final String TAG = SharedPreferencesMethods.class.getSimpleName();

    protected Context mContext;

    public SharedPreferencesMethods(Context mContext) {
        this.mContext = mContext;
    }

    //SharedPreferences Constants
    public static final String CATEGORY_PREFERENCE = "category";
    public static final String CATEGORY_PREFERENCE_KEY = "org.creativecommons.thelist.445329";
    public static final String LIST_ITEM_PREFERENCE = "item";
    public static final String LIST_ITEM_PREFERENCE_KEY = "org.creativecommons.thelist.348914";


    //TODO:Methods for adding extracting array

    //Add Array to SharedPreferences
    public void SaveSharedPreference (String preferenceName, String key, String value){
        SharedPreferences sharedPref = mContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public JsonArray RetrieveSharedPreference (String preferenceName, String preferenceKey){
        SharedPreferences sharedPref = mContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        String value = sharedPref.getString(preferenceKey, null);

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(value);
        JsonArray categoryArray = element.getAsJsonArray();

        return categoryArray;
    }

}

package com.example.android.contactsapp.local;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Converter {

@TypeConverter
public static HashMap<String,String> fromString(String value){
    Type type = new TypeToken<HashMap<String,String>>(){}.getType();
    return new Gson().fromJson(value,type);
}

@TypeConverter
    public static String fromHashMap(HashMap<String,String> hashMap){

    Gson gson=new Gson();
    String json=gson.toJson(hashMap);
    return json;
}
}

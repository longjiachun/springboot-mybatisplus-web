package com.vstaryw.web.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static String toJson(Object obj){
        return JSON.toJSONString(obj);
    }

    public static <T> T parseJson(String json,Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }

    public static <T> List<T> parseJsonArray(String json,Class<T> clazz){
        return JSON.parseArray(json,clazz);
    }

    public static List<String> toJsonList(Collection<?> list){
        if(list == null){
            return null;
        }
        List<String> result = new ArrayList<String>();
        for(Object obj : list){
            result.add(toJson(obj));
        }
        return  result;
    }

    public static <T> List<T> paraseJsonList(List<String> list,Class<T> clazz){
        if (list == null) {
            return null;
        }

        List<T> result = new ArrayList<T>();
        for (String s : list) {
            result.add(parseJson(s, clazz));
        }
        return result;
    }

    public static Map<String,Object> objToMap(Object obj){
        return JSON.parseObject(JSON.toJSONString(obj),Map.class);
    }

    public static Map<String,Object> objToMapBySelected(Object obj, String... properties){
        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(properties);
        String json = JSON.toJSONString(obj, simplePropertyPreFilter);
        return JSON.parseObject(json,Map.class);
    }

    public static List<Map> listToMapListBySelected(Object obj, String... properties){
        SimplePropertyPreFilter simplePropertyPreFilter = new SimplePropertyPreFilter(properties);
        String jsonString = JSONArray.toJSONString(obj, simplePropertyPreFilter);
        return JSONArray.parseArray(jsonString,Map.class);
    }

}

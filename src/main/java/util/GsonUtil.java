package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author weilu
 * @date 2021/8/19
 */
public class GsonUtil {
    public static final Gson GSON = new GsonBuilder().create();

    private static Type type = new TypeToken<Map<String, Object>>() {
    }.getType();

    private static Type listType = new TypeToken<List<Map<String, Object>>>() {
    }.getType();

    private static Type mapType = new TypeToken<Map<String, Map<String, Long>>>() {
    }.getType();

    /**
     * 将对象转化为json字符串
     *
     * @param obj 对象
     */
    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    /**
     * 将json字符串转化为Map<String,Object>对象
     *
     * @param json 需要解析的json字符串
     */
    public static Map<String, Object> fromJson(String json) {
        return GSON.fromJson(json, type);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return GSON.fromJson(json, typeOfT);
    }

    /**
     * 将json字符串转化为List<Map<String,Object>>对象
     *
     * @param json 需要解析的json字符串
     */
    public static List<Map<String, Object>> listMapFromJson(String json) {
        return GSON.fromJson(json, listType);
    }

    /**
     * 将json字符串转化为对象
     *
     * @param json 需要解析的json字符串
     * @param clss 对象的类型
     * @return 解析后的对象
     */
    public static <T> T fromJson(String json, Class<T> clss) {
        return GSON.fromJson(json, clss);
    }

    /**
     * 解析嵌套map
     *
     * @param json
     * @return
     */
    public static Map<String, Map<String, Long>> mapFromJson(String json) {
        return GSON.fromJson(json, mapType);
    }
}

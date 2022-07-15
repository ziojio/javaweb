package z.java.code.datastructure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

// 散列存储数据
public class MapSample {

    public static void main(String[] args) {

        Hashtable<String,String> hashtable = new Hashtable<>();

        HashMap<String,String> map = new HashMap<>();
        map.put("a", "b");

        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("a", "b");

        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("a", "b");

    }
}


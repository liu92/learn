package org.learn.jdk.hashmapd;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: HashDemo
 * @Description:
 * @Author: lin
 * @Date: 2019/9/25 16:00
 * History:
 * @<version> 1.0
 */
public class HashDemo {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("1","3434");
        System.out.println(map);
    }
}

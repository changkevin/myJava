package com.zhang.myjava.datastructure.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zck on 2018/8/30.
 */
public class LinkedHashMapLRU<K, V> extends LinkedHashMap<K, V> implements Map<K, V> {
    public LinkedHashMapLRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size() > 6) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedHashMapLRU<Character, Integer> lru = new LinkedHashMapLRU<Character, Integer>(
                16, 0.75f, true);

        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
    }
}

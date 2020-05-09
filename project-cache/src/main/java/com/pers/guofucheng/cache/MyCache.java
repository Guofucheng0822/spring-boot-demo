package com.pers.guofucheng.cache;

import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

/**
 * 缓存
 *
 * @author guofucheng
 * @date 2020/05/09
 */
@Component
public class MyCache<K, V> {

    @Autowired
    private LoadingCache<K, V> loadingCache;


    public V get(K key) {
        return loadingCache.getIfPresent(key);
    }

    public V put(K key, V value) {
        loadingCache.put(key, value);
        return value;
    }

    public V remove(K key) {
        V v = get(key);
        loadingCache.invalidate(key);
        return v;
    }

    public void clear() {
        loadingCache.invalidateAll();
    }

    public int size() {
        return (int)loadingCache.size();
    }

    public Set<K> keys() {
        return loadingCache.asMap().keySet();
    }

    public Collection<V> values() {
        return loadingCache.asMap().values();
    }
}

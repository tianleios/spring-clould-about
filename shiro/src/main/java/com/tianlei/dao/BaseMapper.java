package com.tianlei.dao;

public interface BaseMapper<T> {

    int save(T obj);
    T findByName(String name);
    T findById(Long id);
}

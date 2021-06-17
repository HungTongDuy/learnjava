package com.example.demo.GenericType;

public class StringAndValueEntry<V> extends KeyValue<String, V> {

    public StringAndValueEntry(String key, V value) {
        super(key, value);
    }
}

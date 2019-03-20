package com.example.demo.common.serializer;

public interface ISerializer {
    <T> byte[] serializer(T obj);
    <T> T deserializer(byte[] data,Class<T> clazz);
}

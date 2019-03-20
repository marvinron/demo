package com.example.demo.common.serializer;


import com.thoughtworks.xstream.XStream;

public class XMLSerializer implements ISerializer {
    private XStream xStream = new XStream();

    @Override
    public <T> byte[] serializer(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserializer(byte[] data, Class<T> clazz) {
        return (T)xStream.fromXML(new String(data));
    }
}

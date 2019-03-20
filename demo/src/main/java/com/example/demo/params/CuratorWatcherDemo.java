package com.example.demo.params;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Vector;

public class CuratorWatcherDemo {
    static Vector v = new Vector();
    public static void main(String[] args) {

        CuratorFramework curator = CuratorFrameworkFactory.builder().connectString("192.168.11.153:2181,192.168.11.154:2181,192.168.11.155:2181")
                .sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).namespace("curator").build();
        curator.start();

    }
}

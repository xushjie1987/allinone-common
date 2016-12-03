/**
 * Project Name:allinone-common
 * File Name:DaemonTest.java
 * Package Name:com.allinone.common.util
 * Date:2016年12月3日下午7:04:07
 * Copyright (c) 2016, All Rights Reserved.
 *
*/
package com.allinone.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.allinone.common.util.Daemon.DaemonFactory;

/**
 * ClassName:DaemonTest <br/>
 * Function: <br/>
 * Date: 2016年12月3日 下午7:04:07 <br/>
 * 
 * @author shengjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class DaemonTest {
    @Test
    public void testDaemon_1() throws InterruptedException {
        // 镜像线程工厂
        DaemonFactory df = new DaemonFactory();
        // 创建镜像线程
        Daemon d = (Daemon) df.newThread(() -> {
            try {
                while (true) {
                    System.out.println("Hello Daemon.");
                    Thread.sleep(1000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // 启动镜像线程
        d.start();
        // 检查镜像线程
        System.out.println(d.isDaemon());
        Thread.sleep(3000L);
        System.out.println("Bye Bye.");
    }
    
    @Test
    public void testDaemon_2() throws InterruptedException {
        ExecutorService s = Executors.newFixedThreadPool(3,
                                                         new DaemonFactory());
        for (int i = 0; i < 3; i++) {
            s.submit(() -> {
                System.out.println("I'm " + Thread.currentThread()
                                                  .getName());
            });
        }
    }
}

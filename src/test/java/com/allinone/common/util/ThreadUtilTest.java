/**
 * Project Name:allinone-common
 * File Name:ThreadUtilTest.java
 * Package Name:com.allinone.common.util
 * Date:2016年12月3日下午8:46:23
 * Copyright (c) 2016, All Rights Reserved.
 *
*/
package com.allinone.common.util;

import org.junit.Test;

/**
 * ClassName:ThreadUtilTest <br/>
 * Function: <br/>
 * Date: 2016年12月3日 下午8:46:23 <br/>
 * 
 * @author shengjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class ThreadUtilTest {
    @Test
    public void testSleepAtLeastIgnoreInterrupts() throws InterruptedException {
        Thread t = new Thread(() -> {
            long start = System.currentTimeMillis();
            ThreadUtil.sleepAtLeastIgnoreInterrupts(2000L);
            System.out.println("Elasped time: " + (System.currentTimeMillis() - start) + "ms");
        });
        t.start();
        Thread.sleep(300L);
        t.interrupt();
        Thread.sleep(300L);
        t.interrupt();
        Thread.sleep(300L);
        t.interrupt();
        Thread.sleep(300L);
        t.interrupt();
        Thread.sleep(300L);
        t.interrupt();
        Thread.sleep(1000L);
    }
}

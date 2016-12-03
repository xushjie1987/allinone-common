/**
 * Project Name:allinone-common
 * File Name:StopWatchTest.java
 * Package Name:com.allinone.common.util
 * Date:2016年12月3日下午3:26:10
 * Copyright (c) 2016, All Rights Reserved.
 *
*/
package com.allinone.common.util;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * ClassName:StopWatchTest <br/>
 * Function: <br/>
 * Date: 2016年12月3日 下午3:26:10 <br/>
 * 
 * @author shengjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class StopWatchTest {
    @Test
    public void testStopWatch_1() {
        try (StopWatch sw = new StopWatch()) {
            // 启动计时器
            sw.start();
            Thread.sleep(300L);
            // 当前耗时
            System.out.println(sw.now());
            // 停止计时器
            sw.stop();
            System.out.println(sw);
            Thread.sleep(2200L);
            // 当前耗时
            System.out.println(sw.now(TimeUnit.MILLISECONDS));
            // 启动计时器
            sw.start();
            Thread.sleep(1100L);
            // 当前耗时
            System.out.println(sw.now());
            Thread.sleep(1100L);
            // 停止计时器
            sw.stop();
            // 当前耗时
            System.out.println(sw.now());
            // 再次启动计时器
            sw.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

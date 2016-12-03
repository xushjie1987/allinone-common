/**
 * Project Name:allinone-common
 * File Name:TimeTest.java
 * Package Name:com.allinone.common.util
 * Date:2016年12月3日下午8:24:08
 * Copyright (c) 2016, All Rights Reserved.
 *
*/
package com.allinone.common.util;

import org.junit.Test;

/**
 * ClassName:TimeTest <br/>
 * Function: <br/>
 * Date: 2016年12月3日 下午8:24:08 <br/>
 * 
 * @author shengjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class TimeTest {
    @Test
    public void test_1() {
        System.out.println("monotonicNow(): " + Time.monotonicNow());
        System.out.println("now(): " + Time.now());
    }
}

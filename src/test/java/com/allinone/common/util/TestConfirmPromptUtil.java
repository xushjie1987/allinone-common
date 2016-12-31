/**
 * Project Name:allinone-common
 * File Name:TestConfirmPromptUtil.java
 * Package Name:com.allinone.common.util
 * Date:2016年12月31日下午11:02:23
 * Copyright (c) 2016, All Rights Reserved.
 *
*/
package com.allinone.common.util;

import java.io.IOException;

import org.junit.Test;

/**
 * ClassName:TestConfirmPromptUtil <br/>
 * Function: <br/>
 * Date: 2016年12月31日 下午11:02:23 <br/>
 * 
 * @author shengjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class TestConfirmPromptUtil {
    
    @Test
    public void test1() throws IOException {
        ConfirmPromptUtil.confirmPrompt("Hello confirm prompt? ");
    }
}

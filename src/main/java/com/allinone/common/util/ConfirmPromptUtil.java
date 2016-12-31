/**
 * Project Name:allinone-common
 * File Name:ConfirmPromptUtil.java
 * Package Name:com.allinone.common.util
 * Date:2016年12月31日下午11:01:31
 * Copyright (c) 2016, All Rights Reserved.
 *
*/
package com.allinone.common.util;

import java.io.IOException;

/**
 * ClassName:ConfirmPromptUtil <br/>
 * Function: <br/>
 * Date: 2016年12月31日 下午11:01:31 <br/>
 * 
 * @author shengjie
 * @version
 * @since JDK 1.8
 * @see
 */
public class ConfirmPromptUtil {
    /**
     * Print out a prompt to the user, and return true if the user responds with "y" or "yes". (case
     * insensitive)
     */
    public static boolean confirmPrompt(String prompt) throws IOException {
        while (true) {
            System.err.println(prompt + " (Y or N) ");
            StringBuilder responseBuilder = new StringBuilder();
            while (true) {
                int c = System.in.read();
                if (c == -1 || c == '\r' || c == '\n') {
                    break;
                }
                responseBuilder.append((char) c);
            }
            
            String response = responseBuilder.toString();
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                return true;
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
                return false;
            }
            System.err.println("Invalid input: " + response);
            // else ask them again
        }
    }
}

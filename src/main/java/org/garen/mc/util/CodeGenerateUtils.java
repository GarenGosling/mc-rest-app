package org.garen.mc.util;

import java.util.UUID;

/**
 * Created by ylm on 2017/9/19.
 */
public class CodeGenerateUtils {
    public static String getRandomCode(){
        return UUID.randomUUID().toString();
    }
}

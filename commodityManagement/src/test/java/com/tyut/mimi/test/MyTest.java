package com.tyut.mimi.test;

import com.tyut.mimi.utils.MD5Util;
import org.junit.Test;

public class MyTest {

    @Test
    public void testMD5(){
        String mi = MD5Util.getMD5("000000");
        System.out.println(mi);
    }
}

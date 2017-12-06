package com.blog.test;

import com.blog.dao.bottom.DataDispose;
import org.junit.Test;

public class testDataDispose {

    @Test
    public void testLogin(){
        DataDispose ldd = new DataDispose();
       System.out.println(ldd.getForLogin("root","2098231"));

    }
}

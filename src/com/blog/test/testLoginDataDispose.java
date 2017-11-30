package com.blog.test;

import com.blog.dao.bottom.LoginDataDispose;
import org.junit.Test;

public class testLoginDataDispose {

    @Test
    public void testLogin(){
        LoginDataDispose ldd = new LoginDataDispose();
       System.out.println(ldd.getForLogin("root","2098231"));

    }
}

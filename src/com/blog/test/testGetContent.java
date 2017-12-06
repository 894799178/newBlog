package com.blog.test;

import com.blog.dao.bottom.DataDispose;
import org.junit.Test;

public class testGetContent {
    @Test
    public void testGetContents(){
        DataDispose contentDataDispose = new DataDispose();
        System.out.println(contentDataDispose.getTitle(0));
        System.out.println(  contentDataDispose.getContent(1));
    }
}

package com.blog.test;

import com.blog.dao.bottom.ContentDataDispose;
import org.junit.Test;

public class testGetContent {
    @Test
    public void testGetContents(){
        ContentDataDispose contentDataDispose = new ContentDataDispose();
        System.out.println(contentDataDispose.getTitle(0));
        System.out.println(  contentDataDispose.getContent(1));
    }
}

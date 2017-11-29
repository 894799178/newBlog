package com.blog.test;

import com.blog.dao.db.DataDisposeInterfaceImp;
import org.junit.Test;

public class testDataDisposeInterfaceImp extends DataDisposeInterfaceImp {


    @Test
    public void testGetAll(){
        System.out.print(super.getAll());
    }
}

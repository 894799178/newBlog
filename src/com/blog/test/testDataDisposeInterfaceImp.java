package com.blog.test;

import com.blog.dao.db.DataDisposeInterfaceImp;
import org.junit.Test;

public class testDataDisposeInterfaceImp extends DataDisposeInterfaceImp {



    @Test
    public void testGetAll() {

        System.out.print(super.getAll());
    }
    @Test
    public void testGetForId(){
        System.out.println(super.getById(1));
    }
}

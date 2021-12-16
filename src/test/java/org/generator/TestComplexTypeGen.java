package org.generator;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestComplexTypeGen extends Assert {
    ComplexTypeGen r = new ComplexTypeGen(0);

    @Test
    public void uniqueness() {
        int sz = Employee.INSTANCE.size();
        Set<String> s = new HashSet<String>(sz);

        for (int i=0; i<sz; i++)
            assertTrue(s.add(r.next()));

        assertFalse(s.add(r.next()));
    }

    @Test
    public void firstTen() {
        for (int i=0; i<10; i++)
            //System.out.println("**********TestCase"+i+"**********");
            System.out.println("**********TestCase"+(i+1)+"**********"+"\n"+r.next()+"\n");
    }
}

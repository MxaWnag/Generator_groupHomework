package org.generator;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CodeTest的测试类
 *
 * @author qingke
 * @date 2021-12-12 18:02:36
 */
public class CodeTestTest {

        @Test
        public void testAdd(){
        CodeTest testObj=new CodeTest();
        int result = testObj.Add(1,2);
        assertEquals(result,3);
        }

}
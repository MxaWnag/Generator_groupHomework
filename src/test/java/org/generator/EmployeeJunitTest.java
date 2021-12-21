package org.generator;


import org.generator.EmployeeJunit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EmployeeJunit的测试类
 *
 * @author 
 * @date 2021-12-21 09:24:48
 */
public class EmployeeJunitTest {

        @Test
        public void testUniqueness(){
        EmployeeJunit testObj=new EmployeeJunit();
        assertTrue(testObj.Uniqueness());
        }
        @Test
        public void testSize(){
        EmployeeJunit testObj=new EmployeeJunit();
        assertTrue(testObj.Size());
        }
        @Test
        public void testIfadult(){
        EmployeeJunit testObj=new EmployeeJunit();
        assertTrue(testObj.Ifadult());
        }

}
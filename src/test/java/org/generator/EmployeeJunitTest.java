package org.generator;


import org.generator.EmployeeJunit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * EmployeeJunit的测试类
 *
 * @date 2021-12-24 01:33:00
 */
public class EmployeeJunitTest {

        @Test
        public void testIfadult(){
        EmployeeJunit testObj=new EmployeeJunit();
        assertTrue(testObj.Ifadult());
        }
        @Test
        public void testIfvalid(){
        EmployeeJunit testObj=new EmployeeJunit();
        assertTrue(testObj.Ifvalid());
        }
        @Test
        public void testIfonly(){
        EmployeeJunit testObj=new EmployeeJunit();
        assertTrue(testObj.Ifonly());
        }
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

}
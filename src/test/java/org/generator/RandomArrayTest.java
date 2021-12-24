package org.generator;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;
public class RandomArrayTest {
    RandomArray ra = new RandomArray();
    Random rand = new Random();
    int[] arr1 = ra.genInt(5,100);
    String[] str = ra.getStr(5);
    Boolean[] arr2 = ra.getboolean(5);
    double[] dou = ra.getfloat(5,0,10);


    @Test
    public void ifEmpty(){
        int[] tmp = ra.genInt(0,0);
        String[] tmp1 = ra.getStr(rand.nextInt(20)+1);
        boolean res = true;
        assertEquals(res,(boolean) (arr1.length!=0));
        assertEquals(res,(boolean) (arr2.length!=0));
        assertEquals(res,(boolean) (str.length!=0));
        assertEquals(res,(boolean) (dou.length!=0));
        assertEquals(res,(tmp.length==0));
        assertEquals(res,tmp1.length!=0);
    }

    @Test
    public void ifValid(){
        boolean flag = true;
        for (int i=0;i<arr1.length;i++){
            if(arr1[i]>100||dou[i]>10||dou[i]<0){
                flag = false;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void lengthTest(){
        int res =5;
        int len = rand.nextInt(20);
        int[] tmp = ra.genInt(len,len);
        assertEquals(res,arr1.length);
        assertEquals(res,arr2.length);
        assertEquals(res,str.length);
        assertEquals(res,dou.length);
        assertEquals(len,tmp.length);
    }
}

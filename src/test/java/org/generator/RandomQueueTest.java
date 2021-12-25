package org.generator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

public class RandomQueueTest {
    RandomQueue<Integer> rd = new RandomQueue<Integer>();
    RandomArray ra = new RandomArray();
    Random rand = new Random();
    int len =rand.nextInt(50);
    int[] arr = ra.genInt(len,20);
    Collection<Integer> str = new ArrayList<>();
    int[] tmp ={1,1,1,2,3};

    @Test
    public void ifEmpty(){
        assertTrue(rd.isEmpty());
        //生成随机数，来进行判断
        for (int i=0;i<arr.length;i++)
            rd.add(arr[i]);
        assertEquals(len,arr.length);

    }
    @Test
    public void ifRemove(){
        rd.add(1);
        rd.add(1);
        rd.add(0);
        assertTrue( rd.remove(1));
        assertFalse(rd.remove(2));
        assertTrue(rd.remove(0));
    }

    @Test
    public void ifRemoveAll(){

        for(int i=0;i<tmp.length;i++){
            str.add(tmp[i]);
        }
        //检查removeAll（只添加str）
        rd.addAll(str);
        assertTrue(rd.removeAll(str));
        assertFalse(rd.containsAll(str));

        //再添加一个元素，检查removeAll
        rd.addAll(str);
        rd.add(4);
        assertTrue(rd.removeAll(str));
        assertFalse(rd.isEmpty());
        assertTrue(rd.contains(4));
        assertFalse(rd.contains(1));
    }

    @Test
    public void ifAddAll(){
        for(int i=0;i<tmp.length;i++){
            str.add(tmp[i]);
        }
        //检查addAll
        rd.addAll(str);
        assertTrue(rd.containsAll(str));
        assertTrue(rd.contains(1));

        //检查add
        assertFalse(rd.contains(4));
        rd.add(4);
        assertTrue(rd.contains(4));


    }
}

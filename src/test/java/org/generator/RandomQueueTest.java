package org.generator;

import org.junit.Test;

import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

public class RandomQueueTest {


    @Test
    public void ifEmpty(){
        RandomQueue<Integer> rd = new RandomQueue<Integer>();
        RandomArray ra = new RandomArray();
        Random rand = new Random();
        int len =rand.nextInt(50);
        int[] arr = ra.genInt(len,20);
        for (int i=0;i<arr.length;i++)
            rd.add(arr[i]);
        assertEquals(len,arr.length);
    }

}

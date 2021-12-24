package org.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomArray {
    private static final String[] STRINGS_SOURCE = new String[]{"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private static final int STR_LEN = STRINGS_SOURCE.length;

    //int类型随机数组生成
    public int[] genInt(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

    //String类型变量数组的生成
    public String[] getStr(int len){
        String[] strings = new String[len];
        List<String> stringslist = Arrays.asList(STRINGS_SOURCE);
        //打乱元素排序
        for (int j=0;j<len;j++) {
            Collections.shuffle(stringslist);

            StringBuilder randomStr = new StringBuilder();
            for (int i = 0; i < STR_LEN; i++) {
                randomStr.append(stringslist.get(i));
            }
            //随机截取16位字符串
            Random stringRand = new Random();
            int i = stringRand.nextInt(STR_LEN - 16);

            strings[j] = randomStr.substring(i, i + 16);
        }
        return strings;
    }

    //浮点数类型数组的生成
    public double[] getfloat(int len,int min,int max){
        double[] floats = new double[len];

        for (int i=0;i<len;i++){
            floats[i]=min + ((max - min) * new Random().nextDouble());
        }
        return floats;
    }

    //布尔类型数组的生成
    public Boolean[] getboolean(int len){
        Boolean[] booleans = new Boolean[len];
        Random rand = new Random();
        for (int i=0;i<len;i++){
            booleans[i] = rand.nextBoolean();
        }
        return booleans;
    }

}

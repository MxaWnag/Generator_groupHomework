package org.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.*;
import java.util.*;


public class Employee {

    private List<String> firstname = new ArrayList<String>();
    private List<String> lastname = new ArrayList<String>();
    private int age;
    private boolean hasMarry;
    private String ID;
    private float grade;
    private int CaseNumber;
    int count = 1 ;

    Random rand = new Random();
    private final int prime;
    private static final String[] STRINGS_SOURCE = new String[]{"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private static final int STR_LEN = STRINGS_SOURCE.length;

    public Employee() {
        try {
            load("firstname.txt", firstname);
            load("lastname.txt", lastname);

        } catch (IOException e) {
            throw new Error(e);
        }


        int combo = size();

        int primeCombo = 2;
        while (primeCombo<=combo) {
            int nextPrime = primeCombo+1;
            primeCombo *= nextPrime;
        }
        prime = primeCombo+1;
    }

    public int getAge(){
        return this.age;
    }
    public float getGrade(){
        return this.grade;
    }
    public String getID(){
        return this.ID;
    }
    public int size() {
        return firstname.size()*lastname.size();
    }

    public int getPrime() {
        return prime;
    }


    //随机生成浮点数
    public static double doubleGen(final double min, final double max) {
        return min + ((max - min) * new Random().nextDouble());
    }
    //保留四位小数
    public static String formateRate(String rateStr) {
        if (rateStr.indexOf(".") != -1) {
            // 获取小数点的位置
            int num = 0;
            num = rateStr.indexOf(".");

            String dianAfter = rateStr.substring(0, num + 2);
            String afterData = rateStr.replace(dianAfter, "");

            return rateStr.substring(0, num) + "." + afterData.substring(0, 4);
        } else {
            if (rateStr == "1") {
                return "10000";
            } else {
                return rateStr;
            }
        }
    }




    // 使用 Collections.shuffle 生成16位随机字符串
    private static String idGen() {
        List<String> stringslist = Arrays.asList(STRINGS_SOURCE);
        //打乱元素排序
        Collections.shuffle(stringslist);
        StringBuilder randomStr = new StringBuilder();
        for (int i = 0; i < STR_LEN; i++) {
            randomStr.append(stringslist.get(i));
        }
        //随机截取16位字符串
        Random stringRand = new Random();
        int i = stringRand.nextInt(STR_LEN-16);
        return randomStr.substring(i, i+16);
    }



    public String dataGeneration (int i) {
        int fn = i/firstname.size();
        int ln = i%lastname.size();
        age = rand.nextInt(27)+18;
        hasMarry = rand.nextBoolean();
        ID = idGen();
        String s= formateRate(String.valueOf(doubleGen(40.0000,100.0000)));
        grade= Float.parseFloat(s);


        CaseNumber = count;


        return "name:"+firstname.get(fn)+" "+lastname.get(ln)+"\n"+"age:"+age+"\n"+"hasMarry:"+hasMarry+"\n"
                +"ID:"+ID+"\n"+"grade:"+grade+"\n"+"CaseNumber:"+CaseNumber;
    }





    //逐行读取txt文件
    private void load(String name, List<String> col) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(name),"US-ASCII"));
        try {
            String line;
            while ((line=r.readLine())!=null)
                col.add(line);
        } finally {
            r.close();
        }
    }

    static final Employee INSTANCE = new Employee();
}

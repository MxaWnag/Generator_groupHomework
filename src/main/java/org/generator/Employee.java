package org.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {
    private List<String> firstname = new ArrayList<String>();
    private List<String> lastname = new ArrayList<String>();
    private int age;
    private boolean hasMarry;
    Random rand = new Random();
    private final int prime;

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


    public int size() {
        return firstname.size()*lastname.size();
    }

    /**
     * Sufficiently big prime that's bigger than {@link #size()}
     */
    public int getPrime() {
        return prime;
    }

    public String combination (int i) {
        int fn = i/firstname.size();
        int ln = i%lastname.size();
        age = rand.nextInt(27)+18;
        hasMarry = rand.nextBoolean();

        return "name:"+firstname.get(fn)+" "+lastname.get(ln)+"\n"+"age:"+age+"\n"+"hasMarry:"+hasMarry;
    }
    public int getAge(){
        return this.age;
    }
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

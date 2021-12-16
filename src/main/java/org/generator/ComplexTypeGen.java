package org.generator;


public class ComplexTypeGen {
    private int pos;

    public ComplexTypeGen(int seed) {
        this.pos = seed;
    }

    public ComplexTypeGen() {
        this((int) System.currentTimeMillis());
    } 
    public synchronized String next() {
        Employee d = Employee.INSTANCE;
        pos = Math.abs(pos+d.getPrime()) % d.size();
        return d.combination(pos);
    }
}

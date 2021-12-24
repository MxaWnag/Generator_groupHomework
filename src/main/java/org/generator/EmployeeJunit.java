package org.generator;

import java.util.HashSet;
import java.util.Set;

public class EmployeeJunit {

//生成测试用例的个数
    public boolean Size() {
        Employee d = new Employee();
        System.out.println(d.size());
         return (d.size()==450);
    }

//每个测试用例是否具有独特性
    public boolean Uniqueness(){
        ComplexTypeGen comp = new ComplexTypeGen();
        int sz = Employee.INSTANCE.size();
        Set<String> s = new HashSet<String>(sz);

        for (int i=0; i<sz; i++)
            s.add(comp.next());

        return s.add(comp.next());
    }
//测试是否每个测试年龄是否大于18
    public boolean Ifadult(){
        ComplexTypeGen comp = new ComplexTypeGen(0);
        int sz = Employee.INSTANCE.size();
        for(int i=0;i<sz;i++){
            if(comp.getAge()<18){
                return false;
            }
            else
                comp.next();
        }
        return true;
    }
    //测试grade
    public boolean Ifvalid(){
        ComplexTypeGen comp = new ComplexTypeGen(0);
        int sz = Employee.INSTANCE.size();

        for(int i=0;i<sz;i++){
            if(comp.getGrade()<40||comp.getGrade()>100){
                return false;
            }
            else
                comp.next();
        }
        return true;
    }

    //测试ID的唯一性
    public boolean Ifonly(){

            ComplexTypeGen comp = new ComplexTypeGen(0);
            int sz = Employee.INSTANCE.size();
        Set<String> s = new HashSet<String>(sz);
            for(int i=0;i<sz;i++){
                if(!s.add(comp.getID())){
                    return false;
                }
                else
                    comp.next();
            }
            return true;

    }

}

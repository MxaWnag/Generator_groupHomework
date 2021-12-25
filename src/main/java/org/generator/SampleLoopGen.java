package org.generator;
//Authority:YinGe
public class SampleLoopGen {
    public void testSimple1(){
        SampleLoop s1 = new SampleLoop();
        //Test1不进入循环变量
        System.out.println("不进入循环变量");
        s1.getIteration(1);
        s1.SampleLoopRun1();
        //Test2 循环一次
        System.out.println("进入一次循环变量");
        s1.getIteration(2);
        s1.SampleLoopRun1();
        //Test3 循环10次；
        System.out.println("进入十次循环变量");
        s1.getIteration(11);
        s1.SampleLoopRun1();
        System.out.println("测试结束");



    }
    public void testSimple2()
    {
        SampleLoop s2 = new SampleLoop();
        //进入while循环
        System.out.println("进入while循环");
        s2.getCondition(true);
        s2.SampleLoopRun2();
        //不进入while循环
        System.out.println("不进入while循环");
        s2.getCondition(false);
        s2.SampleLoopRun2();
    }
}

package org.generator;
//Authority:YinGe
public class SampleLoopGen {
    public void test(){
        SampleLoop s = new SampleLoop();
        //Test1不进入循环变量
        System.out.println("不进入循环变量");
        s.getIteration(1);
        s.SampleLoopRun();
        //Test2 循环一次
        System.out.println("进入一次循环变量");
        s.getIteration(2);
        s.SampleLoopRun();
        //Test3 循环10次；
        System.out.println("进入十次循环变量");
        s.getIteration(11);
        s.SampleLoopRun();
        System.out.println("测试结束");



    }
}

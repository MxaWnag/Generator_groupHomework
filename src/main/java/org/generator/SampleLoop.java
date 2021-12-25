package org.generator;
//Authority:YinGe
public class SampleLoop {
    int iteration =0;
    boolean condition = false;
    public void SampleLoopRun1()
    {
        int iteration = this.iteration;
        for(int i=1;i<iteration;i++)
        {
            System.out.println(String.valueOf(i));
        }System.out.println("本次循环结构已结束");
        System.out.println(" ");
    }public void SampleLoopRun2()
    {
            boolean condition =this.condition;
            int i=0;
            while(condition &&i<=10)
            {
                System.out.println("在循环中");
                System.out.println(String.valueOf(i++));
            }System.out.println("本次循环结构已结束");
    }

    public void getIteration(int iteration)
    {
        this.iteration=iteration;
    }
    public void getCondition(boolean condition)
    {
        this.condition = condition;
    }

}

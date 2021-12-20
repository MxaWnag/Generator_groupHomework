package org.generator;
//Authority:YinGe
public class SampleLoop {
    int iteration =0;

    public void SampleLoopRun()
    {
        int iteration = this.iteration;
        for(int i=1;i<iteration;i++)
        {
            System.out.println(String.valueOf(i));
        }System.out.println("本次循环结构已结束");
        System.out.println(" ");
    }
    public void getIteration(int iteration)
    {
        this.iteration=iteration;
    }

}

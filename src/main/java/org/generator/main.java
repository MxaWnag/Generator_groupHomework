package org.generator;

import graph.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class main {
	//基于基路径的测试算法的实现运行
	public static void GraphRun(){
		GraphReader reader = new GraphReader("sese_graph.txt");
		Graph graph = reader.readFromFile();
		GraphVerfier graphVerfier = new GraphVerfier(graph);
		graphVerfier.buildSimplePaths();
		graphVerfier.printSimplePaths();
		graphVerfier.buildPrimePaths();
		System.out.println("\nPrime paths:");
		for (SimplePath primePath : graphVerfier.getPrimePaths()) {
			System.out.println(primePath);
		}
	}

	//复杂类型变量测试用例的生成
	public static void ComplexTypeGeneration(){
		ComplexTypeGen comp = new ComplexTypeGen(0);

		for (int i=0; i<20; i++)
			//System.out.println("**********TestCase"+i+"**********");
			System.out.println("**********TestCase"+(i+1)+"**********"+"\n"+comp.next()+"\n");
	}

	//随机数组的生成
	public static void RandomArrayGen(){
		RandomArray ra = new RandomArray();
		int[] arr1 = ra.genInt(5,100);
		String[] str = ra.getStr(5);
		Boolean[] arr2 = ra.getboolean(5);
		double[] dou = ra.getfloat(5,0,10);
		for (int n=0;n<5;n++){
			System.out.println("Integer:"+arr1[n]+" "
					+"String:"+str[n]+" "
					+"Boolean:"+arr2[n]+" "
					+"Double:"+dou[n]);

		}
	}
	//随机队列的生成
	public static void RandomQueueGen(){
		RandomQueue<Integer> rd = new RandomQueue<Integer>();
		RandomArray ra = new RandomArray();
		Random rand = new Random();
		int[] arr = ra.genInt(rand.nextInt(50),20);

		RandomQueue<Integer> test = new RandomQueue<>();
		test = test.generator();
		System.out.println(test.size());

		//System.out.println(arr.length);
		//通过add方法
		for (int i=0;i<arr.length;i++){
			rd.add(arr[i]);
		}
		//通过addAll方法
		Collection<Integer> str = new ArrayList<>();

		for(int i=0;i<arr.length;i++){
			str.add(arr[i]);
		}
		RandomQueue<Integer> rq = new RandomQueue<>();
		rq.addAll(str);
		System.out.println(arr.length);
		System.out.println(rq.size());

		System.out.println(rd.size());



	}
	//初始化代码生成器及执行
	public static void JunitGenerator(){
		JunitCodeGenerator codeGenerator=new JunitCodeGenerator("org.generator.EmployeeJunit","test");
		codeGenerator.run();
		String tmp = codeGenerator.getRootSrcPath();
		System.out.println(tmp+"\n");
	}
	public static void SampleLoopGenerator(){
		SampleLoopGen gen = new SampleLoopGen();
		gen.testSimple1();
		gen.testSimple2();
	}

	public static void main(String[] args) {

		GraphRun();//基路径生成
	    ComplexTypeGeneration();//复杂变量生成
		RandomArrayGen();//随机数组生成
		RandomQueueGen();//随机队列生成
		JunitGenerator();//junit单元测试生成
		SampleLoopGenerator();//循环结构测试生成

	}

}

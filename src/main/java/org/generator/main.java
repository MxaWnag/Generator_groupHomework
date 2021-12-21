package org.generator;

import graph.Graph;


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
		for (int i=0; i<10; i++)
			//System.out.println("**********TestCase"+i+"**********");
			System.out.println("**********TestCase"+(i+1)+"**********"+"\n"+comp.next()+"\n");
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
		gen.test();
	}

	public static void main(String[] args) {

		GraphRun();
		ComplexTypeGeneration();
		JunitGenerator();
		SampleLoopGenerator();
	}

}

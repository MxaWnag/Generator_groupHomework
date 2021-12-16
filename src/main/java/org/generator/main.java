package org.generator;

import graph.Graph;

public class main {

	public static void main(String[] args) {
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
		/*初始化代码生成器及执行
		JunitCodeGenerator codeGenerator=new JunitCodeGenerator("qingke","org.generator.CodeTest","test");
		codeGenerator.run();
		String tmp = codeGenerator.getRootSrcPath();
		System.out.println(tmp+"\n");

		 */

	}

}

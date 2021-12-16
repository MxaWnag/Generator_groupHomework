package org.generator;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 代码生成器
 *
 */
public class JunitCodeGenerator {
    /**
     * 包路径
     */
    private static final String BASE_PACKAGE = "test/java";//项目中代码根路径


    private String author;//注释中作者名称

    private String sourceClass="E:\\Software Testing  Verification\\wordnet-random-name-master\\src\\main\\java\\org\\generator\\CodeTest.java";//源类全路径

    private  String templateName="test.ftl";//模板名称
    //项目根路径
    private final String rootSrcPath = getClass().getResource("/").getPath().replaceAll("%20"," ").replace("/target/classes/","/src/");

    //模板路径
    final String templateDir = rootSrcPath + "main/java/org/generator";




    public JunitCodeGenerator(String author, String sourceClass, String templateName) {
        this.author = author;
        this.sourceClass=sourceClass;
        this.templateName=templateName;
    }

    public void run() {
        try {
            //反射获取源class对象
            Class sourceGalss=Class.forName(sourceClass);
            //生成目标测试类
            generate(sourceGalss, templateName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * 使用freemarker模板工具生成目标代码
     * void
     * @throws
     */
    private void generate(Class sourceGalss, String templateName)
            throws IOException, TemplateException {
        //freemarker配置
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //设置freemarker模板路径
        cfg.setDirectoryForTemplateLoading(new File(templateDir));
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        //获取模板对象
        Template template = cfg.getTemplate(templateName + ".ftl", "UTF-8");

        // 定义模板数据
        Package sourcePackage=sourceGalss.getPackage();
        Map<String, Object> data = new HashMap<>();
        //是否抽象类
        if (Modifier.isAbstract(sourceGalss.getModifiers())){
            data.put("isAbstract","1");
        }else {
            data.put("isAbstract","0");
        }
        //是否接口
        if (Modifier.isInterface(sourceGalss.getModifiers())){
            data.put("isInterface","1");
        }else {
            data.put("isInterface","0");
        }
        data.put("basePackage", BASE_PACKAGE+"."+sourcePackage.getName());
        data.put("realPackage", sourcePackage.getName());
        data.put("author", author);
        Method[] methods=sourceGalss.getDeclaredMethods();
        List<String> methodNameList=new ArrayList<>();
        for (int i = 0; i < methods.length; i++) {
            Method methods1=methods[i];
            if (Modifier.isPublic(methods1.getModifiers())){
                methodNameList.add(methods1.getName().substring(0,1).toUpperCase()+methods1.getName().substring(1));
            }
        }

        Constructor[] constructors=sourceGalss.getDeclaredConstructors();
        List<Integer> constructorList=new ArrayList<>();
        int count=0;
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor=constructors[i];
            if (Modifier.isPublic(constructor.getModifiers())){
                constructorList.add(count++);
            }
        }
        data.put("methods",methodNameList);
        data.put("constructorList",constructorList);
        data.put("date", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        data.put("className", sourceGalss.getSimpleName());


        // 输出文件

        String fileName = sourceGalss.getSimpleName().substring(0, 1).toUpperCase() + sourceGalss.getSimpleName().substring(1);
        final String outFile =
                rootSrcPath +  BASE_PACKAGE.replace(".", "/") + "/"  +sourcePackage.getName().replace(".","/").replace("/main/","/test/")+"/"+
                        fileName + "Test.java";
        System.out.println("sourcePackageName:"+sourcePackage.getName()+"\n");
        final String outFilePath=rootSrcPath +  BASE_PACKAGE.replace(".", "/") + "/"  +sourcePackage.getName().replace(".","/");
        File filePath=new File(outFilePath);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        Writer out = new FileWriter(outFile);
        template.process(data, out);

        System.out.println(templateName + "文件生成成功：" + outFile);
    }

    public String getRootSrcPath() {
        return rootSrcPath;
    }
}
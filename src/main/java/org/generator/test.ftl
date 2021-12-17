package org.generator;


import ${realPackage}.${className};
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ${className}的测试类
 *
 * @author ${author}
 * @date ${date}
 */
public class ${className}Test {
<#if (isAbstract == "1")>
    //abstract
</#if>
<#if (isInterface == "1")>
    //interface
</#if>
    <#if (isAbstract != "1")&&(isInterface != "1")>

    <#list methods as method>
        @Test
        public void test${method}(){
        ${className} testObj=new ${className}();
        assertTrue(testObj.${method}());
        }
    </#list>
    </#if>

}
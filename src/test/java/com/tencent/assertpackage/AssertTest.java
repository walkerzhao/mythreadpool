package com.tencent.assertpackage;

/**
 * 记得打开assert ,java vm 参数:-ea
 */
public class AssertTest {
    public static void main(String[] args) {
        System.out.println("hello");
        assert (false ): " false ,throw it.";   //如果表达式为false的话,抛出异常,终止程序运行.
        System.out.println("world");
    }
}
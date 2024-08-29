package com.wanglingyun.test;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Description
 * @Author zoe ling
 * @Date 2024/8/29
 *
 */
public class CandyCrushSagaTest {
    @Test
    public void TestSolution(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(StageDemo.solution(str));
    }
    @Test
    public void TestSolution2(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(StageDemo.solution2(str));
    }


}


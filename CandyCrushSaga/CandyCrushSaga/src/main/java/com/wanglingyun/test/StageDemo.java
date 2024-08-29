package com.wanglingyun.test;

import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description
 * @Author zoe ling
 * @Date 2024/8/29
 */
public class StageDemo {
        public static class Node {
            char val;
            int cnt;

            public Node(char val, int cnt) {
                this.val = val;
                this.cnt = cnt;
            }
        }

        public static String solution(String str) {
            char[] chars = str.toCharArray();
            int len = str.length();
            Stack<Node> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                if (stack.isEmpty() || stack.peek().val != chars[i]) {
                    stack.push(new Node(chars[i], 1));
                } else {
                    Node node = stack.pop();
                    if (node.cnt <= 1) {
                        node.cnt++;
                        stack.push(node);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                sb.append(String.valueOf(cur.val).repeat(Math.max(0, cur.cnt)));

            }
            return sb.reverse().toString();
        }

    public static String solution2(String str) {
        char[] chars = str.toCharArray();
        int len = str.length();
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || stack.peek().val != chars[i]) {
                stack.push(new Node(chars[i], 1));
            } else {
                Node node = stack.pop();
                node.cnt++;
                stack.push(node);

                while (!stack.isEmpty() && stack.peek().cnt >= 3) {
                    Node top = stack.pop();
                    if (top.val=='a')
                        continue;
                    char ch = getPreChar(top);
                    if (stack.isEmpty() || stack.peek().val != ch) {
                        stack.push(new Node(ch, 1));
                    } else {
                        Node pre = stack.pop();
                        pre.cnt++;
                        stack.push(pre);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            sb.append(String.valueOf(cur.val).repeat(Math.max(0, cur.cnt)));
        }
        return sb.reverse().toString();
    }

    private static char getPreChar(Node node) {
        char ch = (char) ((((node.val - 'a') - 1 + 26) % 26) + 'a');
        return ch;
    }

}




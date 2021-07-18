package com.laohu.datastructure.Stack;

/**
 * @program: algorithm
 * @description: 栈实现测试
 * @author: Holland
 * @create: 2021-07-18 18:45
 **/
public class StackTest {

    public static void main(String[] args) {
        //顺序栈
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("j");
        arrayStack.push("x");
        arrayStack.push("l");

        String pop1 = arrayStack.pop();
        String pop2 = arrayStack.pop();

        System.out.println("pop1: " + pop1 + ", pop2: " + pop2);

        //链式栈
        LinkedListStack LinkedListStack = new LinkedListStack();
        LinkedListStack.push("h");
        LinkedListStack.push("w");
        LinkedListStack.push("k");

        LinkedListStack.printAll();

        String pop3 = LinkedListStack.pop();
        String pop4 = LinkedListStack.pop();

        System.out.println("pop3: " + pop3 + ", pop4: " + pop4);
    }

}


package com.laohu.datastructure.Stack;

/**
 * @program: algorithm
 * @description: 链表实现的链式栈
 * @author: Holland
 * @create: 2021-07-18 18:41
 **/
public class LinkedListStack {
    /**
     * 尾部结点
     */
    private StringNode head;

    public class StringNode {

        private String val;
        private StringNode next;

        public StringNode(String val, StringNode next) {
            this.val = val;
            this.next = next;
        }

    }

    /**
     * @Description: 压栈
     * @param: String data
     * @auther: Holland
     * @date: 2021/7/18 6:51 下午
     */
    public void push(String data) {

        StringNode newNode = new StringNode(data, null);

        if(this.head == null){
            this.head = newNode;
            return;
        }

        //压栈就是将新结点替换原来的旧头结点
        newNode.next = this.head;

        this.head = newNode;
    }

    /**
     * @Description: 出栈
     * @return: String
     * @auther: Holland
     * @date: 2021/7/18 6:52 下午
     */
    public String pop() {

        if (this.head == null) {
            throw new IllegalStateException("空栈,弹出数据失败");
        }

        //获取此时头结点的数值
        String val = this.head.val;
        //将头结点修改为原头结点的next
        this.head = this.head.next;

        return val;
    }

    public void printAll() {
        StringNode node = this.head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

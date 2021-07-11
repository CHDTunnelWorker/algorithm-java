package com.laohu.datastructure.linkedlist;

/**
 * @program: algorithm
 * @description: 单向链表
 * @author: Holland
 * @create: 2021-07-10 21:31
 **/
public class SingleLindedList<T> {
    /**
     * 声明头结点
     */
    private SingleNode<T> head = null;

    /**
     * 单向结点对象
     *
     * @param <T>
     */
    public class SingleNode<T> {
        /**
         * 结点中的数据
         */
        private T data;
        /**
         * 后继指针
         */
        private SingleNode<T> next;

        public SingleNode(T data, SingleNode<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public SingleNode<T> getNext() {
            return next;
        }

        public void setNext(SingleNode<T> next) {
            this.next = next;
        }
    }

    public void initListByData(T[] dataArray) {
        //判空直接返回
        if (dataArray == null || dataArray.length == 0) {
            return;
        }

        int arraySize = dataArray.length;

        //中间变量记录最后一个结点
        SingleNode<T> finalNode = null;

        for (int i = 0; i < arraySize; i++) {
            //初始化结点对象
            T data = dataArray[i];
            SingleNode<T> next = null;
            SingleNode<T> node = new SingleNode<T>(data, next);

            if (finalNode == null) {
                this.head = node;
            } else {
                finalNode.setNext(node);
            }

            finalNode = node;
        }
    }

    public void sysoutSingleLinkedListElement() {
        if (this.head == null) {
            System.out.println("空单向链表!");
            return;
        }

        T headData = this.head.data;
        SingleNode<T> next = this.head.next;
        System.out.println("头结点: " + headData);

        while (next != null) {
            T data = next.getData();
            next = next.getNext();
            System.out.println("结点: " + data);
        }
    }
}

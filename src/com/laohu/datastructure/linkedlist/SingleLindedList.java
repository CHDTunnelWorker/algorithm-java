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
     * 单向链表的结点对象
     *
     * @param <T>
     */
    public static class SingleNode<T> {
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

    /**
     * @Description: 通过数组初始化单向链表
     * @param: T[] dataArray 数组对象
     * @return: SingleNode<T> 头结点
     * @auther: Holland
     * @date: 2021/7/11 2:20 下午
     */
    public SingleNode<T> initListByData(T[] dataArray) {
        //判空直接返回
        if (dataArray == null || dataArray.length == 0) {
            return null;
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

        return head;
    }

    /**
     * @Description: 输出单向链表的所有结点数据
     * @auther: Holland
     * @date: 2021/7/11 2:21 下午
     */
    public void printAll() {
        if (this.head == null) {
            System.out.println("空单向链表!");
            return;
        }

        T headData = this.head.data;
        SingleNode<T> next = this.head.next;
        System.out.println("头结点: " + headData);

        while (next != null) {
            //获取当前结点数据并打印
            T data = next.getData();
            System.out.println("结点: " + data);
            //next指向下一个结点
            next = next.getNext();
        }
    }

    /**
     * @Description: 输出单向链表的所有结点数据
     * @param: SingleNode<T> headNode 头结点
     * @auther: Holland
     * @date: 2021/7/11 2:21 下午
     */
    public void printAll(SingleNode<T> node) {
        if (node == null) {
            System.out.println("空单向链表!");
            return;
        }

        while (node != null) {
            //获取当前结点数据并打印
            T data = node.getData();
            System.out.println("结点: " + data);
            //next指向下一个结点
            node = node.getNext();
        }
    }

    /**
     * @Description: 使用快慢指针法, 找到单向链表的中间结点
     * @return: SingleNode<T> 获取单向链表的中间结点
     * @auther: Holland
     * @date: 2021/7/11 2:59 下午
     */
    public SingleNode<T> getMiddleNode() {

        if (this.head == null) {
            return null;
        }

        SingleNode<T> fast = this.head;
        SingleNode<T> slow = this.head;

        //注意,因为fast在移动,所以需要判断fast是否为空
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * @Description: 检测链表中是否有环(思想:快慢指针法,一个走两步一个走一步,相遇则说明有环)
     * @return: boolean true为有环 false为无环
     * @auther: Holland
     * @date: 2021/7/11 6:08 下午
     */
    public boolean checkCircle() {

        SingleNode<T> fast = this.head;
        SingleNode<T> slow = this.head;

        //注意,因为fast在移动,所以需要判断fast是否为空
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    /**
     * @Description: 删除倒数第k个结点(快指针先走k - 1步, 然后定义慢指针与快指针在同步走, 当快指针的next为null时, 则此时慢指针的结点为需要删除的结点)
     * @param: int k 倒数第k个
     * @auther: Holland
     * @date: 2021/7/11 3:19 下午
     */
    public void delReverseElement(int k) {
        //快指针先走k-1步
        SingleNode<T> fast = this.head;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            System.out.println("单向链表为空或k值超出链表元素个数!删除失败");
            return;
        }

        SingleNode<T> slow = this.head;
        SingleNode<T> prevNode = null;

        while (fast.next != null) {
            fast = fast.next;
            prevNode = slow;
            slow = slow.next;
        }

        //prevNode == null 说明要删除的是头结点
        if (prevNode == null) {
            this.head = head.next;
        } else {
            prevNode.next = prevNode.next.next;
        }

    }

    /**
     * @Description: 反转单向链表(思想 : 循环中, 通过新变量保存下一个结点的地址, 然后再按逻辑顺序修改指针指向)
     * @auther: Holland
     * @date: 2021/7/11 4:54 下午
     */
    public void reverseLinkedList() {

        SingleNode<T> node = this.head;
        SingleNode<T> prevNode = null;

        while (node != null) {
            SingleNode<T> next = node.next;
            node.next = prevNode;
            prevNode = node;
            node = next;
        }

        this.head = prevNode;
    }

    /**
     * @Description: 将两个有序单向链表进行合并,并返回合并后的头结点
     * @param: SingleNode<T> firstListHead 第一个单向链表的头结点
     * @param: SingleNode<T> secondListHead 第二个单向链表的头结点
     * @return: SingleNode<T> 合并后的头结点
     * @auther: Holland
     * @date: 2021/7/11 6:30 下午
     */
    public SingleNode<T> mergeTwoSortedLinkedList(SingleNode<T> firstListHead, SingleNode<T> secondListHead){
        return null;
    }
}

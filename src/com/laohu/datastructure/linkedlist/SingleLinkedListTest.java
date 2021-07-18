package com.laohu.datastructure.linkedlist;

/**
 * @program: algorithm
 * @description: 单向链表代码测试
 * @author: Holland
 * @create: 2021-07-10 22:47
 **/
public class SingleLinkedListTest {

    public static void main(String[] args) {

        SingleLindedList<Integer> integerSingleLindedList = new SingleLindedList<Integer>();

        Integer[] integers = {2, 4, 6, 8};
        integerSingleLindedList.initListByData(integers);
//        integerSingleLindedList.printAll();

        //获取单向链表的中间结点
        SingleLindedList.SingleNode<Integer> middleNode = integerSingleLindedList.getMiddleNode();

        //删除倒数第n个元素
//        integerSingleLindedList.delReverseElement(2);
//        integerSingleLindedList.printAll();

        //反转单向链表
//        integerSingleLindedList.reverseLinkedList();
//        integerSingleLindedList.printAll();

        //判断链表是否有环
//        boolean circleFlag = integerSingleLindedList.checkCircle();
//        System.out.println("circleFlag: " + circleFlag);

        //两个有序链表的合并
        SingleLindedList<Integer> linkedList1 = new SingleLindedList<Integer>();
        Integer[] integer1 = {1, 2, 3, 4, 7};
        linkedList1.initListByData(integer1);
        SingleLindedList.SingleNode head1 = linkedList1.getHead();


        SingleLindedList<Integer> linkedList2 = new SingleLindedList<Integer>();
        Integer[] integer2 = {5, 6, 8, 9, 10};
        linkedList2.initListByData(integer2);
        SingleLindedList.SingleNode head2 = linkedList2.getHead();

        SingleLindedList.SingleNode newHead = linkedList1.mergeTwoSortedLinkedList(head1, head2);
        linkedList1.printAll(newHead);
    }

}

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

        Integer[] integers = {2,4,6,8};
        integerSingleLindedList.initListByData(integers);
//        integerSingleLindedList.printAll();

        //获取单向链表的中间结点
        SingleLindedList.SingleNode<Integer> middleNode = integerSingleLindedList.getMiddleNode();

        //删除倒数第n个元素
//        integerSingleLindedList.delReverseElement(2);
//        integerSingleLindedList.printAll();

        //反转单向链表
        integerSingleLindedList.reverseLinkedList();
        integerSingleLindedList.printAll();

        //判断链表是否有环
        boolean circleFlag = integerSingleLindedList.checkCircle();
        System.out.println("circleFlag: " + circleFlag);
    }

}

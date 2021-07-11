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

        Integer[] integers = {2, 4, 6};
        integerSingleLindedList.initListByData(integers);
        integerSingleLindedList.sysoutSingleLinkedListElement();
    }

}

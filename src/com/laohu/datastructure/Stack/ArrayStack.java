package com.laohu.datastructure.Stack;

/**
 * @program: algorithm
 * @description: 数组实现的顺序栈
 * @author: Holland
 * @create: 2021-07-18 18:40
 **/
public class ArrayStack {
    /**
     * 数组
     */
    private String[] array;
    /**
     * 存放数据的位置下标
     */
    private int index;
    /**
     * 数组大小
     */
    private int size;

    public ArrayStack (int size) {
        this.array = new String[size];
        this.index = 0;
        this.size = size;
    }

    /**
     * @Description: 压栈
     * @param: String data
     * @auther: Holland
     * @date: 2021/7/18 6:51 下午
     */
    public void push(String data){

        if(index == size){
            throw new ArrayIndexOutOfBoundsException("超出栈大小,压栈失败");
        }

        //向数组尾部添加数据,并移动填充数据index下标
        array[index] = data;
        index++;
    }

    /**
     * @Description: 出栈
     * @return: String
     * @auther: Holland
     * @date: 2021/7/18 6:52 下午
     */
    public String pop(){

        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("空栈,弹出数据失败!");
        }

        //将数组尾部数据弹出,并移动需要填充数据的index下标
        index--;
        String data = array[index];
        array[index] = null;

        return data;
    }

}

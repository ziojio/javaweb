package com.ziojio.code.datastructure;

import java.util.ArrayDeque;

// 先进后出的一种数据结构（FIFO）
public class QueueSample {

    public static void main(String[] args) {

        // 双端队列
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        // 添加和移除，抛异常
        integers.add(0);
        integers.remove();

        // 添加和移除
        integers.offer(1);
        integers.poll();

        // 取第一个
        integers.peek();
        // 取第一个，为空 抛异常
        integers.element();


    }
}


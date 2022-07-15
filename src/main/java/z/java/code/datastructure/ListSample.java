package z.java.code.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 线性数据存储结构
public class ListSample {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(10);

        // 添加和移除，抛异常
        integers.add(0);
        integers.remove(2);

        LinkedList<Integer> linkedList = new LinkedList<>();

        // 添加和移除，抛异常
        linkedList.add(0);
        linkedList.remove(2);


    }
}


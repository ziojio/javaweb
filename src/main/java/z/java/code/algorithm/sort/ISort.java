package z.java.code.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * <a href="https://blog.csdn.net/gane_cheng/article/details/52652705" target="_blank">
 * 常见排序算法及对应的时间复杂度和空间复杂度
 * </a>    
 */
public interface ISort {

    /**
     * 排序
     *
     * @param array 排序前的数组
     * @return 排序后的数组
     */
    int[] sort(int[] array);

    static void printSort(ISort sort, int[] array) {
        System.out.println("排序之前: " + Arrays.toString(array));

        long startNanos = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            array = sort.sort(array);
        }
        long stopNanos = System.nanoTime();
        double lengthMillis = TimeUnit.NANOSECONDS.toMillis(stopNanos - startNanos) / 1000D;

        System.out.println("排序之后: " + Arrays.toString(array));
        System.out.println("共耗时：[" + lengthMillis + "]ms");
    }
}

package com.exmaple.Demo.util;

public class BubbleSort {

    public static void sort(int[] source) {
        // 排序前先输出
        int size = source.length;
        for (int i = 0; i < size - 1; i++) {
            boolean isSwap = false;
            // 每次排序都从0开始，size-i-1结束,因为每一趟排序结束，都将排序队列中最大的那个移到最右边
            for (int j = 0; j < size - i - 1; j++) {
                //
                if (source[j] > source[j + 1]) {
                    int temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                    isSwap = true;
                }
            }
            // 如果没有换，代表排序已经结束
            if (!isSwap) {
                break;
            }

        }
    }
}

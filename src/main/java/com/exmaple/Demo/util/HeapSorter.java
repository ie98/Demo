package com.exmaple.Demo.util;

public class MaxHeap {
    public void sort(int[] array) {
        heapSort(array);
    }
    public static void MakeMinHeap(int a[], int n){
        for(int i=(n-1)/2 ; i>=0 ; i--){
            MinHeapFixdown(a,i,n);
        }
    }
    //从i节点开始调整,n为节点总数 从0开始计算 i节点的子节点为 2*i+1, 2*i+2
    public static void MinHeapFixdown(int a[],int i,int n){

        int j = 2*i+1; //子节点
        int temp = 0;

        while(j<n){
            //在左右子节点中寻找最小的
            if(j+1<n && a[j+1]<a[j]){
                j++;
            }

            if(a[i] <= a[j])
                break;

            //较大节点下移
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i = j;
            j = 2*i+1;
        }
    }
    public static void MinHeap_Sort(int a[],int n){
        int temp = 0;
        MakeMinHeap(a,n);

        for(int i=n-1;i>0;i--){
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            MinHeapFixdown(a,0,i);
        }
    }

    public static void main(String[] args) {
        int array[]={1,6,9,45,65,12,3,4,578,78,5,6,13,458,12,456,789,123};
        HeapSorter heapSorter=new HeapSorter();
        heapSorter.heapSort(array);
//        heapSorter.MinHeap_Sort(array,array.length);
        for (int i:array){
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }
}

}
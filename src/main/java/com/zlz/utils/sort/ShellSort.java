package com.zlz.utils.sort;

import java.util.Arrays;

/**
 * @author zhailz
 *
 * 时间：2016年9月22日 ### 上午10:42:28
 * 
 * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以**让一个元素可以一次性地朝最终位置前进一大步**
 * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，
 * 需排序的数据几乎是已排好的了（此时插入排序较快）。假设有一个很小的数据在一个已按升序排好序的数组的末端。
 * 如果用复杂度为O(n2)的排序（冒泡排序或插入排序），可能会进行n次的比较和交换才能将该数据移至正确位置。
 * 而希尔排序会用较大的步长移动数据，所以小数据只需进行少数比较和交换即可到正确位置。
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 0, 1, 2, 3, 8 };
		shellsort(arrays);
		System.out.println(Arrays.toString(arrays));
	}

	public static void shellsort(int[] arr) {
		int gap = 1, i, j, len = arr.length;
		int temp;
		//确定gap的位置
		while (gap < len / 3) {
			gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
		}

		for (; gap > 0; gap /= 3)
			//按照一定的步长，变化的插入排序
			for (i = gap; i < len; i++) {
				temp = arr[i];
				for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = temp;
			}
	}
}

package com.zlz.utils.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhailz
 * 插入排序，稳定的算法，最好的情况O(n),最坏的情况O(n2),平均的情况是O(n2)
 */
public class InsertSort {

  public static void main(String[] args) {
    int[] arrays = new int[] { 5, 1, 6, 2, 4, 5, 6, 7, 0, 4, 2, 3, 5, 7, 8 };
    arrays = insertSort(arrays);
    System.out.println(Arrays.toString(arrays));

    Object[] obs = new Object[]{"3","1","4","5","7","8","0","9"};
    insertSort(obs);
    System.out.println(Arrays.toString(obs));
  }
  
  public static Object[] insertSort(Object[] obs){
	  return insertSortFE(obs,0,obs.length -1);
  }
  

  private static Object[] insertSortFE(Object[] obs, int start, int end) {
	  for (int i = start +1; i <= end; i++) {
		Object temp = obs[i];
		int k = i-1;
		for (; k >= 0; k--) {
			if(compare(obs[k],temp) >= 0){
				break;
			}else{
				obs[k+1] = obs[k];
			}
		}
		
		obs[k+1] = temp;
	  }
	  return obs;
}

private static int compare(Object fir, Object sed) {
	@SuppressWarnings("unchecked")
	Comparable<Object> firs = (Comparable<Object>) fir;
	return firs.compareTo(sed);
}

public static int[] insertSort(int[] arrays) {
    for (int i = 1; i < arrays.length; i++) {
      int temp = arrays[i];
      int j = i - 1;
      for (; j >= 0 && arrays[j] > temp; j--) {
        arrays[j + 1] = arrays[j];
      }
      arrays[j + 1] = temp;
    }

    return arrays;
  }

}


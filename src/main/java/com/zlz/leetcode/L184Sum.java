package com.zlz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhailz
 *
 * 时间：2016年7月20日 ### 下午1:44:50
 */
public class L184Sum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    List<Integer> l;
	    Arrays.sort(nums);
	    int len = nums.length;
	    for(int i = 0; i < len - 3; i++){
	        if(i != 0 && nums[i] == nums[i-1]) continue;
	        if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
	        if(nums[i] + nums[len-1] + nums[len-2] + nums[len-2] < target) continue;
	        for(int j = i+ 1; j < len - 2; j++){
	            if(j != i+1 && nums[j] == nums[j-1]) continue;
	            if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
	            if(nums[i] + nums[j] + nums[len-1] + nums[len-2] < target) continue;
	            int head = j+1, end = len - 1;
	            while(head < end){
	                int tempt = nums[i] + nums[j] + nums[head] + nums[end];
	                if(tempt == target){
	                    l = new ArrayList<Integer>();
	                    l.add(nums[i]);
	                    l.add(nums[j]);
	                    l.add(nums[head]);
	                    l.add(nums[end]);
	                    list.add(l);
	                    head++;
	                    while(head < end && nums[head] == nums[head-1]){
	                        head++;
	                    }
	                }
	                else if(tempt > target) end--;
	                else head++;
	            }
	        }
	    }
	    return list;
	}
}

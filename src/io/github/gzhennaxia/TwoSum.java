package io.github.gzhennaxia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @Author: LiBo
 * @Date: 2018/5/14下午 11:39
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ret = twoSum(nums, target);
        int[] ret2 = twoSum2(nums, target);
        System.out.println("ret = " + Arrays.toString(ret));
        System.out.println("ret2 = " + Arrays.toString(ret2));
        //ret = [0, 1]
        //ret2 = [0, 1]
    }


    //方法1：两个循环
    public static int[] twoSum(int[] nums, int target) {

        //使用HashMap降低时间复杂度，key为数组元素的值，value为数组元素的下标。
        Map<Integer, Integer> map = new HashMap<>();

        //1. 将数组元素和其下标的关系存储在HashMap中。
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        //2. 遍历HashMap寻找满足条件的数组下标。
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }
        throw new IllegalArgumentException("No Solution");
    }

    //方法2：一个循环
    //注意：1，2的步骤顺序不能颠倒，否则在遇到3+3=6这种情况的时候得不到正确答案。原因是HashMap中当key值相同时新的value会替换掉旧的value。
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){

            int diff = target - nums[i];

            //1. 先查看是否存在满足条件的结果
            if (map.containsKey(diff) && map.get(diff) != i){
                return new int[]{map.get(diff), i};
            }

            //2. 再将当前数组元素及其下标放入map中
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no such result!");
    }
}

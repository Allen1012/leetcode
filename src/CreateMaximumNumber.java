import java.util.LinkedList;

/**
 * 321. 拼接最大数
 * 难度
 * 困难
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * https://leetcode-cn.com/problems/create-maximum-number/
 */
public class CreateMaximumNumber {

    public static void main(String[] args) {
        CreateMaximumNumber c = new CreateMaximumNumber();
        int[] nums1 = {6, 3, 9, 0, 5, 6};
        int[] nums2 = {2, 2, 5, 2, 1, 4, 4, 5, 7, 8, 9, 3, 1, 6, 9, 7, 0};

        int[] nums3 = {1, 7, 0, 6, 8, 9, 8, 9, 1, 6, 9, 1, 9, 9, 5, 8, 4};
        int k = 23;

        c.maxNumber(nums1,nums2,k);

    }

    
    public int[] getMaxArr(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] > arr2[i]){
                return arr1;
            }
            if(arr1[i] < arr2[i]){
                return arr2;
            }
        }
        return arr1;
    }

    public int[] getArr(LinkedList<Integer> list1,LinkedList<Integer> list2){
        int[] num = new int[list1.size()+list2.size()];
        int a1;
        int a2;
        int i =0;
        while (!list1.isEmpty() || !list2.isEmpty()){
            if(list1.isEmpty()){
                a1 = -1;
            }else {
                a1 = list1.getFirst();
            }
            if(list2.isEmpty()){
                a2 = -1;
            }else {
                a2 = list2.getFirst();
            }

            if(a1>a2){
                num[i++] = a1;
                list1.removeFirst();
            }else if(a1 < a2) {
                num[i++] = a2;
                list2.removeFirst();
            }else {
                boolean hasDown = false;
                int len = Math.min(list1.size(),list2.size());
                for (int j = 1; j < len; j++) {
                    if(list1.get(j) > list2.get(j)){
                        num[i++] = a1;
                        list1.removeFirst();
                        hasDown = true;
                        break;
                    }
                    if(list1.get(j) < list2.get(j)){
                        num[i++] = a2;
                        list2.removeFirst();
                        hasDown = true;
                        break;
                    }
                }
                if(!hasDown){
                    if(list1.size() > list2.size()){
                        num[i++] = a1;
                        list1.removeFirst();
                    }else {
                        num[i++] = a2;
                        list2.removeFirst();
                    }
                }

            }
        }
        return num;
    }


    public LinkedList<Integer> getDownList(int[] nums,int k){
        LinkedList<Integer> list = new LinkedList<>();
        if(k==0){
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.isEmpty()){
                list.add(nums[i]);
                k--;
            }else {
                while (!list.isEmpty() && list.getLast() < nums[i] && nums.length - i -1 >= k){
                    list.removeLast();
                    k++;
                }
                if(k>0){
                    list.add(nums[i]);
                    k--;
                }

            }
        }

        return list;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] t = new int[k];
        int[] maxArr = new int[k];
        LinkedList<Integer> l1 ;
        LinkedList<Integer> l2 ;
        for (int i = 0; i <= Math.min(nums1.length,k); i++) {
            if(i+nums2.length < k){
                continue;
            }
            l1 = getDownList(nums1,i);
            l2 = getDownList(nums2,k-i);

            System.out.println("i= "+i);
            System.out.println(l1.toString());
            System.out.println(l2.toString());
            System.out.println(" ");
            t = getArr(l1,l2);
            for (int j = 0; j < t.length; j++) {
                System.out.printf(" "+t[j]);
            }
            System.out.println(" ");
            maxArr = getMaxArr(t,maxArr);

            for (int j = 0; j < maxArr.length; j++) {
                System.out.printf(" "+maxArr[j]);
            }
            System.out.println(" ");

        }
        return maxArr;
    }




}

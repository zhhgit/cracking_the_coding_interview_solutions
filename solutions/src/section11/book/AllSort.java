package section11.book;

/**
 * Created by zhanghao1 on 2017/10/26.
 */
public class AllSort {
    public static void main(String[] args){
        int[] nums1 = {3,4,1,5,2,7,6};
        bubbleSort(nums1);
        showSortResult("bubble",nums1);
    }

    //---------------------------公用---------------------------
    //打印结果
    private static void showSortResult(String type,int[] nums){
        System.out.println("-----------" + type + "----------");
        for(int num:nums){
            System.out.println(num);
        }
    }

    //交换两个数
    private static void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    //-----------------------冒泡排序------------------------
    private static void bubbleSort(int[] nums){
        //i表示第几轮的比较
        for(int i = 0;i<nums.length-1; i++){
            bubbleEachRound(nums,i);
        }
    }

    //每一轮将最大的数字冒泡到最后
    private static void bubbleEachRound(int[] nums,int round){
        //注意第round轮需要比较的次数
        for(int i = 0;i<nums.length - round - 1;i++){
            if(nums[i]> nums[i+1]){
                swap(nums,i,i+1);
            }
        }
    }

    //-----------------------选择排序------------------------
    private static void selectionSort(int[] nums){

    }

}

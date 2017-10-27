package section11.book;

/**
 * Created by zhanghao1 on 2017/10/27.
 */
public class AllSearch {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,4,5,6,7,8};
        int val = 5;
        System.out.println(binarySearch(nums1,val));
        System.out.println(binarySearchRecursive(nums1,val,0,nums1.length));
    }

    //-------------------二分查找-----------------
    private static int binarySearch(int[] nums,int val){
        int low = 0;
        int high = nums.length-1;
        int middle;
        while(low <= high){
            middle = (low + high) / 2;
            if(nums[middle] < val){
                low = middle + 1;
            }
            else if(nums[middle] > val){
                high = middle -1;
            }
            else {
                return middle;
            }
        }
        return -1;
    }

    //-------------------递归二分查找-----------------
    private static int binarySearchRecursive(int[] nums,int val,int low,int high){
        //递归一定要提供退出条件！！
        if(low > high){
            return -1;
        }
        int result;
        int middle = (low + high) / 2;
        if(nums[middle] < val){
            result = binarySearchRecursive(nums,val,middle+1,high);
        }
        else if(nums[middle] > val){
            result = binarySearchRecursive(nums,val,low,middle-1);
        }
        else {
            return middle;
        }
        return result;
    }
}

package section11.book;

/**
 * Created by zhanghao1 on 2017/10/26.
 */
public class AllSort {
    public static void main(String[] args){
        int[] nums1 = {3,4,1,5,2,7,6};
        bubbleSort(nums1);
        showSortResult("bubble",nums1);
        int[] nums2 = {3,4,1,5,2,7,6};
        selectionSort(nums2);
        showSortResult("selection",nums2);
        int[] nums3 = {3,4,1,5,2,7,6};
        mergeSort(nums3,0,nums3.length-1);
        showSortResult("merge",nums3);
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
        int minIndex = 0;
        for(int i=0;i<nums.length;i++){
            minIndex = i;
            for(int j=i;j<nums.length;j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums,minIndex,i);
        }
    }

    //-----------------------归并排序------------------------
    private static void mergeSort(int[] nums,int low,int high){
        //总数为偶数时，左右两半均分；总数为基数时，左半比右半多1；
        //递归函数一定要提供退出的条件，否则stackOverflow
        if(low < high){
            int middle = (low + high) / 2;
            mergeSort(nums,low,middle);
            mergeSort(nums,middle+1,high);
            merge(nums,low,middle,high);
        }
    }

    private static void merge(int[] nums,int low,int middle,int high){
        //将归并前的前后两段复制一份到新数组helper中
        int[] helper = new int[nums.length];
        for(int i=low;i<=high;i++){
            helper[i] = nums[i];
        }
        //左右两端的游标
        int helperLeft = low;
        int helperRight = middle + 1;
        //用于回填到原数组的游标
        int current = low;
        //当两个游标都在自己的段范围内
        while(helperLeft<=middle && helperRight<=high){
            if(helper[helperLeft] <= helper[helperRight]){
                nums[current] = helper[helperLeft];
                helperLeft++;
            }
            else{
                nums[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        /*如果此时右侧已全部重排进原数组，左侧还剩下，整体移动到余下的数组中
        如果此时左侧已全部重排进原数组，无需处理，因为右侧的就在正确的位置了*/
        if(helperLeft <= middle){
            for(int i = helperLeft;i<=middle;i++){
                nums[current++] = helper[i];
            }
        }
    }

    //-----------------------快速排序------------------------
    private static void quickSort(int[] nums){

    }

}

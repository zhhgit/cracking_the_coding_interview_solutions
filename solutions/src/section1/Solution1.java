package section1;

/**
 * Created by zhanghao1 on 2017/9/26.
 * 字符串中字符是否不重复
 */
public class Solution1 {
    public static void main(String[] args){
        String[] strArr = {"abc","aba"};
        for(String s: strArr){
            System.out.println(isUniqueChars(s));
        }
    }

    //假设都是ASCII字符
    private static boolean isUniqueChars(String str){
        if(str.length() > 256) {
            return false;
        }
        boolean[] resultArr = new boolean[256];
        for(int i = 0; i< str.length(); i++){
            int curr = str.charAt(i);
            if(resultArr[curr]){
                return false;
            }
            else{
                resultArr[curr] = true;
            }
        }
        return true;
    }
}

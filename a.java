package mid;

import java.util.Arrays;

public class a {
    public static void main(String[] args) {
        int [][] arr= {{1,3,1},{6,4,2},{5,1,7},{9,3,3},{8,5,4}};
        int[] a=sum(arr);
        System.out.println(Arrays.toString(a));
    }
    public static int[] sum(int[][] arr){
        int[] r= {0,0,0};
        int[] ans=new int[2];
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                r[i]+=arr[j][i];
            }
        }
        for(int i=0;i<2;i++){
            ans[i]=r[i+1]-r[i];
        }
        return ans;
    }
}

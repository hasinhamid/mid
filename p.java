package mid;
import java.lang.reflect.Array;
import java.util.Arrays;
import java .util.Stack;
public class p {
    public static void main(String[] args) {
        int[][] tasks = {
            {1, 5},
            {2, 3},
            {4, 6},
            {7, 10},
            {9, 11},
            {12, 15}
        };

        System.out.println("Merged Non-Overlapping Tasks:");
        print_total_task(tasks);
    }
    public static void print_total_task(int[][]tasks){
        Stack<int[]> arr= new Stack<>();
        int [] curr=tasks[0];
        for(int[]task : tasks){
            int cEnd=curr[1];
            int lF= task[0];
            if(cEnd>=lF){
                if (cEnd<task[1]) {
                    curr[1]=task[1];
                }
            }
            else{
                arr.push(curr);
                curr=task;
            }
        }
        arr.push(curr);
        while (!arr.isEmpty()) {
            int[] a=arr.pop();
            System.out.println(Arrays.toString(a));
        }
    }

}



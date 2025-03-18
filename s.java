package mid;

import java.util.Stack;

public class s {
    public static void main(String[] args) {
        Stack<Integer>st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        
        Stack modifiedStack = Do_Adjacent_Swap(st);

        System.out.println("\nModified Stack:");
        while (!modifiedStack.isEmpty()) {
            System.out.println(modifiedStack.peek());
            modifiedStack.pop();
        }
        System.out.println();
    }
    
    public void printStack(Stack st) {
        
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
        System.out.println();
    }

    public static Stack<Integer> Do_Adjacent_Swap(Stack<Integer> st){
        Stack<Integer> ev= new Stack<>();
        Stack<Integer> od= new Stack<>();
        Stack<Integer> nm= new Stack<>();
        while (!st.isEmpty()) {
            if(st.peek()%2==0){
                ev.push(st.pop());
            }
            else{
                od.push(st.pop());
            }
        }
        while (!od.isEmpty() && !ev.isEmpty()) {
            nm.push(ev.pop());
            nm.push(od.pop());
        }
        


        return nm;
    }

     
}

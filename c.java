package mid;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class c {
  
        public static void main(String[] args) {
            // Create a stack and push test data (M_ and F_ ids)
            Stack<String> st = new Stack<>();
            
            // Test case: Pushing M and F IDs into the stack
            st.push("F_18");
            st.push("F_9");
            st.push("M_7");
            st.push("M_1");
            st.push("M_19");
            st.push("M_3");
            st.push("F_5");
            st.push("F_4");
            st.push("F_20");
            st.push("M_10");
    
            // Call the dance_pair method (which you need to implement)
            dance_pair(st);
        }
    
        
        public static void dance_pair(Stack st) {
            Queue queue = new LinkedList<>();
            while (!st.isEmpty()) {
                String current = (String) st.pop();
                if (current == null) continue;
                String[] currentParts = idgenderextractor(current);
                String currentGender = currentParts[0];
                String currentId = currentParts[1];
                
                if (currentGender.equals("M")) {
                    // Process male
                    if (!st.isEmpty()) {
                        String nextPerson = (String) st.peek();
                        String[] nextParts = idgenderextractor(nextPerson);
                        String nextGender = nextParts[0];
                        if (nextGender != null && nextGender.equals("F")) {
                            // Pair with next female
                            nextPerson = (String) st.pop();
                            String nextId = nextParts[1];
                            System.out.println(currentId + " and " + nextId + " are paired together");
                        } else {
                            // Check queue for spare female
                            if (!queue.isEmpty()) {
                                String spare = (String) queue.remove();
                                String[] spareParts = idgenderextractor(spare);
                                String spareId = spareParts[1];
                                System.out.println(spareId + " and " + currentId + " are paired together");
                            }
                            // Else, discard the male
                        }
                    } else {
                        // Stack is empty, check queue for spare female
                        if (!queue.isEmpty()) {
                            String spare = (String) queue.remove();
                            String[] spareParts = idgenderextractor(spare);
                            String spareId = spareParts[1];
                            System.out.println(spareId + " and " + currentId + " are paired together");
                        }
                        // Else, discard the male
                    }
                } else {
                    // Process female
                    if (!st.isEmpty()) {
                        String nextPerson = (String) st.peek();
                        String[] nextParts = idgenderextractor(nextPerson);
                        String nextGender = nextParts[0];
                        if (nextGender != null && nextGender.equals("M")) {
                            // Pair with next male
                            nextPerson = (String) st.pop();
                            String nextId = nextParts[1];
                            System.out.println(currentId + " and " + nextId + " are paired together");
                        } else {
                            // Enqueue current female
                            queue.add(current);
                        }
                    } else {
                        // Stack is empty, enqueue current female
                        queue.add(current);
                    }
                }
            }
        }
    


    // public static void dance_pair(Stack<String> st) {
    //     Stack <String> listf= new Stack<>();
    //     Stack <String> listM= new Stack<>();
    //     String a=st.pop();
    //     String[] as=id_gender_extractor(a);
    //     if(as[0].equals("M")){
    //         listM.push(a);
    //     }
    //     else{
    //         listf.push(a);
    //     }
    //     while (!st.isEmpty()) {
    //         a=st.pop();
    //         if(id_gender_extractor(a).[0].e)
    //         if () {
    //             System.out.println(as[1]+" and "+bs[1]+" are paired together");
    //             as=st.pop();
                
    //         }
    //         else{

    //         }
    //     }
    // }
    // // id_gender_extractor method to extract gender and ID from the string
    public static String[] idgenderextractor(String s) {
        if (s != null) {
            String gender = s.substring(0, 1); // "M" or "F"
            String id = s.substring(2); // ID part (e.g., 18, 20, etc.)
            return new String[]{gender, id};
        }
        return new String[]{null, null};
    }
 

}

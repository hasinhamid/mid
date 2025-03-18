package mid;



public class b {
   
    public static void main(String[] args) {
            // Test case: Linked list = 1 → 2 → 3 → 4 → 5, and target sum = 7
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
    
            int targetSum = 7;
    
            // Call the function (you need to implement this)
            boolean result = IsSumPossible(head, targetSum);
            System.out.println(result);  // Expected output: true
        }

        public static boolean IsSumPossible(ListNode head, int n) {
            // Simple approach: check all pairs
            if(head==null || head.next==null){
                return false;
            }
            ListNode n1=head;
            while (n1.next!=null) {
                ListNode n2= n1.next;
                while (n2!=null) {
                    if(n1.val+n2.val==n){
                        return true;
                    }
                    n2=n2.next;
                }
                n1=n1.next;
            }
            return false;
        }
    
    
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

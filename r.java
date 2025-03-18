package mid;


public class r {

    public static void main(String[] args) {
        // Create a linked list with duplicate tickets
        Node head = new Node(101);
        head.next = new Node(103);
        head.next.next = new Node(101);
        head.next.next.next = new Node(101);
        head.next.next.next.next = new Node(103);
        head.next.next.next.next.next = new Node(104);
        head.next.next.next.next.next.next = new Node(105);
        head.next.next.next.next.next.next.next = new Node(105);

        System.out.println("Original Tickets:");
        printList(head);

        // Remove duplicates
        head = remove_Duplicates(head);

        System.out.println("\nFixed Tickets (Duplicates Removed):");
        printList(head);
    }
        // 1 2 3 1 4 1 1 
    public static Node remove_Duplicates(Node arr){
        for(int i=0;i<size(arr)-1;i++){
            Node curr=nodeAt(arr,i);
            for(int j=i+1;j<size(arr);j++){
                Node ch= nodeAt(arr, j);
                if(curr.ticketID==ch.ticketID){
                    remove(nodeAt(arr, j-1));
                    j--;
                }
            }
        }
        return arr;
    }
    public static void remove(Node prev){
        prev.next=prev.next.next;
        return;
    }
    public static int size(Node H){
        int i=0;
        Node curr=H;
        while(curr!=null){
            curr=curr.next;
            i++;
        }
        return i;
    }
    public static Node nodeAt(Node H, int a){
        int i=0;
        Node curr=H;
        while(i<a){
            curr=curr.next;
            i++;
        }
        return curr;
    }


     public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.ticketID + " ");
            temp = temp.next;
        }
        System.out.println();
    }
   
     
}

class Node {
    int ticketID;
    Node next;

    Node(int ticketID) {
        this.ticketID = ticketID;
        this.next = null;
    }
}

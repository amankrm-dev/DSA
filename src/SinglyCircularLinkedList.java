public class SinglyCircularLinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    Node tail,head;
    public SinglyCircularLinkedList(){
        this.head=null;
        this.tail=null;
    }
    public void insertAtFirst(int data){
        Node nNode=new Node(data);
        if(head==null){
            head=tail=nNode;
            tail.next=head;
        }
        else {
            nNode.next=head;
            head=nNode;
            tail.next=head;
        }
    }

    public void insertAtPos(int data,int pos){
        if (pos==1 ||head==null){
            insertAtFirst(data);
        }
        Node cNode=head;
        Node nNode=new Node(data);
        for(int i=1;i<pos-1 && cNode.next!=head;i++){
            cNode=cNode.next;
        }
        nNode.next=cNode.next;
        cNode.next=nNode;
        if (cNode==tail) tail=nNode;

    }
    public void insertAtLast(int data){
        Node nNode=new Node(data);
        if(head==null){
            head=tail=nNode;
            tail.next=head;
        }
        else {
            tail.next=nNode;
            tail=nNode;
            tail.next=head;
        }

    }
    public void deleteAtFirst(){
        if (head==null) return;
        if (head==tail){
            head=tail=null;
        }
        else {
            head=head.next;
            tail.next=head;
        }
    }
    public void deleteAtPos(int pos){
        if(head==null) return;
        if(pos==1){
            deleteAtFirst();
        }
        Node cNode=head;
        for(int i=1;i<pos-1 && cNode.next!=head;i++){
            cNode=cNode.next;
        }
        cNode.next=cNode.next.next;
        if(cNode.next==head){
            tail=cNode;
        }


    }
    public void deleteAtLast(){
        if (head==null)return;
        if (head==tail){
            head=tail=null;
            return;
        }
        Node cNode=head;
        while (cNode.next!=tail){
            cNode=cNode.next;
        }
        cNode.next=head;
        tail=cNode;
    }
    public boolean search(int data){
        if(head==null)return false;
        Node cNode=head;
        do {
            if(cNode.data==data)return true;
            cNode=cNode.next;


        }
        while (cNode!=head);
        return false;

    }
    public void display(){
        Node cNode=head;
        do{
            System.out.print(cNode.data+" <->");
            cNode=cNode.next;
        }
        while (cNode!=head);
        System.out.println("BAck to head");
    }

    public static void main(String[] args) {
        SinglyCircularLinkedList list=new SinglyCircularLinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(20);
        list.insertAtPos(15, 2);
        list.display(); // Expected Output: 10 -> 15 -> 20 -> (Back to Head)

        list.deleteAtFirst();
        list.deleteAtLast();
        list.display(); // Expected Output: 15 -> (Back to Head)

        System.out.println("Search 15: " + list.search(15)); // Expected: true
        System.out.println("Search 10: " + list.search(10)); // Expected: false
    }
}


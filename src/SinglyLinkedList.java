import java.awt.geom.NoninvertibleTransformException;

public class SinglyLinkedList{
   private class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node head;
   public SinglyLinkedList(){
       head=null;
   }
   public void insertAtFirst(int data){
       Node newNode=new Node(data);
       if(head!=null){
           newNode.next=head;
       }
       head=newNode;
   }
   public void insertAtPos(int data,int pos){
       Node cNode=head;
       for(int i=1;i<pos-1;i++) {
           cNode = cNode.next;
       }
           Node nNode=new Node(data);
           nNode.next=cNode.next;
           cNode.next=nNode;

   }
   public void insertAtLast(int data){
       Node n=new Node(data);
       Node cNode=head;
       while (cNode.next!=null){
           cNode= cNode.next;
       }
       cNode.next=n;
   }
   public void deleteAtFirst(){
       Node cNode=head;
       head=head.next;
       cNode.next=null;
   }
   public void deleteAtPos(int pos){
       Node cNode= head;
       for(int i=1;i<pos-1;i++){
           cNode=cNode.next;

       }
       cNode.next=cNode.next.next;

   }
   public void deleteAtLast(){
       if(head==null) return;
       if(head.next==null){
           head=null;
           return;
       }
       Node cNode= head;
       while (cNode.next.next!=null){
           cNode=cNode.next;

       }
       cNode.next=null;
   }
   public void display(){
       if (head==null){
           return;
       }
       Node cNode=head;
       while (cNode!=null){
           System.out.print(cNode.data+" ->");
           cNode=cNode.next;
       }
       System.out.println("Null");
   }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(20);
        list.insertAtPos(15, 2);
        list.display();
        list.deleteAtFirst();
        list.deleteAtLast();
        list.display();


    }
}
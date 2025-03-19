import javax.naming.NameNotFoundException;
import java.awt.geom.NoninvertibleTransformException;

public class DoublyLinkedList{
    private class Node{
        int data;
        Node next,prev;
        public Node(int data){
            this.data=data;
            prev=next=null;

        }
    }
    Node head;
    public DoublyLinkedList(){
        head=null;
    }
   public void insertAtFirst(int data){
       Node nNode=new Node(data);
       if(head!=null){
           nNode.next=head;
           head.prev=nNode;
       }
       head=nNode;
   }
    public void insertAtPos(int data,int pos){
        Node cNode=head;
        for(int i=1;i<pos-1;i++){
            cNode=cNode.next;

        }
        Node nNode=new Node(data);
        nNode.next=cNode.next;
        nNode.prev=cNode;
        if(cNode.next!=null){
            cNode.next.prev=nNode;
        }
        cNode.next=nNode;
    }
    public void insertAtLast(int data){
        Node nNode= new Node(data);
        if(head==null){
            head= nNode;
            return;
        }
        Node cNode=head;
        while (cNode.next!=null){
            cNode=cNode.next;

        }
        cNode.next=nNode;
        nNode.prev=cNode;
    }
    public void deleteAtFirst(){
        if(head==null) return;
        head=head.next;
        if(head!=null){
            head.prev=null;
        }


    }
    public void deleteAtPos(int pos){
        Node cNode=head;
        for(int i=1;i<pos;i++){
            cNode=cNode.next;
        }
        cNode.prev.next=cNode.next;
        cNode.next.prev=cNode.prev;

    }
    public void deleteAtLast(){
        Node cNode=head;
        while(cNode.next!=null)
        {
            cNode=cNode.next;

        }
        cNode.prev.next=null;
    }
    public void display(){
        Node cNode=head;
        while(cNode!=null){
            System.out.print(cNode.data+" <->");
            cNode=cNode.next;

        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(20);
        list.insertAtPos(15, 2);
        list.display();
        list.deleteAtFirst();
        list.deleteAtLast();
        list.display();
    }
}
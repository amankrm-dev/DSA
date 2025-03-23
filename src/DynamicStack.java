public class DynamicStack {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    private Node top;
    public DynamicStack(){
        this.top=null;
    }

    public void push(int data){
        Node nNode=new Node(data);
        nNode.next=top;
        top=nNode;
        System.out.println("Data Pushed:"+data);
    }

    public int pop(){
        if(top==null){
            System.out.println("Stack Underflow!");
            return -1;
        }
        int popped=top.data;
        top=top.next;
        return popped;
    }
    public int peek(){
        if(top==null){
            System.out.println("Stack Underflow!");
            return -1;
        }
        return top.data;
    }
    public boolean is_Empty(){
        return top==null;
    }
    public void display(){
        if(is_Empty()){
            System.out.println("Stack is Empty!");
            return;
        }
        Node temp=top;
        System.out.print("Stack Elements:");
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicStack stack=new DynamicStack();
        System.out.println("Is stack Empty?"+stack.is_Empty());
        stack.push(20);
        stack.push(44);
        stack.push(34);
        stack.push(12);
        stack.pop();
        stack.display();
        stack.push(98);
        stack.peek();
        stack.display();
        System.out.println("Peek:"+stack.peek());
        System.out.println("Is stack Empty?"+stack.is_Empty());
    }
}


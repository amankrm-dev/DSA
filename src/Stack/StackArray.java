package Stack;

public class StackArray {
    int[] stackArr;
    int size;

    public StackArray(int capacity){
        stackArr=new int[capacity];
        size=0;
    }
    public void push(int data){
        if(size==stackArr.length){
            System.out.println("Stack overFlow");
            return;
        }
        stackArr[size]=data;
        size++;
    }
    public void pop(){
        if(size==0){
            System.out.println("Stack underflow");
            return;
        }
        System.out.println(stackArr[--size]);
    }
    public int peek(){
        if (size<0){
            System.out.println("Stack underflow");
        }
         return stackArr[size-1];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void display(){
        if(size==0){
            System.out.println("Stack is Empty");
            return;
        }
        for (int i=size-1;i>=0;i--){
            System.out.print(stackArr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack=new StackArray(5);
        stack.push(54);
        stack.push(55);
        stack.pop();
        stack.display();
        stack.push(22);
        stack.push(12);
        stack.display();
        System.out.println("Peek:"+stack.peek());
        System.out.println("isEmpty:"+stack.isEmpty());
    }
}

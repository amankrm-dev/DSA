public class StaticList {
    int[] arr;
    int size;
    public StaticList(int capacity){
        arr=new int[capacity];
        size=0;
    }
    public void insertAtFirst(int data){
        if(size==arr.length){
            System.out.println("List is Full");
            return;
        }
        for(int i=size;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=data;
        size++;

    }
    public void insertAtPos(int data,int pos){
        for(int i=size;i>=pos;i--){
            arr[i]=arr[i-1];
        }
        arr[pos-1]=data;
        size++;
    }
    public void insertAtLast(int data){
        arr[size]=data;
        size++;
    }
    public void deleteAtFirst() {
        if (size == 0) {
            System.out.println("List is Empty");
        }
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }
    public void deleteAtPos(int pos){
        for(int i=pos-1;i<size-1;i++){
            arr[i]=arr[i+1];
        }
        size--;
    }
    public void deleteAtLast(){
        if(size==0){
            System.out.println("List is Empty");
            return;
        }
        size--;

    }
    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public boolean search(int data){
        for(int i=0;i<size;i++) {
            if (data == arr[i]) {
                return true;
            }
        }
            return false;
    }

    public static void main(String[] args) {
        StaticList list=new StaticList(10);
        list.insertAtFirst(12);
        list.insertAtFirst(1);
        list.insertAtFirst(122);
        list.insertAtFirst(132);
        list.insertAtPos(44,3);
        list.insertAtLast(23);
        list.deleteAtFirst();
        list.deleteAtPos(2);
        list.deleteAtLast();
        list.display();
        System.out.println("List Search 22:"+list.search(22));
    }
}

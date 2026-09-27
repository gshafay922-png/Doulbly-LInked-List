class Node {
    int data;
    Node next;
    Node previous;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

public class LinkedList {
    Node head;

    public void AddAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }

    public void AddAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node Nodeptr = head;
        while (Nodeptr.next != null) {
            Nodeptr = Nodeptr.next;
        }
        Nodeptr.next = newNode;
        newNode.previous = Nodeptr;
    }
    public void AddAtSpecificPosition(int data, int position) {
        if (position == 0) {
            AddAtStart(data);
            return;
        }
        Node newNode = new Node(data);
        Node Nodeptr = head;
        int currentPosition = 0;
        while (Nodeptr != null && currentPosition < position - 1) {
            Nodeptr = Nodeptr.next;
            currentPosition++;
        }
        if (Nodeptr == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        if (Nodeptr.next == null) {
            Nodeptr.next = newNode;
            newNode.previous = Nodeptr;
            return;
        }
        newNode.next = Nodeptr.next;
        newNode.previous = Nodeptr;
        Nodeptr.next.previous = newNode;
        Nodeptr.next = newNode;
    }
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node Nodeptr = head;
        while (Nodeptr != null) {
            System.out.print(Nodeptr.data + " ---> ");
            Nodeptr = Nodeptr.next;
        }
        System.out.println("null");
    }
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
    public boolean IsFirst(int data){
        Node Nodeptr = head;
        if(Nodeptr.data==data){
            return true;
        }
        return false;
    }
    public boolean IsMiddle(int data) {
        if (head == null || head.next == null) {
            return false;
        }

        Node Nodeptr = head;
        while (Nodeptr != null) {
            if (Nodeptr.data == data) {
                if (Nodeptr.previous != null && Nodeptr.next != null) {
                    return true;
                } else {
                    return false;
                }

            }
            Nodeptr = Nodeptr.next;
        }
        return false;
    }public boolean IsLast(int data){
        if (head == null) {
            return false;
        }

        Node Nodeptr1 = head;
        while (Nodeptr1.next != null) {
            Nodeptr1 = Nodeptr1.next;
        }
        if (Nodeptr1.data == data) {
            return true;
        }
        return false;
    }
    public void deleteAtStart(){
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }

        Node Nodeptr = head;
        head=Nodeptr.next;
        Nodeptr.next.previous = null;

    }
    public void deleteAtSpecificPosition(int position) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (position == 1) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            return;
        }

        Node Nodeptr = head;
        int currentPosition = 1;
        while (Nodeptr != null && currentPosition < position) {
            Nodeptr = Nodeptr.next;
            currentPosition++;
        }
        if (Nodeptr == null) {
            System.out.println("Position out of bounds!");
            return;
        }
        if (Nodeptr.next == null) {
            Nodeptr.previous.next = null;
            return;
        }
        Nodeptr.previous.next = Nodeptr.next;
        Nodeptr.next.previous = Nodeptr.previous;
    } public void deleteAtEnd(){
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node Nodeptr = head;
        while (Nodeptr.next != null) {
            Nodeptr = Nodeptr.next;
        }
        Nodeptr.previous.next = null;

    }
    public void insertSorted(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        if (data <= head.data) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            return;
        }

        Node Nodeptr = head;
        while (Nodeptr.next != null && Nodeptr.next.data < data) {
            Nodeptr = Nodeptr.next;
        }
        newNode.next = Nodeptr.next;
        newNode.previous = Nodeptr;

        if (Nodeptr.next != null) {
            Nodeptr.next.previous = newNode;
        }
        Nodeptr.next = newNode;
    }   public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.AddAtStart(10);
        list.AddAtEnd(5);
        list.display();
        list.AddAtSpecificPosition(15, 1);
        list.display();
        list.deleteAtStart();
        list.deleteAtSpecificPosition(1);
        list.deleteAtEnd();
        list.insertSorted(11);
        list.insertSorted(5);
        list.insertSorted(13);
        list.display();
        System.out.println(list.IsMiddle(5));
        System.out.println(list.IsFirst(7));
        System.out.println(list.isEmpty());
        System.out.println(list.IsLast(15));


    }
}
package latihan_java.Java_Collection_Framework.LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        
        if (head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
           
        }
        current.next = newNode;
    }

    public void remove(){
        Node current = head;
        System.out.println(current);
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data);
            if(current.next != null){
                System.out.print(" => ");
            }
            current = current.next; 
        }
        System.out.println();
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukan jumlah node anda: ");
        int countNode = scanner.nextInt();
        MyLinkedList myLinkedList = new MyLinkedList();

        for(int i = 0; i < countNode; i++){
            System.out.print("Masukan node ke - " + (i+1) + " : ");
            int node = scanner.nextInt();
            myLinkedList.add(node);
        }

        myLinkedList.printList();
        myLinkedList.remove();
    }
}
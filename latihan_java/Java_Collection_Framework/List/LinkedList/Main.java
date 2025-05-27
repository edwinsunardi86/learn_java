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

    public void delete(int data){
        if(head == null){
            System.out.println("List kosong");
            return;
        }

        // Kalau node yang mau dihapus ada di head
        if(head.data == data){
            head = head.next;
            System.out.println("Data " + data + " berhasil dihapus");
            return;
        }

        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                System.out.println("Data " + data + " berhasil dihapus");
                return;
            }
            current = current.next;
        }
        System.out.println("Data " + data + " tidak ditemukan");
    }

    public void reserve(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;     // simpan next
            current.next = prev;     // balik pointer
            prev = current;          // majuin prev
            current = next;          // majuin current
        }
        head = prev; // update head ke node terakhir
    }

public boolean isPalindrome(){
    //salin isi linkedList ke string builder
    StringBuilder sb = new StringBuilder();
    Node current = head;

        while(current != null){
            sb.append(current.data);
            current = current.next;
        }

        // bandingkan string dengan kebalikannya
        String str = sb.toString();
        String reserve = sb.reverse().toString();
        
        return str.equals(reserve);
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
        System.out.print("Masukan node yang mau dihapus: ");
        int data = scanner.nextInt();
        myLinkedList.delete(data);
        myLinkedList.reserve();
        myLinkedList.isPalindrome();
    }
}
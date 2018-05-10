package com.interview.loop;

import com.interview.LinkedListCreator;
import com.interview.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by changhr2013 on 2018/5/8.
 */
public class LinkedListReverser {

    public Node reverseLinkedList(Node head){
        Node newHead=null;
        Node currentHead=head;

        while(currentHead!=null){
            Node next=currentHead.getNext();
            currentHead.setNext(newHead);
            newHead=currentHead;
            currentHead=next;
        }

        return newHead;
    }

    public static Node createLargeLinkedList(int size){
        Node pre=null;
        Node head=null;
        for(int i=1;i<=size;i++){

            Node node=new Node(i);

            if(pre!=null){
                pre.setNext(node);
            }else{
                head=node;
            }
            pre=node;
        }
        return head;
    }

    public static void main(String[] args) {

        LinkedListCreator linkedListCreator=new LinkedListCreator();
        LinkedListReverser linkedListReverser=new LinkedListReverser();
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,4,5))));
        Node.printLinkedList(linkedListReverser.reverseLinkedList(createLargeLinkedList(10)));

    }
}

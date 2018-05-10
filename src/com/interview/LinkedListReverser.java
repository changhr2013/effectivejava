package com.interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by changhr2013 on 2018/5/5.
 */
public class LinkedListReverser {

    public Node reverseLinkedList(Node head){

        if(head==null||head.getNext()==null){
            return head;
        }

        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;

    }

    public static void main(String[] args) {
        LinkedListCreator linkedListCreator=new LinkedListCreator();
        LinkedListReverser linkedListReverser=new LinkedListReverser();
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(linkedListReverser.reverseLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,4,5))));


    }
}

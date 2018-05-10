package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by changhr2013 on 2018/5/5.
 */
public class LinkedListCreator {

    public Node createLinkedList(List<Integer> data){
        if(data.isEmpty()){
            return null;
        }

        Node firstNode=new Node(data.get(0));
        firstNode.setNext(createLinkedList(data.subList(1,data.size())));
        return firstNode;
    }

    public static void main(String[] args) {

        LinkedListCreator linkedListCreator=new LinkedListCreator();

        Node.printLinkedList(linkedListCreator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(linkedListCreator.createLinkedList(Arrays.asList(1,2,3,4,5)));

    }
}

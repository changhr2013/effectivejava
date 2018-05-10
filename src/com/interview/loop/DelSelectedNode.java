package com.interview.loop;

import com.interview.Node;

/**
 * Created by changhr2013 on 2018/5/9.
 */
public class DelSelectedNode {

    public static Node createTheNodes(){
        Node end= new Node(2);

        Node three= new Node(2);
        three.setNext(end);
        Node two= new Node(2);
        two.setNext(three);
        Node one= new Node(2);
        one.setNext(two);
        Node head = new Node(2);
        head.setNext(one);
        return head;
    }

    public Node nodeDeleter(Node node,int value){
        if(node==null){
            return null;
        }
        Node head = node;
        Node next = node.getNext();
        if(next==null&&head.getValue()==2){
            return null;
        }
        while (next!=null){
            if(node.getValue()==value){
                head=next;
                node=next;
                next=next.getNext();
                continue;
            }

            if(next.getValue()==value){
                node.setNext(next.getNext());
            }else{
                node=next;
            }
            next=next.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        DelSelectedNode delSelectedNode=new DelSelectedNode();
        Node head=createTheNodes();
        Node result=delSelectedNode.nodeDeleter(head,2);
        Node.printLinkedList(result);
    }
}

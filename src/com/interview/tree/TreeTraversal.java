package com.interview.tree;

/**
 * Created by Tony on 2018/5/10.
 */
public class TreeTraversal {

    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue());
        inOrder(root.getRight());
    }

    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue());
    }
    public String constructPostOrder(String preOrder,String inOrder){
        if(preOrder.isEmpty()){
            return "";
        }
        char root = preOrder.charAt(0);
        int leftSize = inOrder.indexOf(root);
        return
        constructPostOrder(preOrder.substring(1,leftSize+1),inOrder.substring(0,leftSize))+
                constructPostOrder(preOrder.substring(leftSize+1),inOrder.substring(leftSize+1))+
                root;
    }

    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();
        TreeCreator treeCreator = new TreeCreator();
        TreeNode sampleTree = treeCreator.createTree();

//        treeTraversal.preOrder(sampleTree);
//        System.out.println();
//        treeTraversal.inOrder(sampleTree);
//        System.out.println();
//        treeTraversal.postOrder(sampleTree);
//        System.out.println();
        System.out.println(treeTraversal.constructPostOrder("ABDEGCF","DBGEACF") );
    }
}

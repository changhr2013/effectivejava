package com.interview.tree;

/**
 * Created by Tony on 2018/5/10.
 */
public class TreeCreator {

    public TreeNode createTree(){
        TreeNode root=new TreeNode('A');

        root.setLeft(new TreeNode('B'));
        root.setRight(new TreeNode('C'));

        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getRight().setRight(new TreeNode('F'));

        root.getLeft().getRight().setLeft(new TreeNode('G'));

        return root;
    }
}

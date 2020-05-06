package org.example.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    BinaryTree()
    {
        root = null;
    }

    public void printPreOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);

    }

    public void printPostOrder(Node root){
        if(root == null){
            return;
        }


        printPreOrder(root.left);
        printPreOrder(root.right);
        System.out.println(root.data);

    }


    public void printInOrder(Node root){
        if(root == null){
            return;
        }

        printPreOrder(root.left);
        System.out.println(root.data);
        printPreOrder(root.right);
    }


    public void printLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node != null){
                queue.add(node.left);
                queue.add(node.right);
                System.out.println(node.data);
            }
        }
    }

    public boolean isPresent(Node root,int element){
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node != null){
                queue.add(node.left);
                queue.add(node.right);
               if(node.data == element){
                   return true;
               }
            }
        }
        return false;
    }


    public void insert(Node node,int item){
        Queue<Node> q = new LinkedList<>();

        if(node == null){
            node = new Node(item);
            return;
        }
        q.add(node);

        while (!q.isEmpty()){
           Node temp = q.poll();

            if (temp.left == null) {
                temp.left = new Node(item);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(item);
                break;
            } else
                q.add(temp.right);
        }

    }




    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder(tree.root);

        System.out.println("\nLevel order of binary tree is ");
        tree.printLevelOrder(tree.root);

        int element = 5;
        System.out.println("Is "+element+ " present: "+tree.isPresent(tree.root,element));

        System.out.println("insert new node");
        tree.insert(tree.root,10);

        tree.printLevelOrder(tree.root);
    }

    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}

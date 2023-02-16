package com.trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeClass {
    private class TreeNode {
        int value;
        TreeNode leftChild;
        TreeNode rightChild;
        private TreeNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node==> " + value;
        }
    }

    private TreeNode root;

    public TreeNode getRootNode(){
        return root;
    }

    public void insert(int value){
        var node = new TreeNode(value);
        if(root==null){
            root = node;
            return;
        }

        var current = root;
        while (true){
            if(value< current.value) {
                if(current.leftChild==null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if(current.rightChild==null){
                    current.rightChild = node;
                    break;                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        if(root==null)
            return false;

        var current = root;
        while (current!=null){
            if (current.value<value)
                current = current.rightChild;
            else if (current.value>value)
                current = current.leftChild;
            else return true;
        }
        return false;
    }

    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(TreeNode node){
        List<Integer> list = new ArrayList<>();
        //Root -> Left -> Right
        var current = node;
        if(current==null)
            return;

        System.out.print(current.value + " ");
        preOrder(current.leftChild);
        preOrder(current.rightChild);
    }

    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(TreeNode node){
        //Left -> Root --> Right
        var current = node;
        if(current==null)
            return;


        inOrder(current.leftChild);
        System.out.print(current.value + " ");
        inOrder(current.rightChild);
    }

    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(TreeNode node){
        //Root -> Left -> Right
        var current = node;
        if(current==null)
            return;

        postOrder(current.leftChild);
        postOrder(current.rightChild);
        System.out.print(current.value + " ");
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        //first put the current level nodes to queue
        //then traverse that node's children and put them on top of queue
        //then after traversing children of that node put it into out list

        //Tree -> 1 2 3 4 5 6 7
        //Queue -> {1} --> {2,3} --> {4,5,6,7}
        //List -> {{1}} --> {{1}, {2,3}} -> {{1}, {2,3}, {4,5,6,7}}
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root==null)
            return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i=0;i<levelNum;i++){
                if (queue.peek() != null && queue.peek().leftChild != null) queue.offer(queue.peek().leftChild);
                if (queue.peek() != null && queue.peek().rightChild != null) queue.offer(queue.peek().rightChild);
                subList.add(queue.poll().value);
            }

            wrapList.add(subList);
        }

        return wrapList;
    }

    public List<Integer> iterativePreorderTraversal(TreeNode root){
        //Root -> Left -> Right
        //idea is push the root node to stack
        //then after it push the right child and left child
        //then traverse the left child and right child till null
        //and push all the values to stack

        //Tree -> 1 2 7 3 4 5 6
        //Stack -> 1 --> 7 2 --> 7 4 3 --> 7 4 --> 7 6 5
        //Print -> 1 --> 2 --> 3 --> 4 --> 5 6 --> 7

        List<Integer> preOrder = new ArrayList<>();

        //edge case
        if(root==null) return preOrder;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            preOrder.add(root.value);

            if(root.rightChild!=null)
                stack.push(root.rightChild);
            if(root.leftChild!=null)
                stack.push(root.leftChild);
        }

        return preOrder;
    }
    public List<Integer> iterativeInorderTraversal(TreeNode root){
        //Left -> Root -> Right
        //idea is push the root node to stack
        //then after it push the right child and left child
        //then traverse the left child and right child till null
        //and push all the values to stack

        //Tree -> 1 2 7 3 4 5 6
        //Stack -> 1 --> 1 2 --> 1 2 4 --> 1 5 --> 1 6 5 --> 1 7 --> 3
        //Print ->                     -->4 2--> 6 5 --> 7 1 --> 3

        List<Integer> inOrder = new ArrayList<>();

        //edge case
        if(root==null) return inOrder;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node =root;
        while (true){
            if(node!=null){
                stack.push(node);
                node =node.leftChild;
            }else {
                if(stack.isEmpty())
                    break;
                node = stack.pop();
                inOrder.add(node.value);
                node = node.rightChild;
            }
        }

        return inOrder;
    }

    public List<Integer> iterativePostOrderTraversalUsing2Stacks(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);

            if(root.leftChild!=null)
                stack1.push(root.leftChild);
            if(root.rightChild!=null)
                stack1.push(root.rightChild);
        }

        while (!stack2.isEmpty())
            list.add(stack2.pop().value);

        return list;

        //TC --> O(N)
        //SC --> O(2N) --> O(N)
    }

    public List<Integer> iterativePostOrderTraversalUsingStack(TreeNode curr){
        List<Integer> list = new ArrayList<>();
        if(curr==null)
            return list;

        Stack<TreeNode> stack = new Stack<>();

        while (curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr = curr.leftChild;
            }else{
                TreeNode temp = stack.peek().rightChild;
                if(temp==null){
                    temp = stack.pop();
                    list.add(temp.value);
                    while (!stack.isEmpty() && temp==stack.peek().rightChild){
                        temp = stack.pop();
                        list.add(temp.value);
                    }
                }else
                    curr = temp;
            }
        }

        return list;
        //TC --> O(2N)
        //SC --> O(N)
    }

    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.num = num;
            this.node = node;
        }
    }
    public void allTraversals(TreeNode root){
        //Preorder --> Root->Left->Right
        //Preorder --> Left->Root->Right
        //Preorder --> Left->Right->Root

        Stack<Pair> stack = new Stack<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()){
            //if num is 1, then add it to preorder, num++, left
            //if num is 2, then add it to inorder, num++, right
            //if num is 3, then add it to postorder

            Pair curr = stack.pop();

            if(curr.num==1){
                preOrder.add(curr.node.value);
                curr.num++;
                stack.push(curr);

                if(curr.node.leftChild!=null)
                    stack.push(new Pair(curr.node.leftChild, 1));
            }else if(curr.num==2){
                inOrder.add(curr.node.value);
                curr.num++;
                stack.push(curr);

                if(curr.node.rightChild!=null)
                    stack.push(new Pair(curr.node.rightChild, 1));
            }
            else
                postOrder.add(curr.node.value);
        }
    }
}

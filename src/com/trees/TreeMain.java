package com.trees;

public class TreeMain {
    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 6, 14, 24, 3, 8, 26 };
//        int[] arr = {1,2,3,4,5,6,7,8 };
        TreeClass tree = new TreeClass();
        for(int i: arr){
            tree.insert(i);
        }
//        tree.insert(7);
//        tree.insert(4);
//        tree.insert(9);
//        tree.insert(1);
//        tree.insert(6);
//        tree.insert(8);
//        tree.insert(10);

//        System.out.println(tree.find(10));
//        System.out.println("Pre-Order Traversal: ");
////        tree.preOrder();
//        System.out.println(tree.iterativePreorderTraversal(tree.getRootNode()));
//        System.out.println();
//        System.out.println("In-Order Traversal: ");
////        tree.inOrder();
//        System.out.println(tree.iterativeInorderTraversal(tree.getRootNode()));
//        System.out.println();
        System.out.println("Post-Order Traversal: ");
        tree.postOrder();
        System.out.println("Iterative Post order: ");
//        System.out.println(tree.iterativePostOrderTraversalUsing2Stacks(tree.getRootNode()));
        System.out.println(tree.iterativePostOrderTraversalUsingStack(tree.getRootNode()));
        System.out.println();
        System.out.println("Done");
    }
}

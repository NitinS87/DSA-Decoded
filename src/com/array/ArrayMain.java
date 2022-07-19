package com.array;

public class ArrayMain {
    public static void main(String[] args) {
        ArrayClass arr = new ArrayClass(5);
        arr.insert(5);
        arr.insert(10);
        arr.insert(15);
        arr.insert(20);
        arr.insert(25);
//        arr.removeAt(5);
        System.out.println(arr.indexOf(25));
        System.out.println(arr.max());
        arr.print();

        arr.reverse();
        arr.print();

    }
}

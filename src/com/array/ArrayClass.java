package com.array;

public class ArrayClass {
    private int[] items;
    private int count;

    public ArrayClass(int length){
        items = new int[length];
    }

    public void print(){
        for(int i=0;i<count;i++){
            System.out.println(items[i]);
        }
    }

    public void insert(int item){
        //if array is full, resize it
        if(items.length == count){
            //create new array with double length
            int[] newItems = new int[2* count];

            //copy all existing items
            for(int i=0;i<count;i++){
                newItems[i] = items[i];
            }

            //set new array as old array
            items = newItems;

        }

        //add the new item at the end
        items[count++] = item;
    }

    public void removeAt(int index){
        //validate the index
        if(index<0 || index>=count)
            throw new IllegalArgumentException();

        //shift the items to the left to fill hole
        for(int i = index; i<count;i++){
            items[i] = items[i+1];
        }

        count--;
    }

    public int indexOf(int item){
        //traverse through the array
        for(int i=0;i<count;i++){
            if(item == items[i]) {
                return i;
            }
        }

        //if not found return -1
        return -1;
    }

    public int max(){
        int maxItem = items[0];
        for(int i=0;i< count;i++){
            if(maxItem< items[i])
                maxItem = items[i];
        }

        return maxItem;
    }

    public void reverse(){
        int[] reverseItem = new int[count];
        int revCount = 0;
        for(int i=count-1;i>=0;i--){
            reverseItem[revCount++] = items[i];
        }

        items = reverseItem;
    }

}

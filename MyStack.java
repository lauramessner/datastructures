/* Laura Messner - lmm2314
 * MyStack.java uses an array to manipulate a stack
 */

import java.util.*;
import java.util.EmptyStackException;
import java.io.*;

public class MyStack<T> implements MyStackInterface<T> {
    
    private T[] myArray;
    private int size;
    
    //create a stack
    @SuppressWarnings("unchecked")
    public MyStack() {
        size = 0;
        myArray = (T[]) new Object[10]; 
    }
  
    //interface implementation
    @SuppressWarnings("unchecked")
    public void push(T x) {
        if(size == myArray.length) {
            //create a new array of double the size
            T[] myArray2 = (T[]) new Object[2*size];
        
            //copy the content of the 1st array into the 2nd
            for(int i = 0; i < size; i++) {
                myArray2[i] = myArray[i];
            }
            myArray = myArray2;
            myArray2[size] = x; 
            size++; 
        }
        else {
            myArray[size] = x; 
            size++; 
        }
    }
    
    @Override
	public T pop() {
        //exception if stack is empty
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            size--;
            return myArray[size];
        }
    }
    
    @Override
	public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
            
        }
        return myArray[size-1];       
    }
    
    @Override
	public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
	public int size() {
        return size;
    }   
}
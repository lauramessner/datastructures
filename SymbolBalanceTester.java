import java.util.*;
import java.io.*;

public class SymbolBalanceTester{
  
    public static void main(String[] args){
        SymbolBalance test = new SymbolBalance();
        test.setFile("TestFiles/Test2.java");
        
        test.checkFile();
        
        // System.out.println("javid");
        // MyStack<Character> symStack = new MyStack<Character>(); 
        // char a = 'a';
        // // Character javid =  new Character(a);
        // symStack.push(a);
        // System.out.println(symStack.peek());
    }  
}
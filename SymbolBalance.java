/* Laura Messner - lmm2314
 * SymbolBalance.java checks 
 * for syntax errors in given files
 */

import java.util.*;
import java.io.*;

public class SymbolBalance implements SymbolBalanceInterface {
    
    int lineNb = 0;
    char readChar;
    char symMatch;
    int quoteNb = 0;
    //int commentNb = 0;
    File myFile;
    MyStack<Character> symStack = new MyStack<Character>(); 
    
    

    MismatchError me = new MismatchError(lineNb, readChar, symMatch);
    EmptyStackError es = new EmptyStackError(lineNb);
    //NonEmptyStackError nes = new NonEmptyStackError(symStack.peek(), symStack.size());
    
    @Override
    public void setFile(String filename) {
        
        myFile = new File(filename);
    }
    
    @Override
	public BalanceError checkFile() {
 
        try {
            Scanner scanner = new Scanner(myFile);
            while(scanner.hasNextLine()) { 
                String line = scanner.nextLine();
                lineNb++;

                for(int i = 0; i < line.length(); i++) {
                    readChar = line.charAt(i);
                    char readCharNext = line.charAt(i++);

                    //ignore characters between comments      
                    if((readChar == '/') && (readCharNext == '*')) {
                        readChar = '*';
                        System.out.println("ln27");                     
                        symStack.push(readChar); //push '*' 
                        //commentNb = 1;
                    }  
                    if((readChar == '*') && (readCharNext == '/')) {
                        //the while loop ensures we ignore chars between comments
                        while(symStack.pop() != '*' ) {
                            symStack.pop();
                        }
                    }

                    //ignore characters between quotes
                    if(readChar == '"') {
                        symStack.push(readChar);
                        quoteNb = 1;
                    }    
                    if((readChar == '"') && (quoteNb == 1)) {
                        //the while loop ensures we ignore chars between quotes
                        while(symStack.pop() != '"') {
                            System.out.println("ln27");
                            symStack.pop();
                            quoteNb = 0;
                        }
                    }
               
                    if(((readChar == '{') || (readChar == '[') || (readChar == '(')) && 
                       (symStack.isEmpty() == true)) {
                        System.out.println("ln27");
                        symStack.push(readChar);
                    }
                    else if(((readChar == '}') || (readChar == ']') || (readChar == ')')) && 
                             (symStack.isEmpty() == true)) {
                        return es;
                    }
                    System.out.println("ln81");
                    //peek at the symbol in the stack to match it with its closing
                    symMatch = symStack.peek();
                    if(((symMatch=='{') && (readChar=='}')) || 
                       ((symMatch=='[') && (readChar==']')) ||
                        ((symMatch=='(') && (readChar==')')) ||
                         ((symMatch=='"') && (readChar=='"'))) {
                        symStack.pop();     
                    }
                    else {
                        return me;
                    }
                }
            }
            //if we are at the end of the file and stack still has elements
            /*while(scanner.hasNextLine() == false) {
                if(symStack.isEmpty() == false) {
                    return nes;
                }
            }*/
        //exception if file not found
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;   
    }
} 
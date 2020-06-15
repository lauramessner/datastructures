/* Laura Messner - lmm2314
 * TwoStackQueue.java creates a queue
 * out of two separate stacks
 */
 
public class TwoStackQueue<T> implements TwoStackQueueInterface<T> {
    
    private MyStack<T> s1;
    private MyStack<T> s2;
    
    public TwoStackQueue() {
        s1 = new MyStack<T>();
        s2 = new MyStack<T>();
    }
    
    public void enqueue(T x) {
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }
    
	public T dequeue() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        if(!s2.isEmpty()) {
            return s2.pop();
        }
        else {
            return null;
        }
    }
    
	public int size() {
        return s1.size() + s2.size();
    }
    
	public boolean isEmpty() {
        if(s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    } 
}
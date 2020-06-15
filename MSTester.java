public class MSTester{
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        MyStack<String> m = new MyStack<String>();
        System.out.println(m.size());
        m.push("Socrates");
        m.push("Plato");
        m.push("Aristophanes");
        System.out.println(m.size());
        m.pop();
        m.pop();
        System.out.println(m.size());
        
    }
}
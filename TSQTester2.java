public class TSQTester2{
    public static void main(String[] args) {


        TwoStackQueue<String> testQueue = new TwoStackQueue<String>();

        testQueue.enqueue("Roses");
        System.out.println(testQueue.dequeue());
        testQueue.enqueue("Peonies");
        testQueue.enqueue("Daisies");
        testQueue.enqueue("Chrysanthemums");
        testQueue.enqueue("Dandelions");
        while(!testQueue.isEmpty()) {
            System.out.println(testQueue.dequeue());
        }
        System.out.println(testQueue.size());
        System.out.println(testQueue.dequeue());
        testQueue.enqueue("Sunflowers");
        System.out.println(testQueue.dequeue());

    }
}
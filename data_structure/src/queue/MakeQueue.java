package queue;

import java.util.ArrayList;

public class MakeQueue<T> {
    private ArrayList<T> queue = new ArrayList<>();

    public void enqueue(T value) {
        queue.add(value);
    }

    public T dequeue(){
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MakeQueue<Integer> mq = new MakeQueue<>();

        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);

        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}

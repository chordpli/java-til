package linkedList;

public class Node<T> {
    T data;
    Node<T> next = null;

    public Node(T data){
        this.data = data;
    }



    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<>(2);
        node1.next = node2;
        Node head = node1; // 맨 앞을 나타내는 변수 그래서 맨 앞에 있는 노드 객체를 넣음

    }
}

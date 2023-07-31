package HW_10;

public class MyLinkedList<E> {

    transient int size;
    transient Node<E> first;
    transient Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
    
        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public void setPrev(Node<E> prev){
            this.prev = prev;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }

        public Node<E> getPrev(){
            return prev;
        }

        public Node<E> getNext(){
            return next;
        }

        public E get(){
            return element;
        }
    }

    public MyLinkedList(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public void addToStart(E element){
        Node<E> node = new Node<E>(null, element, first);
        if(this.size == 0){
            this.first = this.last = node;
        }
        else{
            this.first.setPrev(node);
            this.first = node;
        }
        this.size++;
    }

    public void addToEnd(E element){
        Node<E> node = new Node<E>(last, element, null);
        if(this.size == 0){
            this.first = this.last = node;
        }
        else{
            this.last.setNext(node);
            this.last = node;
        }
        this.size++;
    }

    public E get(int index){
        Node<E> element = this.first;
        while(index != 0){
            element = element.getNext();
            index--;
        }
        return element.get();
    }

    public int size(){
        return this.size;
    }
}
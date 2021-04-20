import java.io.*;
class Node<E> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private E element;
    private Node<E> prev;
    private Node<E> nextNd;

    Node(E e)
    {
        element = e;
        nextNd = null;
        prev = null;
    }

    void setElement(E e)
    {
        element = e;
    }

    void setNext(Node<E> nodePointer)
    {
        nextNd = nodePointer;
    }

    void setPrev(Node<E> prevNode)
    {
        prev = prevNode;
    }

    E getElement()
    {
        return this.element;
    }

    Node<E> getNext()
    {
        return this.nextNd;
    }
    
    Node<E> getPrev()
    {
        return this.prev;
    }

}

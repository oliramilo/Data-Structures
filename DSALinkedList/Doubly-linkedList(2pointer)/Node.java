class Node
{
    private Object element;
    private Node prev;
    private Node nextNd;

    Node(Object e)
    {
        element = e;
        nextNd = null;
        prev = null;
    }

    void setElement(Object e)
    {
        element = e;
    }

    void setNext(Node nodePointer)
    {
        nextNd = nodePointer;
    }

    void setPrev(Node prevNode)
    {
        prev = prevNode;
    }

    Object getElement()
    {
        return this.element;
    }

    Node getNext()
    {
        return this.nextNd;
    }
    
    Node getPrev()
    {
        return this.prev;
    }

}

class Node
{
    private Object element;
    private Node nextNd;

    Node(Object e)
    {
        element = e;
        nextNd = null;
    }

    void setElement(Object e)
    {
        element = e;
    }

    void setNext(Node nodePointer)
    {
        nextNd = nodePointer;
    }

    Object getElement()
    {
        return this.element;
    }

    Node getNext()
    {
        return this.nextNd;
    }

}

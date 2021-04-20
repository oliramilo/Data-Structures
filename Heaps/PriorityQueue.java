//Max priority Queue
class PriorityQueue
{
    private Heap maxHeap;
    public PriorityQueue()
    {
        maxHeap = new Heap();
    }

    void add(int priority, Object val)
    {
        maxHeap.add(priority, val);
    }

    Object remove()
    {
        return maxHeap.remove();
    }

    int size()
    {
        return maxHeap.size();
    }

    boolean isEmpty()
    {
        return maxHeap.isEmpty();
    }
}

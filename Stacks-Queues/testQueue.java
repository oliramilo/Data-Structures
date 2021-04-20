public class testQueue 
{
    public static void main(String[] args)
    {
        System.out.println("Testing for Circular Queue is an instance of DSAQueue");
        DSAQueue shuffle = new Queue();
        DSAQueue queue = new CircQueue();
        try 
        {
            if(queue instanceof CircQueue)
            {
                Thread.sleep(1000);
                System.out.println("Test passed.\n");
            }
            else
            {
                Thread.sleep(1000);
                throw new IllegalArgumentException("Test failed\n");
            }
        
            System.out.println("\nSize of queue is " + queue.size());
            System.out.println("\nDefault size is " + DSAQueue.CAPACITY);
        
            if(queue.isEmpty())
            {
                
                Thread.sleep(500);
                System.out.println("\nQueue is currently empty");
                Thread.sleep(250);
                System.out.println("\nEnqueueing 1000 numbers to the queue");
                int i=1;
                while(i <= queue.size())
                {
                    queue.enQueue(i);
                    i++;
                }

                Thread.sleep(1000);
                System.out.println("\nCurrent count in queue is now " + queue.getCount());
                if(!queue.isFull())
                {
                    throw new IllegalArgumentException("\nQueue is not full");
                }

                Thread.sleep(500);
                System.out.println("\nPeek of the queue should be 1");
                if(String.valueOf(queue.peek()).equals("1"))
                {
                    Thread.sleep(500);
                    System.out.println("\nTest passed for peek value " + queue.peek());
                }
            }

            else
            {
                throw new IllegalArgumentException("Queue is not empty, test failed");
            }
            System.out.println("\nTesting dequeue, removing first 500 elements ");
            Thread.sleep(750);
            int x = 0;
            while(x < 500)
            {
                queue.deQueue();
                x++;
            }
            if(queue.getCount() != 500)
            {
                System.out.println("\nTest failed");
            }
            else
            {
                System.out.println("\nTest passed for count " + queue.getCount());
            }
            System.out.println("\nShuffle Queue is full: " + queue.isFull());
            System.out.println("Circular Queue is empty: " + queue.isEmpty());
            System.out.println("Peek is now " + queue.peek());
            System.out.println("Circ Queue test passed\n");
            Thread.sleep(100);


            System.out.println("\n\nTesting for Shuffling Queue is an instance of DSAQueue");
            if(shuffle instanceof DSAQueue)
            {
                int i = 1;
                int j =0;
                System.out.println("Test passed " + (shuffle instanceof DSAQueue));
                System.out.println("\nShuffle Queue is empty: " + shuffle.isEmpty());
                System.out.println("\nShuffle Queue is full: " + shuffle.isFull());
                System.out.println("\nQueueing 1000 integers into queue");

                while(!shuffle.isFull())
                {
                    shuffle.enQueue(i);
                    i++;
                }

                System.out.println("\nFront element of the queue: " +shuffle.peek());
                Thread.sleep(750);
                System.out.println("\nShuffle Queue is empty: " + shuffle.isEmpty());
                System.out.println("\nShuffle Queue is full: " + shuffle.isFull());
                System.out.println("\nDequeueing 500 elements in ShuffleQueue");
                while(j < 500)
                {
                    shuffle.deQueue();
                    j++;
                }
                System.out.println("\nFront element of the queue: " +shuffle.peek());
                if(shuffle.getCount() != 500)
                {
                    System.out.println("Test failed ");
                }

                System.out.println("\nShuffling Queue is empty: " + shuffle.isEmpty());
                System.out.println("\nShuffling Queue is full: " + shuffle.isFull());
            }
            else
            {
                System.out.println("Test failed for ShuffleQueue instance of DSAQueue");
            }
        }
        catch(InterruptedException e) { }
    }
}

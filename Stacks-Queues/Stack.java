public class Stack extends DSAStack
{
    public Stack()
    {
        super();
    }

    public Stack(int max)
    {
        super(max);
    }

    @Override
    public void push(Object obj)
    {
        if(!isFull())
        {
            stackArray[count] = obj;
            count +=1;
        }

        else
        {
            throw new StackFullException("Stack is full.");
        }
    }
    
    @Override
    public Object pop()                                                         
    {                                                                           
         Object topVal = null;                                                   
         if(isEmpty())                                                           
         {                                                                       
             throw new StackEmptyException("Stack is Empty");                    
         }                                                                       
         else                                                                    
         {                                                                       
             topVal = peek();                                                    
             count -=1;                                                          
         }                                                                       
         return topVal;                                                          
    }

    @Override
    public Object peek()                                                        
    {                                                                           
        Object topVal = null;                                                   
        if(!isEmpty())                                                          
        {                                                                       
            topVal = stackArray[count-1];                                       
        }                                                                       
                                                                                 
        else                                                                    
        {
            throw new StackEmptyException("Empty stack");                       
        }
        return topVal;                                                          
    } 
}

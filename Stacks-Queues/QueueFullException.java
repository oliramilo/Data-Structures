public class QueueFullException extends RuntimeException
{
    public QueueFullException(String error)
    {
        super(error);
    }
}

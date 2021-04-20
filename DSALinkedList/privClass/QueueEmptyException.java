class QueueEmptyException extends RuntimeException
{
    QueueEmptyException(String err)
    {
        super(err);
    }
}

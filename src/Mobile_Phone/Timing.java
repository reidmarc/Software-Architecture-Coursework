package Mobile_Phone;

public class Timing
{
    public long startTiming()
    {
        return System.nanoTime();
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public long endTiming(long start)
    {
        long duration = System.nanoTime() - start;
        return duration / 1000000000;
    }
}

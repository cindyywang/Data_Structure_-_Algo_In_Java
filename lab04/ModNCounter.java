/**
 * Created by ying2ra on 6/23/17.
 */
public class ModNCounter extends Counter {
    int N;

    public ModNCounter(int N)
    {
        this.N = N;
    }
    public int value()
    {
        return (super.value() % N);
    }
}

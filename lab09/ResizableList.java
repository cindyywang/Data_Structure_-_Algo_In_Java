/**
 * Created by ying2ra on 7/15/17.
 */
public class ResizableList extends FixedSizeList
{
    public ResizableList()
    {
        super(20);
    }

    @Override
    public void add(int k)
    {
        if(values.length == count+1)
        {
            int[] temp = new int[2*values.length];
            System.arraycopy( values, 0, temp, 0, values.length );
            values = temp;
        }
        super.add(k);
    }

    public void add(int i, int k)
    {
        if(values.length == count+1)
        {
            int[] temp = new int[2*values.length];
            System.arraycopy( values, 0, temp, 0, values.length );
            values = temp;
        }
        super.add(i,k);
    }

}

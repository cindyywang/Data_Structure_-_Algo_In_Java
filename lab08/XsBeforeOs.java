public class XsBeforeOs {

    // Rearrange the elements of values so that all the Xs precede all
    // the Os.
    public static void rearrange(char[] values) {
        int lastXpos = -1;
        for (int k = 0; k < values.length; k++)
        {
            if (values[k] == 'X')
            {

                // YOUR CODE HERE
                lastXpos = k;

                /*if(  values[k+1] == 'O')//lastXpos?
                {
                    for(int i = k+1; i < values.length; i++)
                    {
                        if(values[i] == 'X')
                        {
                            values[k+1] = 'X';
                            values[i] = 'O';
                        }
                    }
                }*/

                /*for(int i = lastXpos+1; i < values.length; i++)
                {
                    if(values[i] == '')
                }*/
            }
            else
            {


                int i = k + 1;
                if (i < values.length - 1)
                {
                    while((values[i] == 'O') && (i < values.length - 1))
                    {
                        i++;
                    }
                    if (values[i] == 'X')
                    {
                        values[i] = 'O';
                        values[k] = 'X';
                    }

                }


            }


            try
            {
                isOK(values, k);
            } catch (IllegalStateException e) {
                System.err.println("inconsistency at position " + k);
            }
        }
    }

    // Check for consistency. All the Xs in elements 0 to k of values should
    // precede all the Os. Throw an IllegalStateException if this is not
    // consistent.
    public static void isOK (char[] values, int k) {

        // YOUR CODE HERE
        //int firstO;
        for(int i = 0; i < k+1; i++)
        {
            if(values[i] == 'O')
            {
                //firstO = i;
                for (int j = i+1; j < k+1; j++)
                {
                    if(values[j] == 'X')
                    {
                        throw new IllegalStateException();
                    }
                }
            }
        }

    }
}

/*
L10
What about abstract/interface?: Y, we can.
//can have two generics<S, T>
public class Box<T>
{
    T ITEM;
        public Box(T item)
        {
            this.item = item;
        }
}

Iterator interface
hasNext()
next()
when implement interface must have the two above, but can be implemented differently
default remove()
when implement default, it will already have had

while(iterator.hasNext())
{
    a = iterator.next();
}

enhance for loop

ArrayList<Point> a = newArrayList<Point>();
for(Point x: a)
{
    print(x);
}

// a has to implement Iterable
iterator()
return an iterator obj
 */
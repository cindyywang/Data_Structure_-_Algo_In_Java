public class Time {

    private int myHours;
    private int myMinutes;
    

    public Time(String s) {
        try
        {
            int colonPos = s.indexOf(":");
            String subhour = s.substring(0,colonPos);
            String subminute = s.substring(colonPos+1);
            if(subhour.length() > 2)
            {
                throw new IllegalArgumentException("too many leading zeros for hour!");
            }
            if(subminute.length() > 2)
            {
                throw new IllegalArgumentException("too many leading zeros for minute!");
            }
            int hours = Integer.parseInt(s.substring(0, colonPos));
            int minutes = Integer.parseInt(s.substring(colonPos + 1));
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Illegal Argument");
        }
        catch(NullPointerException e)
        {
            System.out.println("null");
        }
        timeHelper();


    }



    public Time(int hours, int minutes) {
        myHours = hours;
        myMinutes = minutes;
        timeHelper();


    }



    public void timeHelper()
    {
        if(this.myHours < 0)
        {
            throw new IllegalArgumentException("Hour can't be negative!");
        }
        if(this.myHours > 23)
        {
            throw new IllegalArgumentException("No more than 24 hours a day!");
        }
        if(this.myMinutes < 0)
        {
            throw new IllegalArgumentException("Minute can't be negative!");
        }
        if(this.myMinutes > 59)
        {
            throw new IllegalArgumentException("No more than 60 minutes in an hour!");
        }
    }

    public boolean equals (Object obj) {
        Time t = (Time) obj;
        return myHours == t.myHours && myMinutes == t.myMinutes;
    }

    public String toString() {
        if (myMinutes < 10) {
            return myHours + ":0" + myMinutes;
        } else {
            return myHours + ":" + myMinutes;
        }
    }
}

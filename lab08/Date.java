public class Date {

    /* DAYS_IN_MONTH[month-1] represents the number of days in month during a non-leap year. */
    public static final int[] DAYS_IN_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int myMonth;        // months range from 1 (January) through 12 (December)
    private int myDateInMonth;  // dates-in-month range from 1 through the number of days in the month
    private int myYear;         // years are between 1900 and 2100 (arbitrary decision)

    public Date (int month, int dateInMonth, int year) {
        myMonth = month;
        myDateInMonth = dateInMonth;
        myYear = year;
    }
    
    // Determine if the date information is internally consistent.
    public void isOK() {
        boolean leapDay;// Feb has 29 if true
        if (myYear % 4 != 0) {
            leapDay = false;
        } else if (myYear % 100 != 0) {
            leapDay = true;
        } else if (myYear % 400 != 0) {
            leapDay = false;
        } else {
            leapDay = true;
        }
        if( myYear < 1900 || myYear > 2100)
        {
            throw new IllegalStateException();
        }
        if( myMonth < 1 || myMonth > 12)
        {
            throw new IllegalStateException();
        }
        if(myDateInMonth < 1)
        {
            throw new IllegalStateException();
        }
        if( myMonth == 4 || myMonth == 6 || myMonth == 9 || myMonth == 11)
        {
            if(myDateInMonth > 30)
                throw new IllegalStateException();
        }
        else if(myMonth == 2)
        {
            if(leapDay)
            {
                if (myDateInMonth > 29)
                    throw new IllegalStateException();
            }
            else
            {
                if(myDateInMonth > 28)
                    throw new IllegalStateException();
            }

        }
        else
        {
            if(myDateInMonth > 31)
                throw new IllegalStateException();
        }

    }
}

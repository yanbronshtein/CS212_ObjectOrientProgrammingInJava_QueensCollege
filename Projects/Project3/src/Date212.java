/**
 * <tt>Date212</tt>
 * The Date212 class is for validating, and formatting a date input in the form of a string
 *
 * @author yanivbronshtein
 * @version 2.0
 *
 *
 * */

public class Date212 {
    /**first 4 characters of inputed date string*/
    private int year = -1;
    /** the 5th and 6th characters of the inputed date string*/
    private int month = -1;
    /**the last two characters of the inputed date string */
    private int day = -1;
    /**Local copy of the string date passed to the class through the constructor */
    private int originalDateInt = -1;
    /**States whether the date passed to the constructor is valid or not*/

    public boolean valid = false;


    /**
     * Constructs a Date212 for the specified string.
     * <p>
     * If the <code>valid</code> flag as determined by the output of the call to checkDate is <code>true</code>,
     * then <code>year</code>, <code>month</code>
     * and <code>day</code> parameters are set by extracting the respective substrings and converting the resulting
     * string to integer values. Otherwise, the default values for the variables which are clearly invalid are preserved
     *
     * @param   date            a string to be parsed.
     * @exception NullPointerException if date is <CODE>null</CODE>
     */
    Date212(String date) throws Date212Exception
    {


        checkDate(date);
        this.year = Integer.parseInt(date.substring(0, 4));
        this.month = Integer.parseInt(date.substring(4, 6));
        this.day = Integer.parseInt(date.substring(6, 8));
        this.originalDateInt = Integer.parseInt(date);



    }

    /**This method takes in an input date and determines whether it is formatted properly in the following format:
     * yyyymmdd.First the, method attempts to convert the entire string to an integer. If the operation a Number Format
     * Exception then the string is clearly invalid so the method returns <code>false</code>
     * Next, the method checks that the length of the string is 8. Next, the method checks that the <code>month</code>
     * field is in range and proceeds to check the <code>day</code> field is valid on a month by month basis. There is
     * also a leap year check that affects the month of February
     * @param date
     * @return whether given date is valid or not
     * @exception NumberFormatException entered string is not a valid number
     * @exception StringIndexOutOfBoundsException the index was illegal at some point
     *
     *
     * */
    private static void checkDate(String date) throws Date212Exception
    {

        int year = -1, month = -1, day = -1;

        //Check if if string is of proper length yyyymmdd (8 characters)
        String skipMsg = "Not added to the list! Skipped. ";
        String dateMsg = "Date: " + date + " is invalid. ";
        int convertedDate;
        try {
            convertedDate = Integer.parseInt(date);

        } catch (NumberFormatException e) {
            throw new Date212Exception(dateMsg + "Must be numeric. " + skipMsg);
        }


        if (date.length() != 8) {
            throw new Date212Exception(dateMsg + "Must have exactly 8 digits. " + skipMsg);
        }

        try {
            year = Integer.parseInt(date.substring(0, 4));
        } catch (StringIndexOutOfBoundsException e) {
            throw new Date212Exception(dateMsg + "The year " + year + " is incorrect. " + skipMsg);
        }


        try {
            month = Integer.parseInt(date.substring(4, 6));
        } catch (StringIndexOutOfBoundsException e) {
            throw new Date212Exception(dateMsg + "The month " + month + " is incorrect. " + skipMsg);
        }

        try {
            day = Integer.parseInt(date.substring(6, 8));
        } catch (StringIndexOutOfBoundsException e) {
            throw new Date212Exception(dateMsg + "Day " + day + " is incorrect. " + skipMsg);
        }


        //Check if valid month
        if (!(month >= 1 && month <= 12)) {
            throw new Date212Exception(dateMsg + "The month " + month + "not in range [1,12]. " + skipMsg);

        }
        //Check for correct number of days for February(leap year and non-leap year)
        else if (month == 2) {
            if (isLeapYear(year)) {
                if (!(day >= 1 && day <= 29)) {
                    throw new Date212Exception(dateMsg + "Day " + day + " not in range[1,29] due to leap year. " + skipMsg);
                }
            } else {
                if (!(day >= 1 && day <= 28)) {
                    throw new Date212Exception(dateMsg + "Day " + day + " not in range[1,28]. " + skipMsg);
                }
            }
        }

        //Check for the correct number of days for:
        // April, June,September, and November
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (!(day >= 1 && day <= 30)) {
                throw new Date212Exception(dateMsg + "Day " + day + " not in range[1,30]. " + skipMsg);
            }
        }
        else {
            //Check for correct number of days for:
            // January, March, May, July, August, and October
            if (!(day >= 1 && day <= 31)) {
                throw new Date212Exception(dateMsg + "Day " + day + " not in range[1,31]. " + skipMsg);
            }
        }
    }



    /**Determines whether the parameter is a leap year
     * @param year 4 digit integer value
     * @return leap Year?
     * @see <a href = "https://en.wikipedia.org/wiki/Leap_year">Leap Year</a>
     *
     *
     * */
    private static boolean isLeapYear(int year)
    {

        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;


        if (year % 4 == 0)
            return true;
        return false;
    }


    /**
     * This method overrides the existing <code>toString</code> method for objects. Given the integer values of<code>
     *     month</code>, <code>day</code>, and <code>year</code>, the method returns a string of the form mm/dd/yyyy.
     * @return formatted string
     */

    @Override
    public String toString()
    {
        //Convert the integer values of the months back to strings
        String monthStr,dayStr,yearStr;
        String fmonthStr = null,fdayStr = null,fyearStr = null;
        monthStr = Integer.toString(month);
        dayStr = Integer.toString(day);
        yearStr = Integer.toString(year);
        String[] prependString = {"","0","00","000"};
        //Add a zero on the left of the month if it comes before October

        //Month Section
        if(month < 10)
            fmonthStr = prependString[1] + monthStr;
        else
            fmonthStr = prependString[0] + monthStr;

        //Day Section
        if(day < 10 )
            fdayStr = prependString[1] + dayStr;
        else
            fdayStr = prependString[0] + dayStr;

        //Year Section
        if(year >= 1000)
            fyearStr = prependString[0] + yearStr;
        //100-999
        if (year >= 100 && year <= 999 )
            fyearStr = prependString[1] + yearStr;
        //10-99
        if (year >= 10 && year <= 99)
            fyearStr = prependString[2] + yearStr;
        //1-9
        if(year >= 1 && year <= 9)
            fyearStr = prependString[3] + yearStr;
        //Year 0
        if(year ==0)
            fyearStr = "0000";

        return (fmonthStr + "/" + fdayStr + "/" + fyearStr); //format is: mm/dd/yyyy

    }

    /**Returns the month attribute of  Date212 Object
     * @return month*/
    public int getMonth() {
        return month;
    }

    /**Returns the day attribute of  Date212 Object
     *@return day*/
    public int getDay() {
        return day;
    }

    /**Returns the year attribute of  Date212 Object
     * @return year*/
    public int getYear() {
        return year;
    }


    /**This method compares the integer values of the converted strings inputted from the file
     * @param min the date being compare to
     * @return -1 if "this" is a more recent date, 0 if the two dates are the same, and 1 others */
    int compareDates(Object min) {

        if(this.originalDateInt < ((Date212) min).originalDateInt)
            return -1;
        if(this.originalDateInt == ((Date212) min).originalDateInt)
            return 0;
        return 1;
    }


}

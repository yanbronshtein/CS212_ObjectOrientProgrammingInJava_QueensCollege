/**
 * <tt>Date212Exception</tt>
 * The Date212Exception class is creates a custom exception to be raised if date is invalid
 *
 * @author yanivbronshtein
 * @version 1.0
 *
 *
 * */
public class Date212Exception extends IllegalArgumentException {

    /**Constructs a Date212Exception
     * @param msg Error message*/
    public Date212Exception(String msg)
    {
        super(msg);
    }



}



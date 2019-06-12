import java.util.Comparator;
/**
 * <tt>Date212Comparator</tt>
 * The Date212Comparator class implements the comparator for Date212 dates using the compareDates()
 * method previously implemented in the Date212 class. The Comparator will be used for putting
 * dates into the sorted TreeMap of dates.
 *
 * @author yanivbronshtein
 * @version 1.0
 *
 *
 * */
public class Date212Comparator implements Comparator<Date212> {
    public int compare(Date212 date1, Date212 date2) {
        return date1.compareDates(date2);
    }

}

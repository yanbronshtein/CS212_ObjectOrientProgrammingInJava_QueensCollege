
import java.util.TreeMap;

/**
 * <tt>Project4</tt>
 * The Project4 Class contains setter and getter methods for the unsorted linked list used to store all valid dates as
 * read in from the file or added by the user and the sortedMap, a TreeMap with Date212 objects as the keys and
 * Integer objects for the running tally's.
 *
 * @author yanivbronshtein
 * @version 1.0
 *
 *
 * */
public class Project4
{
    /**GUI object to create file Selection menu */
    private static DateGUI fileGUI;
    /**Unsorted LinkedLists of dates */
    private static UnsortedDate212List unsorted = new UnsortedDate212List();
    /**Sorted TreeMap of dates */
    private static TreeMap<Date212,Integer> sortedMap = new TreeMap<>(new Date212Comparator());


    /** Main method */
    public static void main(String[] args)
    {

        fileGUI = new DateGUI();

    }

    /**Getter method for unsorted linkedList of dates
     * @return unsorted list of dates */
    public static UnsortedDate212List getUnsorted()
    {
        return unsorted;
    }

    /**Getter method for sorted Tree Map
     * @return TreeMap of sorted Date212 dates */
    public static TreeMap<Date212, Integer> getSortedMap()
    {
        return sortedMap;
    }

    /**Setter method for unsorted linkedlist of dates
     * @param unsorted LinkedList of dates*/
    public static void setUnsorted(UnsortedDate212List unsorted)
    {
        Project4.unsorted = unsorted;
    }

    /**Setter method for sorted Tree Map of dates
     * @param sortedMap tree map of dates */
    public static void setSortedMap(TreeMap<Date212, Integer> sortedMap)
    {
        Project4.sortedMap = sortedMap;
    }
}



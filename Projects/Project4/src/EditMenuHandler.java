
import javax.swing.*;
import java.awt.event.*;
import java.util.TreeMap;
/**
 * <tt>EditMenuHandler</tt>
 *
 * @author yanivbronshtein
 * @version 1.0
 *This class handles the tasks of opening a file, readings dates from that file and
 * storing those dates in a Date212List and a TreeMap. This class implements the ActionListener
 * interface and therefore contains an actionPerformed() method
 *
 * */
public class EditMenuHandler implements ActionListener {
    /**Original JFrame passed from DateGUI */
    JFrame jframe;
    /**New date manually inputted by user */
    String inputDate;


    /**Constructs EditMenuHandler and instantiate jframe to passed frame*/
    public EditMenuHandler (JFrame jf)
    {
        jframe = jf;
    }

    /**This method implements the actionPerformed() for the EditMenuHandler. If the Insert Option is selected,
     * an input dialog pops up for the user to enter a date. UpdateLists() is called to update the data based on the
     * user input. A new Date212GUI is created to display the dates
     * @param event user event*/
    public void actionPerformed(ActionEvent event)
    {
        UnsortedDate212List unsorted = Project4.getUnsorted();
        TreeMap<Date212,Integer> sortedMap = Project4.getSortedMap();
        String menuName = event.getActionCommand();
        if (menuName.equals("Insert")) {
            while(true) {
                inputDate = JOptionPane.showInputDialog("Please enter a date in format:YYYYMMDD. If you are tired type the word DONE");
                if(inputDate.equalsIgnoreCase("done"))
                    break;
                updateLists(unsorted, sortedMap, inputDate);
            }
            DateGUI gui = new DateGUI(unsorted,sortedMap);
            gui.displayDates();
        }

    }
    /**This method updates the unsortedDate212List and sortedMap tree Map with the the inputDate String
     * The method is used by both the EditMenuHandler and FileMenuHandler classes. Every date read in is automatically
     * added provided that it did not trigger a Date212Exception. Since a TreeMap can only have unique entries,
     * the key is always the Date212 object to be sorted according the compareDates() method in the Date212Comparator.
     * The value is used to keep a running tally of the number of occurences of that date in the TreeMap. If the date
     * is already in the map, the count is incremented, or a default value of 1 is added. The setter methods in Project4
     * are then called to update the unsorted list and sorted map.
     * @param unsorted UnsortedDate212List LinkedList to hold store dates as read in from the file
     * @param sortedMap TreeMap of sorted dates
     * @param inputDate date entry to be added to unsorted and sortedMap*/
    static void updateLists(UnsortedDate212List unsorted, TreeMap<Date212, Integer> sortedMap, String inputDate)
    {
        Date212 tentativeDateObj;
        try {
            tentativeDateObj = new Date212(inputDate);

            unsorted.add(tentativeDateObj);
            if(sortedMap.containsKey(tentativeDateObj)) {
                sortedMap.put(tentativeDateObj, sortedMap.get(tentativeDateObj) + 1);
            }
            else{
                sortedMap.put(tentativeDateObj,1);
            }
        } catch (Date212Exception e) {
            System.out.println(e.getMessage());
        }
        Project4.setUnsorted(unsorted);
        Project4.setSortedMap(sortedMap);

    }
}
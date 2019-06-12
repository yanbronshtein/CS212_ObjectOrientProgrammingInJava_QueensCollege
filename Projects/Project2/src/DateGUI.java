import javax.swing.*;
import java.awt.*;

/**
 * <tt>DateGUI</tt>
 * The DateGUI class is for displaying formatted dates in a GridLayout GUI with 1 row and two columns.
 * The left column shows the list of unsorted but properly formatted dates.
 * The right column shows the list of both formatted and sorted dates
 *
 * @author yanivbronshtein
 * @version 1.0
 *
 *
 * */


class DateGUI
{

    /**The GUI frame */
    private static JFrame myFrame;

    /**Text area for unsorted dates */
    private JTextArea lhsTextArea;
    /**Text area for sorted dates */
    private JTextArea rhsTextArea;
    /**Date212List of unsorted dates for display */
    private UnsortedDate212List unsorted;
    /**Date212List of sorted dates for display */
    private SortedDate212List sorted;

    /**Constructs a DateGUI object given two Date212Lists
     * @param unsorted UnsortedDate212List to be displayed
     * @param sorted SortedDate212List to be displayed*/
    public DateGUI(UnsortedDate212List unsorted,SortedDate212List sorted)
    {
        this.unsorted = unsorted;
        this.sorted = sorted;
    }



    /** Displays dates using Java Swing */
    public void display()
    {
        myFrame = new JFrame("Dates");
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout());
        myFrame.setSize(400,400);
        myFrame.setLocation(100,100);
        Container myContentPane = myFrame.getContentPane();
        lhsTextArea = new JTextArea();
        rhsTextArea = new JTextArea();

        myContentPane.add(lhsTextArea);
        myContentPane.add(rhsTextArea);

        lhsTextArea.setText("Unsorted List:\n" + unsorted.generateDisplayString());
        rhsTextArea.setText("Sorted List:\n" + sorted.generateDisplayString());


        myFrame.setVisible(true);
    }
}

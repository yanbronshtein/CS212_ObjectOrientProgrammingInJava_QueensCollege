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


import javax.swing.*;
import java.awt.*;

public class DateGUI
{

    /**The GUI frame */
    private static JFrame myFrame;

    /**Text area for unsorted dates */
    private JTextArea lhsTextArea;
    /**Text area for sorted dates */
    private JTextArea rhsTextArea;
    /**Array of unsorted dates for display */
    private String[] unsortedDatesAsStrings;
    /**Array of sorted dates for display */
    private String[] sortedDatesAsStrings;

    /**Constructs a DateGUI object given two string arrays*/
    public DateGUI(String[] unsortedDatesAsStrings,String[] sortedDatesAsStrings)
    {
        this.unsortedDatesAsStrings = unsortedDatesAsStrings;
        this.sortedDatesAsStrings = sortedDatesAsStrings;
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
        lhsTextArea.append("Unsorted List:\n");
        rhsTextArea.append("Sorted List:\n");

        for (int i=0;i<unsortedDatesAsStrings.length;i++) {
            lhsTextArea.append(unsortedDatesAsStrings[i] + "\n");

            rhsTextArea.append(sortedDatesAsStrings[i] + "\n");
        }
        myFrame.setVisible(true);
    }
}

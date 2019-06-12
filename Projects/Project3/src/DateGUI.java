import javax.swing.*;
import java.awt.*;

/**
 * <tt>DateGUI</tt>
 * The DateGUI class is for displaying formatted dates in a GridLayout GUI with 1 row and two columns AND for displaying
 * the file choosing menu.
 *
 * @author yanivbronshtein
 * @version 2.0
 *
 *
 * */


class DateGUI extends JFrame
{
    /**Unsorted date List to be displayed */
    private UnsortedDate212List unsorted;
    /**Sorted date List to be displayed */
    private SortedDate212List sorted;
    /**The GUI frame */
    private static JFrame myFrame;
    /*Text area for unsorted dates */ /**Text area for unsorted dates */
    private static JTextArea lhsTextArea;
    /*Text area for sorted dates */ /**Text area for sorted dates */
    private static JTextArea rhsTextArea;


    /**Constructs a File Menu to pick a text file full of dates */
    public DateGUI()
    {
        setTitle("Bruh Pick a File. Hint.Hint: It's called \"date.txt\"");
        setSize(400,400);
        setLocation  (400,200);
        createFileMenu();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**Constructor to display unsorted and sorted dates
     * @param unsorted dateList of unsorted dates
     * @param sorted dateList of sorted dates*/
    public DateGUI(UnsortedDate212List unsorted, SortedDate212List sorted)
    {
        this.unsorted = unsorted;
        this.sorted = sorted;
    }


    /** Displays dates using Java Swing */
    public void displayDates()
    {

        myFrame = new JFrame("Dates");
        lhsTextArea = new JTextArea();
        rhsTextArea = new JTextArea();
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout());
        myFrame.setSize(400,400);
        myFrame.setLocation(100,100);
        Container myContentPane = myFrame.getContentPane();



        myContentPane.add(lhsTextArea);
        myContentPane.add(rhsTextArea);

        lhsTextArea.setText("Unsorted List:\n" + unsorted.generateDisplayString());
        rhsTextArea.setText("Sorted List:\n" + sorted.generateDisplayString());


        myFrame.setVisible(true);
    }

    /**Creates a file menu */
    public void createFileMenu( ) {
        JMenuItem   item;
        JMenuBar    menuBar  = new JMenuBar();
        JMenu       fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this);

        item = new JMenuItem("Open");    //Open...
        item.addActionListener(fmh);
        fileMenu.add(item);

        fileMenu.addSeparator();           //add a horizontal separator line

        item = new JMenuItem("Quit");       //Quit
        item.addActionListener(fmh);
        fileMenu.add(item);

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);



    }


}

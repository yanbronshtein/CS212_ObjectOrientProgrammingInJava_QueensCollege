import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;


/**
 * <tt>DateGUI</tt>
 * The DateGUI class is for displaying formatted dates in a GridLayout GUI with 1 row and two columns AND for displaying
 * the file choosing menu.
 *
 * @author yanivbronshtein
 * @version 3.0
 *
 *
 * */


class DateGUI extends JFrame
{
    /**Unsorted date List to be displayed */
    private UnsortedDate212List unsorted;
    /**Sorted date tree map to be displayed */
    TreeMap<Date212, Integer> sortedMap;
    /**The GUI frame */
    private static JFrame myFrame;
    /*Text area for unsorted dates */ /**Text area for unsorted dates */
    private static JTextArea lhsTextArea;
    /*Text area for sorted dates */ /**Text area for sorted dates */
    private static JTextArea rhsTextArea;


    /**Constructor to create a File Menu to pick a text file full of dates */
    public DateGUI()
    {
        setTitle("Bruh Pick a File. Hint.Hint: It's called \"date.txt\"");
        setSize(400,400);
        setLocation  (400,200);
        createFileAndEditMenu();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**Constructor to display unsorted and sorted dates
     * @param unsorted dateList of unsorted dates
     * @param sortedMap dateList of sorted dates*/
    public DateGUI(UnsortedDate212List unsorted, TreeMap<Date212,Integer> sortedMap)
    {
        this.unsorted = unsorted;
        this.sortedMap = sortedMap;
    }


    /** Displays dates */
    public void displayDates()
    {
        /*Creates window for dates */
        myFrame = new JFrame("Dates");
        lhsTextArea = new JTextArea();
        rhsTextArea = new JTextArea();
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setLayout(new GridLayout());
        myFrame.setSize(400,400);
        myFrame.setLocation(100,100);
        Container myContentPane = myFrame.getContentPane();

        /*Add text areas for displaying unsorted and sorted dates */
        myContentPane.add(lhsTextArea);
        myContentPane.add(rhsTextArea);

        /*Call generateDisplayString() to print contents of unsortedDate212List to left text area */
        lhsTextArea.setText("Unsorted List:\n" + unsorted.generateDisplayString());
        /*Extract the key (Date212 object) and the value(occur */
        rhsTextArea.setText("Sorted List:\n");
        for(Map.Entry<Date212,Integer> me : sortedMap.entrySet()){
            rhsTextArea.append(me.getKey().toString() +"\toccurrences: " + me.getValue()+  "\n");
        }


        myFrame.setVisible(true);
    }

    /**Creates GUI for choosing a file */
    public void createFileAndEditMenu( )
    {
        JMenuItem   item; //Object used for adding options to both the file menu and edit menu
        JMenuBar    menuBar  = new JMenuBar(); //contains options of both the file menu and edit menu
        JMenu       fileMenu = new JMenu("File"); //Menu for File Menu
        JMenu       editMenu = new JMenu("Edit"); //Menu for Edit Menu


        /*Create file and edit menu handlers */
        FileMenuHandler fmh = new FileMenuHandler(this);
        EditMenuHandler emh = new EditMenuHandler(this);

        /*Create Open Option for File Menu Handler*/
        item = new JMenuItem("Open");
        item.addActionListener(fmh);
        fileMenu.add(item);

        /*Add horizontal separator line */
        fileMenu.addSeparator();

        /*Create Quit Option for File Menu */
        item = new JMenuItem("Quit");
        item.addActionListener(fmh);
        fileMenu.add(item);

        /*Create Insert Option for Edit Menu*/
        item = new JMenuItem("Insert"); //Insert Option
        item.addActionListener(emh);
        editMenu.add(item);


        /*Create Menu */
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);



    }


}

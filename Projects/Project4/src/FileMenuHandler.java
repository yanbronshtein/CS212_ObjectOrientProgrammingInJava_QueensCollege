import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * <tt>FileMenuHandler</tt>
 *
 * @author yanivbronshtein
 * @version 2.0
 *This class handles the tasks of opening a file, readings dates from that file and
 * storing those dates in a Date212List and a TreeMap. This class implements the ActionListener
 * interface and therefore contains an actionPerformed() method
 *
 * */


public class FileMenuHandler implements ActionListener {
    private static JFrame jframe;


    /**Constructs a File Menu Handler and instantiates jframe with the one passed in
     * @param jf Original JFrame */
    public FileMenuHandler (JFrame jf)
    {
        jframe = jf;
    }

    /**This method implements the actionPerformed() method described in the ActionListener interface
     * The method checks if the Open Quit option was selected by the user.
     * If the Open option was selected, the openFile() method is called. Otherwise an OptionDialog pops up
     * and the decide() method is called to process the user response to the OptionDialog
     * @param event user event */
    public void actionPerformed(ActionEvent event)
    {
        String  menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Open"))
            openFile( );
        if (menuName.equals("Quit")) {
            Object[] options = {
                    "Yes, fuck off",
                    "Hmm...I'll give you a second chance",
            };
            int choice = JOptionPane.showOptionDialog(jframe,"No! Don't leave me for Java FX! " +
                            "I promise. I won't be crap. Are you sure you want to leave?",
                    "Message",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]);
            decide(choice);


        }
    }
    /**This method creates a File Chooser to allow the user to select a file to read dates
     * from on their native platform. If the user successfully selects a file and hits "ok"
     * then the readSource() is called. Otherwise, an OptionDialog pops up and the decide() method is called to respond
     * to the user response*/
    private void openFile( )
    {
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser( );
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION)
            readSource(chooser.getSelectedFile());
        else {
            Object[] options = {
                    "Because this app sucks. I want to EXIT",
                    "Oops let me try finding that file again ",

            };
            int choice = JOptionPane.showOptionDialog(jframe,"Why didn't you pick a file? Are you trying to quit?",
                    "Message",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[1]);
            decide(choice);
        }

    }
    /**This method processes the user response to OptionDialogs. If the user hit "YES" or "X", the program terminates.
     * If the user hits "No", then no action is taken
     * @param choice Integer value generated from user response to OptionDialog*/
    private void decide(int choice) {
        switch(choice)
        {
            case JOptionPane.YES_OPTION:
                System.exit(0);

                break;
            case JOptionPane.NO_OPTION:

                break;
            case JOptionPane.CLOSED_OPTION:
                System.exit(0);
                break;
        }
    }


    /** Reads dates from a text file using a buffered reader. For each date, the method performs a validity check
     * To account for extra "invisible characters" such as new lines, tabs, and spaces inadvertently introduced by the
     * user, method trims the inputDate lines. Only valid dates as determined by the checkDate() method inside the Date212
     * class are added to the the unsorted Date212List and sorted TreeMap that are retrieved from the Project4 class.
     * Otherwise, an exception is silently thrown and printed in the console along with the invalid date. For each date
     * read in from the file the updateLists() method stored in the EditMenuHandler class is called to refresh the
     * information to be displayed in the GUI
     * @param chosenFile the name of the text file located in the current directory
     * */
    private static void readSource(File chosenFile)
    {

        try (
                BufferedReader input = new BufferedReader(new FileReader(chosenFile))) {


            StringTokenizer myTokens;
            String line, delimiter = ",";

            /*Call the getter methods in Project4 class to retrieve the unsortedDate212List and sortedMap TreeMap  */
            UnsortedDate212List unsorted = Project4.getUnsorted();
            TreeMap<Date212, Integer> sortedMap = Project4.getSortedMap();


            while ((line = input.readLine()) != null) { //Read from file line by line until reached EOF
                myTokens = new StringTokenizer(line.trim(), delimiter); //Tokenize the line by commas

                while (myTokens.hasMoreTokens()) {
                    String tentativeDate = (myTokens.nextToken()).trim();
                    EditMenuHandler.updateLists(unsorted, sortedMap, tentativeDate);
                }

            }
            DateGUI gui = new DateGUI(unsorted, sortedMap);
            gui.displayDates();

        }catch (IOException e){
            throw new Date212Exception("Cannot open the file "+chosenFile.getName() +" for reading dates");
        }


    }


}

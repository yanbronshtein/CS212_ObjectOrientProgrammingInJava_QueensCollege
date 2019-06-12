import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;


public class FileMenuHandler implements ActionListener {
    private static JFrame jframe;
    private static TextFileInput myFile;



    public FileMenuHandler (JFrame jf) {
        jframe = jf;
    }
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

    private void decide(int choice) {
        switch(choice)
        {
            case JOptionPane.YES_OPTION:
                System.exit(0);

                break;
            case JOptionPane.NO_OPTION:

                break;
            case JOptionPane.CLOSED_OPTION:
                //User pressed 'X' button on the options dialog.If you want to exit app here.
                System.exit(0);
                break;
        }
    }


    /** Reads dates from a text file using TextFileInput class. For each date, the method performs a validity check
     * To account for extra "invisible characters" such as new lines, tabs, and spaces inadvertently introduced by the
     * user, method trims the input lines. Only valid dates as determined by the checkDate() method inside the Date212
     * class are added to the the unsorted and sorted linked lists. Otherwise, an exception is silently thrown and
     * printed in the console
     * @param chosenFile the name of the text file located in the current directory
     * */
    private static void readSource(File chosenFile)
    {
        //Verify that the file can be opened for reading
        String chosenFileName = chosenFile.getName();
        myFile = new TextFileInput(chosenFileName); //Open file for reading



        StringTokenizer myTokens;
        String line, delimiter = ",";

         UnsortedDate212List unsorted = new UnsortedDate212List();
        SortedDate212List sorted = new SortedDate212List();


        while ( (line = myFile.readLine() ) != null) { //Read from file line by line until reached EOF
            myTokens = new StringTokenizer(line.trim(), delimiter); //Tokenize the line by commas

            while (myTokens.hasMoreTokens()) {
                String tentativeDate = (myTokens.nextToken()).trim();
                Date212 tentativeDateObj;
                try {
                    tentativeDateObj = new Date212(tentativeDate);
                        unsorted.add(tentativeDateObj);
                        sorted.add(tentativeDateObj);
                } catch (Date212Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        myFile.close(); //Close file
        //Display unsorted and sorted dates using second constructor of
        // DateGUI class
        DateGUI gui = new DateGUI(unsorted,sorted);
        gui.displayDates();

    }
}

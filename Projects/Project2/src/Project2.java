import java.util.StringTokenizer;
/**
 * <tt>Project2</tt>
 * The Project2 Class for reading dates from a text file, and displaying them in both unsorted and and sorted order in
 * a Date212GUI
 *
 * @author yanivbronshtein
 * @version 1.0
 *
  *
 * */
public class Project2
{
    /** The name of the text file to read from*/
    private static String fileName = "dates.txt";
    /** GUI object to display dates*/
    private static DateGUI gui;
    /**Text File Input  */
    private static TextFileInput myFile;
    /**Linked List for unsorted dates */
    private static UnsortedDate212List unsorted;
    /**Linked List for sorted dates */
    private static SortedDate212List sorted;

    /** Main method */
    public static void main(String[] args)
    {
        //Retrieve data from file
        readFromFile(fileName);
        DateGUI gui = new DateGUI(unsorted,sorted);
        gui.display();
    }





    //This method reads dates from a text file and tokenizes them by the delimiters: newline and comma
    /** Reads dates from a text file using TextFileInput class. For each date, the method performs a validity check
     * To account for extra "invisible characters" such as new lines, tabs, and spaces inadvertently introduced by the
     * user, method trims the input lines. Only valid dates as determined by the isValidDate method inside the Date212
     * class are added to the the unsorted and sorted linked lists
     * @param fileName the name of the text file located in the current directory
     * @throws RuntimeException
     * @throws java.io.FileNotFoundException
     *
     * */

    private static void readFromFile(String fileName)
    {
        //Verify that the file can be opened for reading

        try {
            myFile = new TextFileInput(fileName); //Open file for reading
        }catch(RuntimeException e){

            throw new RuntimeException("Cannot open " + fileName + " for reading\n");
        }


        StringTokenizer myTokens;
        String line, delimiter = ",";

        unsorted = new UnsortedDate212List();
        sorted = new SortedDate212List();


        while ( (line = myFile.readLine() ) != null) { //Read from file line by line until reached EOF
            myTokens = new StringTokenizer(line.trim(), delimiter); //Tokenize the line by commas

            while (myTokens.hasMoreTokens()) {
                String tentativeDate = (myTokens.nextToken()).trim();
                Date212 tentativeDateObj = new Date212(tentativeDate);

                //Skip invalid dates. Simultaneously add dates to unsorted and sorted linkedLists
                if(tentativeDateObj.valid) {
                    unsorted.add(tentativeDateObj);
                    sorted.add(tentativeDateObj);
                }
            }
        }

        myFile.close(); //Close file

    }

}

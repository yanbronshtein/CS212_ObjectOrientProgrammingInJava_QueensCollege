
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * <tt>Project1</tt>
 * The Project1 Class for reading dates from a text file, reformatting and sorting them, and then displaying them
 * in a gui
 * along with the unsorted dates.
 *
 * @author yanivbronshtein
 * @version 1.0
 *
 *
 * */
public class Project1
{
    /** The name of the text file to read from*/
    private static String fileName = "dates.txt";
    /** GUI object to display dates*/
    private static DateGUI gui;
    /**Text File Input  */
    private static TextFileInput myFile;

    /** Main method */
    public static void main(String[] args)
    {
        //Retrieve data from file
        ArrayList<String> dateList = readFromFile(fileName);
        int numDates = dateList.size();
        int[] unsorted = new int[numDates];

        for (int i = 0; i < numDates ; i++) {
            unsorted[i] = Integer.parseInt(dateList.get(i));
        }

        int[] unsortedClone = unsorted.clone();
        //Sort array of valid dates
        int[] sorted = selectionSort(unsortedClone);



        //Format strings and display on GUI
        String[] unsortedDatesAsStrings,sortedDatesAsStrings;
        unsortedDatesAsStrings = formatDates(unsorted);
        sortedDatesAsStrings = formatDates(sorted);
        gui = new DateGUI(unsortedDatesAsStrings,sortedDatesAsStrings);
        gui.display();


    }


    /** Returns a properly formatted string array of dates by creating a Date212 object that
     * correctly formats the date.
     * @param arr the array of dates converted to integers
     * @return a string array of the formatted dates*/
    private static String[] formatDates(int[] arr)
    {
        int size = arr.length;
        String[] formattedDates = new String[size];
        for (int i = 0; i < size ; i++) {
            String rawDate = Integer.toString(arr[i]);
            formattedDates[i] = new Date212(rawDate).toString();
        }
        return formattedDates;
    }


    //This method reads dates from a text file and tokenizes them by the delimiters: newline and comma
    /** Reads dates from a text file using TextFileInput class. For each date, the method performs a validity check
     * To account for extra "invisible characters" such as new lines, tabs, and spaces inadvertently introduced by the
     * user, method trims the input lines. Only valid dates as determined by the isValidDate method inside the Date212
     * class are added to the array list.
     * @param fileName the name of the text file located in the current directory
     * @return array list of strings of filtered dates.
     * @throws RuntimeException
     * @throws java.io.FileNotFoundException
     *
     * */

    private static ArrayList<String> readFromFile(String fileName)
    {

        //Verify that the file can be opened for reading
        try {
            myFile = new TextFileInput(fileName); //Open file for reading
        }catch(RuntimeException e){

            throw new RuntimeException("Cannot open " + fileName + " for reading\n");
        }


        StringTokenizer myTokens;
        String line, delimiter = ",";
        ArrayList<String> myList = new ArrayList<>();

        while ( (line = myFile.readLine() ) != null) { //Read from file line by line until reached EOF
            myTokens = new StringTokenizer(line.trim(), delimiter); //Tokenize the line by commas

            while (myTokens.hasMoreTokens()) {
                String tentativeDate = (myTokens.nextToken()).trim();
                Date212 tentativeDateObj = new Date212(tentativeDate);

                //Skip invalid dates
                if(tentativeDateObj.valid)
                    myList.add(tentativeDate); //Add the tokens (individual dates) from each line to array list
            }
        }

        myFile.close(); //Close file

        return myList;
    }


    /**Returns a sorted array of integers using the Selection Sort Algorithm.
     * @param arr unsorted array of integers
     * @return sorted list of integers
     * @see <a href = "https://en.wikipedia.org/wiki/Selection_sort">SelectionSort</a>
     *  */
    private static int[] selectionSort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


}

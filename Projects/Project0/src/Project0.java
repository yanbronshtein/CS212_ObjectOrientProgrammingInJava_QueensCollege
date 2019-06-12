//Created by Yaniv Bronshtein
//Lab Section CSCI 212-11
/**
Write a Java program that will
        1. Ask the user to type in a sentence, using a JOptionPane.showInputDialog().
        2. The program will examine each letter in the string and count how many times the upper-case
        letter 'E' appears, and how many times the lower-case letter 'e' appears. The key here is to use
        the charAt method in class String.
        3. Using a JOptionPane.showMessageDialog(), tell the user how many upper and lower case e's
        were in the string.
        4. Repeat this process until the user types the word "Stop". (Check out the method
        equalsIgnoreCase in class String to cover all upper/lower case possibilities of the word
        "STOP").

        **/




import javax.swing.*;
public class Project0 {


    public static void main(String[] args) {
        String inputString;
        while(true) {

            inputString = JOptionPane.showInputDialog("Please enter an input string and click OK. " +
                    "\nYou may stop the program at any time in any one of the following ways:\n" +
                    "1.Type STOP and click ok" + "\n" + "2. Click Cancel" + "\n" + "3. Click the x to exit from the application");
            if (inputString.equalsIgnoreCase("STOP") )  {
                System.exit(0);
            }


            //Parse the string and increment the respective counters
            int numLowerCaseE = 0, numUpperCaseE = 0;
            for (int i = 0; i < inputString.length() ; i++) {
                if(inputString.charAt(i) == 'e') ++numLowerCaseE;
                if(inputString.charAt(i) == 'E') ++numUpperCaseE;
            }
            JOptionPane.showMessageDialog(null,"Number of lower case e's:\t" +
                    numLowerCaseE +" \nNumber of upper case e's\t" + numUpperCaseE
                 + "\n The original string entered was:\n" + inputString);
        }
    }


}

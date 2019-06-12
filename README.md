
CS 212: Object Oriented Programming at Queens College
===

# Table of Contents
1. [Project 0: Polynomial Arithmetic](#Project-0)
2. [Project 1: Use array/arrayList to store dates](#Project-1)
3. [Project 2: Emergency Room](#Project-2)
4. [Project 3: Add exception functionality](#Project-3)
5. [Project 4: Add TreeMap functionality](#Project-4)



## Project 0: Polynomial Arithmetic <a name="Project-0"></a>
### Program Description:
This project is intended for you to use programming concepts you learned in CSCI 111 (decision statements, loop statements) and apply them in a simple Java program (using some of the classes covered in lecture and lab). In addition, you will submit the project through Blackboard to make sure it is clear how to do that.
We will look at your coding style, documentation (comments) and, of course, that the project works. Check out the grading scheme in the Projects folder in Blackboard.

### Program Requirements:
Write a Java program that will
1. Ask the user to type in a sentence, using a JOptionPane.showInputDialog().
2. The program will examine each letter in the string and count how many time the upper-case
letter 'E' appears, and how many times the lower-case letter 'e' appears. The key here is to use
the charAt method in class String.
3. Using a JOptionPane.showMessageDialog(), tell the user how many upper and lower case e's
were in the string.
4. Repeat this process until the user types the word "Stop". (Check out the method
equalsIgnoreCase in class String to cover all upper/lower case possibilities of the word "STOP").


## Project 1: Use array/arrayList to store dates <a name="Project-1"></a>
### Sorting an Array of Dates/ Displaying in a GUI/Creating a Class
Given an input file of dates represented as Strings, read the dates from the file and display them in a GUI. 
The dates will be in the form yyyymmdd (such as 20181001 for October 1, 2018). 
The GUI should have a GridLayout with one row and two columns. 
The left column should display the dates in the order read from the file, and the right column should display the dates in sorted order (using Selection Sort).
Create a class called Date212 to represent a date. It will store the year, month and day as integers (not as a String), so you will need three private instance variables. 
A constructor should be provided that takes a String (representing the date as above). Use the substring method of class String to pull out the month, day and year, 
and parse them as integers. Include a private validity checking method that should make sure that the month and day values are legal. 
If it is not a valid date, print it to the console and do not put it in the array of dates. 
Create a toString method in class Date212 the will return the date in the form mm/dd/yyyy. 
Use this method to display the dates in the GUI.
Use two arrays containing Date212 objects, one containing valid dates in the order read from the file, the other read in and then sorted using Selection Sort.
### The input file
Each line of the input file may contain several dates separated by commas. You will need to use a StringTokenizer to separate out the individual dates. So, an example of the input file would be:
20141001
20080912,20131120,19980927
20020202
20120104
## Project 2: Implement Custom LinkedList to store dates <a name="Project-2"></a>
### List of Dates

Create a class called Date212Node which has fields for the data (a Date212) and next (Date212Node) instance variables. 
Include a one-argument constructor which takes a Date212 as a parameter. (For hints, see the PowerPoint on "Static vs. Dynamic Structures”.)
#### public Date212Node (Date212 d) {  . . }

The instance variables should have protected access. 
There will not be any get and set methods for the two instance variables.
Create an abstract linked list class called Date212List. 
This should be a linked list with head node as described in lecture. 
Modify it so that the data type in the nodes is Date212. 
The no-argument constructor should create an empty list with first and last pointing to an empty head 
node, and length equal to zero. Include an append method in this class.
Create two more linked list classes that extend the abstract class Date212List: One called 
UnsortedDate212List and one called SortedDate212List, each with appropriate no-argument 
constructors. Each of these classes should have a method called add(Date212) that will add a new node 
to the list. In the case of the UnsortedDate212List it will add it to the end of the list by calling the append 
method in the super class. In the case of the SortedDate212List it will insert the node in the proper 
position to keep the list sorted.
Instantiate two linked lists, and for every date read from the file, add it to the unsorted and sorted lists 
using the add method. You will end up with the first list having the dates from the input file in the order 
they were read, and in the second list the dates will be in sorted order. Display the unsorted and sorted 
dates in the GUI just as in project 1.


## Project 3: Add exception functionality <a name="Project-3"></a>

### Create a File Menu in your GUI
Add a file menu to your DateGUI with options to open a file for reading, and one to Quit the program.

### Create an new Exception for Dates
Create a new Exception called Date212Exception. 
The constructor of Date212 should throw this exception if an invalid date is read from the file. 
If this exception is thrown, the invalid date and the message from the exception should be printed to the 
console. You will need a FileMenuHandler class to handle the events from the FileMenu.
## Project 4: Emergency Room <a name="Project-4"></a>

### Create an Edit Menu in your GUI
Add a second menu to the GUI called Edit which will have one menu item called Insert. 
Clicking on insert should prompt the user using a JOptionPane input dialog to enter a new date in 
the same format as is read from the input file. 
The new date, if valid, should be displayed in the unsorted and sorted text areas of the GUI. 
If the date is invalid it should be printed to the console. 
You will need to write a second menu handler called EditMenuHandler.
### Use a Tree Map to sort the Dates
Instead of using a SortedLinkedList to sort the dates, use a TreeMap. 
Display the sorted dates as usual in the right text area of the GUI.










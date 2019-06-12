/**
 * <tt>Date212List</tt>
 * The abstract Date212List class is implements certain methods common to a LinkedList class in java
 * for storing Date212 dates
 *
 * @author yanivbronshtein
 * @version 2.0
 *
 *
 * */
public abstract class Date212List {

    /**Pointer to dummy node of Date212List */
    private Date212Node first;
    /**Pointer to last node of Date212List */
    private Date212Node last;
    /**length of Date212 list excluding dummy node */
    private int length;
    /**Pointer to first element of Date212 list. Not dummy node */
    private Date212Node head;



    /**Sets length of Date212List
     * @param length integer length of linkedList */
    public void setLength(int length) {
        this.length = length;
    }

    /** @return length of Date212List*/
    public int getLength()
    {
        return this.length;
    }
    /** @return pointer to dummy node of Date212List*/
    public Date212Node getFirst()
    {
        return this.first;
    }
    /** @return pointer to last node of Date212List*/
    public Date212Node getLast()
    {
        return this.last;
    }

    /**Constructs a Date212List. Creates an empty list, sets first and last pointer to point to the list
     * Sets length of the list to 0
     * */
    public Date212List()
    {
        head = new Date212Node(null);
        first = head;
        last = head;
        this.length = 0;
    }

    /**Adds date to tail of Date212List. If the list is empty, the method sets the next pointer of first to the start
     * of the newNode and the last pointer to newNode. Otherwise, the method sets both the last and next pointer of last
     * to newNode. In both cases the next pointer of newNode is set to null and the length is incremented
     * @param data Date212 object */
    void append(Date212 data) {
        Date212Node newNode = new Date212Node(data);
        if (first.next == null) {
            first.next = newNode;
            last.next = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        newNode.next = null;
        this.length++;
    }


    /**Checks if Date212list is empty by checking next pointer of first
     * @return check if next pointer is null*/
    public boolean isEmpty(){
        return (first.next == null);
    }



    /**Method checks if two Date212Lists are equal and overrides equals() method for objects built into Java.
     *
     * @param other Generic Object */
    @Override
    public boolean equals(Object other) {
        //Check if passed list is null or the class names are different or the length of two lists are different
        if (other == null || getClass() != other.getClass() || this.length != ((Date212List) other).length)
            return false;

        Date212Node nodeThis = this.first;
        Date212Node nodeOther = ((Date212List) other).first;
        //Iterate through each list comparing the data variable inside each node */
        while (nodeThis != null) {
            // Since the two linked lists are the same length,
            // they should reach null on the same iteration.

            if (nodeThis.data != nodeOther.data)
                return false;

            nodeThis = nodeThis.next;
            nodeOther = nodeOther.next;
        }

        return true;
    }

    /**Method removes first element if Date212List by shifting head pointer
     * @return temp first node in list removed */
    Date212Node deleteFirst()
    {
        Date212Node temp = head ;
        head = head.next;
        return temp;
    }

    /**Method removes last element if Date212List by iterating through the list until the last element is reached
     * and remove the link to the last node
     * @return temp last node in list removed */
    Date212Node deleteLast ()
    {
        Date212Node current = head;

        while(current.next.next != null){
            current = current.next;
        }

        Date212Node temp = current.next;
        current.next = null;

        return temp;
    }

    /**Returns Date212Node pointer to the date passed by iterating through Date212List until reached the end of the list
     * or the node corresponding to the date has been found as determined by the equals() method
     * @param date Date212 being looked for
     * @return p Pointer to node corresponding to respective date*/
    public Date212Node find (Date212 date) {
        Date212Node p = first.next;
        while (p != null && !(p.data).equals(date)) {
            p = p.next;
        }
        return p;
    }




    /**Generates string to be displayed in GUI by extracting and formatting the dates in  a Date212List
     * @return printString */
    String generateDisplayString()
    {
        Date212Node temp = first.next;
        StringBuilder printString = new StringBuilder();
        while(temp != null){
            printString.append(temp.data.toString()).append("\n");
            temp = temp.next;
        }
        return printString.toString();

    }
    /**Abstract method to add nodes a Date212List */
    abstract void add(Date212 date);




}

/**
 * <tt>SortedDate212List</tt>
 * The SortedDate212List Class extends the Date212List class and implements the add() method outlined there
 *
 * @author yanivbronshtein
 * @version 1.0
 *
 *
 * */
class SortedDate212List extends Date212List {

    /**Constructs a SortedDate212List by invoking the constructor of the Date212List class */
    public SortedDate212List()
    {
        super();
    }

    /**This method adds a Date212Node to a SortedDate212List by iterating through the list, keeping track
     * of the current node and the node immediately preceding until the end of the list
     * is reached or the current date comes earlier than a date already in the list.
     * Then, the next pointer of the newNode is set to the next pointer of the previous node and the former is set
     * to the newNode. The length of the list is updated
     * @param data date to be inserted into the list*/
    void add(Date212 data)
    {

        Date212Node newNode = new Date212Node(data);
        Date212Node first = super.getFirst();
        int length = super.getLength();
        Date212Node previous = first;
        Date212Node current = first.next;
        while(current != null && current.data.compareDates(data) < 0){
            previous = current;
            current = current.next;

        }

        newNode.next  = previous.next;
        previous.next = newNode;
        super.setLength(length + 1);
    }

}

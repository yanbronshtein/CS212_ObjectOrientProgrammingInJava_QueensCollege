/**
 * <tt>Date212Node</tt>
 * The Date212 class defines a node to be used in a Date212List
 * @author yanivbronshtein
 * @version 1.0
 * */

class Date212Node {

    protected Date212 data;
    protected Date212Node next;

    /**
     * Constructs a Date212Node for the specified Date212 object.
     * Sets data class variable to the inputDate date and the next pointer to null
     *
     * @param   data            a Date212 date.
     */
    public Date212Node(Date212 data)
    {
        this.data = data;
        this.next = null;

    }
}

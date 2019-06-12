/**
 * <tt>UnsortedDate212List</tt>
 * The UnsortedDate212List class extends the Date212List class to implement a linked list for storing dates
 * in unsorted order. The class implements the abstract add() method in the super class
 *
 * @author yanivbronshtein
 * @version 1.0
 *
 *
 * */
class UnsortedDate212List extends Date212List {


    /**Constructs a SortedDate212List by invoking the constructor of the Date212List class */
    public UnsortedDate212List()
    {
        super();
    }

    /**Method invokes the append() method of the Date212List to add a date to an UnsortedDate212List */
    void add(Date212 data)
    {
        super.append(data);
    }



}

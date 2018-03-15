public class a_16_20
{
    /*Write a method called shift that rearranges the elements of a list of integers by moving to the end of the list all values
    that are in odd-numbered positions and otherwise preserving list order. For example, suppose that a variable list
    stores the values [10, 31, 42, 23, 44, 75, 86]. The call of list.shift(); should rearrange the list to store
    [10, 42, 44, 86, 31, 23, 75]. It doesn’t matter whether the value itself is odd or even; what matters is
    whether the value appears in an odd index (index 1, 3, 5, etc.). Also notice that the original order of the list is otherwise
    preserved. You may not construct any new nodes nor use any auxiliary data structures to solve this problem. You
    also may not change any data fields of the nodes; you must solve this problem by rearranging the links of the list.*/

    //initiate standard variables
    private ListNode front;

    //too test the method
    public void run()
    {
        //I have made an add-method to ListNode
        addNodeToList(0,10);
        addNodeToList(1,31);
        addNodeToList(2,42);
        addNodeToList(3,23);
        addNodeToList(4,44);
        addNodeToList(5,75);
        addNodeToList(6,86);

        //I have made a print list data method
        shift();
        printList();
    }

    //rearranges the elements of a list of integers by moving to the end of the list all values
    //that are in odd-numbered positions and otherwise preserving list order.
    public void shift()
    {
        //initiate variables
        int copyA = 0;

        //the first for-loop checks if current data is odd
        for (ListNode current = front; current != null; current = current.next)
        {
            if ((current.data % 2) != 0)
            {
                copyA = current.data;

                //sec loop puts the odd-data in end of the list by two if-statment
                for (ListNode secCurrent = current; secCurrent != null; secCurrent = secCurrent.next)
                {
                    //avoid null pointer exception!
                    if (secCurrent.next != null)
                    {
                        secCurrent.data = secCurrent.next.data;
                    }
                    if (secCurrent.next == null)
                    {
                        secCurrent.data = copyA;
                    }
                }
            }
        }
    }

    //an add-method to ListNode that adds a value to the list
    public void addNodeToList(int index, int value)
    {
        //if index is 0, then add value to front
        if(index == 0)
        {
            front = new ListNode(value, front);
        }
        // else add a value to the end of list
        else
        {
            ListNode current = front;
            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    //prints the list
    public void printList()
    {
        //the for-loop that prints the list data out
        System.out.print("[ ");
        for (ListNode current = front; current != null; current = current.next)
        {
            System.out.print(current.data + ", ");
        }
        System.out.println("]" + "\n");
    }

}

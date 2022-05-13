
// Assignment #: 10
//         Name: Michael Mayers
//    StudentID: 1221983412
//      Lecture: 12:20-1:10
//  Description: LinkedList class
public class LinkedList {
    Table first;
    int size;

    public LinkedList() {
        first = null;
        size = 0;
    }

    public void add(int numberOfGuests, String name) {
        Table newGuest = new Table(numberOfGuests, name);
        if (first == null) {
            first = newGuest;
        } else {
            Table pointer = first;
            while (pointer.next != null)
                pointer = pointer.next;

            pointer.next = newGuest;
        }
        size++;
    }

    public Table removeFirst() {
        if (first == null) {
            Table.EmptyTable none = new Table.EmptyTable();
            first = none;
            return first;
        } else {
            //Object element = first;
            Table temp = first;
            first = first.next;
            size--;
            return temp;
        }

    }

    public Table removeLast() {
        Table previous1 = first;
        Table current1 = first.next;
        while (current1 != null && current1.next != null) {
            previous1 = current1;
            current1 = current1.next;

        }

        if (current1 != null) {
            previous1.next = current1.next;
            size--;
        }
        return first;

    }

    public Table removeMiddle(String name1) {
        if (getPosition(name1) == -1) {
            Table.EmptyTable none = new Table.EmptyTable();
            first = none;
            System.out.println("Hello");
            return first;
        }
        else
        {
            Table prev = first;
            Table current = first.next;
            getPosition(name1);
            while(current!=null&&(!prev.name.equals(name1)))
            {

                prev = current;
                current = current.next;
            }

                prev.next = current.next;
                size--;
                System.out.println("HI");
                return current;




        }

    }

    public Table removeGuest(String name) {

        Table x = first;
        if(getPosition(name)==0)
        {
            removeFirst();
        }
        else if(getPosition(name)-1==size)
        {
            x = removeLast();
        }
        else
        {
            x = removeMiddle(name);
        }
        return x;

    }

    public int getPosition(String name1) {
        Boolean f = true;

        if (first.name.equals("")) {
            return -1;
        }
        else{
            Table prev = first;
            Table current = first.next;
            int i = 0;
            while(current!=null&&(!prev.name.equals(name1)))
            {
                i++;
                prev = current;
                current = current.next;
                if(prev.name.equals(name1))
                {
                    f = true;
                }
                else
                {
                    return -1;
                }


            }
            if(f)
            {
                return i;
            }
            else
            {
                return -1;
            }
        }
    }

    public int getNumberOfParties(int num) {
        int i = 0;
        if (first == null) {
            return -1;
        }
        while (first != null) {
            if (first.guests == num) {
                i++;
                first = first.next;
            } else {
                first = first.next;
            }
        }
        return first.guests;
    }

    public String listReservations() {

        if (first == null) {
            return "No reservations in queue at this time \n";
        } else {
            String z = "";
            Table prev = first;

            int i = 0;
            if (size != 1)
            {

                while (prev != null) {
                    z += prev.toString();
                    prev = prev.next;
                    i++;
                }
            }
            if(size == 1)
            {
                z += prev.toString();
            }

            return z + "\n" + "Total reservations: " + i;
        }

    }
}

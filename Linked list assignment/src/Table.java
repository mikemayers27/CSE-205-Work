
// Assignment #: 10
//         Name: Michael Mayers
//    StudentID: 1221983412
//      Lecture: 12:20-1:10
//  Description: Table class

public class Table {

    String name;
    int guests;
    Table next;

    public Table(int n, String name){
        this.name = name;
        guests = n;
        next = null;
    }

    public String toString(){
        return "\nReservation for " + name + ": party of "
                + guests + ".\n";
    }


    public static class EmptyTable extends Table{

        public EmptyTable() {
            super(-1, "");
        }
    }
}

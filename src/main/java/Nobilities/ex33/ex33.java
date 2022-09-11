package Nobilities.ex33;

import java.util.ArrayList;
import java.util.Arrays;
// Join orders and customers
public class ex33 {

    class Data {
        String[] orders = {
                //order id, customer id, date
                "10308,2,1996-09-18",
                "10309,37,1996-09-19",
                "10310,77,1996-09-20"
        };

        String[] customers = {
                // customer id, name, country
                "1,Alfreds Futterkiste,Germany",
                "2,Ana Trujillo,Mexico",
                "3,Antonio Moreno,Mexico"
        };
    }
    public static void main(String[] args) {
        final var students = new ArrayList<Orders>();

        for(final var line : lines) {
            students.add(Orders.decode(line));
        }

        double gradeSum = 0.0;
        for (Orders current : students ) {
            gradeSum += current.grade;
        }
        gradeSum /= students.size();

        System.out.println(gradeSum);
    }

}
class Orders {
    final int orderID;
    final int customerID;
    final String date;

    public Orders(int orderID, int customerID, String date) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.date = date;
    }
    static Orders decode(String line){
        String[] elements = line.split(",");

        return new Orders(
                Integer.valueOf(elements[0]),
                Integer.valueOf(elements[1]),
                elements[2],
                Arrays.copyOfRange(elements,3,elements.length)
        );


    }
}

record Customers(int customerId, String name, String country) {

    static Customers decode(String line) {
        String[] elements = line.split(",");

        return new Customers(
                Integer.valueOf(elements[1]),
                elements[2],
                elements[3],
                Arrays.copyOfRange(elements, 3, elements.length)
        );
    }

}
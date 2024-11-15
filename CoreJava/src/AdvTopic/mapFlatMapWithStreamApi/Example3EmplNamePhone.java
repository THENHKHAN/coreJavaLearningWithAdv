package AdvTopic.mapFlatMapWithStreamApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// https://www.scaler.com/topics/java-flatmap/

class EmployeeWithPhone {
    private String name;
    private List<String> phones;

    public EmployeeWithPhone(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

}

public class Example3EmplNamePhone {
    public static void main(String[] args) {
        ArrayList<EmployeeWithPhone> employees = new ArrayList<>();
        employees.add(new EmployeeWithPhone("Hritik", Arrays.asList("1234567890", "1122334455")));
        employees.add(new EmployeeWithPhone("Ranvijay", Arrays.asList("2456801357", "2233445566")));
        employees.add(new EmployeeWithPhone("John", Arrays.asList("4389079300", "5840244859")));
        employees.add(new EmployeeWithPhone("Mathew", Arrays.asList("9977554433")));

        System.out.println("A 2-D List of Employee phone numbers:");
        System.out.println(
                // open a stream
                // List<Employee> -> Stream<Employee>
                employees.stream()

                        // map each Employee instance to list of their stored phone numbers
                        // Employee -> List<String>
                        .map(emp -> emp.getPhones())
                        // each List<String> collected in a Stream to give Stream<List<String>>

                        // collects each list in the stream to another List
                        // which results in List<List<String>>
                        .collect(Collectors.toList())
        );
// [[1234567890, 1122334455], [2456801357, 2233445566], [4389079300, 5840244859], [9977554433]]

        System.out.println("\n The flattened List of Employee phone numbers:");

        // the lambda expressions can also be replaced to equivalent method references
        System.out.println(
                // open a stream
                // List<Employee> -> Stream<Employee>
                employees.stream()

                        // method reference is equivalent to emp -> emp.getPhones() lambda expression
                        // Employee -> List<String>
                        // List<String> -> Stream<List<String>>
                        .map(EmployeeWithPhone::getPhones)

                        // maps each list of phone numbers to open another stream and map each phone in that stream according to some logic
                        // input Stream to flatMap = Stream<List<String>>
                        .flatMap(
                                // List<String> -> Stream<String>
                                phones -> phones.stream() // using stream MUST here

                                        // phone String -> another phone String -> Stream<String>
                                        .map(phone -> "+91-" + phone) // TODO : used map inside flatmap - this is new for me
                        )
                        // flattens out Stream<Stream<String> to Stream<String>

                        // collects each phone String in flattened stream into a List
                        .collect(Collectors.toList())
        );
        // [+91-1234567890, +91-1122334455, +91-2456801357, +91-2233445566, +91-4389079300, +91-5840244859, +91-9977554433]
    }
}

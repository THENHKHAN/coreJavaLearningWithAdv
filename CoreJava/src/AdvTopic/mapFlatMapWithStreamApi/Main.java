package AdvTopic.mapFlatMapWithStreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> citiesWorkedIn1 = new ArrayList<>();
        citiesWorkedIn1.add("Delhi");
        citiesWorkedIn1.add("Bengaluru");
        citiesWorkedIn1.add("Dubai");
        citiesWorkedIn1.add("Pune");

        Employee emp1 = new Employee(1, "Noorul1",  citiesWorkedIn1);

        List<String> citiesWorkedIn2 = new ArrayList<>();
        citiesWorkedIn2.add("Lucknow");
        citiesWorkedIn2.add("Noida");

        Employee emp2 = new Employee(2, "Noorul2",  citiesWorkedIn2);


        List<String> citiesWorkedIn3 = new ArrayList<>();
        citiesWorkedIn3.add("USA");
        citiesWorkedIn3.add("Indore");
        citiesWorkedIn3.add("Gujarat");

        Employee emp3 = new Employee(3, "Noorul3",  citiesWorkedIn3);


        // let's create list of employee
        List<Employee> listOfEmployee = new ArrayList<>();
        listOfEmployee.add(emp1);
        listOfEmployee.add(emp2);
        listOfEmployee.add(emp3);

        // TODO: print all employee present
        System.out.println("List of Employs: " + listOfEmployee);// [Employee{id=1, name='Noorul1', citiesWorkedIn=[Delhi, Bengaluru, Dubai, Pune]}, Employee{id=2, name='Noorul2', citiesWorkedIn=[Lucknow, Noida]}, Employee{id=3, name='Noorul3', citiesWorkedIn=[USA, Indore, Gujarat]}]

        //TODO:  print all the employee id in a list

//        List<Integer> empIdLst = new ArrayList<>();
//        for (Employee emp: listOfEmployee){
//            empIdLst.add(emp.getId());
//        }
//        System.out.println("Employes Ids : " + empIdLst); // [1, 2, 3]
        // Stream version with map
        List<Integer> empIdLst = listOfEmployee.stream()
                                                .map(empObj -> empObj.getId())
                                                .toList(); // S.C : map(Employee::getId)
        System.out.println("Employs Ids : " + empIdLst); // [1, 2, 3]

        // TODO: print all the employee citiesWorkedIn in a list
        List< List<String> > listOfEmploysCitiesWorkedIn = listOfEmployee.stream()
                .map(Employee::getCitiesWorkedIn).toList();
        System.out.println("Employs CitiesWorkedIn List : " + listOfEmploysCitiesWorkedIn);
        // [ [Delhi, Bengaluru, Dubai, Pune], [Lucknow, Noida], [USA, Indore, Gujarat] ]

        // TODO: print all the cities where all the employee worked in : we'll use map then flatmap to worked on inner list (to flatten)
// remove the duplicate city if available that's y used Set.           // flattens out Stream<Stream<String> to Stream<String>
        Set<String> citiesWorkedInFlatten = listOfEmployee.stream()
                .flatMap(emplObj-> emplObj.getCitiesWorkedIn().stream())
                .collect(Collectors.toSet());
        System.out.println("All the employee worked in these cities : " + citiesWorkedInFlatten);// [Lucknow, Delhi, USA, Bengaluru, Gujarat, Pune, Noida, Indore, Dubai]

    }
}

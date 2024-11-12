package AdvTopic.mapFlatMapWithStreamApi;

import java.util.List;

// https://www.youtube.com/watch?v=TM6TZvVoAko
// https://www.youtube.com/watch?v=CwvlS3ViGFQ
// https://www.scaler.com/topics/map-vs-flatmap/
/*
Flattening is the process of converting several collections of items present inside another collection into a single collection of items.
For example, [[1, 2], 3, [4, 5], []] is flattened to [1, 2, 3, 4, 5].
 */
public class Employee {
    private int id;
    private String name;
    private List<String> citiesWorkedIn; // employee worked in these cities

    public Employee(int id, String name, List<String> citiesWorkedIn){
        this.id= id;
        this.name= name;
        this.citiesWorkedIn= citiesWorkedIn;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<String> getCitiesWorkedIn(){
        return this.citiesWorkedIn;
    }

    public void setCitiesWorkedIn(List<String> citiesWorkedIn) {
        this.citiesWorkedIn = citiesWorkedIn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citiesWorkedIn=" + citiesWorkedIn +
                '}';
    }
}

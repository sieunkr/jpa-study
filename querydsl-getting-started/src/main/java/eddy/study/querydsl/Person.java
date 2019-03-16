package eddy.study.querydsl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

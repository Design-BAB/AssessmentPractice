
package edu.mdc.javaassessment12to18;

/**
 *
 * @author bbece
 */

/*
Define a class called Person with two attributes: age stored as integer and id stored as integer. Then 
define constructor with parameters for all attributes, and corresponding set and get methods for all 
attributes.  
*/
public class Person {
    private int age;
    private int id;
    
    public Person(int age, int id) {
        this.age = age;
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

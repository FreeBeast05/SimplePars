package baseclasses;


import baseclasses.correctnessdata.ValidEmployee;
import exceptions.NotValidDataException;

import java.math.BigDecimal;

public class Employee {
    private int id;
    private String secondName;
    private String firstName;
    private BigDecimal salary;

    public Employee(int id, String secondName, String firstName, BigDecimal salary) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSecondName(String secondName) {
        try {
            ValidEmployee.validNameOrSecondName(secondName);
            this.secondName = secondName;
        } catch (NotValidDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public void setFirstName(String firstName) {
        try {
            ValidEmployee.validNameOrSecondName(secondName);
            this.firstName = firstName;
        } catch (NotValidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
package baseclasses.entities;


import java.math.BigDecimal;
import java.util.Objects;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && secondName.equals(employee.secondName) && firstName.equals(employee.firstName) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salary);
    }
}
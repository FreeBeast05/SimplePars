package baseclasses.entities;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String title;
    private List<Employee> listEmployers = new LinkedList<>();


    public BigDecimal getSumSalaryAllEmployee() {
        return listEmployers.stream().map(Employee::getSalary).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }


    public Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getListEmployers() {
        return listEmployers;
    }

    public void setListEmployers(List<Employee> listEmployers) {
        this.listEmployers = listEmployers;
    }

    public List<Employee> addEmployer(Employee employee) {
        this.listEmployers.add(employee);
        return listEmployers;
    }

    public BigDecimal getAvgSalary() {
        return listEmployers.size() == 0 ? BigDecimal.ZERO : getSumSalaryAllEmployee().divide(new BigDecimal(listEmployers.size()), 2, RoundingMode.CEILING);

    }


    @Override
    public String toString() {
        return "Department{" +
                "title='" + title + '\'' +
                '}' + listEmployers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return title.equals(that.title) && listEmployers.equals(that.listEmployers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, listEmployers);
    }
}
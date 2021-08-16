package baseclasses.entities;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String title;
    private List<Employee> listEmployers = new LinkedList<>();
    private boolean flagRecount = false;
    private  BigDecimal sumSalaryAllEmployee;
    private BigDecimal avgSalary;


    public BigDecimal getSumSalaryAllEmployee() {
        if (flagRecount) {
            avgSalary = getAvgSalaryForSublist(listEmployers);
            sumSalaryAllEmployee = getSumSalaryForSublist(listEmployers);
            flagRecount = false;
        }
        return sumSalaryAllEmployee;
    }

    public static BigDecimal getSumSalaryForSublist(List<Employee> sublist){
        return sublist.stream().map(Employee::getSalary).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
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
        flagRecount = true;
        this.listEmployers = listEmployers;
    }

    public void addEmployer(Employee employee) {
        flagRecount = true;
        this.listEmployers.add(employee);
    }

    public BigDecimal getAvgSalary() {
        if (flagRecount) {
            sumSalaryAllEmployee = listEmployers.stream().map(Employee::getSalary).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            avgSalary = getAvgSalaryForSublist(listEmployers);
            flagRecount = false;
        }
        return avgSalary;
    }

    public static BigDecimal getAvgSalaryForSublist( List<Employee> sublist){
        BigDecimal sumForSubset = sublist.stream().map(Employee::getSalary).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            if (sumForSubset.compareTo(BigDecimal.ZERO) == 0){
                return BigDecimal.ZERO;
            }
            else return sumForSubset.divide(BigDecimal.valueOf(sublist.size()), 2, RoundingMode.HALF_UP);
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
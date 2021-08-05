package daseclasses;


import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Department {
    private  String title;
    private List<Employee> listEmployeers= new LinkedList<>();

    public Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Employee> getListEmployeers() {
        return listEmployeers;
    }

    public void setListEmployeers(List<Employee> listEmployeers) {
        this.listEmployeers = listEmployeers;
    }

    public List<Employee> addEmployer(Employee employee){
        this.listEmployeers.add(employee);
        return listEmployeers;
    }

    public BigDecimal getAvgSalary(){
        BigDecimal sumSalary = listEmployeers.stream().map(Employee::getSalary).reduce(BigDecimal::add).get();
        return sumSalary.divide(new BigDecimal(listEmployeers.size()));

    }


    @Override
    public String toString() {
        return "Department{" +
                "title='" + title + '\'' +
                '}'+ listEmployeers.toString();
    }
}
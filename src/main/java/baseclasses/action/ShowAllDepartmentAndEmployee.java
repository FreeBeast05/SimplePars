package baseclasses.action;

import baseclasses.entities.Department;
import baseclasses.entities.Employee;

import java.util.Map;

public class ShowAllDepartmentAndEmployee {
    public static void showMap(Map<String, Department> departmentMap) {
        for (String title : departmentMap.keySet()) {
            System.out.println(title);
            for (Employee employee : departmentMap.get(title).getListEmployers()) {
                System.out.println(employee.toString());
            }
            System.out.println(departmentMap.get(title).getAvgSalary());
        }
    }
}

package baseclasses.action;

import baseclasses.correctnessdata.ValidParameter;
import baseclasses.entities.Department;

import java.util.Map;

public class Main {
    public static String path2;
    public static void main(String[] args) {
        String[] path = ValidParameter.validInputParameter(args);
        path2 = path[1];
        String coding = "Cp1251";
        Map<String, Department> mapDepartment = CreateMapDepartment.createMapDepartment(path, coding) ;
        ShowAllDepartmentAndEmployee.showMap(mapDepartment);
        TransfersGroupEmployees.transfersGroup(mapDepartment);
    }
}

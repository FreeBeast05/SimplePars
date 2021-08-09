package baseclasses;

import baseclasses.action.CreateMapDepartment;
import baseclasses.action.ShowAllDepartmentAndEmployee;
import baseclasses.action.TransfersEmployee;
import baseclasses.correctnessdata.ValidParameter;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] path = ValidParameter.validInputParameter(args);
        String coding = "Cp1251";
        Map<String, Department> mapDepartment = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path[0]), coding))) {
            String s;
            while ((s = br.readLine()) != null) {
                CreateMapDepartment.createMapDepartment(s, mapDepartment);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Кодировка файла не известна");
        } catch (IOException e) {
            System.out.println("Возникла ошибка ввода");
        }
        ShowAllDepartmentAndEmployee.showMap(mapDepartment);
        List<String> possibleTransfers = TransfersEmployee.transfers(mapDepartment);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path[1]))) {
            for (String value : possibleTransfers) {
                writer.write(value + "\n");
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка ввода");
        }


    }
}

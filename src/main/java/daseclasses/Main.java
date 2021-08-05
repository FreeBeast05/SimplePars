package daseclasses;

import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.NotValidDataException;
import exceptions.NotValidDepartamentException;
import exceptions.NotValidSalaryException;

public class Main {
    public static void main(String[] args) {

        String file = args[0];
        List<Department> listDepartament = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251"))) {
            String s;
            while ((s = br.readLine()) != null) {
                CreateListDepartment.createListDep(s, listDepartament);
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Файл не найден или кодиравка файла не известна");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

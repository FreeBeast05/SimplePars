package baseclasses.correctnessdata;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ValidParameter {
    public static String[] validInputParameter(String[] args){
        String fileInput = null;
        String fileOutput = null;
        if (args.length==2){
            fileInput = args[0];
            fileOutput = args[1];
            File file = new File(fileOutput);
            if (file.exists()) {
                System.out.println("Файл с таким именем уже существует, хотите его перезаписать? Д/н");
                Scanner in = new Scanner(System.in);
                String num = in.nextLine();
                if (num.equalsIgnoreCase("д")) {
                    boolean tr = file.delete();
                }
                else {
                    System.out.println("Обновление данных не произведено");
                    System.exit(1);
                }
            }
            else {
                try {
                    boolean tr = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(args.length==1) {
            System.out.println("Не указан путь выходного файла");
            System.exit(-1);
        }
        else {
            System.out.println("Не указаны входной и выходной пути файлов");
            System.exit(-1);
        }

        return new String[] {fileInput, fileOutput};

    }
}

package baseclasses.correctnessdata;

public class ValidParameter {
    public static String[] validInputParameter(String[] args){
        String fileInput = null;
        String fileOutput = null;
        if (args.length==2){
            fileInput = args[0];
            fileOutput = args[1];
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

package exceptions;

public class NotValidDepartmentException extends  IllegalAccessException {
    public NotValidDepartmentException(String message){
        super(message);
    }
}

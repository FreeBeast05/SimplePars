package exceptions;

public class NotValidDepartamentException extends  IllegalAccessException {
    public NotValidDepartamentException(String message){
        super(message);
    }
}

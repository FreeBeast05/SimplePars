package exceptions;

public class NotValidDataException extends  IllegalAccessException {
    public NotValidDataException(String message){
        super(message);
    }
}

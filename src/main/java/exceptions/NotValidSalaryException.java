package exceptions;

public class NotValidSalaryException extends  NumberFormatException {
    public NotValidSalaryException(String message){
        super(message);
        }
}

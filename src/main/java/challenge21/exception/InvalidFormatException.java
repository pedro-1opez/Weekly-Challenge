package challenge21.exception;

/*
    This class represents a user-defined exception that will be thrown if
    the file does not start with a number
*/
public class InvalidFormatException extends Exception{

    public InvalidFormatException(String message){
        super(message);
    }

}

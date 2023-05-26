package challenge21.exception;

/*
    This class represents a user-defined exception that will be thrown if
    the file contains an unsupported operator
*/
public class UnsupportedOperatorException extends Exception{
    public UnsupportedOperatorException(String message){
        super(message);
    }
}

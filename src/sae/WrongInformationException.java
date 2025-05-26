package sae;

public class WrongInformationException extends Exception{
    public WrongInformationException(String s){
        super("WrongInformationException : " + s);
    }
}

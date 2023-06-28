package edu.uady.pagos.error;

public class ControlPagosException extends Exception{
    private int code;
    private String message;

    public ControlPagosException (String message){
        super(message);
    }
}

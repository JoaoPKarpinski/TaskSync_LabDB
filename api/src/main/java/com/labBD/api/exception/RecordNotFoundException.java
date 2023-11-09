package com.labBD.api.exception;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(Object id){
        super("Sem registro correspondente à requisição. ID " + id);
    }
}

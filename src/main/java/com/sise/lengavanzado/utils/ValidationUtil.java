package com.sise.lengavanzado.utils;
import java.util.List;
import org.springframework.validation.FieldError;


public class ValidationUtil {

    public static String getOneMessageFromErrors(List<FieldError>errors){
        String message = "";
        for (FieldError error : errors){

            if(!message.isEmpty()){
                message += ", ";

            }
            message +=  error.getField() + " " + error.getDefaultMessage();
        }
        return message+".";
    }
    
}

package bstorm.akimts.gestion_produit.controller;

import bstorm.akimts.gestion_produit.models.dto.FieldErrorDTO;
import bstorm.akimts.gestion_produit.models.dto.ValidationErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handle(Exception ex){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("oh on a un probleme");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ValidationErrorDTO dto = new ValidationErrorDTO();

        for (ObjectError error : ex.getGlobalErrors()){
            dto.globalErrors.add( error.getDefaultMessage() );
        }

        for (FieldError error : ex.getFieldErrors()){
            dto.fieldErrors.add(
                    FieldErrorDTO.builder()
                            .message( error.getDefaultMessage() )
                            .fieldName( error.getField() )
                            .build()
            );
        }

        return ResponseEntity
                .badRequest()
                .body(dto);

    }
}

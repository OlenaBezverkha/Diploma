package com.superstore.storesever.error;

import com.superstore.storesever.model.*;
import com.superstore.storesever.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorView> handleConflict(Exception ex) {

        if(ex instanceof ItemNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildErrorView(HttpStatus.NOT_FOUND));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildErrorView(HttpStatus.BAD_REQUEST));
    }

    private ErrorView buildErrorView(HttpStatus status) {
        ErrorView view = new ErrorView();
        Error error = new Error();

        switch (status) {
            case BAD_REQUEST:
                error.setCode(status.value());
                error.setTitle("Server Error");
                error.setDetail("Unexpected server error");
                break;
            case NOT_FOUND:
                error.setCode(status.value());
                error.setTitle("Requesting Resource not found");
                error.setDetail("Requesting Resource not found");
                break;
            default:
                error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
                error.setTitle("Internal Server Error");
                error.setDetail("Internal Server Error");
        }

        Error[] errors = {error};
        view.setErrros(errors);
        return view;
    }
}

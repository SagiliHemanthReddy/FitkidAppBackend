package in.dackend.fitapp.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error_code", "USER_NAME_ALREADY_EXISTS");
        errorResponse.put("error_message", "The username already exists. Please choose a different username.");
        errorResponse.put("error_type", "DataIntegrityViolation");

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // Other exception handlers can be added here
}

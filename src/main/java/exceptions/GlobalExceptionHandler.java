package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler 
{
    @ExceptionHandler(validationExceptions.class)
    public ResponseEntity<ErrorResponse> handleValidationException(validationExceptions ex)
     {
        ErrorResponse errorResponse = new ErrorResponse(ex.getEntityName(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    public static class ErrorResponse
    {
        private String entityName;
        private String message;
        public ErrorResponse(String entityName, String message)
        {
            this.entityName = entityName;
            this.message = message;
        }
        public String getEntityName()
        {
            return entityName;
        }
        public String getMessage()
        {
            return message;
        }
    }

}

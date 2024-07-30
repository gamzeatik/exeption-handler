package demo.exception_handler.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvice {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        HttpStatus status;
        ErrorResponse errorResponse = switch (ex.getErrorCode()) {
            case CUSTOMER_NOT_FOUND -> {
                status = HttpStatus.NOT_FOUND;
                yield new ErrorResponse(ex.getErrorCode().name(), ex.getMessage());
            }
        };
        return ResponseEntity.status(status).body(errorResponse);
    }
}

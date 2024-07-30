package demo.exception_handler.customer;

import lombok.Getter;

@Getter
public class CustomerNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public CustomerNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

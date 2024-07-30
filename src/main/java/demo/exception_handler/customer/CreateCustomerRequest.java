package demo.exception_handler.customer;

public record CreateCustomerRequest(
      String name, String lastName, String email) {
}

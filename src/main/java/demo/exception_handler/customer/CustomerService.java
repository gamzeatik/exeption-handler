package demo.exception_handler.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;


    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        "Customer not found id: %s".formatted(id), ErrorCode.CUSTOMER_NOT_FOUND)
                );
    }

    public Customer createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID());
        customer.setFirstName(request.name());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        return customerRepository.save(customer);
    }
}

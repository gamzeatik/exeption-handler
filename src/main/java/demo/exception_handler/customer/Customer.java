package demo.exception_handler.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table
@Entity
@Getter
@Setter
public class Customer {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}



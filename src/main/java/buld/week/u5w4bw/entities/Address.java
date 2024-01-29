package buld.week.u5w4bw.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private UUID id;
    private String Street;
    private int houseNumber;
    private String provincia;
    private int postalCode;
    private String city;
}

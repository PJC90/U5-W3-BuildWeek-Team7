package buld.week.u5w4bw.entities;

import jakarta.persistence.*;
import lombok.*;
import buld.week.u5w4bw.entities.Clients;

import java.util.UUID;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue

    private UUID addressId;




    private String Street;
    private int houseNumber;
    private String provincia;
    private int postalCode;
    private String city;
    @ManyToOne
    private Clients client;
}

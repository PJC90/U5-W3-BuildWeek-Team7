package buld.week.u5w4bw.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue
    private UUID id;
    private String Street;
    private int houseNumber;
    private int postalCode;
    private String city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id")
    private Province province;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comune_code")
    private Comune comune;


}

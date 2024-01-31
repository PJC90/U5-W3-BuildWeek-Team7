package buld.week.u5w4bw.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Province {

    @Id
    @GeneratedValue
    private long id;

    //  @Column(name = "province_code")
    private int provinceCode;

    private String sigla;

    private String nomeProvincia;

    private String regione;

}

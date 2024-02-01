package buld.week.u5w4bw.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

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

    private int provinceCode;

    private String sigla;

    private String nomeProvincia;

    private String regione;

    @OneToMany(mappedBy = "province")
    private List<Comune> comunesList;


}

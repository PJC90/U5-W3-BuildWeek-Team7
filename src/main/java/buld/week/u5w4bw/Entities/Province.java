package buld.week.u5w4bw.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Province {

    @Id
    @GeneratedValue
    private long id;

    private String sigla;

    private String nomeProvincia;

    private String regione;

}

package buld.week.u5w4bw.entities;


import jakarta.persistence.Column;
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
public class Comune {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "province_id")
    private int provinceCode;

    @Column(name = "comune_code")
    private int comuneCode;

    @Column(name = "name")
    private String name;

}

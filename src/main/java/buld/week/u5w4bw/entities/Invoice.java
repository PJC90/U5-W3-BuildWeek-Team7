package buld.week.u5w4bw.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue
    private UUID number;
    private LocalDate date;
    private double imports;
    @Enumerated(EnumType.STRING)
    private Invoicestates state;


}

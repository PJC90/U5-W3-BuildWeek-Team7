package buld.week.u5w4bw.Enteties;

import buld.week.u5w4bw.Enum.Invoicestates;
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

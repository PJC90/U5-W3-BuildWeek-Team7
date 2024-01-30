package buld.week.u5w4bw.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private String statoFattura;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    private List<String> statusList = new ArrayList<>(Arrays.asList("Pagata", "Da pagare", "Emessa"));


    public void addStatus(String status) {
        statusList.add(status);
    }


}

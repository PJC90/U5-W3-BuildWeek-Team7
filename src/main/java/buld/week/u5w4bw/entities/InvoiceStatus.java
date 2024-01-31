package buld.week.u5w4bw.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class InvoiceStatus {
    @Id
    @GeneratedValue
    private Long id;
    private List<String> statusList = new ArrayList<>(Arrays.asList("Pagata", "Da pagare", "Emessa"));


    public void addStatus(String status) {
        statusList.add(status);
    }
}

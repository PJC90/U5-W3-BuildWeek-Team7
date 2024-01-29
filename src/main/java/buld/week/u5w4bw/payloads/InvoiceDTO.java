package buld.week.u5w4bw.payloads;

import buld.week.u5w4bw.entities.enums.Invoicestates;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record InvoiceDTO(
        @NotNull(message = "state è un campo obbligatorio")
        Invoicestates state,
        @NotEmpty(message = "imports è un campo obbligatorio")
        double imports,
        @NotEmpty(message = "la data è obbligatoria")
        LocalDate date,
        @NotNull(message = "l'id dell'user è un campo obbligatorio!")
        UUID client_id
) {
}

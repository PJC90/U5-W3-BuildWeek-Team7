package buld.week.u5w4bw.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AddressDTO(
        @NotEmpty(message = "Il campo street non può essere vuoto")
        String street,

        @NotEmpty(message = "Il campo houseNumber non può essere vuoto")
        int houseNumber,
        @NotEmpty(message = "Il campo provincia non può essere vuoto")
        String provincia,
        @NotEmpty(message = "Il campo zipCode non può essere vuoto")
        int zipCode,
        @NotEmpty(message = "Il campo city non può essere vuoto")
        String city,
        @NotNull(message = "l'id dell'user è un campo obbligatorio!")
        UUID client_id

) {
}

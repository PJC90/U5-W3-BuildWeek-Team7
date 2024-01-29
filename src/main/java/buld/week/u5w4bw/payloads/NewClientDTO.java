package buld.week.u5w4bw.payloads;

import buld.week.u5w4bw.Entities.Address;
import buld.week.u5w4bw.Entities.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record NewClientDTO(


        @NotEmpty
        BusinessType businessType,
        @NotEmpty
        String P_IVA,
        @NotEmpty
        @Email
        String email,

        LocalDate lastcontactDate,
        @NotNull
        double revenue,
        @NotEmpty
        String PEC,
        @NotEmpty
        String companyNumber,
        @NotEmpty
        String contactMail,
        String contactName,
        String contactSurname,
        String contactNumber,
        String businessLogo


        ) {

}

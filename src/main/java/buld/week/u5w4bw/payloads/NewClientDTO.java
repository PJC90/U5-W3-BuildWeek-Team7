package buld.week.u5w4bw.payloads;


import buld.week.u5w4bw.entities.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

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
        @NotEmpty
        String contactName,
        @NotEmpty
        String contactSurname,
        @NotEmpty
        String contactNumber,
        String businessLogo


) {

}

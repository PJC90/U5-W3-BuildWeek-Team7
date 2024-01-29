package buld.week.u5w4bw.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;
import buld.week.u5w4bw.Entities.enums.BusinessType;

import java.time.LocalDate;

public record ClientUpdateDTO(


        @NotBlank
        BusinessType businessType,
        @NotBlank
        String P_IVA,
        @NotBlank
        @Email
        String email,
        LocalDate lastcontactDate,
        @NotBlank
        double revenue,
        @NotBlank
        String PEC,
        @NotBlank
        String companyNumber,
        @NotBlank
        String contactMail,
        @NotBlank
        String contactName,
        @NotBlank
        String contactSurname,
        @NotBlank
        String contactNumber,
        String businessLogo


) {

}

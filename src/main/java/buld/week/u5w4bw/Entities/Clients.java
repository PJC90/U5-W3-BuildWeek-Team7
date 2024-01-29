package buld.week.u5w4bw.Entities;

import buld.week.u5w4bw.Entities.enums.BusinessType;
import buld.week.u5w4bw.entities.Address;
import buld.week.u5w4bw.entities.Invoice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter


public class Clients {
    private UUID clientId;
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;
    private String P_IVA;
    private String email;
    private LocalDate registerDate;
    private LocalDate lastcontactDate;
    private double revenue;
    private String PEC;
    private String companyNumber;
    private String contactMail;
    private String contactName;
    private String contactSurname;
    private String contactNumber;
    private String businessLogo;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private List<Address> address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoices_number")
    @JsonIgnore
    private List<Invoice> invoices;


}

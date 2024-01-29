package buld.week.u5w4bw.entities;

import buld.week.u5w4bw.Entities.enums.BusinessType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Clients {

    @Id
    @GeneratedValue
    private UUID clientid;

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
    private List<Address> addressList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoices_number")
    @JsonIgnore
    private List<Invoice> invoiceList;


    public Clients(BusinessType businessType, String p_IVA, String email, LocalDate registerDate, LocalDate lastcontactDate, double revenue, String PEC, String companyNumber, String contactMail, String contactName, String contactSurname, String contactNumber, String businessLogo) {
        this.businessType = businessType;
        P_IVA = p_IVA;
        this.email = email;
        this.registerDate = registerDate;
        this.lastcontactDate = lastcontactDate;
        this.revenue = revenue;
        this.PEC = PEC;
        this.companyNumber = companyNumber;
        this.contactMail = contactMail;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactNumber = contactNumber;
        this.businessLogo = businessLogo;

    }


}

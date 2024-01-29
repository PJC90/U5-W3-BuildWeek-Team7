package buld.week.u5w4bw.entities;

import buld.week.u5w4bw.Entities.enums.BusinessType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Clients {
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
    private Address address;

    private List<Invoice> invoiceList;

    private List<Address> addressList;


    public Clients(BusinessType businessType, String p_IVA, String email, LocalDate registerDate, LocalDate lastcontactDate, double revenue, String PEC, String companyNumber, String contactMail, String contactName, String contactSurname, String contactNumber, String businessLogo, Address address) {
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
        this.address = address;
    }


    @Override
    public String toString() {
        return "Clients{" +
                "clientid=" + clientid +
                ", businessType=" + businessType +
                ", P_IVA='" + P_IVA + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", lastcontactDate=" + lastcontactDate +
                ", revenue=" + revenue +
                ", PEC='" + PEC + '\'' +
                ", companyNumber='" + companyNumber + '\'' +
                ", contactMail='" + contactMail + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactSurname='" + contactSurname + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", businessLogo='" + businessLogo + '\'' +
                ", address=" + address +
                '}';
    }
}

package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.Clients;
import buld.week.u5w4bw.exceptions.NotFoundException;
import buld.week.u5w4bw.payloads.ClientUpdateDTO;
import buld.week.u5w4bw.payloads.NewClientDTO;
import buld.week.u5w4bw.repositories.ClientsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class ClientService {

    @Autowired
    ClientsDAO clientsDAO;

    public Page<Clients> findAll(int size, int page, String order) {
        Pageable pageable = PageRequest.of(size, page, Sort.by(order));
        return clientsDAO.findAll(pageable);
    }

    public Clients findById(UUID clientId) {
        return clientsDAO.findById(clientId).orElseThrow(() -> new NotFoundException(clientId));
    }


    public Clients clientSave(UUID clientId, Clients body) {
        Clients update = this.findById(clientId);
        update.setBusinessType(body.getBusinessType());
        update.setP_IVA(body.getP_IVA());
        update.setEmail(body.getEmail());
        update.setRegisterDate(body.getRegisterDate());
        update.setLastcontactDate(body.getLastcontactDate());
        update.setRevenue(body.getRevenue());
        update.setPEC(body.getPEC());
        update.setCompanyNumber(body.getCompanyNumber());
        update.setContactMail(body.getContactMail());
        update.setContactName(body.getContactName());
        update.setContactSurname(body.getContactSurname());
        update.setContactNumber(body.getContactNumber());
        update.setBusinessLogo(body.getBusinessLogo());

        return clientsDAO.save(update);
    }

    public Clients clientUpdate(UUID clientId, ClientUpdateDTO body) {
        Clients newClient = new Clients();
        newClient.setBusinessType(body.businessType());
        newClient.setP_IVA(body.P_IVA());
        newClient.setEmail(body.email());
        newClient.setRegisterDate(LocalDate.now());
        newClient.setLastcontactDate(body.lastcontactDate());
        newClient.setRevenue(body.revenue());
        newClient.setPEC(body.PEC());
        newClient.setCompanyNumber(body.companyNumber());
        newClient.setContactMail(body.contactMail());
        newClient.setContactName(body.contactName());
        newClient.setContactSurname(body.contactSurname());
        newClient.setContactNumber(body.contactNumber());
        newClient.setBusinessLogo(body.businessLogo());

        return clientsDAO.save(newClient);
    }


    public void invoiceDelete(UUID clientId) {
        Clients delete = this.findById(clientId);
        clientsDAO.delete(delete);
    }

}

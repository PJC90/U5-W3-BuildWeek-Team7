package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.InvoiceStatus;
import buld.week.u5w4bw.exceptions.NotFoundException;
import buld.week.u5w4bw.repositories.InvoiceStatusDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceStatusService {

    @Autowired
    private InvoiceStatusDAO invoiceStatusDAO;
    public List<String> getStatusList(){
        InvoiceStatus found = this.findById(1);
        return found.getStatusList();
    }

    public InvoiceStatus saveInvoiceStatus(){
        InvoiceStatus newInvoicestatus = new InvoiceStatus();
        return invoiceStatusDAO.save(newInvoicestatus);
    }

    public InvoiceStatus findById(long id){
        return invoiceStatusDAO.findById(id).orElseThrow(()->new NotFoundException(id));
    }
    public InvoiceStatus updateInvoiceStatus(String newStatus){
        InvoiceStatus newInvoicestatus = this.findById(1);
        newInvoicestatus.getStatusList().add(newStatus);
        return invoiceStatusDAO.save(newInvoicestatus);
    }

}

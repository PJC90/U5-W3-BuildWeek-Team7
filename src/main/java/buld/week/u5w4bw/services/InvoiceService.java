package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.Clients;
import buld.week.u5w4bw.entities.Invoice;
import buld.week.u5w4bw.entities.InvoiceStatus;
import buld.week.u5w4bw.exceptions.NotFoundException;
import buld.week.u5w4bw.payloads.InvoiceDTO;
import buld.week.u5w4bw.repositories.InvoiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvoiceService {
    @Autowired
    InvoiceDAO invoiceDao;
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @Autowired
    private ClientService clientService;

    public Page<Invoice> findAll(int size, int page, String order) {
        Pageable pageable = PageRequest.of(size, page, Sort.by(order));
        return invoiceDao.findAll(pageable);
    }

    public Invoice saveInvoice(InvoiceDTO payload) {
        Invoice invoice = new Invoice();
        InvoiceStatus found = invoiceStatusService.findById(1);
        invoice.setStatoFattura(found.getStatusList().get(2));
        invoice.setInvoiceStatus(invoiceStatusService.findById(1));
        invoice.setDate(payload.date());
        invoice.setImports(payload.imports());
        Clients client = clientService.findById(payload.client_id());
        invoice.setClient(client);
        return invoiceDao.save(invoice);
    }

    public Invoice findById(UUID number) {
        return invoiceDao.findById(number).orElseThrow(() -> new NotFoundException(number));
    }


    public Invoice invoiceUpdate(UUID number, Invoice body) {
        Invoice update = this.findById(number);
        update.setDate(body.getDate());
        update.setImports(body.getImports());
        update.setStatoFattura(update.getStatoFattura());

        return invoiceDao.save(update);
    }


    public void invoiceDelete(UUID number) {
        Invoice delete = this.findById(number);
        invoiceDao.delete(delete);
    }

    //--------------------QUERIES---------------\\


    public List<Invoice> filterByClient(UUID id) {
        return invoiceDao.filterByClient(id);
    }

    public List<Invoice> filterByState(String stato) {
        return invoiceDao.filterByState(stato);
    }

    public List<Invoice> filterByDate(int year) {
        return invoiceDao.filterByDate(year);
    }

    public List<Invoice> filterByImports(double min, double max) {
        return invoiceDao.filterByImports(min, max);
    }


}

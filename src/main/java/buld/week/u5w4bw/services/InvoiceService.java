package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.Invoice;
import buld.week.u5w4bw.exceptions.NotFoundException;
import buld.week.u5w4bw.repositories.InvoiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvoiceService {

    @Autowired
    InvoiceDAO invoiceDao;

    public Page<Invoice> findAll(int size, int page, String order) {
        Pageable pageable = PageRequest.of(size, page, Sort.by(order));
        return invoiceDao.findAll(pageable);
    }

    public Invoice findById(UUID number) {
        return invoiceDao.findById(number).orElseThrow(() -> new NotFoundException(number));
    }

    public Invoice invoiceUpdate(UUID number, Invoice body) {
        Invoice update = this.findById(number);
        update.setDate(body.getDate());
        update.setImports(body.getImports());
        update.setState(body.getState());

        return invoiceDao.save(update);
    }


    public void invoiceDelete(UUID number) {
        Invoice delete = this.findById(number);
        invoiceDao.delete(delete);
    }
}

package buld.week.u5w4bw.controllers;


import buld.week.u5w4bw.entities.Invoice;
import buld.week.u5w4bw.payloads.InvoiceDTO;
import buld.week.u5w4bw.payloads.InvoiceResponseDTO;
import buld.week.u5w4bw.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Invoice> invoceList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "30") int size, @RequestParam(defaultValue = "number") String order) {
        return invoiceService.findAll(page, size, order);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceResponseDTO saveInvoice(@RequestBody InvoiceDTO payload) {
        Invoice invoice = invoiceService.saveInvoice(payload);
        return new InvoiceResponseDTO(invoice.getNumber());
    }

    @GetMapping("/{number}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public Invoice invoiceId(@PathVariable UUID number) {
        return invoiceService.findById(number);
    }

    @PutMapping("/{number}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Invoice invoicePut(@PathVariable UUID number, @RequestBody Invoice utenteBody) {
        return invoiceService.invoiceUpdate(number, utenteBody);
    }

    @DeleteMapping("/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void invoiceDelete(@PathVariable UUID number) {
        invoiceService.invoiceDelete(number);
    }

    //--------------------QUERIES--------------

    @GetMapping("/filter/clientId")
    public List<Invoice> filterByClient(@RequestParam(name = "clientId") UUID id) {
        return invoiceService.filterByClient(id);
    }

    @GetMapping("/filter/state")
    public List<Invoice> filterByState(@RequestParam(name = "state") String state) {
        return invoiceService.filterByState(state);
    }

    @GetMapping("/filter/date")
    public List<Invoice> filterByDate(@RequestParam(name = "data") int year) {
        return invoiceService.filterByDate(year);
    }

    @GetMapping("/filter/imports")
    public List<Invoice> filterByImports(@RequestParam(name = "min") double min, @RequestParam(name = "max") double max) {
        return invoiceService.filterByImports(min, max);

    }

}

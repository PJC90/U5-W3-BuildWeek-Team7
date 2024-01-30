package buld.week.u5w4bw.controllers;


import buld.week.u5w4bw.entities.Address;
import buld.week.u5w4bw.payloads.AddressDTO;
import buld.week.u5w4bw.payloads.AddressResponseDTO;
import buld.week.u5w4bw.payloads.InvoiceDTO;
import buld.week.u5w4bw.payloads.InvoiceResponseDTO;
import buld.week.u5w4bw.services.InvoiceService;
import buld.week.u5w4bw.entities.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

   @GetMapping
   @PreAuthorize("hasAuthority('ADMIN')")
   public Page<Invoice> invoceList(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "30")int size, @RequestParam(defaultValue = "number")String order){
       return invoiceService.findAll(page,size,order);
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
    public Invoice invoiceId(@PathVariable UUID number){
        return invoiceService.findById(number);
    }

    @PutMapping("/{number}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Invoice invoicePut(@PathVariable UUID number,@RequestBody Invoice utenteBody ){
        return  invoiceService.invoiceUpdate(number,utenteBody);
    }

    @DeleteMapping("/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority(ADMIN)")
    public void invoiceDelete(@PathVariable UUID number){
        invoiceService.invoiceDelete(number);
    }





}

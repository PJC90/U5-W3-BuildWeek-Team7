package buld.week.u5w4bw.controllers;


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
    //-------------------------- /me--------------------\\

    @GetMapping("/me")
    public Invoice profiloUtente(@AuthenticationPrincipal Invoice invoice){
        return invoice;
    }


    @PutMapping("/me/{number}")
    public Invoice invoiceUpdate(@AuthenticationPrincipal Invoice number,@RequestBody Invoice body){
        return invoiceService.invoiceUpdate(number.getNumber(),body);
    }


    @DeleteMapping("/me/{number}")
    public void  invoiceDelete(Invoice number){
        invoiceService.invoiceDelete(number.getNumber());
    }





}

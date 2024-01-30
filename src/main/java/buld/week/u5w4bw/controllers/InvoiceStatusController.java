package buld.week.u5w4bw.controllers;

import buld.week.u5w4bw.entities.InvoiceStatus;
import buld.week.u5w4bw.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice_status")
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @GetMapping
    public List<String> getListStatus(){
        return invoiceStatusService.getStatusList();
    }

    @PostMapping
    public InvoiceStatus saveInvoice(){
        return  invoiceStatusService.saveInvoiceStatus();
    }

    @PatchMapping
    public InvoiceStatus updateInvoiceStatus(@RequestParam(name = "newStatus") String newStatus){
        return invoiceStatusService.updateInvoiceStatus(newStatus);
    }
}

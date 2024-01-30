package buld.week.u5w4bw.controllers;

import buld.week.u5w4bw.entities.Clients;
import buld.week.u5w4bw.payloads.NewClientDTO;
import buld.week.u5w4bw.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    private ClientService clientService;


    @GetMapping
    public Page<Clients> getClients(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "id") String order) {
        return clientService.findAll(page, size, order);
    }


    @GetMapping("/{clientId}")
    public Clients findById(@PathVariable UUID clientId) {

        return clientService.findById(clientId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clients saveNewClients(@RequestBody NewClientDTO payload) {
        return clientService.clientSave(payload);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteClients(@PathVariable UUID clientId) {
        clientService.clientDelete(clientId);
    }

}

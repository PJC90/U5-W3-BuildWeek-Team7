package buld.week.u5w4bw.controllers;


import buld.week.u5w4bw.entities.Address;
import buld.week.u5w4bw.payloads.AddressDTO;
import buld.week.u5w4bw.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    private AddressService addressService;


    @GetMapping
    public Page<Address> getAdresses(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String order) {
        return addressService.findAll(page, size, order);
    }


    @GetMapping("/{id}")
    public Address findById(@PathVariable UUID id) {

        return addressService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address saveNewAddress(@RequestBody AddressDTO payload) {
        return addressService.saveAddress(payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteAddress(@PathVariable UUID id) {
        addressService.FindByIdAndDelete(id);
    }

}

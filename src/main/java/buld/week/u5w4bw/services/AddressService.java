package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.Address;
import buld.week.u5w4bw.exceptions.NotFoundException;
import buld.week.u5w4bw.payloads.AddressDTO;
import buld.week.u5w4bw.repositories.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressDAO addressDAO;


    public Page<Address> findAll(int size, int page, String order) {
        Pageable pageable = PageRequest.of(size, page, Sort.by(order));
        return addressDAO.findAll(pageable);
    }


    public Address findById(UUID id) {
        return addressDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Address saveAddress(AddressDTO payload) {
        Address address = new Address();
        address.setCity(payload.city());
        address.setStreet(payload.street());
        address.setHouseNumber(payload.houseNumber());
        address.setPostalCode(payload.zipCode());
        return addressDAO.save(address);
    }


    public void FindByIdAndDelete(UUID id) {
        Address found = this.findById(id);
        addressDAO.delete(found);
    }


}

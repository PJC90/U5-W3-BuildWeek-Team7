package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.Address;
import buld.week.u5w4bw.entities.Clients;
import buld.week.u5w4bw.entities.Comune;
import buld.week.u5w4bw.entities.Province;
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
    @Autowired
    private ComuneService comuneService;
    @Autowired
    private ProvinceService provinceService;


    @Autowired
    private ClientService clientService;

    public Page<Address> findAll(int size, int page, String order) {
        Pageable pageable = PageRequest.of(size, page, Sort.by(order));
        return addressDAO.findAll(pageable);
    }


    public Address findById(UUID id) {
        return addressDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Address saveAddress(AddressDTO payload) {
        Comune found = comuneService.findByid(payload.id_city());
        Province found2 = provinceService.findByProvinceCode(payload.provincia_code());
        Address address = new Address();
        address.setComune(found);
        address.setProvince(found2);
        address.setStreet(payload.street());
        address.setCity(found.getName());
        address.setStreet(payload.street());
        address.setHouseNumber(payload.houseNumber());
        address.setPostalCode(payload.zipCode());
        Clients clientFound = clientService.findById(payload.client_id());
        clientFound.getAddressList().add(address);
        return addressDAO.save(address);
    }


    public void FindByIdAndDelete(UUID id) {
        Address found = this.findById(id);
        addressDAO.delete(found);
    }


}

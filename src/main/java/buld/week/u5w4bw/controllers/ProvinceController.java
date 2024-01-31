package buld.week.u5w4bw.controllers;

import buld.week.u5w4bw.entities.Comune;
import buld.week.u5w4bw.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;


    @GetMapping("{prov_id}")
    public List<Comune> getComunesList(@PathVariable int prov_id) {
        return provinceService.getComunesList(prov_id);
    }
}

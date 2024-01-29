package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.Comune;
import buld.week.u5w4bw.exceptions.NotFoundException;
import buld.week.u5w4bw.repositories.ComuneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ComuneService {


    @Autowired
    private ComuneDAO comuneDAO;

    public Page<Comune> findAll(int size, int page, String order) {
        Pageable pageable = PageRequest.of(size, page, Sort.by(order));
        return comuneDAO.findAll(pageable);
    }


    public Comune findByid(long id) {
        return comuneDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public Comune saveComune(Comune comune) {
        return comuneDAO.save(comune);
    }

}

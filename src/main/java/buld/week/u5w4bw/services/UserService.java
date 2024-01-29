package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.User;
import buld.week.u5w4bw.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public Page<User> findAll(int size,int page,String order){
        Pageable pageable= PageRequest.of(size,page, Sort.by(order));
        return userDao.findAll(pageable);
    }

    public  User findById(UUID userId){
        return userDao.findById(userId).orElseThrow(()->new NotFoundExeption(userId));
    }


}

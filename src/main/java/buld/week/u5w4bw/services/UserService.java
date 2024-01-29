package buld.week.u5w4bw.services;


import buld.week.u5w4bw.entities.User;
import buld.week.u5w4bw.exceptions.NotFoundException;
import buld.week.u5w4bw.repositories.UserDAO;
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
    UserDAO userDao;

    public Page<User> findAll(int size,int page,String order){
        Pageable pageable= PageRequest.of(size,page, Sort.by(order));
        return userDao.findAll(pageable);
    }

    public  User findById(UUID userId){
        return userDao.findById(userId).orElseThrow(()->new NotFoundException(userId));
    }

    public User userUpdate(UUID userId,User body){
        User update=this.findById(userId);
        update.setName(body.getName());
        update.setSurname(body.getSurname());
        update.setEmail(body.getEmail());
        update.setPassword(body.getPassword());
        update.setAvatar(body.getAvatar());
        update.setRole(body.getRole());
        return userDao.save(update);
    }


    public void userDelete(UUID userId){
        User delete=this.findById(userId);
        userDao.delete(delete);
    }


}

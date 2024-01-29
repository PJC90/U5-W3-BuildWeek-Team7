package buld.week.u5w4bw.services;

import buld.week.u5w4bw.entities.User;
import buld.week.u5w4bw.entities.enums.Roles;
import buld.week.u5w4bw.exceptions.BadRequestException;
import buld.week.u5w4bw.exceptions.UnauthorizedException;
import buld.week.u5w4bw.payloads.loginPayload.UserLoginDTO;
import buld.week.u5w4bw.payloads.userPayload.UserDTO;

import buld.week.u5w4bw.repositories.UserDAO;
import buld.week.u5w4bw.security.JWTtools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private JWTtools jwTtools;
    @Autowired
    private UserDAO userDao;
    @Autowired
    private UserService userService;

    public String authenticateUser(UserLoginDTO body) {
        User user = userService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), user.getPassword())) {
            return jwTtools.createToken(user);
        } else {
            throw new UnauthorizedException("Credenziali non valide!!");
        }
    }

    public User save(UserDTO body) {
        userDao.findByEmail(body.email()).ifPresent(user -> {
            throw new BadRequestException("email " + user.getEmail() + " già in uso!");
        });
        userDao.findByUsername(body.username()).ifPresent(user -> {
            throw new BadRequestException("username " + user.getUsername() + " già in uso!");
        });
        User newUser = new User();
        newUser.setName(body.name());
        newUser.setSurname(body.surname());
        newUser.setUsername(body.username());
        newUser.setEmail(body.email());
        newUser.setPassword(body.password());
        newUser.setRole(Roles.USER);
        newUser.setAvatar("https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());
        return userDao.save(newUser);
    }
}

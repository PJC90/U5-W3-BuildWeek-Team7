package buld.week.u5w4bw.Repository;

import buld.week.u5w4bw.Enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<User, UUID> {
}

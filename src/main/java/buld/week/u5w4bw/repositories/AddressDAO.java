package buld.week.u5w4bw.repositories;

import buld.week.u5w4bw.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressDAO extends JpaRepository<Address, UUID> {
}

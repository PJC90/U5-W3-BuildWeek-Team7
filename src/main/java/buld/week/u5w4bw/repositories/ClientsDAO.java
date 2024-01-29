package buld.week.u5w4bw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientsDAO extends JpaRepository<buld.week.u5w4bw.Entities.Clients, UUID> {
}

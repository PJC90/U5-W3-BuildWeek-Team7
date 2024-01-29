package buld.week.u5w4bw.repository;

import buld.week.u5w4bw.Entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientsDAO extends JpaRepository<Clients, UUID> {
}

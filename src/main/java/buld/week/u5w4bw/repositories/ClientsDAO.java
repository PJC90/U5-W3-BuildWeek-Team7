package buld.week.u5w4bw.repositories;


import buld.week.u5w4bw.entities.Clients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface ClientsDAO extends JpaRepository<Clients, UUID> {
}
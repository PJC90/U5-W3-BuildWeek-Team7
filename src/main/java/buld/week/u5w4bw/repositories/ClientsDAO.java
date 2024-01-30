package buld.week.u5w4bw.repositories;


import buld.week.u5w4bw.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository

public interface ClientsDAO extends JpaRepository<Clients, UUID> {

    @Query("SELECT c FROM Clients c WHERE c.revenue >= :revenue")
    List<Clients> filterByYearlyRevenue(double revenue);

    @Query("SELECT c FROM Clients c WHERE c.registerDate >= :data")
    List<Clients> filterByRegisterDate(@Param("data") LocalDate data);

    @Query("SELECT f FROM Cliente f WHERE f.lastcontactDate >= :data")
    List<Clients> filterBylastContactDate(@Param("data") LocalDate data);

    @Query("SELECT f FROM Clients f WHERE f.contactName LIKE :name/**")
    List<Clients> filterByContactName(@Param("name") String contactName);



}
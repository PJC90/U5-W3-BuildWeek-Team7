package buld.week.u5w4bw.repositories;

import buld.week.u5w4bw.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, UUID> {

    @Query("SELECT i FROM Invoice i WHERE i.client.clientId= :id")
    List<Invoice> filterByClient(@Param("id") UUID id);

    @Query("SELECT i FROM Invoice i WHERE i.statoFattura= :stato")
    List<Invoice> filterByState(@Param("stato")String stato);

    @Query("SELECT i FROM Invoice i WHERE i.date= :data")
    List<Invoice> filterByDate(@Param("data")LocalDate data);

    @Query("SELECT i FROM Invoice i WHERE i.imports BETWEEN :min AND :max")
    List<Invoice> filterByImports(@Param("min")double min,@Param("max")double max);
}

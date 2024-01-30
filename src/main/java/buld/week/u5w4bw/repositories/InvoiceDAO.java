package buld.week.u5w4bw.repositories;

import buld.week.u5w4bw.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, UUID> {

    @Query("SELECT i.statusList FROM Invoice i")
    List<String> getStatusList();

}

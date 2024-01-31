package buld.week.u5w4bw.repositories;

import buld.week.u5w4bw.entities.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceStatusDAO extends JpaRepository<InvoiceStatus, Long> {
    @Query("SELECT i.statusList FROM InvoiceStatus i")
    List<String> getStatusList();
}

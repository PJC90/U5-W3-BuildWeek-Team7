package buld.week.u5w4bw.repositories;

import buld.week.u5w4bw.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProvinceDAO extends JpaRepository<Province, Long> {
}

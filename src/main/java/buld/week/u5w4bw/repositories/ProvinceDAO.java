package buld.week.u5w4bw.repositories;

import buld.week.u5w4bw.entities.Comune;
import buld.week.u5w4bw.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProvinceDAO extends JpaRepository<Province, Long> {
    Province findByProvinceCode(int code);


    @Query("SELECT p.comunesList FROM Province p WHERE p.provinceCode = :prov_code")
    List<Comune> getComuneList(@Param("prov_code") int prov_code);
}

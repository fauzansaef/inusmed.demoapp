package id.inusmed.demoapp.sawit.infrastructure;

import id.inusmed.demoapp.sawit.domain.entity.TblLaporan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblLaporanRepository extends JpaRepository<TblLaporan, Long> {
}

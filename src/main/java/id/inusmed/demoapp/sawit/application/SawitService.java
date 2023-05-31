package id.inusmed.demoapp.sawit.application;


import id.inusmed.demoapp.sawit.domain.dto.LaporanDto;
import id.inusmed.demoapp.sawit.domain.entity.TblLaporan;
import id.inusmed.demoapp.utility.dto.MessageResponse;

import java.util.List;

public interface SawitService {


    List<TblLaporan> getAllLaporan();

    TblLaporan getLaporanById(Long id);

    MessageResponse simpanLaporan(LaporanDto laporanDto);

    MessageResponse updateLaporan(Long id, LaporanDto laporanDto);

    MessageResponse deleteLaporan(Long id);

}

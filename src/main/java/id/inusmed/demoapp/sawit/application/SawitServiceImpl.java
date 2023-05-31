package id.inusmed.demoapp.sawit.application;

import id.inusmed.demoapp.sawit.domain.dto.LaporanDto;
import id.inusmed.demoapp.sawit.domain.entity.TblLaporan;
import id.inusmed.demoapp.sawit.infrastructure.TblLaporanRepository;
import id.inusmed.demoapp.utility.dto.MessageResponse;
import id.inusmed.demoapp.utility.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SawitServiceImpl implements SawitService {

    private final TblLaporanRepository tblLaporanRepository;

    @Autowired
    public SawitServiceImpl(TblLaporanRepository tblLaporanRepository) {
        this.tblLaporanRepository = tblLaporanRepository;
    }

    @Override
    public List<TblLaporan> getAllLaporan() {
        return tblLaporanRepository.findAll();
    }

    @Override
    public TblLaporan getLaporanById(Long id) {
        return tblLaporanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(TblLaporan.class, "id", id.toString()));
    }

    @Override
    public MessageResponse simpanLaporan(LaporanDto laporanDto) {
        TblLaporan tblLaporan = new TblLaporan();
        tblLaporan.setPetugas(laporanDto.getPetugas());
        tblLaporan.setHarga(laporanDto.getHarga());
        tblLaporan.setJumlahBarang(laporanDto.getJumlahBarang());
        tblLaporan.setCreatedAt(LocalDateTime.now());
        tblLaporan.setUpdatedAt(LocalDateTime.now());
        tblLaporanRepository.save(tblLaporan);
        return new MessageResponse("Data berhasil disimpan", HttpStatus.ACCEPTED);
    }

    @Override
    public MessageResponse updateLaporan(Long id, LaporanDto laporanDto) {
        TblLaporan tblLaporan = getLaporanById(id);
        tblLaporan.setHarga(laporanDto.getHarga());
        tblLaporan.setJumlahBarang(laporanDto.getJumlahBarang());
        tblLaporan.setUpdatedAt(LocalDateTime.now());
        tblLaporanRepository.save(tblLaporan);
        return new MessageResponse("Data berhasil diupdate", HttpStatus.ACCEPTED);
    }

    @Override
    public MessageResponse deleteLaporan(Long id) {
        if (tblLaporanRepository.findById(id).isPresent()) {
            tblLaporanRepository.deleteById(id);
            return new MessageResponse("Data berhasil dihapus", HttpStatus.ACCEPTED);
        } else {
            throw new ResourceNotFoundException(TblLaporan.class, "id", id.toString());
        }

    }
}

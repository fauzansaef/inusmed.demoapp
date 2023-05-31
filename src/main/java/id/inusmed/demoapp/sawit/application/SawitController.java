package id.inusmed.demoapp.sawit.application;

import id.inusmed.demoapp.sawit.domain.dto.LaporanDto;
import id.inusmed.demoapp.sawit.domain.entity.TblLaporan;
import id.inusmed.demoapp.utility.dto.MessageResponse;
import id.inusmed.demoapp.utility.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/laporans")
@Tag(name = "Sawit", description = "API Transaction Sawit")
public class SawitController {

    private final SawitService sawitService;

    @Autowired
    public SawitController(SawitService sawitService) {
        this.sawitService = sawitService;
    }

    @GetMapping("")
    public ResponseEntity<List<TblLaporan>> getAllLaporan() {
        return new ResponseEntity<>(sawitService.getAllLaporan(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TblLaporan> getLaporanById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(sawitService.getLaporanById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<MessageResponse> simpanLaporan(@RequestBody @Valid LaporanDto laporanDto) {
        return new ResponseEntity<>(sawitService.simpanLaporan(laporanDto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updateLaporan(@PathVariable(name = "id") Long id, @RequestBody @Valid LaporanDto laporanDto) {
        return new ResponseEntity<>(sawitService.updateLaporan(id, laporanDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteLaporan(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(sawitService.deleteLaporan(id), HttpStatus.ACCEPTED);
    }


}

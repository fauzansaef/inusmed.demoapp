package id.inusmed.demoapp.sawit.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public final class LaporanDto {

    @NotNull
    private Integer harga;

    @NotNull
    private Integer jumlahBarang;

    @NotNull
    @NotEmpty
    private String petugas;

}

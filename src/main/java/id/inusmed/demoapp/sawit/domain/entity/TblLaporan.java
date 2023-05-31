package id.inusmed.demoapp.sawit.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "tbl_laporan")
@Data
public class TblLaporan {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "harga")
    private Integer harga;

    @Column(name = "jumlah_barang")
    private Integer jumlahBarang;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "petugas")
    private String petugas;

}

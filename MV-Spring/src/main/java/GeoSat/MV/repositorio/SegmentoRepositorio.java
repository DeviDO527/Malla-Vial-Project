package GeoSat.MV.repositorio;

import GeoSat.MV.modelo.Segmento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegmentoRepositorio extends JpaRepository<Segmento, Long> {
}
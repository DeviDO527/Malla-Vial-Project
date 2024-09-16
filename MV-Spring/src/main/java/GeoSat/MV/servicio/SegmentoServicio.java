package GeoSat.MV.servicio;

import GeoSat.MV.modelo.Segmento;
import GeoSat.MV.repositorio.SegmentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SegmentoServicio implements ISegmentoServicio{

    @Autowired
    private SegmentoRepositorio segmentoRepositorio;
    @Override
    public List<Segmento> listarSegmentos() {
        return segmentoRepositorio.findAll();
    }

    @Override
    public Segmento buscarSegmentoPorId(Long idSegmento) {
        Segmento segmento = segmentoRepositorio.findById(idSegmento).orElse(null);
        return segmento;
    }

    @Override
    public Segmento guardarSegmento(Segmento segmento) {
        return segmentoRepositorio.save(segmento);
    }

    @Override
    public void eliminarSegmento(Segmento segmento) {
        segmentoRepositorio.delete(segmento);
    }
}

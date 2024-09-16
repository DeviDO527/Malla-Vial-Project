package GeoSat.MV.servicio;

import GeoSat.MV.modelo.Segmento;

import java.util.List;

public interface ISegmentoServicio {
    public List<Segmento> listarSegmentos();
    public Segmento buscarSegmentoPorId(Long idSegmento);
    public Segmento guardarSegmento(Segmento segmento);
    public void eliminarSegmento(Segmento segmento);
}

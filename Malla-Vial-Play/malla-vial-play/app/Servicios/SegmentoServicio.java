package servicios;
////
////import repositorios.SegmentoRepositorio;
////import modelos.Segmento;
////
////import javax.inject.Inject;
////import java.sql.SQLException;
////import java.util.List;
////import java.util.Optional;
////
////public class SegmentoServicio {
////    private static SegmentoRepositorio segmentoRepositorio;
////    @Inject
////    public SegmentoServicio(SegmentoRepositorio segmentoRepositorio) {
////        this.segmentoRepositorio = segmentoRepositorio;
////    }
////    public static boolean actualizarSegmento(Long idSegmento, Segmento segmento) {
////        Optional<Segmento> existente = (Optional<Segmento>) segmentoRepositorio.buscarPorId(idSegmento);
////        if(existente.isPresent()) {
////            segmentoRepositorio.guardar(segmento);
////            return true;
////        }else{
////            return false;
////        }
////    }
////
////    public Segmento buscarSegmento(Long idSegmento) {
////        return (Segmento) segmentoRepositorio.buscarPorId(idSegmento);
////    }
////
////    public List<Segmento>obtenerSegmentos() throws SQLException {
////        return SegmentoRepositorio.buscarTodos();
////    }
////    public void crearSegmento(Segmento segmento) {
////        segmentoRepositorio.guardar(segmento);
////    }
////    public void eliminarSegmento(Long idSegmento) {
////        segmentoRepositorio.eliminar(idSegmento);
////    }
////}
////==========================================================================

import modelos.Segmento;
import repositorios.SegmentoRepositorio;

import java.util.List;

public class SegmentoServicio {
    private final SegmentoRepositorio segmentoRepositorio;

    public SegmentoServicio() {
        this.segmentoRepositorio = new SegmentoRepositorio();
    }

    public List<Segmento> findAll() {
        return segmentoRepositorio.findAll();
    }

    public Segmento findById(Long id) {
        return segmentoRepositorio.findById(id);
    }

    public Segmento create(String direccion, String longitud) {
        return segmentoRepositorio.create(direccion, longitud);
    }

    public Segmento update(Long id, String direccion, String longitud) {
        return segmentoRepositorio.update(id, direccion, longitud);
    }

    public boolean delete(Long id) {
        return segmentoRepositorio.delete(id);
    }
}


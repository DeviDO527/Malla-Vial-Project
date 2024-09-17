package GeoSat.MV.controlador;

import GeoSat.MV.exepcion.RecursoNoEncontradoExepcion;
import GeoSat.MV.modelo.Segmento;
import GeoSat.MV.servicio.ISegmentoServicio;
import GeoSat.MV.servicio.SegmentoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("MV-app")
@CrossOrigin(value = "http://localhost:3000")
public class SegmentoControlador {
    private static final Logger logger = LoggerFactory.getLogger(SegmentoControlador.class);
    @Autowired
    private ISegmentoServicio segmentoServicio;

    @GetMapping("/segmentos")

    public List<Segmento> getSegmentos() {
        var segmentos = segmentoServicio.listarSegmentos();
        segmentos.forEach(segmento -> logger.info(segmento.toString()));
        return segmentos;
    }

    @PostMapping("/segmentos")

    public Segmento setSegmento(@RequestBody Segmento segmento) {
        logger.info(segmento.toString());
        return segmentoServicio.guardarSegmento(segmento);
    }

    @GetMapping("/segmentos/{id}")

    public ResponseEntity<Segmento> getSegmentoById(@PathVariable long id) {
        Segmento segmento = segmentoServicio.buscarSegmentoPorId(id);
        if(segmento == null) {
            throw new RecursoNoEncontradoExepcion("No se encontró el segmento de id: " + id);
        }else{
            return ResponseEntity.ok(segmento);
        }
    }

    @PutMapping("segmentos/{id}")

    public ResponseEntity<Segmento> actualizarSegmento(@RequestBody Segmento segmentoRecibido, @PathVariable long id) {
        Segmento segmento = segmentoServicio.buscarSegmentoPorId(id);
        if (segmento == null) {
            throw new RecursoNoEncontradoExepcion("Id no existente");

        }else{
            segmento.setDireccion(segmentoRecibido.getDireccion());
            segmento.setLongitud(segmentoRecibido.getLongitud());
            segmentoServicio.guardarSegmento(segmento);
        }
        return ResponseEntity.ok(segmento);
    }

    @DeleteMapping("/segmentos/{id}")

    public ResponseEntity<Map<String,Boolean>> eliminarSegmento(@PathVariable long id) {
        Segmento segmento = segmentoServicio.buscarSegmentoPorId(id);
        if(segmento == null) {
            throw new RecursoNoEncontradoExepcion("Id no existente");
        }else{
            segmentoServicio.eliminarSegmento(segmento);
        }
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",true);
        return ResponseEntity.ok(respuesta);
    }
}

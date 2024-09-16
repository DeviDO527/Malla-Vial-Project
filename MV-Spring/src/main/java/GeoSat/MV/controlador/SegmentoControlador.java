package GeoSat.MV.controlador;

import GeoSat.MV.modelo.Segmento;
import GeoSat.MV.servicio.ISegmentoServicio;
import GeoSat.MV.servicio.SegmentoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}

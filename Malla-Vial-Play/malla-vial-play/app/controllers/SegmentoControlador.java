package controllers;

//import play.mvc.*;
//import repositorios.SegmentoRepositorio;
//import modelos.Segmento;
//import javax.inject.Inject;
//import com.fasterxml.jackson.databind.JsonNode;
//import java.util.List;
//import play.libs.Json;
//
//public class SegmentoControlador extends Controller {
//
//    private final SegmentoRepositorio segmentoRepositorio;
//
//    @Inject
//    public SegmentoControlador(SegmentoRepositorio segmentoRepositorio) {
//        this.segmentoRepositorio = segmentoRepositorio;
//    }
//
//    // Método para obtener todos los segmentos
//    public Result getSegmentos() {
//        List<Segmento> segmentos = segmentoRepositorio.buscarTodos();
//        return ok(Json.toJson(segmentos));
//    }
//
//    // Método para crear un nuevo segmento
//    public Result crearSegmento(Http.Request request) {
//        JsonNode json = request.body().asJson();
//        String direccion = json.get("direccion").asText();
//        Double longitud = json.get("longitud").asDouble();
//        Segmento segmento = new Segmento(null, direccion, longitud);
//        segmentoRepositorio.guardar(segmento);
//        return ok("Segmento creado con éxito");
//    }
//
//    // Método para actualizar un segmento existente
//    public Result actualizarSegmento(Http.Request request, Long idSegmento) {
//        JsonNode json = request.body().asJson();
//        String direccion = json.get("direccion").asText();
//        Double longitud = json.get("longitud").asDouble();
//        Segmento segmento = new Segmento(idSegmento, direccion, longitud);
//        segmentoRepositorio.actualizar(segmento);
//        return ok("Segmento actualizado con éxito");
//    }
//
//    // Método para eliminar un segmento por su ID
//    public Result eliminarSegmento(Long idSegmento) {
//        segmentoRepositorio.eliminar(idSegmento);
//        return ok("Segmento eliminado con éxito");
//    }
//}


import modelos.Segmento;
import servicios.SegmentoServicio;

import java.util.List;

public class SegmentoControlador {
    private final SegmentoServicio segmentoServicio;

    public SegmentoControlador() {
        this.segmentoServicio = new SegmentoServicio();
    }

    public List<Segmento> getSegmentos() {
        return segmentoServicio.findAll();
    }

    public Segmento createSegmento(String direccion, String longitud) {
        return segmentoServicio.create(direccion, longitud);
    }

    public Segmento updateSegmento(Long id, String direccion, String longitud) {
        return segmentoServicio.update(id, direccion, longitud);
    }

    public boolean deleteSegmento(Long id) {
        return segmentoServicio.delete(id);
    }
}





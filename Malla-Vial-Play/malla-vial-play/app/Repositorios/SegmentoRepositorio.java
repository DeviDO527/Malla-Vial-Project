//package repositories;
//
//import models.Segmento;
//import io.ebean.Ebean;
//import io.ebean.Query;
//import java.util.List;
//
//public class SegmentoRepositorio {
//
//    // Obtener todos los segmentos
//    public List<Segmento> buscarTodos() {
//        Query<Segmento> query = Ebean.find(Segmento.class);
//        return query.findList();
//    }
//
//    // Crear un nuevo segmento
//    public void guardar(Segmento segmento) {
//        segmento.save();
//    }
//
//    // Buscar un segmento por ID
//    public Segmento buscarPorId(Long idSegmento) {
//        return Ebean.find(Segmento.class, idSegmento);
//    }
//
//    // Actualizar un segmento existente
//    public void actualizar(Segmento segmento) {
//        segmento.update();
//    }
//
//    // Eliminar un segmento por ID
//    public void eliminar(Long idSegmento) {
//        Segmento segmento = buscarPorId(idSegmento);
//        if (segmento != null) {
//            segmento.delete();
//        }
//    }
//}
package repositorios;

//import modelos.Segmento;
//import play.db.Database;
//import play.db.Databases;
//import play.mvc.Http;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SegmentoRepositorio {
//
//    private final Database db;
//
//    public SegmentoRepositorio(Database db) {
//        this.db = db;
//    }
//
//    public List<Segmento> buscarTodos() {
//        List<Segmento> segmentos = new ArrayList<>();
//        try (Connection conn = db.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM segmento")) {
//
//            while (rs.next()) {
//                Long id = rs.getLong("id");
//                String direccion = rs.getString("direccion");
//                Double longitud = rs.getDouble("longitud");
//                segmentos.add(new Segmento(id, direccion, longitud));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return segmentos;
//    }
//
//    public void guardar(Segmento segmento) {
//        String sql = "INSERT INTO segmento (direccion, longitud) VALUES (?, ?)";
//        try (Connection conn = db.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, segmento.getDireccion());
//            pstmt.setDouble(2, segmento.getLongitud());
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Segmento buscarPorId(Long id) {
//        String sql = "SELECT * FROM segmento WHERE id = ?";
//        try (Connection conn = db.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setLong(1, id);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    String direccion = rs.getString("direccion");
//                    Double longitud = rs.getDouble("longitud");
//                    return new Segmento(id, direccion, longitud);
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void actualizar(Segmento segmento) {
//
//        String sql = "UPDATE segmento SET direccion = ?, longitud = ? WHERE id = ?";
//        try (Connection conn = db.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, segmento.getDireccion());
//            pstmt.setDouble(2, segmento.getLongitud());
//            pstmt.setLong(3, segmento.getIdSegmento());
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void eliminar(Long id) {
//        String sql = "DELETE FROM segmento WHERE id = ?";
//        try (Connection conn = db.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setLong(1, id);
//            pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

import modelos.Segmento;

import java.util.ArrayList;
import java.util.List;

public class SegmentoRepositorio {
    private List<Segmento> segmentos;
    private long nextId; // Para simular el auto incremento

    public SegmentoRepositorio() {
        this.segmentos = new ArrayList<>();
        this.nextId = 1L; // Comenzar con ID 1
    }

    // Método para agregar un nuevo segmento (simulando la inserción)
    public Segmento create(String direccion, String longitud) {
        Segmento nuevoSegmento = new Segmento(nextId++, direccion, longitud);
        segmentos.add(nuevoSegmento);
        return nuevoSegmento; // Devuelve el segmento creado
    }

    // Método para obtener todos los segmentos
    public List<Segmento> findAll() {
        return segmentos;
    }

    // Método para obtener un segmento por ID
    public Segmento findById(Long id) {
        return segmentos.stream()
                .filter(seg -> seg.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Método para actualizar un segmento existente
    public Segmento update(Long id, String direccion, String longitud) {
        Segmento segmento = findById(id);
        if (segmento != null) {
            segmento.setDireccion(direccion);
            segmento.setLongitud(longitud);
            return segmento; // Devuelve el segmento actualizado
        }
        return null; // Si no se encuentra el segmento
    }

    // Método para eliminar un segmento por ID
    public boolean delete(Long id) {
        Segmento segmento = findById(id);
        if (segmento != null) {
            segmentos.remove(segmento);
            return true; // El segmento fue eliminado
        }
        return false; // No se encontró el segmento
    }
}

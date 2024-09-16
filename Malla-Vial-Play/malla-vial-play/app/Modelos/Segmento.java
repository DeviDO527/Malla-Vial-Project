package modelos;

//public class Segmento {
//   private long idSegmento;
//   private String direccion;
//   private double longitud;
//
//   public Segmento(Long idSegmento, String direccion, double longitud){
//       this.idSegmento = idSegmento;
//       this.direccion = direccion;
//       this.longitud = longitud;
//   }
//   public long getIdSegmento() {
//       return idSegmento;
//   }
//
//   public void setIdSegmento(long idSegmento) {
//       this.idSegmento = idSegmento;
//   }
//   public String getDireccion() {
//       return direccion;
//   }
//   public void setDireccion(String direccion) {
//       this.direccion = direccion;
//   }
//   public double getLongitud() {
//       return longitud;
//   }
//   public void setLongitud(double longitud) {
//       this.longitud = longitud;
//   }
//}
package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Segmento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private Double longitud;

    // Constructor vacío
    public Segmento() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}

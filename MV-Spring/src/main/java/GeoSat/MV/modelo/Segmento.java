package GeoSat.MV.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Segmento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSegmento;
    String direccion;
    String longitud;
    Boolean activo;
    Date actualiza;
}

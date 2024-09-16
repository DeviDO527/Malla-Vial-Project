"use client";
import { useEffect, useState } from "react";


export default function ListadoSegmentos() {
  const urlBase = "http://localhost:8081";
  const [segmentos, setSegmentos] = useState([]); // Hook de estado

  useEffect(() => {
    cargarSegmentos();
  }, []);

  const cargarSegmentos = async () => {
    try {
      const respuesta = await fetch(urlBase + "/MV-app/segmentos");
      const data = await respuesta.json();
      console.log("Cargar segmentos", data);
      setSegmentos(data);
    } catch (error) {
      console.error("Error cargando segmentos", error);
    }
  };

  return (
    <div className="container">
      <div className="container text-center" style={{ margin: "30px" }}>
        <table className="table table-striped table-hover align-middle">
          <thead className="table-dark align-middle">
            <tr>
              <th scope="col">Segmento</th>
              <th scope="col">Dirección</th>
              <th scope="col">Longitud</th>
              <th scope="col">Bordillos</th>
              <th scope="col">Calzadas</th>
            </tr>
          </thead>
          <tbody>
            {
              // Aquí iteramos sobre el arreglo de segmentos
              segmentos.map((segmento, indice) => (
                <tr key={indice}>
                  <th scope="row">{segmento.idSegmento}</th>
                  <td>{segmento.direccion}</td>
                  <td>{segmento.longitud}</td>
                  <td>{segmento.activo}</td>
                  <td>{segmento.actualiza}</td>
                </tr>
              ))
            }
          </tbody>
        </table>
      </div>
    </div>
  );
}

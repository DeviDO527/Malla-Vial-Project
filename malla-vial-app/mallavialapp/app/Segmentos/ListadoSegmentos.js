"use client";
import axios from 'axios';
import React, { useEffect,useState } from 'react';
export default function ListadoSegmentos() {
  const  urlBase = "http://localhost:8081"
  const [segmentos, setSegmentos] = useState([]); // Hook de estado

  useEffect(() => {
    cargarSegmentos();
  },[]);
  const cargarSegmentos = async () => {
    const respuesta = await axios.get(urlBase + "/MV-app/segmentos");
    console.log("Cargar segmentos <br>", respuesta.data);
    setSegmentos(respuesta.data);
  }

  return (
    <div className = "conatainer">
      <div className = "container text-center" style = {{margin: "30px"}}>
      </div>
        <table className = "table table-striped table-hover align-midle">
          <thead className = "table-dark align-midle">
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
            // Aqui iteramos sobre el arreglo de segmentos
            segmentos.map((segmento,indice) =>(

              <tr key={indice}>
                <th scope="row">{segmento.idSegmento}</th>
                <td>{segmento.direccion}</td>
                <td>{segmento.longitud}</td>
                <td>{segmento.activo}</td>
                <td>{segmento.actualiza}</td>
              </tr>
            ) )
            }
          </tbody>
        </table>
    </div>
  )
}

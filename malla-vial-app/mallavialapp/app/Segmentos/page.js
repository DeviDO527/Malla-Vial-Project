"use client";
import { useEffect, useState } from "react";
import Navegacion from "../Navegacion/page";
import axios from "axios";


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

  const eliminarSegmento = async (idSegmento) => {
    await axios.delete(`${urlBase}/MV-app/segmentos/${idSegmento}`);
    cargarSegmentos();
  }

  return (
    <div className="container">
      <div className="container text-center mb-3" >
        <table className="table table-striped table-hover mb-3">
          <thead className="table-dark ">
            <tr>
              <th scope="col">Segmento</th>
              <th scope="col">Dirección</th>
              <th scope="col">Longitud</th>
              <th scope="col">Opciones</th>
              <th></th>
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
                  <td className = "text-center">
                    <div className = "text-center" style={{margin: "5px"}}>
                      <a href = {`/EditarSegmento/${segmento.idSegmento}`} className = "btn btn-warning btn-sm me-3" style = {{margin:"3px"}}>Editar</a>
                      <button onClick={()=>eliminarSegmento(segmento.idSegmento)} className = "btn btn-danger btn-sm me-3" style = {{margin: "3px"}}>
                        Eliminar
                      </button>
                    </div>
                  </td>
                </tr>
              ))
            }
            
          </tbody>
        </table>
      </div>
    </div>
  );
}
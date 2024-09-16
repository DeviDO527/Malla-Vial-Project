"use client";
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

export default function AgregarSegmento() {

  let navegacion = useNavigate;

  const [segmento, setSegmento] = useState({
    direccion: "",
    longitud: ""
  }); // Hook de estado

  const{direccion, longitud} = segmento;

  const onInputChange = (e) => {
    setSegmento({...segmento, [e.target.name]: e.target.value});
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    const urlBase = "http://localhost:8081/MV-app/segmentos";
    await axios.post(urlBase, segmento);
    navegacion("/");
  }


  return (
    <div className = "container">
      <div className = "container " style = {{margin: "30px"}}>
        <form onSubmit={(e)=>onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="direccionSegmento" className="form-label">Direción del segmento</label>
            <input type="text" className="form-control" id="direccionSegmento" name = "direccionSegmento" required = {true} value ={direccion} onChange = {(e)=>onInputChange(e)} />
          </div>
          <div className="mb-3">
            <label htmlFor="longitudSegmento" className="form-label" >Longitud del Segmento</label>
            <input type="text" className="form-control" id="longitudSegmento" name = "longitudSegmento" required ={true} value ={longitud} onChange = {(e)=>onInputChange(e)}/>
          </div>
          <div className = "text-center">
            <button type="submit" className="btn btn-warning btn-sm" style={{margin: "20px"}}>Agregar</button>
            <a href = "/" className= "btn btn-danger btn-sm">Volver</a>
          </div>
        </form>
      </div>
    </div>
  )
}

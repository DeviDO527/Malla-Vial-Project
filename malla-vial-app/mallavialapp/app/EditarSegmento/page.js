"use client";
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import Navegacion from '../Navegacion/page';
import axios from 'axios';
import { useRouter } from 'next/router';

export default function EditarSegmento() {

    const urlBase = "http://localhost:8081/MV-app/segmentos";

    const {id} = useParams();
   let  navegacion = useNavigate();

  const [segmento, setSegmento] = useState({
    direccion: "",
    longitud: ""
  }); // Hook de estado

  const{direccion, longitud} = segmento

  useEffect(() => {
    cargarSegmento();
  },[])  

  const cargarSegmento = async () => {
    const respuesta = await axios.get(`${urlBase}/${id}`);
    setSegmento(respuesta.data);
  }
  
  const onInputChange = (e) => {
    setSegmento({...segmento, [e.target.name]: e.target.value});
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`${urlBase}/${id}`, segmento);
    navegacion("/");
  }

  return (
    <div className = "container">
      <Navegacion/>
      <div className = "mb-3" style = {{margin: "30px"}}>
        <form onSubmit={(e)=>onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="direccionSegmento" className="form-label">Direción del segmento</label>
            <input type="text" className="form-control" id="direccion" name = "direccion" required = {true} Value ={direccion} onChange = {(e)=>onInputChange(e)} />
          </div>
          <div className="mb-3">
            <label htmlFor="longitudSegmento" className="form-label" >Longitud del Segmento</label>
            <input type="text" className="form-control" id="longitud" name = "longitud" value = {longitud} onChange = {(e)=>onInputChange(e)}/>
          </div>
          <div className = "text-center">
            
            <button type="submit" className="btn btn-warning btn-sm" style={{margin: "20px"}}>Guardar</button>
            <a href = "http:localhost:3000/" className= "btn btn-danger btn-sm">Volver</a>
          </div>
        </form>
      </div>
    </div>
  )
}
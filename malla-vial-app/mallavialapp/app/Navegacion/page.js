"use client";
import { Link } from 'react-router-dom';

export default function Navegacion() {
  return (
    <div className = "container">
        <div className="mb-3" >
            <nav className="navbar navbar-expand-lg navbar-dark bg-success ">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/">Sistema Malla Vial</a>
                    <button 
                        className="navbar-toggler" 
                        type="button" 
                        data-bs-toggle="collapse" 
                        data-bs-target="#navbarNavAltMarkup" 
                        aria-controls="navbarNavAltMarkup" 
                        aria-expanded="false" 
                        aria-label="Toggle navigation"
                    >
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div className="navbar-nav">
                            <a className="nav-link active" aria-current="page" href="/">Segmentos</a>
                            <a className="nav-link" href="#">Bordillos</a>
                            <a className="nav-link" href = "#" >Calzadas</a>
                            <a className="nav-link" href = "/AgregarSegmento">Agregar Segmento</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </div>
  )
}
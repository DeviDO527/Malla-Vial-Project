"use client"

import React, { useEffect, useState } from 'react'
import { useRouter } from 'next/navigation'
import axios from 'axios'
import Navegacion from '@/app/Navegacion/page'

export default function EditarSegmento({ params }) {
  const router = useRouter()
  const { id } = params
  const urlBase = "http://localhost:8081/MV-app/segmentos"

  const [segmento, setSegmento] = useState({
    direccion: "",
    longitud: ""
  })

  const { direccion, longitud } = segmento

  useEffect(() => {
    cargarSegmento()
  }, [id])

  const cargarSegmento = async () => {
    try {
      const respuesta = await axios.get(`${urlBase}/${id}`)
      setSegmento(respuesta.data)
    } catch (error) {
      console.error("Error al cargar el segmento:", error)
      // Aquí puedes manejar el error, por ejemplo, mostrando un mensaje al usuario
    }
  }

  const onInputChange = (e) => {
    setSegmento({ ...segmento, [e.target.name]: e.target.value })
  }

  const onSubmit = async (e) => {
    e.preventDefault()
    try {
      await axios.put(`${urlBase}/${id}`, segmento)
      router.push('/')
    } catch (error) {
      console.error("Error al actualizar el segmento:", error)
      // Aquí puedes manejar el error, por ejemplo, mostrando un mensaje al usuario
    }
  }

  return (
    <div className="container">
      <Navegacion />
      <div className="mb-3" style={{ margin: "30px" }}>
      <h2 className="text-2xl font-bold mb-4">Editar Segmento Actual</h2>
        <form onSubmit={onSubmit}>
          <div className="mb-3">
            <label htmlFor="direccion" className="form-label">Dirección del segmento</label>
            <input
              type="text"
              className="form-control"
              id="direccion"
              name="direccion"
              required={true}
              value={direccion}
              onChange={onInputChange}
            />
          </div>
          <div className="mb-3">
            <label htmlFor="longitud" className="form-label">Longitud del Segmento</label>
            <input
              type="text"
              className="form-control"
              id="longitud"
              name="longitud"
              value={longitud}
              onChange={onInputChange}
            />
          </div>
          <div className="text-center">
            <button type="submit" className="btn btn-primary btn-sm" style={{ margin: "20px" }}>Guardar</button>
            <button onClick={() => router.push('/')} className="btn btn-danger btn-sm">Cancelar</button>
          </div>
        </form>
      </div>
    </div>
  )
}
// import Image from "next/image";
// import styles from "./page.module.css";

import Navegacion from "./Nav/Navegacion";
import ListadoSegmentos from "./Segmentos/ListadoSegmentos";

export default function Home() {
  return (
    <div className = "container">
      <Navegacion/>
      <ListadoSegmentos />
    </div>
  );
}

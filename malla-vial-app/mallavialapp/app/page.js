import Navegacion from "./Navegacion/page";
import ListadoSegmentos from "./Segmentos/page";

export default function Home() {
  return (
    <div className = "container align-middle">
    <Navegacion/>
    <ListadoSegmentos/>
    </div>
   
  );
}
package ar.edu.utn.frba.dds.qmp4;

import ar.edu.utn.frba.dds.qmp3.Atuendo;
import ar.edu.utn.frba.dds.qmp3.Guardarropas;
import java.util.List;


public class AsesorDeImagen {
  private ServicioMeteorologico servicioMeteorologico;

  public AsesorDeImagen(ServicioMeteorologico servicioMeteorologico) {
    this.servicioMeteorologico = servicioMeteorologico;
  }

  public Atuendo sugerirAtuendo(String direccion, Guardarropas guardarropas) {
    EstadoDelTiempo estadoDelTiempo =
        this.servicioMeteorologico.obtenerCondicionesClimaticas(direccion);
    List<Atuendo> combinaciones = guardarropas.todasLasPosiblesCombinaciones();
    return combinaciones
        .stream()
        .filter(combinacion -> combinacion.aptaParaTemperatura(estadoDelTiempo.temperatura()))
        .filter(combinacion -> combinacion.aptaParaHumedad(estadoDelTiempo.humedad()))
        .findFirst()
        .get();

  }
}
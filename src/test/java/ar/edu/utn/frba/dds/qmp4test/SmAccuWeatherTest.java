package ar.edu.utn.frba.dds.qmp4test;

import ar.edu.utn.frba.dds.qmp4.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SmAccuWeatherTest {

  @Test
  public void obtenerCondicionesClimaticasDevuelveEstadoConDatos() {
    AccuWeatherAPI api = new AccuWeatherAPI();
    SmAccuWeather servicio = new SmAccuWeather(api, Duration.ofMinutes(30));

    EstadoDelTiempo estado = servicio.obtenerCondicionesClimaticas("Buenos Aires");

    assertNotNull(estado);
    assertTrue(estado.temperatura() > 0);
    assertNotNull(estado.humedad());
  }

}
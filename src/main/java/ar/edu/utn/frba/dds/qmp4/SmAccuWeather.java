package ar.edu.utn.frba.dds.qmp4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SmAccuWeather implements ServicioMeteorologico {

  private final AccuWeatherAPI api;
  private final Duration periodoDeValidez;
  private Map<String, RespuestaMeteorologica> ultimasRespuestas;

  public SmAccuWeather(AccuWeatherAPI api, Duration periodoDeValidez) {
    this.api = api;
    this.periodoDeValidez = periodoDeValidez;
    this.ultimasRespuestas = new HashMap<>();
  }

  public EstadoDelTiempo obtenerCondicionesClimaticas(String direccion) {
    if (!this.ultimasRespuestas.containsKey(direccion)
        || this.ultimasRespuestas.get(direccion).expiro()) {
      ultimasRespuestas.put(direccion, this.consultarApi(direccion));
    }
    return this.ultimasRespuestas.get(direccion).estadoDelTiempo();
  }

  private LocalDateTime proximaExpiracion() {
    return LocalDateTime.now().plus(this.periodoDeValidez);
  }

  private RespuestaMeteorologica consultarApi(String direccion) {
    var weather = this.api.getWeather(direccion).get(0);

    Map<String, Object> temperatureMap = (Map<String, Object>) weather.get("Temperature");
    int temperaturaFahrenheit = (int) temperatureMap.get("Value");

    double humedadFicticia = 0.5;
    return new RespuestaMeteorologica(
        new EstadoDelTiempo(
            temperaturaFahrenheit,
            humedadFicticia > 0.8 ? Humedad.ALTA : Humedad.BAJA),
        this.proximaExpiracion()
    );
  }
}
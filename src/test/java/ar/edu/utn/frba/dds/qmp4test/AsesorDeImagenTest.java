package ar.edu.utn.frba.dds.qmp4test;

import ar.edu.utn.frba.dds.qmp1.*;
import ar.edu.utn.frba.dds.qmp2.Trama;
import ar.edu.utn.frba.dds.qmp3.Atuendo;
import ar.edu.utn.frba.dds.qmp3.Guardarropas;
import ar.edu.utn.frba.dds.qmp4.AccuWeatherAPI;
import ar.edu.utn.frba.dds.qmp4.AsesorDeImagen;
import ar.edu.utn.frba.dds.qmp4.EstadoDelTiempo;
import ar.edu.utn.frba.dds.qmp4.Humedad;
import ar.edu.utn.frba.dds.qmp4.SmAccuWeather;
import ar.edu.utn.frba.dds.qmp4.ServicioMeteorologico;
import java.time.Duration;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AsesorDeImagenTest {

  @Test
  public void sugerirAtuendoDevuelveUnaCombinacionValida() {
    Prenda superior = new Prenda(
        TipoPrenda.REMERA_MANGAS_CORTAS,
        Material.ALGODON,
        new Color(100, 100, 100),
        null,
        Trama.LISA
    );

    Prenda inferior = new Prenda(
        TipoPrenda.PANTALON,
        Material.JEAN,
        new Color(50, 50, 50),
        null,
        Trama.LISA
    );

    Prenda calzado = new Prenda(
        TipoPrenda.ZAPATILLAS,
        Material.CUERO,
        new Color(30, 30, 30),
        null,
        Trama.LISA
    );

    Atuendo atuendo = new Atuendo(superior, inferior, calzado);
    SmAccuWeather servicioMeteorologico = new SmAccuWeather(new AccuWeatherAPI(), Duration.ofMinutes(30));
    Guardarropas guardarropas = new Guardarropas(
        List.of(superior),
        List.of(inferior),
        List.of(calzado)
    );

    AsesorDeImagen asesor = new AsesorDeImagen(servicioMeteorologico);
    Atuendo sugerido = asesor.sugerirAtuendo("Buenos Aires", guardarropas);

    assertNotNull(sugerido);
    assertEquals(superior, sugerido.getPrendaSuperior());
    assertEquals(inferior, sugerido.getPrendaInferior());
    assertEquals(calzado, sugerido.getCalzado());
  }

  @Test
  public void noDevuelveAtuendoSiNingunoEsAptoPorTemperaturaOHumedad() {
    // Prendas reales
    Prenda superior = new Prenda(
        TipoPrenda.REMERA_MANGAS_LARGAS, // Asumamos tipo cualquiera
        Material.ALGODON,
        new Color(100, 100, 100),
        null,
        Trama.LISA
    );

    Prenda inferior = new Prenda(
        TipoPrenda.PANTALON,
        Material.JEAN,
        new Color(50, 50, 50),
        null,
        Trama.LISA
    );

    Prenda calzado = new Prenda(
        TipoPrenda.ZAPATILLAS,
        Material.CUERO,
        new Color(30, 30, 30),
        null,
        Trama.LISA
    );

    Guardarropas guardarropas = new Guardarropas(
        List.of(superior),
        List.of(inferior),
        List.of(calzado)
    );

    // Servicio meteorologico custom para simular clima frío y humedad alta (no apto)
    ServicioMeteorologico servicioMeteorologico = new ServicioMeteorologico() {
      @Override
      public EstadoDelTiempo obtenerCondicionesClimaticas(String direccion) {
        // Temperatura 5 (no apto porque aptaParaTemperatura > 10)
        // Humedad ALTA (no apto porque aptaParaHumedad == BAJA)
        return new EstadoDelTiempo(5, Humedad.ALTA);
      }
    };

    AsesorDeImagen asesor = new AsesorDeImagen(servicioMeteorologico);

    // Testeo que lance NoSuchElementException porque no hay atuendo apto
    assertThrows(java.util.NoSuchElementException.class, () -> {
      asesor.sugerirAtuendo("Buenos Aires", guardarropas);
    });
  }
}

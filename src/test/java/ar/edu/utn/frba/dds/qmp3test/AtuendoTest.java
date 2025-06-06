package ar.edu.utn.frba.dds.qmp3test;

import ar.edu.utn.frba.dds.qmp1.*;
import ar.edu.utn.frba.dds.qmp2.Trama;
import ar.edu.utn.frba.dds.qmp3.Atuendo;
import ar.edu.utn.frba.dds.qmp4.Humedad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtuendoTest {

  @Test
  public void seCreaUnAtuendoConPrendasCorrectas() {
    Prenda superior = new Prenda(
        TipoPrenda.REMERA_MANGAS_LARGAS,
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
        Trama.CUADROS
    );
    Prenda calzado = new Prenda(
        TipoPrenda.ZAPATILLAS,
        Material.CUERO,
        new Color(30, 30, 30),
        null,
        Trama.LISA
    );

    Atuendo atuendo = new Atuendo(superior, inferior, calzado);

    // Suponiendo que agregás getters para acceder a las prendas
    assertSame(superior, atuendo.getPrendaSuperior());
    assertSame(inferior, atuendo.getPrendaInferior());
    assertSame(calzado, atuendo.getCalzado());
  }

  @Test
  public void atuendoEsAptoParaCualquierHumedad() {
    Humedad humedadAlta = Humedad.ALTA;
    Humedad humedadBaja = Humedad.BAJA;

    Atuendo atuendo = crearAtuendoDummy();

    assertFalse(atuendo.aptaParaHumedad(humedadAlta));
    assertTrue(atuendo.aptaParaHumedad(humedadBaja));
  }

  @Test
  public void atuendoEsAptoParaCualquierTemperatura() {
    Atuendo atuendo = crearAtuendoDummy();

    assertFalse(atuendo.aptaParaTemperatura(10));
    assertTrue(atuendo.aptaParaTemperatura(15));
    assertTrue(atuendo.aptaParaTemperatura(35));
  }

  private Atuendo crearAtuendoDummy() {
    return new Atuendo(
        new Prenda(TipoPrenda.REMERA_MANGAS_LARGAS, Material.ALGODON, new Color(10, 10, 10), null, null),
        new Prenda(TipoPrenda.PANTALON, Material.JEAN, new Color(20, 20, 20), null, null),
        new Prenda(TipoPrenda.ZAPATILLAS, Material.CUERO, new Color(30, 30, 30), null, null)
    );
  }
}
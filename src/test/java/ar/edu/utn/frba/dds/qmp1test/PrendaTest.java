package ar.edu.utn.frba.dds.qmp1test;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.utn.frba.dds.qmp1.Categoria;
import ar.edu.utn.frba.dds.qmp1.Color;
import ar.edu.utn.frba.dds.qmp1.Material;
import ar.edu.utn.frba.dds.qmp1.Prenda;
import ar.edu.utn.frba.dds.qmp1.TipoPrenda;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frba.dds.qmp2.Trama;

public class PrendaTest {

  @Test
  public void construirPrendaBuilder_conTodosLosCampos() {
    Color color1 = new Color(255, 255, 0);
    Color color2 = new Color(255, 255, 0);

    Prenda prenda = Prenda.crear(TipoPrenda.REMERA_MANGAS_CORTAS)
        .material(Material.ALGODON)
        .colorPrimario(color1)
        .colorSecundario(color1)
        .trama(Trama.LUNARES)
        .construir();

    assertNotNull(prenda);
    assertEquals(TipoPrenda.REMERA_MANGAS_CORTAS, prenda.getTipo());
    assertEquals(Categoria.PARTE_SUPERIOR, prenda.getCategoria());
    assertEquals(Material.ALGODON, prenda.getMaterial());
    assertEquals(color1,color1);
    assertEquals(color2,color2);
    assertEquals(Trama.LUNARES, prenda.getTrama());
  }

  @Test
  public void construirPrendaBuilder_sinColorSecundario() {
    Prenda prenda = Prenda.crear(TipoPrenda.ZAPATILLAS)
        .material(Material.CUERO)
        .colorPrimario(new Color(0, 0, 0))
        .construir();

    assertNull(prenda.getColorSecundario());
  }

  @Test
  public void construirPrendaBuilder_sinTrama_asignaTramaLisaPorDefecto() {
    Prenda prenda = Prenda.crear(TipoPrenda.PANTALON)
        .material(Material.JEAN)
        .colorPrimario(new Color(20, 20, 20))
        .construir();

    assertEquals(Trama.LISA, prenda.getTrama());
  }

  @Test
  public void construirPrendaBuilder_sinMaterial_lanzaExcepcion() {
    try {
      Prenda prenda = Prenda.crear(TipoPrenda.REMERA_MANGAS_CORTAS)
          .colorPrimario(new Color(255, 255, 255))
          .construir();
      fail("Se esperaba una excepción por falta de material");
    } catch (IllegalArgumentException e) {
      assertEquals("Faltan datos obligatorios", e.getMessage());
    }
  }

  @Test
  public void construirPrendaBuilder_sinColorPrimario_lanzaExcepcion() {
    try {
      Prenda prenda = Prenda.crear(TipoPrenda.REMERA_MANGAS_CORTAS)
          .material(Material.ALGODON)
          .construir();
      fail("Se esperaba una excepción por falta de color primario");
    } catch (IllegalArgumentException e) {
      assertEquals("Faltan datos obligatorios", e.getMessage());
    }
  }

  @Test
  public void construirPrendaBuilder_sinTipo_lanzaExcepcionAlCrearBuilder() {
    try {
      Prenda.PrendaBuilder builder = Prenda.crear(null);
      fail("Se esperaba una excepción por tipo de prenda nulo");
    } catch (IllegalArgumentException e) {
      assertEquals("Debe especificarse un tipo", e.getMessage());
    }
  }
}
package ar.edu.utn.frba.dds.qmp2test;

import static org.junit.jupiter.api.Assertions.*;

import ar.edu.utn.frba.dds.qmp1.Color;
import ar.edu.utn.frba.dds.qmp1.Material;
import ar.edu.utn.frba.dds.qmp1.Prenda;
import ar.edu.utn.frba.dds.qmp1.TipoPrenda;
import ar.edu.utn.frba.dds.qmp2.Borrador;
import org.junit.jupiter.api.Test;
import ar.edu.utn.frba.dds.qmp2.Trama;

public class BorradorTest {

  @Test
  public void crearPrendaValida_conTodosLosCampos() {

    Color color1 = new Color(255, 255, 0);
    Color color2 = new Color(255, 255, 0);
    Borrador borrador = new Borrador(TipoPrenda.REMERA_MANGAS_CORTAS);
    borrador.especificarMaterial(Material.ALGODON);
    borrador.especificarColorPrincipal(color1);
    borrador.especificarColorSecundario(color2);
    borrador.especificarTrama(Trama.LUNARES);

    Prenda prenda = borrador.crearPrenda();

    assertEquals(TipoPrenda.REMERA_MANGAS_CORTAS, prenda.getTipo());
    assertEquals(Material.ALGODON, prenda.getMaterial());
    assertEquals(color1, prenda.getColorPrimario());
    assertEquals(color2, prenda.getColorSecundario());
    assertEquals(Trama.LUNARES, prenda.getTrama());
  }

  @Test
  public void tramaPorDefectoEsLisa() {
    Borrador borrador = new Borrador(TipoPrenda.PANTALON);
    borrador.especificarMaterial(Material.JEAN);
    borrador.especificarColorPrincipal(new Color(0, 0, 255));

    Prenda prenda = borrador.crearPrenda();

    assertEquals(Trama.LISA, prenda.getTrama());
  }

  @Test
  public void especificarTramaNull_asignaLisa() {
    Borrador borrador = new Borrador(TipoPrenda.ZAPATILLAS);
    borrador.especificarMaterial(Material.CUERO);
    borrador.especificarColorPrincipal(new Color(255, 0, 0));
    borrador.especificarTrama(null); // debería asignar LISA por defecto

    Prenda prenda = borrador.crearPrenda();

    assertEquals(Trama.LISA, prenda.getTrama());
  }

  @Test
  public void tipoDePrendaNull_lanzaExcepcion() {
    try {
      new Borrador(null);
      fail("Se esperaba excepción por tipo de prenda null");
    } catch (NullPointerException e) {
      // OK
    }
  }

  @Test
  public void materialNull_lanzaExcepcion() {
    try {
      Borrador borrador = new Borrador(TipoPrenda.BOTAS);
      borrador.especificarMaterial(null);
      fail("Se esperaba excepción por material null");
    } catch (NullPointerException e) {
      // OK
    }
  }

  @Test
  public void colorPrincipalNull_lanzaExcepcion() {
    try {
      Borrador borrador = new Borrador(TipoPrenda.BOTAS);
      borrador.especificarColorPrincipal(null);
      fail("Se esperaba excepción por color principal null");
    } catch (NullPointerException e) {
      // OK
    }
  }
}

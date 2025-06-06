package ar.edu.utn.frba.dds.qmp1test;

import static org.junit.jupiter.api.Assertions.*;
import ar.edu.utn.frba.dds.qmp1.Color;
import org.junit.jupiter.api.Test;

public class ColorTest {

  @Test
  public void colorValido_deberiaCrearCorrectamente() {
    Color color = new Color(123, 45, 67);
    assertEquals(123, color.getRojo());
    assertEquals(45, color.getVerde());
    assertEquals(67, color.getAzul());
  }

  @Test
  public void colorNegro() {
    Color color = new Color(0, 0, 0);
    assertEquals(0, color.getRojo());
    assertEquals(0, color.getVerde());
    assertEquals(0, color.getAzul());
  }

  @Test
  public void colorBlanco() {
    Color color = new Color(255, 255, 255);
    assertEquals(255, color.getRojo());
    assertEquals(255, color.getVerde());
    assertEquals(255, color.getAzul());
  }

  @Test
  public void colorConValorNegativo_lanzaExcepcion() {
    try {
      new Color(-1, 100, 100);
      fail("Se esperaba una excepción por valor negativo");
    } catch (IllegalArgumentException e) {
      assertEquals("Cada valor de color debe estar entre 0 y 255", e.getMessage());
    }
  }

  @Test
  public void colorConValorMayorA255_lanzaExcepcion() {
    try {
      new Color(100, 300, 100);
      fail("Se espera una excepción por valor mayor a 255");
    } catch (IllegalArgumentException e) {
      assertEquals("Cada valor de color debe estar entre 0 y 255", e.getMessage());
    }
  }
}
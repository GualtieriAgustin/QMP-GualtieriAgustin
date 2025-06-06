package ar.edu.utn.frba.dds.qmp2test;

import ar.edu.utn.frba.dds.qmp1.Color;
import ar.edu.utn.frba.dds.qmp1.Material;
import ar.edu.utn.frba.dds.qmp1.Prenda;
import ar.edu.utn.frba.dds.qmp1.TipoPrenda;
import ar.edu.utn.frba.dds.qmp2.Trama;
import ar.edu.utn.frba.dds.qmp2.Uniforme;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniformeTest {

  @Test
  public void uniformeSeCreaCorrectamenteConSusPrendas() {
    Prenda parteSuperior = new Prenda(
        TipoPrenda.REMERA_MANGAS_CORTAS,
        Material.ALGODON,
        new Color(10, 20, 30),
        new Color(200, 210, 220),
        Trama.RAYADA
    );

    Prenda parteInferior = new Prenda(
        TipoPrenda.PANTALON,
        Material.JEAN,
        new Color(40, 50, 60),
        null,
        null  // debería asignar Trama.LISA por defecto
    );

    Prenda calzado = new Prenda(
        TipoPrenda.ZAPATILLAS,
        Material.CUERO,
        new Color(70, 80, 90),
        null,
        Trama.LUNARES
    );

    Uniforme uniforme = new Uniforme(parteSuperior, parteInferior, calzado);

    // Validaciones parte superior
    assertEquals(TipoPrenda.REMERA_MANGAS_CORTAS, uniforme.getParteSuperior().getTipo());
    assertEquals(Material.ALGODON, uniforme.getParteSuperior().getMaterial());
    assertEquals(10, uniforme.getParteSuperior().getColorPrimario().getRojo());
    assertEquals(20, uniforme.getParteSuperior().getColorPrimario().getVerde());
    assertEquals(30, uniforme.getParteSuperior().getColorPrimario().getAzul());
    assertEquals(200, uniforme.getParteSuperior().getColorSecundario().getRojo());
    assertEquals(Trama.RAYADA, uniforme.getParteSuperior().getTrama());

    // Validaciones parte inferior
    assertEquals(TipoPrenda.PANTALON, uniforme.getParteInferior().getTipo());
    assertEquals(Trama.LISA, uniforme.getParteInferior().getTrama());

    // Validaciones calzado
    assertEquals(TipoPrenda.ZAPATILLAS, uniforme.getCalzado().getTipo());
    assertEquals(Trama.LUNARES, uniforme.getCalzado().getTrama());
  }
}
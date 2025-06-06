package ar.edu.utn.frba.dds.qmp2test;

import ar.edu.utn.frba.dds.qmp1.Color;
import ar.edu.utn.frba.dds.qmp1.Material;
import ar.edu.utn.frba.dds.qmp1.Prenda;
import ar.edu.utn.frba.dds.qmp1.TipoPrenda;
import ar.edu.utn.frba.dds.qmp2.SastreSanJuan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SastreSanJuanTest {

  private SastreSanJuan sastre;

  @BeforeEach
  public void setUp() {
    sastre = new SastreSanJuan();
  }

  @Test
  public void fabricarParteSuperior_creaRemeraConColorYMaterialEsperados() {
    Prenda parteSuperior = sastre.fabricarParteSuperior();

    assertEquals(TipoPrenda.REMERA_MANGAS_CORTAS, parteSuperior.getTipo());

    Color color = parteSuperior.getColorPrimario();
    assertEquals(100, color.getRojo());
    assertEquals(150, color.getVerde());
    assertEquals(200, color.getAzul());

    assertEquals(Material.PIQUE, parteSuperior.getMaterial());
  }

  @Test
  public void fabricarParteInferior_creaPantalonConColorYMaterialEsperados() {
    Prenda parteInferior = sastre.fabricarParteInferior();

    assertEquals(TipoPrenda.PANTALON, parteInferior.getTipo());

    Color color = parteInferior.getColorPrimario();
    assertEquals(50, color.getRojo());
    assertEquals(50, color.getVerde());
    assertEquals(50, color.getAzul());

    assertEquals(Material.ACETATO, parteInferior.getMaterial());
  }

  @Test
  public void fabricarCalzado_creaAnteojosConColorYMaterialEsperados() {
    Prenda calzado = sastre.fabricarCalzado();

    assertEquals(TipoPrenda.ANTEOJOS_SOL, calzado.getTipo());

    Color color = calzado.getColorPrimario();
    assertEquals(30, color.getRojo());
    assertEquals(30, color.getVerde());
    assertEquals(30, color.getAzul());

    assertEquals(Material.CUERO, calzado.getMaterial());
  }
}
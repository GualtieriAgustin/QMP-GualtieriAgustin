package ar.edu.utn.frba.dds.qmp3test;

import ar.edu.utn.frba.dds.qmp1.*;
import ar.edu.utn.frba.dds.qmp2.Trama;
import ar.edu.utn.frba.dds.qmp3.Atuendo;
import ar.edu.utn.frba.dds.qmp3.Guardarropas;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GuardarropasTest {

  @Test
  public void generarSugerencias_devuelveTodasLasCombinacionesPosibles() {
    Prenda superior1 = nuevaPrenda(TipoPrenda.REMERA_MANGAS_LARGAS, "gris");
    Prenda superior2 = nuevaPrenda(TipoPrenda.REMERA_MANGAS_CORTAS, "azul");
    Prenda inferior = nuevaPrenda(TipoPrenda.PANTALON, "negro");
    Prenda calzado1 = nuevaPrenda(TipoPrenda.ZAPATILLAS, "marron");
    Prenda calzado2 = nuevaPrenda(TipoPrenda.ZAPATILLAS, "blanco");

    Guardarropas guardarropas = new Guardarropas(
        List.of(superior1, superior2),
        List.of(inferior),
        List.of(calzado1, calzado2)
    );

    List<Atuendo> sugerencias = guardarropas.generarSugerencias();

    // 2 superiores × 1 inferior × 2 calzados = 4 combinaciones
    assertEquals(4, sugerencias.size());
  }

  @Test
  public void todasLasPosiblesCombinaciones_funcionaIgualQueGenerarSugerencias() {
    Prenda superior = nuevaPrenda(TipoPrenda.REMERA_MANGAS_LARGAS, "gris");
    Prenda inferior = nuevaPrenda(TipoPrenda.PANTALON, "negro");
    Prenda calzado = nuevaPrenda(TipoPrenda.ZAPATILLAS, "blanco");

    Guardarropas guardarropas = new Guardarropas(
        List.of(superior),
        List.of(inferior),
        List.of(calzado)
    );

    List<Atuendo> combinaciones = guardarropas.todasLasPosiblesCombinaciones();
    assertEquals(1, combinaciones.size());

    // Comprobamos que la única combinación tiene las prendas correctas
    Atuendo atuendo = combinaciones.get(0);
    assertSame(superior, atuendo.getPrendaSuperior());
    assertSame(inferior, atuendo.getPrendaInferior());
    assertSame(calzado, atuendo.getCalzado());
  }

  // Helper para crear una prenda de prueba
  private Prenda nuevaPrenda(TipoPrenda tipo, String colorNombre) {
    Color color = switch (colorNombre) {
      case "gris" -> new Color(100, 100, 100);
      case "azul" -> new Color(0, 0, 255);
      case "negro" -> new Color(0, 0, 0);
      case "marron" -> new Color(139, 69, 19);
      case "blanco" -> new Color(255, 255, 255);
      default -> new Color(0, 0, 0);
    };

    return new Prenda(tipo, Material.ALGODON, color, null, Trama.LISA);
  }
}

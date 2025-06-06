package ar.edu.utn.frba.dds.qmp3;

import ar.edu.utn.frba.dds.qmp1.Prenda;
import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
  private List<Prenda> prendasSuperiores;
  private List<Prenda> prendasInferiores;
  private List<Prenda> calzados;

  public Guardarropas(List<Prenda> prendasSuperiores,
                      List<Prenda> prendasInferiores,
                      List<Prenda> calzados) {
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzados = calzados;
  }

  public List<Atuendo> generarSugerencias() {
    List<Atuendo> sugerencias = new ArrayList<>();

    for (Prenda superior : prendasSuperiores) {
      for (Prenda inferior : prendasInferiores) {
        for (Prenda calzado : calzados) {
          sugerencias.add(new Atuendo(superior, inferior, calzado));
        }
      }
    }

    return sugerencias;
  }

  public List<Atuendo> todasLasPosiblesCombinaciones() {
    List<Atuendo> combinaciones = new ArrayList<>();

    for (Prenda superior : prendasSuperiores) {
      for (Prenda inferior : prendasInferiores) {
        for (Prenda calzado : calzados) {
          combinaciones.add(new Atuendo(superior, inferior, calzado));
        }
      }
    }

    return combinaciones;
  }
}
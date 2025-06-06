package ar.edu.utn.frba.dds.qmp2;

import ar.edu.utn.frba.dds.qmp1.Prenda;

public class Uniforme {
  private final Prenda parteSuperior;
  private final Prenda parteInferior;
  private final Prenda calzado;

  public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
  }

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
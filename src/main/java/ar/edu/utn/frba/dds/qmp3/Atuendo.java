package ar.edu.utn.frba.dds.qmp3;


import ar.edu.utn.frba.dds.qmp1.Prenda;
import ar.edu.utn.frba.dds.qmp4.Humedad;

public class Atuendo {
  private final Prenda prendaSuperior;
  private final Prenda prendaInferior;
  private final Prenda calzado;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

  public boolean aptaParaHumedad(Humedad humedad) {
    return humedad == Humedad.BAJA;
  }

  public boolean aptaParaTemperatura(int temperatura) {
    return temperatura > 10;
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
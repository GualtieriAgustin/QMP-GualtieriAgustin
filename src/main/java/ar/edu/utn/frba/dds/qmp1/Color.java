package ar.edu.utn.frba.dds.qmp1;

public class Color {
  private final int rojo;
  private final int verde;
  private final int azul;

  public Color(int rojo, int verde, int azul) {
    if (!esValorRgbValido(rojo) || !esValorRgbValido(verde) || !esValorRgbValido(azul)) {
      throw new IllegalArgumentException("Cada valor de color debe estar entre 0 y 255");
    }
    this.rojo = rojo;
    this.verde = verde;
    this.azul = azul;
  }

  private boolean esValorRgbValido(int valor) {
    return valor >= 0 && valor <= 255;
  }

  public int getRojo() {
    return rojo;
  }

  public int getVerde() {
    return verde;
  }

  public int getAzul() {
    return azul;
  }
}
package ar.edu.utn.frba.dds.qmp2;

import ar.edu.utn.frba.dds.qmp1.Color;
import ar.edu.utn.frba.dds.qmp1.Material;
import ar.edu.utn.frba.dds.qmp1.Prenda;
import ar.edu.utn.frba.dds.qmp1.TipoPrenda;

public class Borrador {
  private final TipoPrenda tipoDePrenda;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private Trama trama = Trama.LISA;

  public Borrador(TipoPrenda tipoDePrenda) {
    this.tipoDePrenda = java.util.Objects.requireNonNull(tipoDePrenda);
  }

  public void especificarMaterial(Material material) {
    this.material = java.util.Objects.requireNonNull(material);
  }

  public void especificarColorPrincipal(Color color) {
    this.colorPrincipal = java.util.Objects.requireNonNull(color);
  }

  public void especificarColorSecundario(Color color) {
    this.colorSecundario = color;
  }

  public void especificarTrama(Trama trama) {
    this.trama = (trama != null) ? trama : Trama.LISA;
  }

  public Prenda crearPrenda() {
    return new Prenda(tipoDePrenda, material, colorPrincipal, colorSecundario, trama);
  }
}
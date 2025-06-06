package ar.edu.utn.frba.dds.qmp1;

import ar.edu.utn.frba.dds.qmp2.Trama;

public class Prenda {
  private final TipoPrenda tipo;
  private final Categoria categoria;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private final Trama trama;

  public Prenda(TipoPrenda tipo,
                 Material material,
                 Color colorPrimario,
                 Color colorSecundario,
                 Trama trama) {
    if (tipo == null || material == null || colorPrimario == null) {
      throw new IllegalArgumentException("Faltan datos obligatorios");
    }

    this.tipo = tipo;
    this.categoria = tipo.getCategoria();
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.colorSecundario = colorSecundario;
    this.trama = (trama != null) ? trama : Trama.LISA; // valor por defecto
  }

  public static PrendaBuilder crear(TipoPrenda tipo) {
    return new PrendaBuilder(tipo);
  }

  public static class PrendaBuilder {
    private final TipoPrenda tipo;
    private Material material;
    private Color colorPrimario;
    private Color colorSecundario;
    private Trama trama;

    public PrendaBuilder(TipoPrenda tipo) {
      if (tipo == null) {
        throw new IllegalArgumentException("Debe especificarse un tipo");
      }
      this.tipo = tipo;
    }

    public PrendaBuilder material(Material material) {
      this.material = material;
      return this;
    }

    public PrendaBuilder colorPrimario(Color color) {
      this.colorPrimario = color;
      return this;
    }

    public PrendaBuilder colorSecundario(Color color) {
      this.colorSecundario = color;
      return this;
    }

    public PrendaBuilder trama(Trama trama) {
      this.trama = trama;
      return this;
    }

    public Prenda construir() {
      return new Prenda(tipo, material, colorPrimario, colorSecundario, trama);
    }
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Material getMaterial() {
    return material;
  }

  public Color getColorPrimario() {
    return colorPrimario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public Trama getTrama() {
    return trama;
  }
}
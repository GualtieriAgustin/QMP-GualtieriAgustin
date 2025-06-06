package ar.edu.utn.frba.dds.qmp1;

public enum TipoPrenda {
  REMERA_MANGAS_CORTAS(Categoria.PARTE_SUPERIOR),
  REMERA_MANGAS_LARGAS(Categoria.PARTE_SUPERIOR),
  PANTALON(Categoria.PARTE_INFERIOR),
  ZAPATILLAS(Categoria.CALZADO),
  BOTAS(Categoria.CALZADO),
  POLLERA(Categoria.PARTE_INFERIOR),
  ANTEOJOS_SOL(Categoria.ACCESORIO),
  PAÑUELO(Categoria.ACCESORIO),
  MUSCULOSA(Categoria.PARTE_SUPERIOR);

  private final Categoria categoria;

  TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

  public Categoria getCategoria() {
    return categoria;
  }
}
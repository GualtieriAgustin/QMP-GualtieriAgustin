package ar.edu.utn.frba.dds.qmp2;


import ar.edu.utn.frba.dds.qmp1.Color;
import ar.edu.utn.frba.dds.qmp1.Material;
import ar.edu.utn.frba.dds.qmp1.Prenda;
import ar.edu.utn.frba.dds.qmp1.TipoPrenda;

public class SastreSanJuan implements Sastre {
  public Prenda fabricarParteSuperior() {
    Borrador b = new Borrador(TipoPrenda.REMERA_MANGAS_CORTAS);
    b.especificarColorPrincipal(new Color(100, 150, 200));
    b.especificarMaterial(Material.PIQUE);
    return b.crearPrenda();
  }

  public Prenda fabricarParteInferior() {
    Borrador b = new Borrador(TipoPrenda.PANTALON);
    b.especificarColorPrincipal(new Color(50, 50, 50));
    b.especificarMaterial(Material.ACETATO);
    return b.crearPrenda();
  }

  public Prenda fabricarCalzado() {
    Borrador b = new Borrador(TipoPrenda.ANTEOJOS_SOL);
    b.especificarColorPrincipal(new Color(30, 30, 30));
    b.especificarMaterial(Material.CUERO);
    return b.crearPrenda();
  }
}
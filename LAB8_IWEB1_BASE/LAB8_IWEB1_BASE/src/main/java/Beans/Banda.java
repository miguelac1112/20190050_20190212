
package Beans;

public class Banda {
    private String idBanda;
    private String nombre_banda;
    private int idlider;
    private int favorito;
    private String lista_perzaonalizada;


    public Banda(String idBanda, String nombre_banda, int idlider) {
        this.idBanda = idBanda;
        this.nombre_banda = nombre_banda;
        this.idlider = idlider;
    }

    public String getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(String idBanda) {
        this.idBanda = idBanda;
    }

    public String getNombre_banda() {
        return nombre_banda;
    }

    public void setNombre_banda(String nombre_banda) {
        this.nombre_banda = nombre_banda;
    }

    public int getIdlider() {
        return idlider;
    }

    public void setIdlider(int idlider) {
        this.idlider = idlider;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public String getLista_perzaonalizada() {
        return lista_perzaonalizada;
    }

    public void setLista_perzaonalizada(String lista_perzaonalizada) {
        this.lista_perzaonalizada = lista_perzaonalizada;
    }
}

package cat.copernic.m03uf06review.orm;

public class Registre {
    
    int id;
    String NombreChicaBarco;
    String Municion;
    int Velocidad;

    public Registre(int id, String NombreChicaBarco, String Municion, int Velocidad) {
        this.id = id;
        this.NombreChicaBarco = NombreChicaBarco;
        this.Municion = Municion;
        this.Velocidad = Velocidad;
    }

    public int getId() {
        return id;
    }

    public String getNombreChicaBarco() {
        return NombreChicaBarco;
    }

    public String getMunicion() {
        return Municion;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreChicaBarco(String NombreChicaBarco) {
        this.NombreChicaBarco = NombreChicaBarco;
    }

    public void setMunicion(String Municion) {
        this.Municion = Municion;
    }

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }

    @Override
    public String toString() {
        return "Registre{" + "id=" + id + ", NombreChicaBarco=" + NombreChicaBarco + ", Municion=" + Municion + ", Velocidad=" + Velocidad + '}';
    }

    
    
    
}

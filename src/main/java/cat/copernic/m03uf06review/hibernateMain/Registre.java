package cat.copernic.m03uf06review.hibernateMain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class Registre {
    
    private Integer id;
    private String Nombre;
    private Date Fecha_de_nacimiento;
    private Double Peso;
    private String LetraFavorita;

    public Registre() {}
    public Registre(Integer id, String Nombre, Date Fecha_de_nacimiento, Double Peso, String LetraFavorita) {
        this.id = id;
        this.Nombre = Nombre;
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
        this.Peso = Peso;
        this.LetraFavorita = LetraFavorita;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setFecha_de_nacimiento(Date Fecha_de_nacimiento) {
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
    }

    public void setPeso(Double Peso) {
        this.Peso = Peso;
    }

    public void setLetraFavorita(String LetraFavorita) {
        this.LetraFavorita = LetraFavorita;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public Date getFecha_de_nacimiento() {
        return Fecha_de_nacimiento;
    }

    public Double getPeso() {
        return Peso;
    }

    public String getLetraFavorita() {
        return LetraFavorita;
    }

    @Override
    public String toString() {
        return "Registre{" + "id=" + id + ", Nombre=" + Nombre + ", Fecha_de_nacimiento=" + Fecha_de_nacimiento + ", Peso=" + Peso + ", LetraFavorita=" + LetraFavorita + '}';
    }
    
    
}

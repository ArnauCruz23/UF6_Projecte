package cat.copernic.m03uf06review.hibernate_relational;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.util.HashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Barcos {
    private Integer id;
    private String nombre;   
    private double peso;
    private int nArmas;
    private Set barcosD;
    
    public Barcos(){}

    public Barcos(Integer id, String nombre, double peso, int nArmas) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.nArmas = nArmas;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public int getnArmas() {
        return nArmas;
    }

    public Set getBarcosD() {
        return barcosD;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setnArmas(int nArmas) {
        this.nArmas = nArmas;
    }

    public void setBarcosD(Set barcosD) {
        this.barcosD = barcosD;
    }
    
    

    

    
    
    
    
}



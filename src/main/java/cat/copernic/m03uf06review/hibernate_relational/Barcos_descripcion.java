package cat.copernic.m03uf06review.hibernate_relational;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Barcos_descripcion {
    
    private Integer id;
    private String carga;
    
    public Barcos_descripcion(){}

    public Barcos_descripcion(Integer id, String carga) {
        this.id = id;
        this.carga = carga;
    }

    public Integer getId() {
        return id;
    }

    public String getCarga() {
        return carga;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (!this.getClass().equals(obj.getClass())) return false;

      Barcos_descripcion obj2 = (Barcos_descripcion)obj;
      if((this.id == obj2.getId()) && (this.carga.equals(obj2.getCarga()))) {
         return true;
      }
      return false;
   }
   
   public int hashCode() {
      int tmp = 0;
      tmp = ( id + carga ).hashCode();
      return tmp;
   }
    }
    
    
    
    
    
    
    
    
    


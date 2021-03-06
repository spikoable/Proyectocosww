package tserviceClases;
// Generated 19/02/2015 11:32:35 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Publicante generated by hbm2java
 */
@Entity
@Table(name="Publicante"
    ,catalog="coswg2"
)
public class Publicante extends Persona implements java.io.Serializable {

     private String experiencia;
     private Date fechaUltimaLicecia;
     private List<Factura> facturas = (List<Factura>) new HashSet(0);
     private List<Oferta> ofertas = (List<Oferta>) new HashSet(0);

    public Publicante() {
    }

    public Publicante(String experiencia, Date fechaUltimaLicecia, List<Factura> facturas, List<Oferta> ofertas) {
       this.experiencia = experiencia;
       this.fechaUltimaLicecia = fechaUltimaLicecia;
       this.facturas = facturas;
       this.ofertas = ofertas;
    }

    Publicante(List<ExperienciaLaboral> lExperiencia, java.sql.Date fechaNacimiento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Publicante(String ExperienciaOfertante, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
     
    @Column(name="Experiencia", nullable=false, length=45)
    public String getExperiencia() {
        return this.experiencia;
    }
    
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaUltimaLicecia", nullable=false, length=10)
    public Date getFechaUltimaLicecia() {
        return this.fechaUltimaLicecia;
    }
    
    public void setFechaUltimaLicecia(Date fechaUltimaLicecia) {
        this.fechaUltimaLicecia = fechaUltimaLicecia;
    }

@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="Identificacion", nullable=false)
    public List<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="publicante")
    public List<Oferta> getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }




}



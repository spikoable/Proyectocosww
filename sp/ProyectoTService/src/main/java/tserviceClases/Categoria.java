package tserviceClases;
// Generated 19/02/2015 11:32:35 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name="Categoria"
    ,catalog="coswg2"
)
public class Categoria  implements java.io.Serializable {


     private Integer id;
     private Interes interes;
     private String nombre;
     private List<Oferta> ofertas = new LinkedList();

    public Categoria() {
    }

	
    public Categoria(Interes interes, String nombre) {
        this.interes = interes;
        this.nombre = nombre;
    }
    public Categoria(Interes interes, String nombre, List<Oferta> ofertas) {
       this.interes = interes;
       this.nombre = nombre;
       this.ofertas = ofertas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Interes_id", nullable=false)
    public Interes getInteres() {
        return this.interes;
    }
    
    public void setInteres(Interes interes) {
        this.interes = interes;
    }

    
    @Column(name="Nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="Oferta_has_Categoria", catalog="coswg2", joinColumns = { 
        @JoinColumn(name="Categoria_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Oferta_id", nullable=false, updatable=false) })
    public List<Oferta> getOfertas() {
        return this.ofertas;
    }
    
    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }




}


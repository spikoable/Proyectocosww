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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Interes generated by hbm2java
 */
@Entity
@Table(name="Interes"
    ,catalog="coswg2"
)
public class Interes  implements java.io.Serializable {


     private Integer id;
     private Postulante postulante;
     private String experiencia;
     private List<Categoria> categorias = new LinkedList();

    public Interes() {
    }

	
    public Interes(Postulante postulante, String experiencia) {
        this.postulante = postulante;
        this.experiencia = experiencia;
    }
    public Interes(Postulante postulante, String experiencia, List<Categoria> categorias) {
       this.postulante = postulante;
       this.experiencia = experiencia;
       this.categorias = categorias;
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
    @JoinColumn(name="Identificacion", nullable=false)
    public Postulante getPostulante() {
        return this.postulante;
    }
    
    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    
    @Column(name="Experiencia", nullable=false, length=45)
    public String getExperiencia() {
        return this.experiencia;
    }
    
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="interes")
    public List<Categoria> getCategorias() {
        return this.categorias;
    }
    
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }




}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tserviceClases;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 *
 * @author LuisAndres
 */
public class ServiceMainProgram {
    public static void main(String a[]){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings(
        configuration.getProperties()).build();
        
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Session session=sessionFactory.openSession();        
        Transaction tx=session.beginTransaction();
        
                
        ServicePersistanceFacade ServicePersistanceFacade=new ServicePersistanceFacade();
        
        
        //1.  Consulta Registro de ofertante y de una oferta.
        
                //Crear correos
                ArrayList<Correo> lCorreos =new ArrayList<Correo>();

                //Traer idCorreo
                Query q = session.createQuery("select count(*) from Correo ");
                List<Integer> tp = q.list();

                Correo correo = new Correo(tp.get(0)+1,"prueba@gmail.com");
                session.save(correo);


                //Crear experiencia 
                ArrayList<ExperienciaLaboral> lExperiencia =new ArrayList<ExperienciaLaboral>();

                for (int i=0;i<2;i++){
                    ExperienciaLaboral oExp = new ExperienciaLaboral("Prueba"+i ,new Date(20140101),"Prueba"+i);
                    session.save(oExp);
                    lExperiencia.add(oExp);
                }


                //Crear Direcciones
                ArrayList<Direcciones> lDirecciones =new ArrayList<Direcciones>();

                for (int i=0;i<2;i++){
                    Direcciones oDir = new Direcciones("Prueba"+i,"Prueba"+i,"Prueba"+i,"Prueba"+i,"Prueba"+i);
                    session.save(oDir);
                    lDirecciones.add(oDir);
                }

                //Registrar ofertante
                ServicePersistanceFacade.registroOfertante(session, 101, "CC", new Date(20140101),"Prueba Hoja de Vida", "20140101", "", "Prueba Oertante", lExperiencia, lCorreos, lDirecciones, "2","LicenciaPrueba",30);
        
                int idOferta;
                Interes i = null;
                
                //Crear categoria asociada
                Categoria cat=ServicePersistanceFacade.registroCategoria(session,"Servicios Categoria", i);
                
                ArrayList<Categoria> cats = new ArrayList<Categoria>();
                
                cats.add(cat);
                
                //Registrar oferta}
                idOferta=ServicePersistanceFacade.registrarOferta(session, 101, "CC", new Date(20140101),new Date(20140101),10000, "Pasear Mascota", "Espera",cats);
                
                
        // 2. Asignación de postulante a una oferta.
        
                //Crear intereses
                ArrayList<Interes> interes=new ArrayList<Interes>();
                Postulante p = null;
                for(int j=0;j<2;j++)interes.add(ServicePersistanceFacade.registroInteres(session,"Prueba"+j,cat, p));
                
                            
                //Registrar postulante
                Postulante oPostulante=ServicePersistanceFacade.registroPostulante(session, 205, "CC", new Date(20140101),"Prueba Hoja de Vida PO", "20140101", "", "Prueba Postulante", lExperiencia, lCorreos, lDirecciones, 100000,interes);
        
        
                //Asignar postulante a una oferta
                ServicePersistanceFacade.asignarOfertaPostulante(session, 205, "CC", idOferta);
        
                
                
        // 3. Ofertas que pueden ser de interés a un solicitante, excluyendo las de solicitantes que tengan expirada su suscripción.
                 
                 //Obtener categorias sobresalientes para un solicitante
                ArrayList<Oferta> ofs=ServicePersistanceFacade.getOfertasPostulante(session,oPostulante);
        
                
        
                
        // 4. Ranking de postulantes por experiencia laboral en el área o por puntajes dados por empleadores anteriores.

                
                
        tx.commit();
        session.close();
    }
    
    
}

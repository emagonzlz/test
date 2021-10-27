package claseintrojpa.entidades.daos;

import claseintrojpa.entidades.Ciudad;
import claseintrojpa.entidades.Persona;
import java.util.List;

/* @author Nahue
 */
public class PersonaDao extends Dao {

  public Persona crearPersona(Persona persona) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(persona);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }

    return persona;
  }
  
  public Persona findById(Integer id) {
    return entityManager.find(Persona.class, id);
  }
  
  public Persona findById(Persona persona) {
    return entityManager.find(Persona.class, persona.getId());
  }
  
  public Persona modificarPersona(Persona persona) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(persona);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    return persona;
  }
  
  public Persona eliminarPersona(Persona persona) {
    try {
      persona = entityManager.find(Persona.class,persona.getId());
      entityManager.getTransaction().begin();
      entityManager.remove(persona);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }

    return persona;
  }
  
  
  
  public List<Persona> findAll() {
    return entityManager.createQuery("select p from Persona p").getResultList();
  }
  
  public List<Persona> findAllByCiudad(Ciudad ciudad) {
    return entityManager.createQuery("select p from Persona p where p.ciudad.nombre = :ciudad")
                                                                                .setParameter("ciudad", ciudad.getNombre())
                                                                                .getResultList();
  }
}

package claseintrojpa.entidades.daos;

import claseintrojpa.entidades.Ciudad;
import java.util.List;

/* @author Nahue
 */
public class CiudadDao extends Dao {

  public Ciudad crearCiudad(Ciudad ciudad) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(ciudad);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    return ciudad;
  }
  
  public Ciudad findById(Integer id) {
    return entityManager.find(Ciudad.class, id);
  }
  
  public Ciudad findById(Ciudad ciudad) {
    return entityManager.find(Ciudad.class, ciudad.getId());
  }
  
  public Ciudad modificarCiudad(Ciudad ciudad) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(ciudad);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    return ciudad;
  }
  
  public Ciudad eliminarCiudad(Ciudad ciudad) {
    try {
      ciudad = entityManager.find(Ciudad.class,ciudad.getId());
      entityManager.getTransaction().begin();
      entityManager.remove(ciudad);
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }

    return ciudad;
  }
  
  public List<Ciudad> findAll() {
    return entityManager.createQuery("select p from Ciudad p").getResultList();
  }
}

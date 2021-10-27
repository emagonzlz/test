
package claseintrojpa.entidades.daos;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/* @author Nahue
 */
public class Dao {

  protected EntityManager entityManager = Persistence.createEntityManagerFactory("ClaseIntroJPAPU").createEntityManager();
  
}

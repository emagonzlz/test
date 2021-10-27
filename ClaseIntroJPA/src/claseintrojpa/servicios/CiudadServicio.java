
package claseintrojpa.servicios;

import claseintrojpa.entidades.Ciudad;
import claseintrojpa.entidades.daos.CiudadDao;
import java.util.List;

/* @author Nahue
 */
public class CiudadServicio {

  private CiudadDao ciudadDao = new CiudadDao();
  
  public Ciudad crearCiudad(Ciudad ciudad) {
   return ciudadDao.crearCiudad(ciudad);
  }
  
  public List<Ciudad> findAll() {
    List<Ciudad> ciudades = ciudadDao.findAll();
    mostrarLista(ciudades);
    return ciudades;
  }
  
  public void modificarCiudad(Ciudad ciudad) throws Exception {
    if (ciudadDao.findById(ciudad) == null) {
      throw new Exception("No existe la ciudad en la base de datos");
    }
    ciudadDao.modificarCiudad(ciudad);
  }
  
  public void eliminarCiudad(Ciudad ciudad) {
  ciudadDao.eliminarCiudad(ciudad);
  }
  
  private void mostrarLista(List<Ciudad> ciudades) {
    for (Ciudad ciudad : ciudades) {
      System.out.println(ciudad.toString());
    }
  }
}


package claseintrojpa.servicios;

import claseintrojpa.entidades.Ciudad;
import claseintrojpa.entidades.Persona;
import claseintrojpa.entidades.daos.PersonaDao;
import java.util.List;

/* @author Nahue
 */
public class PersonaServicio {

  private PersonaDao personaDao = new PersonaDao();
  
  public void crearPersona(Persona persona) {
    personaDao.crearPersona(persona);
  }
  
  public void modificarPersona(Persona persona) throws Exception {
    if (personaDao.findById(persona) == null) {
      throw new Exception("No existe la persona en la base de datos");
    }
    personaDao.modificarPersona(persona);
  }
  
  public void eliminarPersona(Persona persona) {
  personaDao.eliminarPersona(persona);
  }
  
  public List<Persona> findAll() {
    List<Persona> personas = personaDao.findAll();
    mostrarLista(personas);
    return personas;
  }
  
  public List<Persona> findAllByCiudad(Ciudad ciudad) {
    List<Persona> personas = personaDao.findAllByCiudad(ciudad);
    mostrarLista(personas);
    return personas;
  }
  
  private void mostrarLista(List<Persona> personas) {
    for (Persona persona : personas) {
      System.out.println(persona.toString());
    }
  }
}

package claseintrojpa;

import claseintrojpa.entidades.Ciudad;
import claseintrojpa.entidades.Persona;
import claseintrojpa.servicios.CiudadServicio;
import claseintrojpa.servicios.PersonaServicio;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Nahue
 */
public class ClaseIntroJPA {

  public static void main(String[] args) {
    PersonaServicio personaServicio = new PersonaServicio();
//    try {
//
//      Persona persona = new Persona(1, "Erick");
////        Persona persona1 = new Persona(10, "MArtin");
////        Persona persona2 = new Persona(-15, "Gaston");
////        personaServicio.crearPersona(persona);
////        personaServicio.crearPersona(persona1);
////        personaServicio.crearPersona(persona2);
//
////        persona.setNombre("Luciano");
//      personaServicio.modificarPersona(persona);
//      personaServicio.findAll();
//
//      persona = new Persona(2, "Daniel");
////      persona.setId(9);
//      personaServicio.crearPersona(persona);
//
//      
//      persona = new Persona();
//      persona.setId(3);
//      personaServicio.eliminarPersona(persona);
//    } catch (Exception ex) {
////      ex.printStackTrace();
//      System.out.println("Error: " + ex.getMessage());
//    }
//    System.out.println("");
//    personaServicio.findAll();

    try {

      CiudadServicio ciudadServicio = new CiudadServicio();

      Ciudad mardel = ciudadServicio.crearCiudad(new Ciudad("Mar del Plata"));
      Ciudad rosario = ciudadServicio.crearCiudad(new Ciudad("Rosario"));
      Ciudad santaFe = ciudadServicio.crearCiudad(new Ciudad("Santa Fe"));

      personaServicio.crearPersona(new Persona("Moria", mardel));
      personaServicio.crearPersona(new Persona("Messi", rosario));
      personaServicio.crearPersona(new Persona("Angel", santaFe));

      personaServicio.findAll();

      Persona personaAModificar = new Persona(2, "Messi");
      Ciudad paris = ciudadServicio.crearCiudad(new Ciudad("París"));
      personaAModificar.setCiudad(mardel);
      personaServicio.modificarPersona(personaAModificar);

      System.out.println("");
      personaServicio.findAllByCiudad(mardel);

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Error: " + e.getMessage());
    }
  }
}

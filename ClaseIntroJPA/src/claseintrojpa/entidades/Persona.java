
package claseintrojpa.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/* @author Nahue
 */

@Entity
public class Persona implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String nombre;
  private Ciudad ciudad;

  public Persona() {
  }

  public Persona(Integer id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  public Persona( String nombre, Ciudad ciudad) {
    this.nombre = nombre;
    this.ciudad = ciudad;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Ciudad getCiudad() {
    return ciudad;
  }

  public void setCiudad(Ciudad ciudad) {
    this.ciudad = ciudad;
  }
  
  @Override
  public String toString() {
    return "Persona{" + "id=" + id + ", nombre=" + nombre + ", ciudad ="+ ciudad.getNombre()+"}";
  }
}

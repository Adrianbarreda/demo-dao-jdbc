package model.entities;

import java.io.Serializable;
import java.util.Objects;

// "implements Serializable" é para que os objetos possam ser transformados 
// em sequencia de bytes {em java se faz isso se queremos que o 
// profeto seja gravado em arquivos, trafégado em rede étc..}
public class Department implements Serializable						{

	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	private String name;
	
	public Department() { // construtor padrão		
	}

	public Department(Integer id, String name) {		
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// generar o hascode and equals para que os elemnetos possam ser 
	//comparados pelo se conteudo e não pela referência de ponteiro
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}

package model.dao; // o dao faz parte do model. O model ele comprende n�o s� as
// entidades mais tamb�m as classes que fazem transformac�es nessas entidades. 

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);// opera��o respons�vel por inserir no banco de dados o "obj" que eu enviar como par�metro de entrada.
	void update(Department obj);// recebendo um "Department" como argumento.
	void deleteById(Integer id);// recebendo um integer id.
	Department findById(Integer id);// opera��o retornando um Department e o 
	//nome da opera��o � "findById" recebdnedo um integer Id como argumento. 
	//A opera��o pega o "id" e consulta no banco de dados o objeto com esse id. 
	//Se existir vai retornar, se-n�o retrona nullo. 
	List<Department> findAll();// para retornar todos os departementos. 
	//Temos uma lista de Departement e o nome da opera��o vai ser "finAll".
	
	
}

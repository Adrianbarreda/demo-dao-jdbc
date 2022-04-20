package model.dao; // o dao faz parte do model. O model ele comprende não só as
// entidades mais também as classes que fazem transformacões nessas entidades. 

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);// operação responsável por inserir no banco de dados o "obj" que eu enviar como parámetro de entrada.
	void update(Department obj);// recebendo um "Department" como argumento.
	void deleteById(Integer id);// recebendo um integer id.
	Department findById(Integer id);// operação retornando um Department e o 
	//nome da operação é "findById" recebdnedo um integer Id como argumento. 
	//A operação pega o "id" e consulta no banco de dados o objeto com esse id. 
	//Se existir vai retornar, se-não retrona nullo. 
	List<Department> findAll();// para retornar todos os departementos. 
	//Temos uma lista de Departement e o nome da operação vai ser "finAll".
	
	
}

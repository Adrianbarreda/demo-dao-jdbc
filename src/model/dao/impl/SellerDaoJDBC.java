package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn; /*Não precisa fazer uma conexão como banco de 
	dados por meio de um objeto. O DAO vai ter um dependencia com a conexão*/
	/*O objeto "conn" vai estar disponivel em qualquer lugar 
	 * da classe "SellerDaoJDBC". O objeto "conn" vou utlizar como conexão na 
	 * hora de implementar as operações. 
	 * Não precisa fechar a conexão, podemos deixar funcionando (aberta), pq 
	 * assim o mesmo objeto DAO pode servir para fazer mais uma operação. Por 
	 * exemplo depois de fazer o "findById" podemos fazer outra operação como 
	 * mandar inserir um novo dado usando o memso DAO-->"insert". Por tanto, a 
	 * conexão "conn" so se fecha no programa principal.*/
	public SellerDaoJDBC(Connection conn) { /*Forçar a injeção de dependencia*/
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {/*OPeração para encontrar um objeto 
	passando o "id" como parámetro*/		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(/*st recebe a minha conexão conn*/
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ? ");
			
			st.setInt(1, id);/*O priemiro "?" do "prepareStatement" vai recibir o 
			"id" que chegou como parametro de entrada na função "findById"*/
			rs = st.executeQuery();/*O comando sql vai ser executado e o 
			resultado vai cair dentro do comando "rs".
			Quando acaba a primeira consulta e vem o resultado no "rs" o "rs" 
			ta apontando para a posição "zero". A posiçõa "zero" não contém 
			objeto, só a 1(um) que contém. */
			if (rs.next()) {/*O if é para textar se veio algum resultado. 
			Se "rs" não retorno nenhum registro o "rs.next()=false" vou pular 
			o "if" e retornar nullo*/
				Department dep = new Department();/*variavél temporária*/
				dep.setId(rs.getInt("DepartmentId"));/*pegamos o Id do Depart.*/
				dep.setName(rs.getString("DepName"));
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));				
				obj.setDepartment(dep);/*Não é DerpartmentId é uma associação 
				de objeto por isso é "dep"*/
				return obj;
			}
			return null;/*Não existe nenhum vendendor com esse "id"*/					
		}
		
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		/*IMPORTANTE: O "ResultSet" traz os dados no formato de tabela, 
		 * é um objeto com linhas e colunas. Como estamos porgramando OO, a 
		 * classe DAO é responsavel por pegar os dados no BD(banco de dados) 
		 * relacional da tabela e transfromarlos em objetos associados.
		 * O que vai acontecer ? é que vamos criar um objeto com os dados do 
		 * "Alex" que é um "Seller" e associado a ele um outro objeto do tipo 
		 * Department com os dados do departamento dele.
		 * Na programação OO, mesmo buscando os dados no BD na forma de tabela, 
		 * na memoria do PC vou querer tener os objetos associados-instanciados 
		 * em memoria*/
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}

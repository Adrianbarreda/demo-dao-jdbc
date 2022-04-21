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
	
	private Connection conn; /*N�o precisa fazer uma conex�o como banco de 
	dados por meio de um objeto. O DAO vai ter um dependencia com a conex�o*/
	/*O objeto "conn" vai estar disponivel em qualquer lugar 
	 * da classe "SellerDaoJDBC". O objeto "conn" vou utlizar como conex�o na 
	 * hora de implementar as opera��es. 
	 * N�o precisa fechar a conex�o, podemos deixar funcionando (aberta), pq 
	 * assim o mesmo objeto DAO pode servir para fazer mais uma opera��o. Por 
	 * exemplo depois de fazer o "findById" podemos fazer outra opera��o como 
	 * mandar inserir um novo dado usando o memso DAO-->"insert". Por tanto, a 
	 * conex�o "conn" so se fecha no programa principal.*/
	public SellerDaoJDBC(Connection conn) { /*For�ar a inje��o de dependencia*/
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
	public Seller findById(Integer id) {/*OPera��o para encontrar um objeto 
	passando o "id" como par�metro*/		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(/*st recebe a minha conex�o conn*/
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ? ");
			
			st.setInt(1, id);/*O priemiro "?" do "prepareStatement" vai recibir o 
			"id" que chegou como parametro de entrada na fun��o "findById"*/
			rs = st.executeQuery();/*O comando sql vai ser executado e o 
			resultado vai cair dentro do comando "rs".
			Quando acaba a primeira consulta e vem o resultado no "rs" o "rs" 
			ta apontando para a posi��o "zero". A posi��a "zero" n�o cont�m 
			objeto, s� a 1(um) que cont�m. */
			if (rs.next()) {/*O if � para textar se veio algum resultado. 
			Se "rs" n�o retorno nenhum registro o "rs.next()=false" vou pular 
			o "if" e retornar nullo*/
				Department dep = new Department();/*variav�l tempor�ria*/
				dep.setId(rs.getInt("DepartmentId"));/*pegamos o Id do Depart.*/
				dep.setName(rs.getString("DepName"));
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));				
				obj.setDepartment(dep);/*N�o � DerpartmentId � uma associa��o 
				de objeto por isso � "dep"*/
				return obj;
			}
			return null;/*N�o existe nenhum vendendor com esse "id"*/					
		}
		
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		/*IMPORTANTE: O "ResultSet" traz os dados no formato de tabela, 
		 * � um objeto com linhas e colunas. Como estamos porgramando OO, a 
		 * classe DAO � responsavel por pegar os dados no BD(banco de dados) 
		 * relacional da tabela e transfromarlos em objetos associados.
		 * O que vai acontecer ? � que vamos criar um objeto com os dados do 
		 * "Alex" que � um "Seller" e associado a ele um outro objeto do tipo 
		 * Department com os dados do departamento dele.
		 * Na programa��o OO, mesmo buscando os dados no BD na forma de tabela, 
		 * na memoria do PC vou querer tener os objetos associados-instanciados 
		 * em memoria*/
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}

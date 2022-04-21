package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory { //"Fctory" � uma Classe auxiliar respons�vel por 
						//instanciar os meus DAOs.	
	
	public static SellerDao createrSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}/* opera��o est�tica para instanciar os DAOs. O "createrSellerDao()" 
	t�m que retornar um SellerDao. Dessa forma a classe "DaoFactory" vai expor 
	um m�todo que retorna o tipo da interface --> "SellerDao"; 
	mais internamente ela vai instanciar uma implementa��o
	return new SellerDaoJDBC() � uma set para n�o necessitar expor a 
	implementa��o, e deixar somente a interface*/ 
	
}

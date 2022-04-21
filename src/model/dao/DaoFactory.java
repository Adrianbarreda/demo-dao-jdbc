package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory { //"Fctory" é uma Classe auxiliar responsável por 
						//instanciar os meus DAOs.	
	
	public static SellerDao createrSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}/* operação estática para instanciar os DAOs. O "createrSellerDao()" 
	têm que retornar um SellerDao. Dessa forma a classe "DaoFactory" vai expor 
	um método que retorna o tipo da interface --> "SellerDao"; 
	mais internamente ela vai instanciar uma implementação
	return new SellerDaoJDBC() é uma set para não necessitar expor a 
	implementação, e deixar somente a interface*/ 
	
}

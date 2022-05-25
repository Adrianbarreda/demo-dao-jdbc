package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createrSellerDao(); /*Posso acrecentar 
		uma instancia��o de um seller DAO. Dessa forma meu programa n�o conhece 
		a implementa��o s� conhece a interface. � tamb�m uma forma de fazer uma 
		inje��o de dependencia sem explicitar a implementa��o.*/
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);

	}
}

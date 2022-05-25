package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createrSellerDao(); /*Posso acrecentar 
		uma instanciação de um seller DAO. Dessa forma meu programa não conhece 
		a implementação só conhece a interface. É também uma forma de fazer uma 
		injeção de dependencia sem explicitar a implementação.*/
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);

	}
}

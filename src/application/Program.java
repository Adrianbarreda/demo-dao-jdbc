package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		SellerDao sellerDao = DaoFactory.createrSellerDao(); /*Posso acrecentar 
		uma instanciação de um seller DAO. Dessa forma meu programa não conhece 
		a implementação só conhece a interface. É também uma forma de fazer uma 
		injeção de dependencia sem explicitar a implementação.*/
		
		System.out.println(seller);

	}

}

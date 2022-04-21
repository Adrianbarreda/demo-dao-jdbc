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
		uma instancia��o de um seller DAO. Dessa forma meu programa n�o conhece 
		a implementa��o s� conhece a interface. � tamb�m uma forma de fazer uma 
		inje��o de dependencia sem explicitar a implementa��o.*/
		
		System.out.println(seller);

	}

}

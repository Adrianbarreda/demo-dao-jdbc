package application;

import java.util.List;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
	
		/*Scanner sc = new Scanner(System.in);*/
		
		SellerDao sellerDao = DaoFactory.createrSellerDao(); /*Posso acrecentar 
		uma instanciação de um seller DAO. Dessa forma meu programa não conhece 
		a implementação só conhece a interface. É também uma forma de fazer uma 
		injeção de dependencia sem explicitar a implementação.*/
				
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
			for (Seller obj : list) {
				System.out.println(obj);
			}			
		System.out.println("\n=== TEST 3: seller findAll =====");		
		list = sellerDao.findAll();
		
			for (Seller obj : list) {
				System.out.println(obj);
			}
	}
}

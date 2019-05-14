package com.demo.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain {

	// test dao methods
	public static void main(String[] args) {
		/*
		 * System.out.println("Please enter name: "); Scanner sc1 = new
		 * Scanner(System.in); String name = sc1.nextLine();
		 * 
		 * System.out.println("Please enter price: "); double price = sc1.nextDouble();
		 * 
		 * System.out.println("Please enter catergory id: "); int cateId =
		 * sc1.nextInt();
		 * 
		 * System.out.println("Please enter model year: "); int modelY = sc1.nextInt();
		 * 
		 * sc1.close();
		 */

		Products p = new Products("iphone xs", 999.99, 1, 2018);
		ProductsDAO pd = new ProductsDAO();
		pd.add(p);
		// pd.delete(8);

		
		//Products pr = new Products("macbook", 1499.99, 3, 2019);
		//pd.update(pr);

		// get method based on product id
		Products newp = pd.get(7);
		System.out.println(newp.toString());

		// view all records in database
		System.out.println("Current records in products table: ");
		List<Products> list = pd.view();
		for (int i = 0; i < list.size(); i++) {
			String output = list.get(i).toString();
			System.out.println(output);
		}
		
		//System.out.println(new ProductsDAO().view().size());

	}

}

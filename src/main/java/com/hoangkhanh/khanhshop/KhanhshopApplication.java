package com.hoangkhanh.khanhshop;

import com.hoangkhanh.khanhshop.model.Category;
import com.hoangkhanh.khanhshop.model.Product;
import com.hoangkhanh.khanhshop.model.User;
import com.hoangkhanh.khanhshop.repository.CategoryRepository;
import com.hoangkhanh.khanhshop.repository.ProductRepository;
import com.hoangkhanh.khanhshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
//import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class KhanhshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhanhshopApplication.class, args);
	}

//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//
//	@Autowired
//	CategoryRepository categoryRepository;
//
//	@Autowired
//	ProductRepository productRepository;
//
//	@Override
//	public void run(String... args) throws Exception{
//
//		Category category = new Category();
//		category.setName("Chairs");
//		Category category1 = new Category();
//		category1.setName("Beds");
//		Category category2 = new Category();
//		category2.setName("Accesories");
//		Category category3 = new Category();
//		category3.setName("Home Deco");
//		Category category4 = new Category();
//		category4.setName("Tables");
//
//		categoryRepository.save(category);
//		categoryRepository.save(category1);
//		categoryRepository.save(category2);
//		categoryRepository.save(category3);
//		categoryRepository.save(category4);
//
//		Product product = new Product();
//		product.setAbout("avsdad");
//		product.setAvailable(true);
//		product.setCreateDate(new Date());
//		product.setImage("product1.jpg");
//		product.setName("Modern Chair");
//		product.setPrice(343d);
//		product.setQuantity(23);
//		product.setCategory(category);
//
//		Product product1 = new Product();
//		product1.setAbout("sadsdasdsad");
//		product1.setAvailable(true);
//		product1.setCreateDate(new Date());
//		product1.setImage("product2.jpg");
//		product1.setName("Modern Chair");
//		product1.setPrice(343d);
//		product1.setQuantity(23);
//		product1.setCategory(category1);
//
//		productRepository.save(product);
//		productRepository.save(product1);
//
//		User user = new User();
//		user.setAddress("asdsad");
//		user.setEmail("khanh@gmail.com");
//		user.setFullname("Khanh");
//		user.setUsername("khanhdepzai");
//		user.setPassword(passwordEncoder.encode("hello"));
//		user.setPhone(1434234);
//	user.setUserRole("ROLE_EMPLOYEE");
//
//		User user1 = new User();
//		user1.setAddress("asdsad");
//		user1.setEmail("kkkk@gmail.com");
//		user1.setFullname("Khanh");
//		user1.setUsername("hoahong");
//		user1.setPassword(passwordEncoder.encode("hello"));
//		user1.setPhone(1434234);
//		user1.setUserRole("ROLE_USER");
//
//		User user2 = new User();
//		user2.setAddress("asdsad");
//		user2.setEmail("asadas@gmail.com");
//		user2.setFullname("Khanh");
//		user2.setUsername("ngungo");
//		user2.setPassword(passwordEncoder.encode("hello"));
//		user2.setPhone(1434234);
//		user2.setUserRole("ROLE_MANAGER");
//
//			userRepository.save(user);
//			userRepository.save(user1);
//			userRepository.save(user2);
//
//	}
//


}

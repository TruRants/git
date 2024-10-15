package com.stolle.portal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.stolle.portal.domain.MachineRepository;
import com.stolle.portal.domain.User;
import com.stolle.portal.domain.UserRepository;
import com.stolle.portal.domain.CustomerRepository;
import com.stolle.portal.domain.Machine;
import com.stolle.portal.domain.Customer;



@SpringBootApplication
public class PortalApplication implements CommandLineRunner {
	//Logger class to log errors and other messages for the application
	/*There are seven different levels of logging: TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF */

	private static final Logger logger = LoggerFactory.getLogger(PortalApplication.class);

	@Autowired
	private MachineRepository mrepo;

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
		logger.info("Logger Message");
	}

	@Override
	public void run(String... args) throws Exception{

		//Add customers
		Customer customer1 = new Customer("stolle", "centennial");
		Customer customer2 = new Customer("stolle2", "location2");
		custRepo.saveAll(Arrays.asList(customer1, customer2));

		Machine machine1 = new Machine("machine1", customer1);
		Machine machine2 = new Machine("machine2", customer2);
		Machine machine3 = new Machine("machine3", customer1);
		Machine machine4 = new Machine("machine4", customer2);

		mrepo.saveAll(Arrays.asList(machine1, machine2, machine3, machine4));
		
		//Username: user, password: user
		urepository.save(new User("user","$2a$10$78RE4WN9KCMz2xHSR11GM.1/jd8V1oazB70xyaIkdFIlHAEpVCiMe ", "USER"));
		urepository.save(new User("admin", "$2a$10$ziLBpstedCKzorPmJgoVeOzm/83YIt/h7k.LeZysfZKRJ5KtoEUVG", "ADMIN"));

	}

}

package sale_savvy.service;

import org.springframework.stereotype.Service;

import sale_savvy.entity.Customer;
import sale_savvy.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation implements CustomerService {
	  
		CustomerRepository cusRepo;

		public CustomerServiceImplementation(CustomerRepository cusRepo) {
			super();
			this.cusRepo = cusRepo;
		}


		public boolean validate(Customer cus) {
//			String dbPass = cusRepo.findById(cus.getId()).get().getPassword();
//			return cus.getPassword().equals(dbPass);
			Customer dbCus =
		            cusRepo.findByUsername(cus.getUsername());

		    if (dbCus == null) {
		        return false;
		    }

		    return cus.getPassword().equals(dbCus.getPassword());
		}

		
		public String addUser(Customer cus) {
			//check username exists or not
			String uName = cus.getUsername();
			Customer dbCus = cusRepo.findByUsername(uName);
			boolean exists = (dbCus != null);
			
			if(exists == true)
				return "username already exists!";
			else {
				cusRepo.save(cus);
				return "user added successfully!";
			}
		}
  }

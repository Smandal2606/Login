package sale_savvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sale_savvy.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByUsername(String uName);

}

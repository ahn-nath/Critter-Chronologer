package com.udacity.jdnd.course3.critter.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer getCustomerByPets(long id);

}

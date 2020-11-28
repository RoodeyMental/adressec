package edu.hm.wiesheu.markus.vssec.addressec.repository;


import edu.hm.wiesheu.markus.vssec.addressec.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

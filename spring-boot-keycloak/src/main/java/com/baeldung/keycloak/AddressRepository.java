package com.baeldung.keycloak;

import com.baeldung.keycloak.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

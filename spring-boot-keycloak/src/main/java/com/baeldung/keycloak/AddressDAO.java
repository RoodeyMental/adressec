package com.baeldung.keycloak;

import com.baeldung.keycloak.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address, Long> {
}

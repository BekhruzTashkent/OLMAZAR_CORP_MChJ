package uz.pdp.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.restfullapi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

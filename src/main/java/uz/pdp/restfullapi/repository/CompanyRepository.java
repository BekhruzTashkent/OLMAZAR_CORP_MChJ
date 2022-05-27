package uz.pdp.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.restfullapi.entity.Company;
import uz.pdp.restfullapi.entity.Worker;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}

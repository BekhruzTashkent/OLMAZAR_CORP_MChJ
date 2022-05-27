package uz.pdp.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.restfullapi.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

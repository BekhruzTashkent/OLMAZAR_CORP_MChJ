package uz.pdp.restfullapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.restfullapi.entity.Address;
import uz.pdp.restfullapi.entity.Company;
import uz.pdp.restfullapi.entity.Department;
import uz.pdp.restfullapi.entity.Worker;
import uz.pdp.restfullapi.payload.ApiResponse;
import uz.pdp.restfullapi.payload.WorkerDto;
import uz.pdp.restfullapi.repository.AddressRepository;
import uz.pdp.restfullapi.repository.CompanyRepository;
import uz.pdp.restfullapi.repository.DepartmentRepository;
import uz.pdp.restfullapi.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    WorkerRepository workerRepository;

    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Integer id){
        Optional<Worker> workerRepositoryById = workerRepository.findById(id);
        if(workerRepositoryById.isPresent())
            return workerRepositoryById.get();
        return null;
    }

    public ApiResponse addWorker( WorkerDto workerDto){
        boolean existsByPhoneNumber = workerRepository.existsByPhoneNumber(workerDto.getPhoneNumber());
        if(existsByPhoneNumber) {
            return new ApiResponse("there such phone number",false);
        }
        Address address = new Address();
        address.setHomeNumber(workerDto.getHomeNumber());
        address.setStreet(workerDto.getStreet());
        Address address1 = addressRepository.save(address);

        Company company = new Company();
        company.setCorpName(workerDto.getCorpName());
        company.setDirectorName(workerDto.getDirectorName());
        company.setAddress(address1);
        Company company1 = companyRepository.save(company);

        Department department = new Department();
        department.setName(workerDto.getDepartmentName());
        department.setCompany(company1);
        Department department1 = departmentRepository.save(department);

        Worker worker = new Worker();
        worker.setName(workerDto.getWorkerName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());
        worker.setWorkerAddress(address1);
        worker.setDepartment(department1);
        workerRepository.save(worker);
        return new ApiResponse("saved", true);
    }

    public ApiResponse updateWorker(Integer id, WorkerDto workerDto){
        boolean existsByPhoneNumberAndIdNot = workerRepository.existsByPhoneNumberAndIdNot(workerDto.getPhoneNumber(), id);
        if(existsByPhoneNumberAndIdNot){
            return new ApiResponse("there such number for worker", false);
        }

        Optional<Worker> workerRepositoryById = workerRepository.findById(id);
        if(!workerRepositoryById.isPresent()){
            return new ApiResponse("there no such worker", false);
        }

        Worker worker = workerRepositoryById.get();
        Address address = new Address();
        address.setHomeNumber(workerDto.getHomeNumber());
        address.setStreet(workerDto.getStreet());
        Address address1 = addressRepository.save(address);

        Company company = new Company();
        company.setCorpName(workerDto.getCorpName());
        company.setDirectorName(workerDto.getDirectorName());
        company.setAddress(address1);
        Company company1 = companyRepository.save(company);

        Department department = new Department();
        department.setName(workerDto.getDepartmentName());
        department.setCompany(company1);
        Department department1 = departmentRepository.save(department);

        worker.setName(workerDto.getWorkerName());
        worker.setPhoneNumber(workerDto.getPhoneNumber());
        worker.setWorkerAddress(address1);
        worker.setDepartment(department1);
        workerRepository.save(worker);
        return new ApiResponse("saved", true);

    }

    public ApiResponse deleteWorker(Integer id){
        workerRepository.deleteById(id);
        return new ApiResponse("deleted",true);
    }

}

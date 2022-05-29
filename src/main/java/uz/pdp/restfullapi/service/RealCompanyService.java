package uz.pdp.restfullapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.restfullapi.entity.Address;
import uz.pdp.restfullapi.entity.Company;
import uz.pdp.restfullapi.payload.ApiResponse;
import uz.pdp.restfullapi.payload.CompanyDto;
import uz.pdp.restfullapi.repository.AddressRepository;
import uz.pdp.restfullapi.repository.CompanyRepository;
import uz.pdp.restfullapi.repository.DepartmentRepository;
import uz.pdp.restfullapi.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RealCompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    WorkerRepository workerRepository;

    public List<Company> getCompany(){
        List<Company> companyList = companyRepository.findAll();
        return companyList;
    }

    public Company getCompanyById(Integer id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.get();
    }

    public ApiResponse addCompany(CompanyDto companyDto){

        Address address = new Address();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        Address address1 = addressRepository.save(address);

        Company company = new Company();
        company.setCorpName(company.getCorpName());
        company.setDirectorName(company.getDirectorName());
        company.setAddress(address1);
        companyRepository.save(company);
        return new ApiResponse("added", true);
    }

    public ApiResponse updateCompany(Integer id, CompanyDto companyDto){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(!optionalCompany.isPresent()){
            return new ApiResponse("no such company", false);
        }

        Company company = optionalCompany.get();
        Address address = new Address();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        Address address1 = addressRepository.save(address);

        company.setCorpName(company.getCorpName());
        company.setDirectorName(company.getDirectorName());
        company.setAddress(address1);
        companyRepository.save(company);
        return new ApiResponse("added", true);
    }

    public ApiResponse deleteCompany(Integer id){
        companyRepository.deleteById(id);
        return new ApiResponse("successfully deleted", true);
    }

}

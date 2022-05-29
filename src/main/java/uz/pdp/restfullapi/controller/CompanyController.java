package uz.pdp.restfullapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.restfullapi.entity.Company;
import uz.pdp.restfullapi.payload.ApiResponse;
import uz.pdp.restfullapi.payload.CompanyDto;
import uz.pdp.restfullapi.service.RealCompanyService;

import java.util.List;

@RestController
public class CompanyController {

@Autowired
    RealCompanyService realCompanyService;

@GetMapping("api/company")
    public ResponseEntity<List<Company>> getCompany(){
    List<Company> companyList = realCompanyService.getCompany();
    return ResponseEntity.ok(companyList);
    }

    @GetMapping("api/company")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer id){
        Company companyById = realCompanyService.getCompanyById(id);
        return ResponseEntity.ok(companyById);
    }

    @PostMapping("api/company")
    public ResponseEntity<ApiResponse> insertCompany(@RequestBody CompanyDto companyDto){
        ApiResponse addCompany = realCompanyService.addCompany(companyDto);
        return ResponseEntity.ok(addCompany);
    }

    @PutMapping("api/company/{id}")
    public ResponseEntity<ApiResponse> updateCompany(@PathVariable Integer id, @RequestBody CompanyDto companyDto){
        ApiResponse updateCompany = realCompanyService.updateCompany(id, companyDto);
        return ResponseEntity.ok(updateCompany);
    }

    @DeleteMapping("api/comoany/{id}")
    public ResponseEntity<ApiResponse> deleteComoany(@PathVariable Integer id){
        ApiResponse deleteCompany = realCompanyService.deleteCompany(id);
        return ResponseEntity.ok(deleteCompany);
    }

}

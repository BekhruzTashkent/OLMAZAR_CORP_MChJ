package uz.pdp.restfullapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.restfullapi.entity.Worker;
import uz.pdp.restfullapi.payload.ApiResponse;
import uz.pdp.restfullapi.payload.WorkerDto;
import uz.pdp.restfullapi.service.CompanyService;

import java.util.List;

@RestController
public class WorkerController {
    @Autowired
    CompanyService companyService;

    @GetMapping("api/company")
    public ResponseEntity<List<Worker>> getWorkers(){
        List<Worker> workerList = companyService.getWorkers();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping("api/company/{id}")
    public ResponseEntity<Worker> getWorker(@PathVariable Integer id){
        Worker workerById = companyService.getWorkerById(id);
        return ResponseEntity.ok(workerById);
    }

    @PostMapping("api/company")
    public ResponseEntity<ApiResponse> addWorker( @RequestBody WorkerDto workerDto){
        ApiResponse addWorker = companyService.addWorker(workerDto);
        return ResponseEntity.ok(addWorker);
    }

    @PutMapping("api/company/{id}")
    public ResponseEntity<ApiResponse> editWorker(@PathVariable Integer id, @RequestBody WorkerDto workerDto){
        ApiResponse updateWorker = companyService.updateWorker(id, workerDto);
        return ResponseEntity.ok(updateWorker);
    }

    @DeleteMapping("api/company/{id}")
    public ResponseEntity<ApiResponse> deleteWorker(@PathVariable Integer id){
        ApiResponse deleteWorker = companyService.deleteWorker(id);
        return ResponseEntity.ok(deleteWorker);
    }

}

package com.arvind.companyms;

import com.arvind.companyms.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyServiceImpl;

    @GetMapping
    public List<Company> getCompanies(){
        return companyServiceImpl.getCompanies();
    }
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyServiceImpl.createCompany(company);
        return new ResponseEntity<String>("Company created successfully!!!", HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        boolean isUpdated = companyServiceImpl.updateCompany(id,company);
        if(isUpdated)
            return ResponseEntity.ok("Company with id: "+ id+ "updated successfully!!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found!!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isCompany = companyServiceImpl.deleteCompany(id);
        if(isCompany)
            return ResponseEntity.ok("Company deleted successfully!!!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found!!!");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company = companyServiceImpl.getCompany(id);
        if(company!=null)
            return new ResponseEntity<Company>(company,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


}

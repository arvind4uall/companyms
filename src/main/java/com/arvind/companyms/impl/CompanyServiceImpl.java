package com.arvind.companyms.impl;

import com.arvind.companyms.Company;
import com.arvind.companyms.CompanyRepository;
import com.arvind.companyms.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long companyId,Company companyToUpdate) {
        Optional<Company> companyOptional=companyRepository.findById(companyId);
        if(companyOptional.isPresent()){
            companyToUpdate.setId(companyId);
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if(companyOptional.isPresent()){
            companyRepository.deleteById(companyId);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompany(Long companyId) {
        return companyRepository.findById(companyId).orElse(null);
    }
}

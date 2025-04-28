package com.arvind.companyms;


import com.arvind.companyms.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanies();
    void createCompany(Company company);
    boolean updateCompany(Long id,Company company);
    boolean deleteCompany(Long companyId);
    Company getCompany(Long companyId);
    void updateCompanyRating(ReviewMessage reviewMessage);
}

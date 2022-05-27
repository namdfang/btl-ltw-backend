package com.btl.web.service;

import com.btl.web.model.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    public CompanyDTO addCompany(CompanyDTO companyDTO);
    public CompanyDTO updateCompany(int companyId, CompanyDTO companyDTO);
    public boolean deleteCompany(int companyId);
    public List<CompanyDTO> getAllCompany();
    public CompanyDTO getCompanyById(int id);
}

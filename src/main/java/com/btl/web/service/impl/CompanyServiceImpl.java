package com.btl.web.service.impl;

import com.btl.web.model.Company;
import com.btl.web.model.dto.CompanyDTO;
import com.btl.web.model.mapper.CompanyMapper;
import com.btl.web.repository.CompanyRepository;
import com.btl.web.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    final private CompanyRepository companyRepository;
    final private CompanyMapper companyMapper;

    @Override
    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        return companyMapper.convertToDTO(companyRepository.save(companyMapper.convertToEntity(companyDTO)));
    }

    @Override
    public CompanyDTO updateCompany(int companyId, CompanyDTO companyDTO) {
        Company updatedCompany = companyRepository.findById(companyId).orElse(null);
        if (updatedCompany != null) {
            updatedCompany = companyMapper.convertToEntity(companyDTO);
            updatedCompany.setId(companyId);
            return companyMapper.convertToDTO(companyRepository.save(updatedCompany));
        }
        return null;

    }

    @Override
    public boolean deleteCompany(int companyId) {
        Company deletedCompany = companyRepository.findById(companyId).orElse(null);
        if (deletedCompany != null) {
            companyRepository.delete(deletedCompany);
            return true;
        }
        return false;
    }

    @Override
    public List<CompanyDTO> getAllCompany() {
        return companyRepository.findAll().stream().map(c -> companyMapper.convertToDTO(c)).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(int id) {
        Company company = companyRepository.findById(id).orElse(null);
        return company==null ? null:companyMapper.convertToDTO(company);
    }
}

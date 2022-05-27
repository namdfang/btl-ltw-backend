package com.btl.web.model.mapper;

import com.btl.web.model.Building;
import com.btl.web.model.Company;
import com.btl.web.model.dto.CompanyDTO;
import com.btl.web.repository.BuildingRepository;
import com.btl.web.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyMapper {
    
    final private BuildingRepository buildingRepository;

    public CompanyDTO convertToDTO(Company company){
        return CompanyDTO.builder()
                .buildingId(company.getBuilding().getId())
                .companyName(company.getCompanyName())
                .authorizedCapital(company.getAuthorizedCapital())
                .fieldOfOperation(company.getFieldOfOperation())
                .addressInBuilding(company.getAddressInBuilding())
                .groundInArea(company.getGroundInArea())
                .phoneNumber(company.getPhoneNumber())
                .taxNumber(company.getTaxNumber())
                .build();
    }

    public Company convertToEntity(CompanyDTO companyDTO){
        Building building = buildingRepository.findById(companyDTO.getBuildingId()).orElse(null);//throw exception
        return Company.builder()
                .id(companyDTO.getId())
                .companyName(companyDTO.getCompanyName())
                .addressInBuilding(companyDTO.getAddressInBuilding())
                .authorizedCapital(companyDTO.getAuthorizedCapital())
                .fieldOfOperation(companyDTO.getFieldOfOperation())
                .phoneNumber(companyDTO.getPhoneNumber())
                .taxNumber(companyDTO.getTaxNumber())
                .groundInArea(companyDTO.getGroundInArea())
                .build();
    }
}

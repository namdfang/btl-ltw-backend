package com.btl.web.model.mapper;

import com.btl.web.model.Services;
import com.btl.web.model.dto.ServiceDTO;
import org.springframework.stereotype.Component;

@Component
public class ServiceMapper {

    public ServiceDTO convertToDTO(Services services) {
        return ServiceDTO.builder()
                .code(services.getCode())
                .name(services.getName())
                .type(services.getType())
                .unitPrice(services.getUnitPrice())
                .build();
    }

    public Services convertToEntity(ServiceDTO serviceDTO) {
        return Services.builder()
                .code(serviceDTO.getCode())
                .name(serviceDTO.getName())
                .type(serviceDTO.getType())
                .unitPrice(serviceDTO.getUnitPrice())
                .build();
    }
}

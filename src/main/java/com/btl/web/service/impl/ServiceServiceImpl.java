package com.btl.web.service.impl;

import com.btl.web.model.Services;
import com.btl.web.model.dto.ServiceDTO;
import com.btl.web.model.mapper.ServiceMapper;
import com.btl.web.repository.ServiceRepository;
import com.btl.web.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    final private ServiceRepository serviceRepository;
    final private ServiceMapper serviceMapper;

    @Override
    public ServiceDTO addService(ServiceDTO serviceDTO) {
        return serviceMapper.convertToDTO(serviceRepository.save(serviceMapper.convertToEntity(serviceDTO)));
    }

    @Override
    public ServiceDTO updateService(int serviceId, ServiceDTO serviceDTO) {
        Services updatedService = serviceRepository.findById(serviceId).orElse(null);
        if (updatedService!=null) {
            updatedService = serviceMapper.convertToEntity(serviceDTO);
            updatedService.setId(serviceId);
            return serviceMapper.convertToDTO(serviceRepository.save(updatedService));
        }
        return null;

    }

    @Override
    public boolean deleteService(int serviceId) {
        Services deletedService = serviceRepository.findById(serviceId).orElse(null);
        if(deletedService!=null) {
            serviceRepository.delete(deletedService);
            return true;
        }
        return false;
    }

    @Override
    public List<ServiceDTO> getAllService() {
         return serviceRepository.findAll()
                 .stream().map(s -> serviceMapper.convertToDTO(s))
                 .collect(Collectors.toList());
    }

    @Override
    public ServiceDTO getServiceById(int serviceId) {
        Services service = serviceRepository.findById(serviceId).orElse(null);
        return service==null ? null : serviceMapper.convertToDTO(service);
    }
}

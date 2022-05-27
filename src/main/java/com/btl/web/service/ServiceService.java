package com.btl.web.service;

import com.btl.web.model.dto.ServiceDTO;

import java.util.List;

public interface ServiceService {

    public ServiceDTO addService(ServiceDTO serviceDTO);
    public ServiceDTO updateService(int serviceId, ServiceDTO serviceDTO);
    public boolean deleteService(int serviceId);
    public List<ServiceDTO> getAllService();
    public ServiceDTO getServiceById(int serviceId);
}

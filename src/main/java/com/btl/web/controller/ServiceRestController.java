package com.btl.web.controller;

import com.btl.web.model.dto.ServiceDTO;
import com.btl.web.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/services")
@RequiredArgsConstructor
public class ServiceRestController {

    final private ServiceService serviceService;

    @PostMapping()
    public ResponseEntity<ServiceDTO> addService(@RequestBody ServiceDTO serviceDTO) {
        ServiceDTO addedService = serviceService.addService(serviceDTO);
        return new ResponseEntity<>(addedService, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ServiceDTO> updateService(@PathVariable("id") int serviceId,
                                                    @RequestBody ServiceDTO serviceDTO) {
        ServiceDTO updatedService = serviceService.updateService(serviceId, serviceDTO);
        if(updatedService!=null)
            return new ResponseEntity<>(updatedService, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") int serviceId) {
        boolean result = serviceService.deleteService(serviceId);
        if(result) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<ServiceDTO>> getAllService() {
        List<ServiceDTO> services = serviceService.getAllService();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceDTO> getServiceById(@PathVariable("id") int serviceId) {
        ServiceDTO service = serviceService.getServiceById(serviceId);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }
}

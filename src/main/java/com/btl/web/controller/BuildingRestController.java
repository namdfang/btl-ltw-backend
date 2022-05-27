package com.btl.web.controller;

import com.btl.web.model.dto.BuildingDTO;
import com.btl.web.model.dto.CompanyDTO;
import com.btl.web.model.dto.StaffDTO;
import com.btl.web.service.BuildingService;
import com.btl.web.service.StaffService;
import com.btl.web.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
public class BuildingRestController {
    final private CompanyService companyService;
    final private BuildingService buildingService;
    final private StaffService staffService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable("id") int buildingId) {
        BuildingDTO buildingDTO = buildingService.getBuildingById(buildingId);
        return new ResponseEntity<>(buildingDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BuildingDTO>> getAllBuilding() {
        List<BuildingDTO> buildingDTOs = buildingService.getAllBuilding();
        return new ResponseEntity<>(buildingDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/staffs")
    public ResponseEntity<List<StaffDTO>> getAllStaffBuilding(@PathVariable("id") int buildingId) {
        List<StaffDTO> staffDTOS = staffService.getAllStaffBuilding(buildingId);
        return new ResponseEntity<>(staffDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/companies")
    public ResponseEntity<List<CompanyDTO>> getAllCompanyBuilding(@PathVariable("id") int buildingId) {
        List<CompanyDTO> companyDTOs = companyService.getAllCompanyBuilding(buildingId);
        return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO buildingDTO) {
        BuildingDTO createdBuilding = buildingService.addBuilding(buildingDTO);
        return new ResponseEntity<>(createdBuilding, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BuildingDTO> updateBuilding(@PathVariable("id") int buildingId,
                                                    @RequestBody BuildingDTO buildingDTO) {
        BuildingDTO updatedBuilding = buildingService.updateBuilding(buildingId, buildingDTO);
        if (updatedBuilding!=null)
            return new ResponseEntity<>(updatedBuilding, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBuilding(@PathVariable("id") int buildingId) {
        boolean deleteResult = buildingService.deleteBuilding(buildingId);
        if(deleteResult == true) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

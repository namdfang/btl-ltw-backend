package com.btl.web.service.impl;

import com.btl.web.model.Staff;
import com.btl.web.model.dto.StaffDTO;
import com.btl.web.model.mapper.StaffMapper;
import com.btl.web.repository.StaffRepository;
import com.btl.web.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    final private StaffRepository staffRepository;
    final private StaffMapper staffMapper;

    @Override
    public StaffDTO addStaff(StaffDTO staffDTO) {
        return staffMapper.convertToDTO(staffRepository.save(staffMapper.convertToEntity(staffDTO)));
    }

    @Override
    public StaffDTO updateStaff(int staffId, StaffDTO staffDTO) {
        Staff updatedStaff = staffRepository.findById(staffId).orElse(null);
        if(updatedStaff!=null) {
            updatedStaff = staffMapper.convertToEntity(staffDTO);
            updatedStaff.setId(staffId);
            return staffMapper.convertToDTO(staffRepository.save(updatedStaff));
        }
        return null;
    }

    @Override
    public boolean deleteStaff(int staffId) {
        Staff deletedStaff = staffRepository.findById(staffId).orElse(null);
        if(deletedStaff!=null) {
            staffRepository.delete(deletedStaff);
            return true;
        }
        return false;
    }

    @Override
    public StaffDTO getStaffById(int staffId) {
        Staff staff = staffRepository.findById(staffId).orElse(null);
        return staff==null ? null : staffMapper.convertToDTO(staff);
    }

    @Override
    public List<StaffDTO> getAllStaffBuilding(int buildingId) {
        return staffRepository.findByBuildingId(buildingId)
                .stream().map(e -> staffMapper.convertToDTO(e))
                .collect(Collectors.toList());
    }
}

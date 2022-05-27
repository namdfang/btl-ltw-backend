package com.btl.web.model.mapper;

import com.btl.web.model.Staff;
import com.btl.web.model.dto.StaffDTO;
import org.springframework.stereotype.Component;

@Component
public class StaffMapper {

    public StaffDTO convertToDTO(Staff staff) {
        return StaffDTO.builder()
                .name(staff.getName())
                .code(staff.getCode())
                .address(staff.getAddress())
                .dob(staff.getDob())
                .phoneNumber(staff.getPhoneNumber())
                .position(staff.getPosition())
                .wage(staff.getWage())
                .build();
    }

    public Staff convertToEntity(StaffDTO staffDTO) {
        return Staff.builder()
                .code(staffDTO.getCode())
                .name(staffDTO.getName())
                .dob(staffDTO.getDob())
                .address(staffDTO.getAddress())
                .position(staffDTO.getPosition())
                .wage(staffDTO.getWage())
                .phoneNumber(staffDTO.getPhoneNumber())
                .build();
    }
}

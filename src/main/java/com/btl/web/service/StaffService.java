package com.btl.web.service;

import com.btl.web.model.dto.StaffDTO;

import java.util.List;

public interface StaffService {

    public StaffDTO addStaff(StaffDTO staffDTO);
    public StaffDTO updateStaff(int staffId, StaffDTO staffDTO);
    public boolean deleteStaff(int staffId);
    public StaffDTO getStaffById(int staffId);
    public List<StaffDTO> getAllStaffBuilding(int buildingId);

}

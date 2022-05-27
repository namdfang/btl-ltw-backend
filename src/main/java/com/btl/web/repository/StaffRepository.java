package com.btl.web.repository;

import com.btl.web.model.Staff;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    public List<Staff> findByBuildingId(int buildingId);
}

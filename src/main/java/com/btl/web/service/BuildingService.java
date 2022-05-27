package com.btl.web.service;

import com.btl.web.model.dto.BuildingDTO;

import java.util.List;


public interface BuildingService {
        public BuildingDTO addBuilding(BuildingDTO buildingDTO);
        public BuildingDTO updateBuilding(int buildingId, BuildingDTO buildingDTO);
        public boolean deleteBuilding(int companyId);
        public List<BuildingDTO> getAllBuilding();
        public BuildingDTO getBuildingById(int id);
}

package com.btl.web.model.mapper;

import com.btl.web.model.Building;
import com.btl.web.model.dto.BuildingDTO;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {

    public BuildingDTO convertToDTO(Building building){
        return BuildingDTO.builder()
                .id(building.getId())
                .buildingName(building.getBuildingName())
                .addressBuilding(building.getAddressBuilding())
                .groundArea(building.getGroundArea())
                .build();
    }

    public Building convertToEntity(BuildingDTO buildingDTO){
        return Building.builder()
                .id(buildingDTO.getId())
                .buildingName(buildingDTO.getBuildingName())
                .addressBuilding(buildingDTO.getAddressBuilding())
                .groundArea(buildingDTO.getGroundArea())
                .build();
    }
}
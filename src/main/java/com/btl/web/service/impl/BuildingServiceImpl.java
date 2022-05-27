package com.btl.web.service.impl;

import com.btl.web.model.Building;
import com.btl.web.model.dto.BuildingDTO;
import com.btl.web.model.mapper.BuildingMapper;
import com.btl.web.repository.BuildingRepository;
import com.btl.web.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    final private BuildingRepository buildingRepository;
    final private BuildingMapper buildingMapper;

    @Override
    public BuildingDTO addBuilding(BuildingDTO buildingDTO) {
        return buildingMapper.convertToDTO(buildingRepository.save(buildingMapper.convertToEntity(buildingDTO)));
    }

    @Override
    public BuildingDTO updateBuilding(int buildingId, BuildingDTO buildingDTO) {
        Building updatedBuilding = buildingRepository.findById(buildingId).orElse(null);
        if (updatedBuilding != null) {
            updatedBuilding = buildingMapper.convertToEntity(buildingDTO);
            updatedBuilding.setId(buildingId);
            return buildingMapper.convertToDTO(buildingRepository.save(updatedBuilding));
        }
        return null;

    }

    @Override
    public boolean deleteBuilding(int buildingId) {
        Building deletedBuilding = buildingRepository.findById(buildingId).orElse(null);
        if (deletedBuilding != null) {
            buildingRepository.delete(deletedBuilding);
            return true;
        }
        return false;
    }

    @Override
    public List<BuildingDTO> getAllBuilding() {
        return buildingRepository.findAll().stream().map(c -> buildingMapper.convertToDTO(c)).collect(Collectors.toList());
    }

    @Override
    public BuildingDTO getBuildingById(int id) {
        Building building = buildingRepository.findById(id).orElse(null);
        return building==null ? null:buildingMapper.convertToDTO(building);
    }
}

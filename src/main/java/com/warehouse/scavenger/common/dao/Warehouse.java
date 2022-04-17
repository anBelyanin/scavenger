package com.warehouse.scavenger.common.dao;

import java.util.List;

public class Warehouse {

    private Long maxPlaceCount;
    private List<String> segments;
    private List<WarehousePlace> warehousePlaces;

    public Long getMaxPlaceCount() {
        return maxPlaceCount;
    }

    public void setMaxPlaceCount(Long maxPlaceCount) {
        this.maxPlaceCount = maxPlaceCount;
    }

    public List<String> getSegments() {
        return segments;
    }

    public void setSegments(List<String> segments) {
        this.segments = segments;
    }

    public List<WarehousePlace> getWarehousePlaces() {
        return warehousePlaces;
    }

    public void setWarehousePlaces(List<WarehousePlace> warehousePlaces) {
        this.warehousePlaces = warehousePlaces;
    }
}

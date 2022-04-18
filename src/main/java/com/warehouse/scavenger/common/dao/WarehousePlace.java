package com.warehouse.scavenger.common.dao;

import java.util.List;

public class WarehousePlace {

    private String placeNumber;
    private String segment;
    private Long maxCountObject;
    private List<WarehouseObject> warehouseObjects;

    public WarehousePlace(String placeNumber, String segment, Long maxCountObject) {
        this.placeNumber = placeNumber;
        this.segment = segment;
        this.maxCountObject = maxCountObject;
    }
}

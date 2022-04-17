package com.warehouse.scavenger.service.warehouse;

import com.warehouse.scavenger.common.dao.Warehouse;
import com.warehouse.scavenger.common.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WarehouseService {

    private Warehouse warehouse = new Warehouse();

    public void addSegment(String segmentName) {
        List<String> segments = warehouse.getSegments();
        segments.add(segmentName);
        warehouse.setSegments(segments);
    }

    public void deleteSegment(String segmentName) throws BusinessException {
        List<String> segments = warehouse.getSegments();
        boolean isDeleted = segments.remove(segmentName);
        if (!isDeleted) {
            throw new BusinessException("Удаляемый сегмент склада не был найден в списке зарегистрированных сегментов");
        }
        warehouse.setSegments(segments);
    }

    public void changeMaxCountPlaces (Long newCountPlaces) throws BusinessException {
        boolean isRealCount = warehouse.getWarehousePlaces().size() == newCountPlaces;
        if(isRealCount) {
            warehouse.setMaxPlaceCount(newCountPlaces);
        } else {
            throw new BusinessException("Новое количество мест не соответсвует фактическому количеству товаро-мест на складе");
        }
    }

}

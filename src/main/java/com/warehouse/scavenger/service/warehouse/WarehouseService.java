package com.warehouse.scavenger.service.warehouse;

import com.warehouse.scavenger.common.dao.Warehouse;
import com.warehouse.scavenger.common.dao.WarehousePlace;
import com.warehouse.scavenger.common.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WarehouseService {

    private Warehouse warehouse = new Warehouse();

    public void addSegment(String segmentName) throws BusinessException {
        boolean isSegmentExists = warehouse.getSegments().contains(segmentName);
        if(!isSegmentExists) {
            warehouse.getSegments().add(segmentName);
        } else {
            throw new BusinessException("Сегмент уже существует.");
        }
    }

    public void deleteSegment(String segmentName) throws BusinessException {
        boolean isDeleted = warehouse.getSegments().remove(segmentName);
        if (!isDeleted) {
            throw new BusinessException("Удаляемый сегмент склада не был найден в списке зарегистрированных сегментов.");
        }
    }

    public void changeMaxCountPlaces(Long newCountPlaces) throws BusinessException {
        boolean isRealCount = warehouse.getWarehousePlaces().size() <= newCountPlaces;
        if(isRealCount) {
            warehouse.setMaxPlaceCount(newCountPlaces);
        } else {
            throw new BusinessException("Новое количество мест не соответствует фактическому количеству товаро-мест на складе.");
        }
    }

    public void addWarehousePlace(String placeNumber, String segment, Long maxCountObjects) throws BusinessException {
        boolean isAddingPossible = warehouse.getWarehousePlaces().size() < warehouse.getMaxPlaceCount();
        boolean isSegmentExists = warehouse.getSegments().contains(segment);
        if (isAddingPossible && isSegmentExists) {
            WarehousePlace newWarehousePlace = new WarehousePlace(placeNumber, segment, maxCountObjects);
            warehouse.getWarehousePlaces().add(newWarehousePlace);
        } else if (!isAddingPossible) {
            throw new BusinessException("Невозможно добавить место. Превышение максимального количества мест.");
        } else if (!isSegmentExists) {
            throw new BusinessException("Невозможно добавить место с таким сегментом. Сегмент не существует.");
        }
    }

}

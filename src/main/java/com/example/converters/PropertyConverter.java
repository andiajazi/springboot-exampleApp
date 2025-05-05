package com.example.converters;

import com.example.dto.PropertyDto;
import com.example.entity.Property;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public Property toEntity (PropertyDto propertyDto) {
        Property property = new Property(
                propertyDto.type(),
                propertyDto.location(),
                propertyDto.surface(),
                propertyDto.floors()
        );
        return property;
    }

    public PropertyDto toDto (Property property) {
        return new PropertyDto(
                property.getType(),
                property.getLocation(),
                property.getSurface(),
                property.getFloors()
        );
    }

}

package com.ravi.uber.configs;

import com.ravi.uber.dto.PointDto;
import com.ravi.uber.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(PointDto.class, Point.class).setConverter(mappingContext -> {
           PointDto pointDto = mappingContext.getSource();
           return GeometryUtil.createPoint(pointDto);
        });

        mapper.typeMap(Point.class, PointDto.class).setConverter(mappingContext -> {
           Point point = mappingContext.getSource();
           Double[] coordinates = {
                   point.getX(),point.getY()
           };
           return new PointDto(coordinates);
        });
        return mapper;
    }

}

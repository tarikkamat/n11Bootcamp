package com.tarikkamat.restaurantservice.mapper;

import com.tarikkamat.restaurantservice.dto.RestaurantDTO;
import com.tarikkamat.restaurantservice.entity.Restaurant;
import com.tarikkamat.restaurantservice.request.RestaurantRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO convertToRestaurantDTO(Restaurant restaurant);
    Restaurant convertToRestaurant(RestaurantRequest request);
    List<RestaurantDTO> convertToRestaurantDTOList(List<Restaurant> restaurants);

}

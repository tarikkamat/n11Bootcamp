package com.tarikkamat.restaurantservice.controller.contract.impl;

import com.tarikkamat.restaurantservice.controller.contract.RestaurantControllerContract;
import com.tarikkamat.restaurantservice.dto.RestaurantDTO;
import com.tarikkamat.restaurantservice.entity.Restaurant;
import com.tarikkamat.restaurantservice.mapper.RestaurantMapper;
import com.tarikkamat.restaurantservice.request.RestaurantRequest;
import com.tarikkamat.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RestaurantControllerContractImpl implements RestaurantControllerContract {

    private final RestaurantService restaurantService;

    @Override
    public RestaurantDTO addRestaurant(RestaurantRequest request) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.convertToRestaurant(request);
        restaurant = restaurantService.save(restaurant);
        return RestaurantMapper.INSTANCE.convertToRestaurantDTO(restaurant);
    }

}

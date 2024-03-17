package com.tarikkamat.restaurantservice.controller.contract.impl;

import com.tarikkamat.restaurantservice.controller.contract.RestaurantControllerContract;
import com.tarikkamat.restaurantservice.dto.RestaurantDTO;
import com.tarikkamat.restaurantservice.entity.Restaurant;
import com.tarikkamat.restaurantservice.mapper.RestaurantMapper;
import com.tarikkamat.restaurantservice.request.RestaurantRequest;
import com.tarikkamat.restaurantservice.request.RestaurantUpdateRequest;
import com.tarikkamat.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.findAll();
        return RestaurantMapper.INSTANCE.convertToRestaurantDTOList(restaurants);
    }

    @Override
    public RestaurantDTO getRestaurantById(UUID id) {
        Restaurant restaurant = restaurantService.findById(id);
        return RestaurantMapper.INSTANCE.convertToRestaurantDTO(restaurant);
    }

    @Override
    public void deleteRestaurantById(UUID id) {
        restaurantService.deleteById(id);
    }

    @Override
    public RestaurantDTO updateRestaurantById(RestaurantUpdateRequest request) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.convertToUpdateRestaurant(request);
        restaurant = restaurantService.save(restaurant);
        return RestaurantMapper.INSTANCE.convertToRestaurantDTO(restaurant);
    }

    @Override
    public RestaurantDTO updateRestaurantNameById(UUID id, RestaurantUpdateRequest request) {
        Restaurant restaurant = restaurantService.findById(id);
        restaurant.setName(request.name());
        restaurant = restaurantService.save(restaurant);
        return RestaurantMapper.INSTANCE.convertToRestaurantDTO(restaurant);
    }

}

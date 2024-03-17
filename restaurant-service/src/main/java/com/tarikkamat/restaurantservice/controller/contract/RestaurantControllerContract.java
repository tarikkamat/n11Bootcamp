package com.tarikkamat.restaurantservice.controller.contract;

import com.tarikkamat.restaurantservice.dto.RestaurantDTO;
import com.tarikkamat.restaurantservice.request.RestaurantRequest;
import com.tarikkamat.restaurantservice.request.RestaurantUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface RestaurantControllerContract {
    RestaurantDTO addRestaurant(RestaurantRequest request);

    List<RestaurantDTO> getAllRestaurants();

    RestaurantDTO getRestaurantById(UUID id);

    void deleteRestaurantById(UUID id);

    RestaurantDTO updateRestaurantById(RestaurantUpdateRequest request);

    RestaurantDTO updateRestaurantNameById(UUID id, RestaurantUpdateRequest request);

    RestaurantDTO updateRestaurantLocationById(UUID id, RestaurantUpdateRequest request);
}

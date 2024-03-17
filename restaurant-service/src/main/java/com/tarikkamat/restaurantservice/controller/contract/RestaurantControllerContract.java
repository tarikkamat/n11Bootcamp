package com.tarikkamat.restaurantservice.controller.contract;

import com.tarikkamat.restaurantservice.dto.RestaurantDTO;
import com.tarikkamat.restaurantservice.request.RestaurantRequest;

public interface RestaurantControllerContract {
    RestaurantDTO addRestaurant(RestaurantRequest request);
}

package com.tarikkamat.restaurantservice.controller;

import com.tarikkamat.restaurantservice.controller.contract.RestaurantControllerContract;
import com.tarikkamat.restaurantservice.dto.RestaurantDTO;
import com.tarikkamat.restaurantservice.request.RestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantControllerContract restaurantControllerContract;

    @Autowired
    public RestaurantController(RestaurantControllerContract restaurantControllerContract) {
        this.restaurantControllerContract = restaurantControllerContract;
    }

    @PostMapping
    public RestaurantDTO addRestaurant(@RequestBody RestaurantRequest request) {
        RestaurantDTO restaurantDTO = restaurantControllerContract.addRestaurant(request);
        return restaurantDTO;
    }

    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantDTO> restaurantDTOs = restaurantControllerContract.getAllRestaurants();
        return restaurantDTOs;
    }

    @GetMapping("/{id}")
    public RestaurantDTO getRestaurantById(@PathVariable("id") UUID id) {
        RestaurantDTO restaurantDTO = restaurantControllerContract.getRestaurantById(id);
        return restaurantDTO;
    }

}

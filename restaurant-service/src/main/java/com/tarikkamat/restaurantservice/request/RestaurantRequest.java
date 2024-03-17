package com.tarikkamat.restaurantservice.request;

public record RestaurantRequest(
        String name,
        Double latitude,
        Double longitude
) {
}

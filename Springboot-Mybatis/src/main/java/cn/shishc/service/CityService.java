package cn.shishc.service;

import cn.shishc.domain.City;

public interface CityService {
    /**
     *
     * @param cityName
     * @return cityEntity
     */
    City findCityByName(String cityName);

    /**
     *
     * @param cityId
     * @return  cityEntity
     */
    City findCityById(Long cityId);
}

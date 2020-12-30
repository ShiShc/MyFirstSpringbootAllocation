package cn.shishc.controller;

import cn.shishc.domain.City;
import cn.shishc.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:cn.shishc.controller
 * @Date:2020/12/29
 * @Auther:ShiShc
 */

@RestController
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public City findOneCityById(
            @RequestParam(value = "cityId") Long cityId
    ) throws Exception {
        City city = cityService.findCityById(cityId);
        return city;
    }

    @RequestMapping(value = "/getByName")
    public City findOneCityByName(
            @RequestParam(value = "cityName") String cityName
    ) throws Exception {
        City city = cityService.findCityByName(cityName);
        return city;
    }

}

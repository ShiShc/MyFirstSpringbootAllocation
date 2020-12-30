package cn.shishc.service.serviceImpl;

import cn.shishc.domain.City;
import cn.shishc.dao.CityDao;
import cn.shishc.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:cn.shishc.service.serviceImpl
 * @Date:2020/12/29
 * @Auther:ShiShc
 */

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        City city = cityDao.findCityByName(cityName);
        return city;
    }

    @Override
    public City findCityById(Long cityId) {
        City city = cityDao.findCityById(cityId);
        return city;
    }
}

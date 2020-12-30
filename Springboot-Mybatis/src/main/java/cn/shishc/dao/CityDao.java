package cn.shishc.dao;

import cn.shishc.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CityDao {
    /**
     *
     * @param cityId
     * @return
     */
    City findCityById(@Param(value = "cityId") Long cityId);

    /**
     *
     * @param cityName
     * @return
     */
    City findCityByName(@Param(value = "cityName") String cityName);
}

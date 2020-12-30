package cn.shishc.domain;

import lombok.Data;

/**
 * @PackageName:cn.shishc.domain
 * @Date:2020/12/29
 * @Auther:ShiShc
 */

@Data
public class City {
    private Long id;
    private Long provinceId;
    private String cityName;
    private String cityDescription;
}

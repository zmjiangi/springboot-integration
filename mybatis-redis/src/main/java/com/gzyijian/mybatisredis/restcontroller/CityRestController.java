package com.gzyijian.mybatisredis.restcontroller;

import com.gzyijian.mybatisredis.domain.City;
import com.gzyijian.mybatisredis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 城市控制层类
 *
 * @author zmjiangi
 * @date 2019-6-18
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping("/api/city/{id}")
    public City get(@PathVariable("id") Long id) {
        return cityService.findById(id);
    }

    @PostMapping("/api/city")
    public void create(@RequestBody City city) {
        cityService.save(city);
    }

    @PutMapping("/api/city")
    public void modify(@RequestBody City city) {
        cityService.update(city);
    }

    @DeleteMapping("/api/city/{id}")
    public void delete(@PathVariable("id") Long id) {
        cityService.delete(id);
    }
}

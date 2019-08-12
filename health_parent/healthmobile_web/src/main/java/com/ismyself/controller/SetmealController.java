package com.ismyself.controller;

import com.alibaba.dubbo.config.annotation.Reference;
<<<<<<< HEAD
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ismyself.Utils.StringUtils;
=======
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
>>>>>>> e01b3a32a27b161269bdc036bebc58ffd7672bf5
import com.ismyself.constant.MessageConstant;
import com.ismyself.constant.RedisConstant;
import com.ismyself.entity.Result;
import com.ismyself.pojo.Setmeal;
import com.ismyself.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * package com.ismyself.controller;
 *
 * @auther txw
 * @create 2019-08-01  17:12
 * @description：
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Reference
    private SetmealService setmealService;

    @Autowired
    private JedisPool jedisPool;

    //getSetmeal
    @Autowired
    private JedisPool jedisPool;

    /**
     * 展示所有的套餐
     *
     * @return
     */
    @RequestMapping("/getSetmeal")
    public Result getSetmeal() {

        try {
<<<<<<< HEAD
            List<Setmeal> setmealList = new ArrayList<>();
            String setmeal = jedisPool.getResource().get(RedisConstant.SETMEAL_List_DB_RESOURCES);
            Gson gson = new Gson();
            if (StringUtils.isEmpty(setmeal)){
                setmealList = setmealService.findSetmealList();
                String json = gson.toJson(setmealList);
                jedisPool.getResource().set(RedisConstant.SETMEAL_List_DB_RESOURCES,json);
            }else {
                setmealList = gson.fromJson(setmeal,new TypeToken <Collection <Setmeal>>(){}.getType());
            }
            return new Result(true, MessageConstant.QUERY_SETMEALLIST_SUCCESS,setmealList);
=======
            //判断redis是否缓存了
            String jsonstr = jedisPool.getResource().get("getAllSetmeal");
            List<Setmeal> setmealList = null;
            ObjectMapper mapper = new ObjectMapper();
            if (jsonstr == null) {
                setmealList = setmealService.findSetmealList();
                //存入redis，转换成json对象
                jsonstr = mapper.writeValueAsString(setmealList);
                jedisPool.getResource().set("getAllSetmeal", jsonstr);
                //System.out.println(setmealList);

                return new Result(true, MessageConstant.QUERY_SETMEALLIST_SUCCESS, setmealList);

            } else {
                //有缓存,redis存放的是字符串,我们要返回的是list集合进行转换
                setmealList = mapper.readValue(jsonstr, new TypeReference<List<Setmeal>>() {
                });
                //System.out.println(setmealList);
                return new Result(true, MessageConstant.QUERY_SETMEALLIST_SUCCESS, setmealList);
            }
>>>>>>> e01b3a32a27b161269bdc036bebc58ffd7672bf5
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEALLIST_FAIL);
        }

    }

    /**
     * 通过id展示该套餐的信息
     */
    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            Setmeal setmeal = setmealService.findById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setmeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }


}

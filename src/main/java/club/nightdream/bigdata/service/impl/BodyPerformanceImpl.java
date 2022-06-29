package club.nightdream.bigdata.service.impl;

import club.nightdream.bigdata.service.BodyPerformanceService;
import club.nightdream.bodyPerformance.config.RedisUtil;
import club.nightdream.bodyPerformance.pojo.BodyBean;
import club.nightdream.bodyPerformance.searchOne.BodyDriverOne;
import club.nightdream.bodyPerformance.searchThree.BodyDriverThree;
import club.nightdream.bodyPerformance.searchTwo.BodyDriverTwo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class BodyPerformanceImpl implements BodyPerformanceService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void searchOne() {
        try {
            BodyDriverOne.main(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchTwo() {
        try {
            BodyDriverTwo.main(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchThree() {
        try {
            BodyDriverThree.main(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JSONObject getResult(String key) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(redisUtil.get(key));
        return jsonObject;
    }

    @Override
    public void testRedis(String name) {
        redisUtil.set(name, new Date().getTime());
    }
}

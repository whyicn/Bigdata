package club.nightdream.bigdata.service;

import club.nightdream.bodyPerformance.pojo.BodyBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface BodyPerformanceService {
    public void searchOne();

    public void searchTwo();

    public void searchThree();

    public JSONObject getResult(String key);

    public void testRedis(String name);


}

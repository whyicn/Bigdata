package club.nightdream.bigdata.controller;

import club.nightdream.bigdata.service.BodyPerformanceService;
import club.nightdream.bigdata.service.impl.BodyPerformanceImpl;
import com.alibaba.fastjson.JSONObject;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/bodyPerformance")
public class BodyPerformanceController {

    @Autowired
    BodyPerformanceImpl bodyPerformance;


    @GetMapping("/executeTaskOne")
    public HashMap<String, String> searchOne(){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime = dateFormat.format(new Date());
        long startTimeMillis = System.currentTimeMillis();
        bodyPerformance.searchOne();
        long endTimeMillis = System.currentTimeMillis();
        String endTime = dateFormat.format(new Date());
        stringStringHashMap.put("startTime", startTime);
        stringStringHashMap.put("endTime", endTime);
        Long result = endTimeMillis - startTimeMillis;
        stringStringHashMap.put("ExecuteTime", result + "   " + "ms");
        stringStringHashMap.put("Current Task", "TASK-ONE");
        return stringStringHashMap;
    }

    @GetMapping("/executeTaskTwo")
    public HashMap<String, String> searchTwo(){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime = dateFormat.format(new Date());
        long startTimeMillis = System.currentTimeMillis();
        bodyPerformance.searchTwo();
        long endTimeMillis = System.currentTimeMillis();
        String endTime = dateFormat.format(new Date());
        stringStringHashMap.put("startTime", startTime);
        stringStringHashMap.put("endTime", endTime);
        Long result = endTimeMillis - startTimeMillis;
        stringStringHashMap.put("ExecuteTime", result + "   " + "ms");
        stringStringHashMap.put("Current Task", "TASK-TWO");
        return stringStringHashMap;
    }

    @GetMapping("/executeTaskThree")
    public HashMap<String, String> searchThree(){
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime = dateFormat.format(new Date());
        long startTimeMillis = System.currentTimeMillis();
        bodyPerformance.searchThree();
        long endTimeMillis = System.currentTimeMillis();
        String endTime = dateFormat.format(new Date());
        stringStringHashMap.put("startTime", startTime);
        stringStringHashMap.put("endTime", endTime);
        Long result = endTimeMillis - startTimeMillis;
        stringStringHashMap.put("ExecuteTime", result + "   " + "ms");
        stringStringHashMap.put("Current Task", "TASK-THREE");
        return stringStringHashMap;
    }

    @GetMapping("/getValueByKey")
    public JSONObject getResult(@RequestParam("key") String key){
        return bodyPerformance.getResult(key);
    }
}

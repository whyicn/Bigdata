package club.nightdream.bodyPerformance.outputFormat;

import club.nightdream.bigdata.service.impl.BodyPerformanceImpl;
import club.nightdream.bodyPerformance.pojo.BodyBean;
import club.nightdream.bodyPerformance.config.RedisUtil;
import club.nightdream.bodyPerformance.utils.ApplicationContextProvider;
import com.alibaba.fastjson.JSONObject;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Component
public class LogRecordWriter extends RecordWriter<Text, BodyBean> {

    @Override
    public void write(Text key, BodyBean value) throws IOException, InterruptedException {
        RedisUtil redis = ApplicationContextProvider.getBean(RedisUtil.class);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(value);
        redis.set(String.valueOf(key), jsonObject);
    }

    @Override
    public void close(TaskAttemptContext context) throws IOException, InterruptedException {
    }
}

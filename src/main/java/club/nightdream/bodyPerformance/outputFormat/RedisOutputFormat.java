package club.nightdream.bodyPerformance.outputFormat;

import club.nightdream.bodyPerformance.pojo.BodyBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class RedisOutputFormat extends FileOutputFormat<Text, BodyBean> {

    @Override
    public RecordWriter<Text, BodyBean> getRecordWriter(TaskAttemptContext job) throws IOException, InterruptedException {
        LogRecordWriter logRecordWriter = new LogRecordWriter();
        return logRecordWriter;
    }
}

package club.nightdream.bodyPerformance.searchOne;

import club.nightdream.bodyPerformance.pojo.BodyBean;
import club.nightdream.bodyPerformance.outputFormat.RedisOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.Date;

/**
 * this search demonstrate the composition of average data among class A-D and M F.
 */


public class BodyDriverOne {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //1. 获取job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //2. 设置jar
        job.setJarByClass(BodyDriverOne.class);
        //3. 关联map和Reducer
        job.setMapperClass(BodyMapperOne.class);
        job.setReducerClass(bodyreducerOne.class);
        //4. 设置mapper输出的key和value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(BodyBean.class);
        //5. 设置最终数据输出的key和value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(BodyBean.class);

        //设置partitioner
        //job.setPartitionerClass(ProvincePartitioner.class);
        job.setNumReduceTasks(1);

        //设置自定义的outputFormat
        job.setOutputFormatClass(RedisOutputFormat.class);

        //6. 设置数据的输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("/bodyPerformance"));
        long time = new Date().getTime();
        //fileoutoutformat 要输出一个_success文件，还需要指定一个输出目录
        FileOutputFormat.setOutputPath(job, new Path("/bodyPerformanceOutput/" + time));
        //7. 提交job
        job.waitForCompletion(true);
    }
}

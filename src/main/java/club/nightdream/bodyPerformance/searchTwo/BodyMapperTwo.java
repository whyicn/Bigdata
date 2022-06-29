package club.nightdream.bodyPerformance.searchTwo;

import club.nightdream.bodyPerformance.pojo.BodyBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class BodyMapperTwo extends Mapper<LongWritable, Text, Text, BodyBean> {
    private Text outK = new Text();
    private BodyBean outV = new BodyBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, BodyBean>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] items = line.split(",");
        if (items[0].equals("age")){
            return;
        }
        outV.setAge(Float.parseFloat(items[0]));
        outV.setGender(items[1]);
        outV.setHeight_cm(Float.parseFloat(items[2]));
        outV.setWeight_kg(Float.parseFloat(items[3]));
        outV.setBody_fat(Float.parseFloat(items[4]));
        outV.setDiastolic(Float.parseFloat(items[5]));
        outV.setSystolic(Float.parseFloat(items[6]));
        outV.setGripForce(Float.parseFloat(items[7]));
        outV.setSit_bend_forward_cm(Float.parseFloat(items[8]));
        outV.setSit_ups_counts(Float.parseFloat(items[9]));
        outV.setBroad_jump_cm(Float.parseFloat(items[10]));
        outV.setClasses(items[11]);
        outK.set(items[0]+ "_" + items[1]);
        context.write(outK,outV);
    }
}

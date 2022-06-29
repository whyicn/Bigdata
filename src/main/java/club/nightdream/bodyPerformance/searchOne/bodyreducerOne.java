package club.nightdream.bodyPerformance.searchOne;
import club.nightdream.bodyPerformance.pojo.BodyBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class bodyreducerOne extends Reducer<Text, BodyBean, Text, BodyBean> {
    private BodyBean outV = new BodyBean();
    @Override
    protected void reduce(Text key, Iterable<BodyBean> values, Reducer<Text, BodyBean, Text, BodyBean>.Context context) throws IOException, InterruptedException {
        outV.initBodyBean();
        int size = 0;
        for (BodyBean value : values) {
            outV.setAge(value.getAge() + outV.getAge());
            outV.setGender(value.getGender());
            outV.setHeight_cm(value.getHeight_cm() + outV.getHeight_cm());
            outV.setWeight_kg(value.getWeight_kg() + outV.getWeight_kg());
            outV.setBody_fat(value.getBody_fat() + outV.getBody_fat());
            outV.setDiastolic(value.getDiastolic() + outV.getDiastolic());
            outV.setSystolic(value.getSystolic() + outV.getSystolic());
            outV.setGripForce(value.getGripForce() + outV.getGripForce());
            outV.setSit_bend_forward_cm(value.getSit_bend_forward_cm() + outV.getSit_bend_forward_cm());
            outV.setSit_ups_counts(value.getSit_ups_counts() + outV.getSit_ups_counts());
            outV.setBroad_jump_cm(value.getBroad_jump_cm() + outV.getBroad_jump_cm());
            outV.setClasses(value.getClasses());
            size++;
        }
        outV.setAge(outV.getAge() / size);
        outV.setHeight_cm(outV.getHeight_cm() / size);
        outV.setWeight_kg(outV.getWeight_kg() / size);
        outV.setBody_fat(outV.getBody_fat() / size);
        outV.setDiastolic(outV.getDiastolic() / size);
        outV.setSystolic(outV.getSystolic() / size);
        outV.setGripForce(outV.getGripForce() / size);
        outV.setSit_bend_forward_cm(outV.getSit_bend_forward_cm() / size);
        outV.setSit_ups_counts(outV.getSit_ups_counts() / size);
        outV.setBroad_jump_cm(outV.getBroad_jump_cm() / size);

        context.write(key, outV);
    }
}

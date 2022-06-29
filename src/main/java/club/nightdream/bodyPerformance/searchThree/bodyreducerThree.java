package club.nightdream.bodyPerformance.searchThree;
import club.nightdream.bodyPerformance.pojo.BodyBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class bodyreducerThree extends Reducer<Text, BodyBean, Text, BodyBean> {
    Text outK = new Text();
    @Override
    protected void reduce(Text key, Iterable<BodyBean> values, Reducer<Text, BodyBean, Text, BodyBean>.Context context) throws IOException, InterruptedException {
        HashMap<String, BodyBean> bodyBeanHashMap = new HashMap<>(20);
        try {
            compare(values, bodyBeanHashMap);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Iterator<HashMap.Entry<String, BodyBean>> iterator = bodyBeanHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, BodyBean> entry = iterator.next();
            outK.set(entry.getKey());
            context.write(outK, entry.getValue());
        }

    }

    /**
     * A B C D
     * F M
     * top 5
    * */
/*
    List<BodyBean> top_5_F_gender = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_height_cm = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_weight_kg = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_body_fat = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_diastolic = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_systolic = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_gripForce = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_sit_bend_forward_cm = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_sit_ups_counts = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_F_broad_jump_cm = new ArrayList<BodyBean>(6);

    List<BodyBean> top_5_M_gender = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_height_cm = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_weight_kg = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_body_fat = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_diastolic = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_systolic = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_gripForce = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_sit_bend_forward_cm = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_sit_ups_counts = new ArrayList<BodyBean>(6);
    List<BodyBean> top_5_M_broad_jump_cm = new ArrayList<BodyBean>(6);
*/

    //search the best columns of each activity and is devided by classes



    void compare(Iterable<BodyBean> values, HashMap<String, BodyBean> bodyBeanHashMap) throws InvocationTargetException, IllegalAccessException {

        float top_height_cm = 0;
        float top_weight_kg = 0;
        float top_body_fat = 0;
        float top_diastolic = 0;
        float top_systolic = 0;
        float top_gripForce = 0;
        float top_sit_bend_forward_cm = 0;
        float top_sit_ups_counts = 0;
        float top_broad_jump_cm = 0;

        float bottom_height_cm = 10000;
        float bottom_weight_kg = 10000;
        float bottom_body_fat = 10000;
        float bottom_diastolic = 10000;
        float bottom_systolic = 10000;
        float bottom_gripForce = 10000;
        float bottom_sit_bend_forward_cm = 10000;
        float bottom_sit_ups_counts = 10000;
        float bottom_broad_jump_cm = 10000;


        for (BodyBean value : values) {

            if (value.getHeight_cm() > top_height_cm){
                top_height_cm = value.getHeight_cm();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("top_height_cm", bodyBean);
            }

            if (value.getHeight_cm() < bottom_height_cm) {
                bottom_height_cm = value.getHeight_cm();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("bottom_height_cm", bodyBean);
            }

            if (value.getWeight_kg() > top_weight_kg){
                top_weight_kg = value.getWeight_kg();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("top_weight_kg", bodyBean);
            }

            if (value.getWeight_kg() < bottom_weight_kg) {
                bottom_weight_kg = value.getWeight_kg();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("bottom_weight_kg", bodyBean);
            }

            if (value.getBody_fat() > top_body_fat){
                top_body_fat = value.getBody_fat();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("top_body_fat", bodyBean);
            }

            if (value.getBody_fat() < bottom_body_fat) {
                bottom_body_fat = value.getBody_fat();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("bottom_body_fat", bodyBean);
            }

            if (value.getDiastolic() > top_diastolic){
                top_diastolic = value.getDiastolic();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("top_diastolic", bodyBean);
            }

            if (value.getDiastolic() < bottom_diastolic) {
                bottom_diastolic = value.getDiastolic();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("bottom_diastolic", bodyBean);
            }

            if (value.getSystolic() > top_systolic){
                top_systolic = value.getSystolic();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("top_systolic", bodyBean);
            }

            if (value.getSystolic() < bottom_systolic) {
                bottom_systolic = value.getSystolic();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("bottom_systolic", bodyBean);
            }

            if (value.getGripForce() > top_gripForce){
                top_gripForce = value.getGripForce();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("top_gripForce", bodyBean);
            }

            if (value.getGripForce() < bottom_gripForce) {
                bottom_gripForce = value.getGripForce();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("bottom_gripForce", bodyBean);
            }

            if (value.getSit_bend_forward_cm() > top_sit_bend_forward_cm){
                top_sit_bend_forward_cm = value.getSit_bend_forward_cm();
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bodyBeanHashMap.put("top_sit_bend_forward_cm", bodyBean);
            }

            if (value.getSit_bend_forward_cm() < bottom_sit_bend_forward_cm) {
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bottom_sit_bend_forward_cm = value.getSit_bend_forward_cm();
                bodyBeanHashMap.put("bottom_sit_bend_forward_cm", bodyBean);
            }

            if (value.getSit_ups_counts() > top_sit_ups_counts){
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                top_sit_ups_counts = value.getSit_ups_counts();
                bodyBeanHashMap.put("top_sit_ups_counts", bodyBean);
            }

            if (value.getSit_ups_counts() < bottom_sit_ups_counts) {
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bottom_sit_ups_counts = value.getSit_ups_counts();
                bodyBeanHashMap.put("bottom_sit_ups_counts", bodyBean);
            }

            if (value.getBroad_jump_cm() > top_broad_jump_cm){
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                top_broad_jump_cm = value.getBroad_jump_cm();
                bodyBeanHashMap.put("top_broad_jump_cm", bodyBean);
            }

            if (value.getBroad_jump_cm() < bottom_broad_jump_cm) {
                BodyBean bodyBean = new BodyBean();
                BeanUtils.copyProperties(bodyBean, value);
                bottom_broad_jump_cm = value.getBroad_jump_cm();
                bodyBeanHashMap.put("bottom_broad_jump_cm", bodyBean);
            }
        }
    }
}

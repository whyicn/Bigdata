package club.nightdream.bodyPerformance.pojo;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class BodyBean implements WritableComparable<BodyBean> {

    private float age;
    private String gender;
    private float height_cm;
    private float weight_kg;
    private float body_fat;
    private float diastolic;
    private float systolic;
    private float gripForce;
    private float sit_bend_forward_cm;
    private float sit_ups_counts;
    private float broad_jump_cm;
    private String classes;

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getHeight_cm() {
        return height_cm;
    }

    public void setHeight_cm(float height_cm) {
        this.height_cm = height_cm;
    }

    public float getWeight_kg() {
        return weight_kg;
    }

    public void setWeight_kg(float weight_kg) {
        this.weight_kg = weight_kg;
    }

    public float getBody_fat() {
        return body_fat;
    }

    public void setBody_fat(float body_fat) {
        this.body_fat = body_fat;
    }

    public float getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(float diastolic) {
        this.diastolic = diastolic;
    }

    public float getSystolic() {
        return systolic;
    }

    public void setSystolic(float systolic) {
        this.systolic = systolic;
    }

    public float getGripForce() {
        return gripForce;
    }

    public void setGripForce(float gripForce) {
        this.gripForce = gripForce;
    }

    public float getSit_bend_forward_cm() {
        return sit_bend_forward_cm;
    }

    public void setSit_bend_forward_cm(float sit_bend_forward_cm) {
        this.sit_bend_forward_cm = sit_bend_forward_cm;
    }

    public float getSit_ups_counts() {
        return sit_ups_counts;
    }

    public void setSit_ups_counts(float sit_ups_counts) {
        this.sit_ups_counts = sit_ups_counts;
    }

    public float getBroad_jump_cm() {
        return broad_jump_cm;
    }

    public void setBroad_jump_cm(float broad_jump_cm) {
        this.broad_jump_cm = broad_jump_cm;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public BodyBean() {

    }

    public void initBodyBean() {
        this.age = 0;
        this.height_cm = 0;
        this.weight_kg = 0;
        this.body_fat = 0;
        this.diastolic = 0;
        this.systolic = 0;
        this.gripForce = 0;
        this.sit_bend_forward_cm = 0;
        this.sit_ups_counts = 0;
        this.broad_jump_cm = 0;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeFloat(age);
        out.writeUTF(gender);
        out.writeFloat(height_cm);
        out.writeFloat(weight_kg);
        out.writeFloat(body_fat);
        out.writeFloat(diastolic);
        out.writeFloat(systolic);
        out.writeFloat(gripForce);
        out.writeFloat(sit_bend_forward_cm);
        out.writeFloat(sit_ups_counts);
        out.writeFloat(broad_jump_cm);
        out.writeUTF(classes);

    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.age = in.readFloat();
        this.gender = in.readUTF();
        this.height_cm = in.readFloat();
        this.weight_kg = in.readFloat();
        this.body_fat = in.readFloat();
        this.diastolic = in.readFloat();
        this.systolic = in.readFloat();
        this.gripForce = in.readFloat();
        this.sit_bend_forward_cm = in.readFloat();
        this.sit_ups_counts = in.readFloat();
        this.broad_jump_cm = in.readFloat();
        this.classes = in.readUTF();
    }


    @Override
    public String toString() {
        return "BodyBean{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", height_cm=" + height_cm +
                ", weight_kg=" + weight_kg +
                ", body_fat=" + body_fat +
                ", diastolic=" + diastolic +
                ", systolic=" + systolic +
                ", gripForce=" + gripForce +
                ", sit_bend_forward_cm=" + sit_bend_forward_cm +
                ", sit_ups_counts=" + sit_ups_counts +
                ", broad_jump_cm=" + broad_jump_cm +
                ", classes='" + classes + '\'' +
                '}';
    }

    private int ClassToInt(String s){
        if (s.equals("A")){
            return 4;
        }else if (s.equals("B")){
            return 3;
        } else if (s.equals("C")) {
            return 2;
        } else if (s.equals("D")) {
            return 1;
        }
        return 0;
    }

    @Override
    public int compareTo(BodyBean bodyBean) {
        if (ClassToInt(this.classes) > ClassToInt(bodyBean.classes)){
            return -1;
        }else if (ClassToInt(this.classes) < ClassToInt(bodyBean.classes)){
            return 1;
        }else if (this.age > bodyBean.age){
            return 1;
        }else if (this.age < bodyBean.age) {
            return -1;
        }else {
            if (this.height_cm > bodyBean.height_cm){
                return 1;
            }else if (this.height_cm < bodyBean.height_cm){
                return -1;
            }else {
                if (this.weight_kg > bodyBean.weight_kg) {
                    return 1;
                } else if (this.weight_kg < bodyBean.weight_kg) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }
    }
}
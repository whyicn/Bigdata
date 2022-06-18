package club.nightdream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class BigdataApplicationTests {

    @Test
    public static void main(String [] args) throws Exception {
        System.out.println("Compile Over");
        FileSystem fs = FileSystem.get(new URI("hdfs://www.nightdream.club:9870/"), new Configuration());

        FileStatus[] files = fs.listStatus(new Path("/"));
        for (FileStatus f : files) {
            System.out.println(f);
        }
    }
}

package club.nightdream.bigdata.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/BigDataManagement")
public class BigdataController {
    @GetMapping("/test")
    public Integer testProject(){
        return 1;
    }
}

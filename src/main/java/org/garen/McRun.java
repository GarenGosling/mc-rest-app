package org.garen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by Administrator on 2017/8/23.
 */
@SpringBootApplication
@MapperScan("org.garen.mc.mybatis.mapper")
public class McRun {

    public static void main(String[] args) {
        SpringApplication.run(McRun.class, args);
    }

}

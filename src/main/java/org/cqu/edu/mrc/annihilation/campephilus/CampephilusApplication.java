package org.cqu.edu.mrc.annihilation.campephilus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * campephilus
 *
 * @author lx
 * @date 2018/12/6
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@SpringBootApplication
@EnableScheduling
public class CampephilusApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampephilusApplication.class, args);
    }
}

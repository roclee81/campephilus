package org.cqu.edu.msc.annihilation.campephilus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * campephilus
 *
 * @author lx
 * @date 2018/12/6
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
public class CampephilusApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampephilusApplication.class, args);

    }

}

package samplebatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@EnableTransactionManagement
@SpringBootApplication
@EnableAutoConfiguration/*(exclude = {PersistenceExceptionTranslationAutoConfiguration.class})*/
@ComponentScan
@EnableWebMvc
public class SampleBatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleBatisApplication.class, args);
    }
}

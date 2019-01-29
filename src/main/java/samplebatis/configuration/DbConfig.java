package samplebatis.configuration;

import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    public SqlMapClientFactoryBean sqlMapClientFactoryBean() {
        SqlMapClientFactoryBean sqlMapClientFactoryBean = new SqlMapClientFactoryBean();

        sqlMapClientFactoryBean.setConfigLocation(new ClassPathResource("sql-map-config.xml"));

        return sqlMapClientFactoryBean;
    }

    @Bean
    public SqlMapClient sqlMapClient() {
        return (SqlMapClient) sqlMapClientFactoryBean().getObject();
    }

    @Bean
    public SqlMapClientTemplate sqlMapClientTemplate() {
        return new SqlMapClientTemplate(dataSource, sqlMapClient());
    }
}

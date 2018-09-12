package pl.zarosla.webapp.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:configuration/application_pass.cfg")
public class ConfigProperties {
    @Autowired
    Environment env;

/*private String mail_password;
private String mail_name;

    private void readProperties() {
        Properties properties = new Properties();
        String fileName = "../resources/configuration/application_pass.cfg";
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            properties.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }




    }

    @Bean
    public void setProperty(){
        readProperties();

    }*/
}

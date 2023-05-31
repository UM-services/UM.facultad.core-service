/**
 * 
 */
package um.facultad.rest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author daniel
 *
 */
@Configuration
@EnableJpaAuditing
@PropertySource("classpath:config/facultad.properties")
public class FacultadConfiguration {

}

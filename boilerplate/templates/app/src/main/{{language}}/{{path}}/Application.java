package {{group}}.{{project_name|replace('-','')}};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

{% if (spring_boot_version == "2.7.8") %}
import javax.annotation.PostConstruct;
{% else %}
import jakarta.annotation.PostConstruct;
{% endif %}
import java.util.TimeZone;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
}

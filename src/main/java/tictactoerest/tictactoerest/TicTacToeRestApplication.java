package tictactoerest.tictactoerest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"service", "tictactoerest"})
@ImportResource("classpath:application-context.xml")
public class TicTacToeRestApplication extends SpringBootServletInitializer{
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(TicTacToeRestApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TicTacToeRestApplication.class, args);
	}

}

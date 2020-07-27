package pl.bartdel.funfactstwitterbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FunFactsTwitterBotApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FunFactsTwitterBotApplication.class, args);
        FunFact funFact = new FunFact();
        funFact.getFact();
    }

}

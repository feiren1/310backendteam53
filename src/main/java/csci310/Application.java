package csci310;

import csci310.repositories.ProposalRepository;
import csci310.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import csci310.web.*;


@EnableAutoConfiguration
@ComponentScan("csci310")
public class Application {

    @Autowired
    UserRepository ur;
    @Autowired
    ProposalRepository pr;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
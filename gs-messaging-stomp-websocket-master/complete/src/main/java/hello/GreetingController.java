package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("Message is here");
        return new Greeting("Hello, " + message.getName() + "!");
    }
    
    @MessageMapping("/newhello")
    @SendTo("/topic/greetings")
    public Greeting newgreeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println("New Message is here");
        return new Greeting("Hello, " + message.getName() + "!");
    }
    
    

}

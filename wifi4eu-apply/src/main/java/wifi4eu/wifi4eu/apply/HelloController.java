package wifi4eu.wifi4eu.apply;

import io.lettuce.core.RedisClient;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStreamCommands;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(Model model) {

        /*
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStreamCommands<String, String> streamCommands = connection.sync();

        Map<String, String> body =  Collections.singletonMap("key", "value");
        String messageId = streamCommands.xadd("my-stream", body);

        List<StreamMessage<String, String>> messages = streamCommands
                .xread(XReadArgs.Builder.count(1),
                        XReadArgs.StreamOffset.from("my-stream", "0"));



        if(messages.size() == 1) { // a message was read
            System.out.println("OK");

        } else { // no message was read
            System.out.println("Nothing printed");

        }

        return "Greetings from Spring Boot!";
        */

        model.addAttribute("numReceived", Monitor.getReceived());
        model.addAttribute("numProcessed", Monitor.getProcessed());

        return "status";
    }

    /*
    @RequestMapping(value = "/util/populate/{amount}", method = GET)
    public String generateData(@PathVariable int amount) {

        try {
            QueueConsumer conn = new QueueConsumer();
            String ip = "0.0.0.0";

             try {

                 DatagramSocket socket = new DatagramSocket();

                 socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
                  ip = socket.getLocalAddress().getHostAddress();
             } catch (Exception ex) {
                 ip = "0.0.0.0";
             }

            Map<String, String> body = new HashMap<String, String>();
            body.put("r", "100");
            body.put("m", "200");
            body.put("u", "666");
            body.put("ip", ip);

            for (int i = 0; i < amount; i++) {
                conn.add(body);
            }

            return String.valueOf(amount);
        } catch (Exception ex) {
            return "ERROR: " + Util.getStackTrace(ex);
        }
    }
    */

}
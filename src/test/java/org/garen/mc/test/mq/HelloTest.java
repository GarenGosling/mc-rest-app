package org.garen.mc.test.mq;


import org.garen.mc.rpc.mq.publish.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {
    @Autowired
    private HelloSender sender;
    @Test
    public void hello() throws Exception {
        sender.send();
    }
}
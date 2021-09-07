package com.beta.replyservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReplyControllerTest {

    @Autowired
    ReplyController replyController;

    @Test
    public void testProcessedReplyWithRule1() {
        String testString = "11-kbzw9ru";
        String output = replyController.processedReplying(testString).getMessage();
        assertEquals("kbzw9ru", output);
    }

    @Test
    public void testProcessedReplyWithRule2() {
        String testString = "12-kbzw9ru";
        String output = replyController.processedReplying(testString).getMessage();
        assertEquals("5a8973b3b1fafaeaadf10e195c6e1dd4", output);
    }

    @Test
    public void testProcessedReplyWithRule3() {
        String testString = "22-kbzw9ru";
        String output = replyController.processedReplying(testString).getMessage();
        assertEquals("e8501e64cf0a9fa45e3c25aa9e77ffd5", output);
    }
}

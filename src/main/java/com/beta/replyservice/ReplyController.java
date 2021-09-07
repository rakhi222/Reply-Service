package com.beta.replyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.IntStream;

@RestController
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @GetMapping("/reply")
    public ReplyMessage replying() {
        return new ReplyMessage("Message is empty");
    }

    @GetMapping("/reply/{message}")
    public ReplyMessage replying(@PathVariable String message) {
        return new ReplyMessage(message);
    }

    @GetMapping("/v2/reply/{message}")
    public ReplyMessage processedReplying(@PathVariable String message) {

        String processInput = message.split("-")[0];
        String messageInput = message.split("-")[1];
        final String[] result = {messageInput};
        IntStream processList = processInput.chars();

        processList.forEach(i -> {
            if (Character.getNumericValue(i) == 1)
                result[0] = replyService.getReverseString(result[0]);
            else if (Character.getNumericValue(i) == 2)
                result[0] = replyService.getMd5(result[0]);
        });
        return new ReplyMessage(result[0]);
    }
}
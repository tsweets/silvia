package org.beer30.silvia.sample.springintegration;

import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.mail.MailHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * Created by tsweets on 3/25/16.
 */
public class ExecutionsToMailTransformer {


    @Transformer
    public Message<String> transformExecutionsToMail(JobExecution jobExecution) {
        String result = "Execution has " + jobExecution.getStatus().toString();
        return MessageBuilder.withPayload(result)
                .setHeader(MailHeaders.TO, "test@example.com")
                .setHeader(MailHeaders.FROM, "test@example.com").build();
    }

}

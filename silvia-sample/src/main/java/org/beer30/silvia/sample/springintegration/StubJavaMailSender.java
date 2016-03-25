package org.beer30.silvia.sample.springintegration;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tsweets on 3/25/16.
 */
public class StubJavaMailSender implements JavaMailSender {

    private MimeMessage uniqueMessage;

    private final List<MimeMessage> sentMimeMessages = new ArrayList<MimeMessage>();

    private final List<SimpleMailMessage> sentSimpleMailMessages = new ArrayList<SimpleMailMessage>();

    public StubJavaMailSender(MimeMessage uniqueMessage) {
        this.uniqueMessage = uniqueMessage;
    }

    public List<MimeMessage> getSentMimeMessages() {
        return this.sentMimeMessages;
    }

    public List<SimpleMailMessage> getSentSimpleMailMessages() {
        return this.sentSimpleMailMessages;
    }

    public MimeMessage createMimeMessage() {
        return this.uniqueMessage;
    }

    public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
        return this.uniqueMessage;
    }

    public void send(MimeMessage mimeMessage) throws MailException {
        this.sentMimeMessages.add(mimeMessage);
    }

    public void send(MimeMessage[] mimeMessages) throws MailException {
        this.sentMimeMessages.addAll(Arrays.asList(mimeMessages));
    }

    public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
        throw new UnsupportedOperationException("MimeMessagePreparator not supported");
    }

    public void send(MimeMessagePreparator[] mimeMessagePreparators) throws MailException {
        throw new UnsupportedOperationException("MimeMessagePreparator not supported");
    }

    public void send(SimpleMailMessage simpleMessage) throws MailException {
        System.out.println("Sending Email :: " + simpleMessage.getText() + "\n");
        this.sentSimpleMailMessages.add(simpleMessage);
    }

    public void send(SimpleMailMessage[] simpleMessages) throws MailException {
        this.sentSimpleMailMessages.addAll(Arrays.asList(simpleMessages));
    }

    public void reset() {
        this.sentMimeMessages.clear();
        this.sentSimpleMailMessages.clear();
    }

}

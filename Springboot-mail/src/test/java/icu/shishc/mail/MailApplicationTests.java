package icu.shishc.mail;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailApplicationTests {

    @Autowired
    MailService mailService;

    //public boolean sendMimeMail(String mail, String subject, String text, String path)
    @Test
    public void SimpleTest() {
        String mail = "shishc9@126.com";
        String subject = "Simple From ShiShc";
        String text = "Hello";

        mailService.sendSimpleMail(mail, subject, text);

        System.out.println("---success---");
    }


    @Test
    public void AttachmentTest() throws Exception {
        String mail = "shishc9@126.com";
        String subject = "AttachmentTest From ShiShc";
        String text = "Hello";
        String path = "D:\\Photo\\header.jpg";
        mailService.sendMimeMail(mail, subject, text, path);
        System.out.println("---success---");
    }

}

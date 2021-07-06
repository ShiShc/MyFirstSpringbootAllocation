package icu.shishc.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    private JavaMailSender mailSender;


    /**
     * 发送简单邮件
     * @param mail
     * @param subject
     * @param text
     * @return
     */
    public boolean sendSimpleMail(String mail, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(mail);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        return true;
    }


    /**
     * 发送带附件的邮件
     * @param mail
     * @param subject
     * @param text
     * @param path
     * @return
     * @throws Exception
     */
    public boolean sendMimeMail(String mail, String subject, String text, String path) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置编码，否则可能会乱码。
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(username);
        messageHelper.setTo(mail);
        messageHelper.setSubject(subject);
        messageHelper.setText(text, true);
        // 文件源
        FileSystemResource file = new FileSystemResource(new File(path));
        String filename = path.substring(path.lastIndexOf(File.separator));
        messageHelper.addAttachment(filename, file);
        mailSender.send(mimeMessage);
        return true;
    }
}

package icu.shishc;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;

/**
 * @date:2021-4-14, 21:58
 * @author:ShiShc
 */

public class MyTest {
    @Test
    public void test() {
        Factory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = (SecurityManager) factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("congshao", "345");
        try {
            subject.login(token);
            System.out.println(token.toString());
        } catch (AuthenticationException e) {
            System.out.println("Bad username and pwd");
        } finally {
            subject.logout();
        }
    }
}

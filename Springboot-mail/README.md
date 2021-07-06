### 如何食用

1. application.yml

```yaml
spring:
  mail:
  	# 邮箱主机、端口可以百度或在邮箱官网查询；这里以qq邮箱为例。
    host: smtp.qq.com
    # 如果协议是smtp, 端口为587; 如果协议是smtps, 端口为465
    port: 587
    username: 343141457@qq.com
    # 授权码 (需要发条短信才会获得授权法)
    password: *
    default-encoding: UTF-8
    protocol: smtp
```

2. Service

   也不一定你就要用service。

   一般使用MailMessage这个接口。下面两个类实现了这个接口。

   `public class MimeMailMessage implements MailMessage`

   `public class SimpleMailMessage implements MailMessage, Serializable`

   具体方法下载源码看一下。

   另一个比较重要的就是`JavaMailSender`. 

   `public interface JavaMailSender extends MailSender`可以看下这两个接口中的方法。

   
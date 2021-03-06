package autoSendMail2;

import java.util.Date;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MultiMailsender {

    /**
     * 发送邮件给多个接收者
     * @param mailInfo    带发送邮件的信息
     * @return
     */
    public static boolean sendMailtoMultiReceiver(MultiMailSenderInfo mailInfo){
        MyAuthenticator authenticator = null;
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(),
                    mailInfo.getPassword());
        }
        Session sendMailSession = Session.getInstance(mailInfo.getProperties(), authenticator);
        try {
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address[] tos = null;
            String[] receivers = mailInfo.getReceivers();
            if (receivers != null){
                // 为每个邮件接收者创建一个地址
                tos = new InternetAddress[receivers.length + 1];
                tos[0] = new InternetAddress(mailInfo.getToAddress());
                for (int i=0; i<receivers.length; i++){
                    tos[i+1] = new InternetAddress(receivers[i]);
                }
            } else {
                tos = new InternetAddress[1];
                tos[0] = new InternetAddress(mailInfo.getToAddress());
            }
            // 将所有接收者地址都添加到邮件接收者属性中
            mailMessage.setRecipients(Message.RecipientType.TO, tos);
            
            mailMessage.setSubject(mailInfo.getSubject());
            mailMessage.setSentDate(new Date());
            // 设置邮件内容
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(mailInfo.getContent(), "text/html; charset=GBK");
            mainPart.addBodyPart(html);
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 发送带抄送的邮件
     * @param mailInfo    待发送邮件的消息
     * @return
     */
    public static boolean sendMailtoMultiCC(MultiMailSenderInfo mailInfo){
        MyAuthenticator authenticator = null;
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(),
                    mailInfo.getPassword());
        }
        Session sendMailSession = Session.getInstance(mailInfo
                .getProperties(), authenticator);
        try {
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            
            // 获取抄送者信息
            String[] ccs = mailInfo.getCcs();
            if (ccs != null){
                // 为每个邮件接收者创建一个地址
                Address[] ccAdresses = new InternetAddress[ccs.length];
                for (int i=0; i<ccs.length; i++){
                    ccAdresses[i] = new InternetAddress(ccs[i]);
                }
                // 将抄送者信息设置到邮件信息中，注意类型为Message.RecipientType.CC
                mailMessage.setRecipients(Message.RecipientType.CC, ccAdresses);
            } 
            
            mailMessage.setSubject(mailInfo.getSubject());
            mailMessage.setSentDate(new Date());
            // 设置邮件内容
            Multipart mainPart = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(mailInfo.getContent(), "text/html; charset=GBK");
            mainPart.addBodyPart(html);
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        // 创建邮件信息
        MultiMailSenderInfo mailInfo = new MultiMailSenderInfo();
        mailInfo.setMailServerHost("smtp.126.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("xdaping");
        mailInfo.setPassword("da1987ping1954");
        mailInfo.setFromAddress("xdaping@126.com");
        mailInfo.setToAddress("xdaping@163.com");
        mailInfo.setSubject("MyMail测试");
        mailInfo.setContent("<html>" +
        		"<head>" +
        		"<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" />" +
        				"<style>" +
        				"*{margin:0;padding:0;}" +
        				".content{background-color:#e5eecc;}" +
        				"</style>" +
        				"</head>" +
        				"<body>" +
        				"<div class=\"content\">" +
        						"Hi，您好！" +
        						"<br>" +
        						"<br>" +
        						"&nbsp&nbsp&nbsp&nbsp中华字库技术支持问答系统有您的问题，快去解决它吧!" +
        						"<br>" +
        						"<br>" +
        						"<span style=\"color:red\">&nbsp&nbsp&nbsp&nbsp问题类别：输入法云服务</span>" +
        								"<br>" +
        								"<br>" +
        								"<span style=\"color:red\">&nbsp&nbsp&nbsp&nbsp问题描述：如何使用中华字库技术支持问答系统</span>" +
        										"<br>" +
        										"<br>" +
        										"<br>" +
        										"</div>" +
        										"<div>" +
        										"----------------------------------------" +
        										"<br>" +
        										"本邮件由系统自动发出，请勿回复。" +
        										"</div>" +
        										"</body>" +
        										"</html>");

        String[] receivers = new String[]{"461513760@qq.com", "daping@nfs.iscas.ac.cn"};
        String[] ccs = receivers;
        mailInfo.setReceivers(receivers);
        mailInfo.setCcs(ccs);
        
        MultiMailsender.sendMailtoMultiReceiver(mailInfo);//发送邮件给多个接收者
        //MultiMailsender.sendMailtoMultiCC(mailInfo);//发送带抄送的邮件
    }

    /**
     * 发送多接收者类型邮件的基本信息
     */
    public static class MultiMailSenderInfo extends MailSenderInfo{
        // 邮件的接收者，可以有多个
        private String[] receivers;
        // 邮件的抄送者，可以有多个
        private String[] ccs;
        
        public String[] getCcs() {
            return ccs;
        }
        public void setCcs(String[] ccs) {
            this.ccs = ccs;
        }
        public String[] getReceivers() {
            return receivers;
        }
        public void setReceivers(String[] receivers) {
            this.receivers = receivers;
        }
    }
}

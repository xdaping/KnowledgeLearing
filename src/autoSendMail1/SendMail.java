package autoSendMail1;

public class SendMail {
	public static void main(String[] args) {
		String smtp = "smtp.126.com";// smtp服务器
		String from = "xdaping@126.com";// 邮件显示名称
		String to = "461513760@qq.com";// 收件人的邮件地址，必须是真实地址
		String copyto = "daping@nfs.iscas.ac.cn;xdaping@163.com";// 抄送人邮件地址
		String subject = "测试邮件";// 邮件标题
		String content = "你好！";// 邮件内容
		String username = "xdaping";// 发件人真实的账户名
		String password = "da1987ping1954";// 发件人密码
		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password);
	}
}
package autoSendMail1;

public class SendMail {
	public static void main(String[] args) {
		String smtp = "smtp.126.com";// smtp������
		String from = "xdaping@126.com";// �ʼ���ʾ����
		String to = "461513760@qq.com";// �ռ��˵��ʼ���ַ����������ʵ��ַ
		String copyto = "daping@nfs.iscas.ac.cn;xdaping@163.com";// �������ʼ���ַ
		String subject = "�����ʼ�";// �ʼ�����
		String content = "��ã�";// �ʼ�����
		String username = "xdaping";// ��������ʵ���˻���
		String password = "da1987ping1954";// ����������
		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password);
	}
}
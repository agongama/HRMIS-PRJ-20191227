package per.work.zecong.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * MD5ʵ����
 * @author 24538
 *
 */
public class PsdMd5 {

	public static String md5(String psd) {
		// ��Ҫ���ܵ��ַ���
		String src = psd;
		StringBuffer sb = new StringBuffer();
		try {
			// ���ܶ���ָ�����ܷ�ʽ
			MessageDigest md5 = MessageDigest.getInstance("md5");
			// ׼��Ҫ���ܵ�����
			byte[] b = src.getBytes();
			// ����
			byte[] digest = md5.digest(b);
			// ʮ�����Ƶ��ַ�
			char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
					'F' };
			
			// �����ʮ�����Ƶ��ַ���(ͨ��)
			for (byte bb : digest) {
				sb.append(chars[(bb >> 4) & 15]);
				sb.append(chars[bb & 15]);
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}

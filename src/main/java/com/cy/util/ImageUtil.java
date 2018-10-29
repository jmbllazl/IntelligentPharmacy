package com.cy.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// ����  ��֤��  ��  ��֤��ͼƬ  ����
public final class ImageUtil {
	
	private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
	
	private static final int SIZE = 4;      // ��֤��ͼƬ�����ֵĸ���
	private static final int LINES = 3;     // ��֤��ͼƬ�еĸ����ߵ�����
	private static final int WIDTH = 80;    // ��֤��ͼƬ�Ŀ��
	private static final int HEIGHT = 34;   // ��֤��ͼƬ�ĸ߶�
	private static final int FONT_SIZE = 19;// ��֤��ͼƬ�����ֵĴ�С

	/**
	 * ������֤�����֤��ͼƬ�ķ���������װ��Map�С� 
	 * 
	 * ����Map��key����֤�룬Map��value����֤��ͼƬ��
	 */
	public static Map<String, BufferedImage> createImage() {
		
		StringBuffer sb = new StringBuffer();
		
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphic = image.getGraphics();
		graphic.setColor(Color.LIGHT_GRAY);  
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		Random ran = new Random();
		// ������ַ�
		for (int i = 1; i <= SIZE; i++) {
			int r = ran.nextInt(chars.length);
			graphic.setColor(getRandomColor());
			graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			graphic.drawString(chars[r] + "", (i - 1) * WIDTH / SIZE,
					HEIGHT / 2);
			sb.append(chars[r]);// ���ַ����棬����Session
		}
		// ��������
		for (int i = 1; i <= LINES; i++) {
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran
					.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
		map.put(sb.toString(), image);
		return map;
	}

	
	
	/**
	 * ��ͼƬ�����������ķ���
	 */
	public static InputStream getInputStream(BufferedImage image)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(image);
		byte[] imageBts = bos.toByteArray();
		InputStream in = new ByteArrayInputStream(imageBts);
		return in;
	}

	
	// ���������ɫ�ķ���
	private static Color getRandomColor() {
		
		Random ran = new Random();   // �������
		// ���������RGB��ɫ
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran
				.nextInt(256));
		return color;
	}
}
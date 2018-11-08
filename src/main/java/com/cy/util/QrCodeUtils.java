package com.cy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cy.bean.FiveElements;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;



/**
 * @author Juer Whang <br/>
 * - project: CompanyCheckSystem
 * - create: 11:09 2018/10/30
 * - 创建和读取二维码的测试类
 **/

public class QrCodeUtils {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;
    public static final String FORMAT = "png";
    public static final String CHARTSET = "utf-8";

    public static void main(String[] args) {
        String filePath = "D:/java/二维码/yaop.png";
        createQRcode(filePath);
        testReadQRcode(filePath);
    }
    private static void testReadQRcode(String filePath) {
        Result result = getQRresult(filePath);
        if (result != null) {
            System.out.println("二维码内容：" + result.getText());
            if (result.getText() != null) {
                FiveElements fiveElements = JSONObject.parseObject(result.getText(), FiveElements.class);
                System.out.println(fiveElements);
            }
            System.out.println("二维码格式：" + result.getBarcodeFormat());
        }
    }
    /**
     *
     * @Title:createQRcode
     * @Description:创建二维码
     * @param filePath
     * @author doubledumbao
     * @修改时间：2018年2月26日 上午9:44:45
     * @修改内容：创建
     */
    public static void createQRcode(String filePath) {
        /**
         * 如果用的jdk是1.9，需要配置下面这一行。
         */
        //System.setProperty("java.specification.version", "1.9");
        FiveElements fiveElements = new FiveElements();
        fiveElements.setName("zhaohw");
        fiveElements.setGender("M");
        fiveElements.setIdType("I");
        fiveElements.setIdno("370983");
        fiveElements.setMobile("1805310");
        String contents = JSON.toJSONString(fiveElements);
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            Path file = new File(filePath).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, FORMAT, file);
            System.out.println("创建二维码完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @Title:getQRresult
     * @Description:读取二维码
     * @param filePath
     * @return
     * @author doubledumbao
     * @修改时间：2018年2月26日 上午9:45:19
     * @修改内容：创建
     */
    public static Result getQRresult(String filePath) {
        /**
         * 如果用的jdk是1.9，需要配置下面这一行。
         */
        //System.setProperty("java.specification.version", "1.9");
        Result result = null;
        try {
            File file = new File(filePath);

            BufferedImage bufferedImage = ImageIO.read(file);
            BinaryBitmap bitmap = new BinaryBitmap(
                    new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

            HashMap hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
            result = new MultiFormatReader().decode(bitmap, hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}

package com.example.demo.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.UUID;

/**
 * 生成二维码
 *
 * @author houlei
 * @DESC:
 * @create 2019-03-18 15:28
 */
public class QrcodeUtil {

    private static Logger logger = LogManager.getLogger();

    public QrcodeUtil() {
    }

    public static String createQrcode(String dir, String content) {
        return createQrcode(dir, content, 300, 300);
    }

    public static String createQrcode(String dir, String content, int width, int height) {
        try {
            String qrcodeFormat = "png";
            HashMap<EncodeHintType, String> hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = (new MultiFormatWriter()).encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            File file = new File(dir + "/" + UUID.randomUUID().toString() + "." + qrcodeFormat);
            MatrixToImageWriter.writeToPath(bitMatrix, qrcodeFormat, file.toPath());
            return file.getAbsolutePath();
        } catch (Exception var8) {
            logger.error("", var8);
            return "";
        }
    }

    public static String decodeQr(String filePath) {
        String retStr = "";
        if ("".equalsIgnoreCase(filePath) && filePath.length() == 0) {
            return "图片路径为空!";
        } else {
            try {
                BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filePath));
                LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
                Binarizer binarizer = new HybridBinarizer(source);
                BinaryBitmap bitmap = new BinaryBitmap(binarizer);
                HashMap<DecodeHintType, Object> hintTypeObjectHashMap = new HashMap();
                hintTypeObjectHashMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");
                Result result = (new MultiFormatReader()).decode(bitmap, hintTypeObjectHashMap);
                retStr = result.getText();
            } catch (Exception var8) {
                logger.error("", var8);
            }

            return retStr;
        }
    }

    public static void main(String[] args) {
        String filePath = QrcodeUtil.createQrcode("/user/qrcode", "大白老师");
        System.out.println("生成的路径为===="+filePath);
    }
}

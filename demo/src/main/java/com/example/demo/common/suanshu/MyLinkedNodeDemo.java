package com.example.demo.common.suanshu;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;



/**
 * @author houlei
 * @DESC:用jdk生成缩略图
 * @create 2019-03-19 17:29
 */
public class MyLinkedNodeDemo {

    public static void main(String[] args) throws Exception {
//        createPreviewImage("E:\\user\\qrcode\\cwJvt6E-ktm-wallpapers.jpg","E:\\user\\qrcode\\127.jpg");
        Thumbnails.of("E:\\user\\qrcode\\cwJvt6E-ktm-wallpapers.jpg").size(200,300).toFile("E:\\user\\qrcode\\129.jpg");
    }

    public static void createPreviewImage(String srcFile, String destFile) {

        try {

            File fi = new File(srcFile); // src

            File fo = new File(destFile); // dest
            int nw = 500; // final int IMAGE_SIZE = 120;
            AffineTransform transform = new AffineTransform();
            BufferedImage bis = ImageIO.read(fi);
            int w = bis.getWidth();
            int h = bis.getHeight();
            int nh = (nw * h) / w;
            double sx = (double) nw / w;
            double sy = (double) nh / h;
            transform.setToScale(sx, sy);

            AffineTransformOp ato = new AffineTransformOp(transform, null);

            BufferedImage bid = new BufferedImage(nw, nh,

                    BufferedImage.TYPE_3BYTE_BGR);

            ato.filter(bis, bid);

            //多了个空格
            ImageIO.write(bid, "jpeg", fo);

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(

                    " Failed in create preview image. Error:  "

                            + e.getMessage());

        }

    }



}

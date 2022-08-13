package com.cyzc.springboot.controller;



import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *
 * @author Cyzc
 * @since [2022/03/08 13:50]
 */
@Controller
public class QrCodeController {


    @RequestMapping("/getQrCode202202")
    @ResponseBody
    public void getQrCode202202(HttpServletRequest request, HttpServletResponse response) {


        String redirect_url_encode = "https://oneapp-dev.mercedes-benz.com.cn/bcar/goScrmHelmPortal.jsp?redirect=starPlayerQrCode.do&source=HELM_WEB_2_Web_6d810c1a-33db-44c4-a0eb-b216f800ad26&fromType=车主&length=larger2";

        BufferedImage s = createQrcode(redirect_url_encode);
        response.setContentType("image/jpeg");
        try {
            ImageIO.write(s, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private BufferedImage createQrcode(String url) {
        final int BLACK = 0xFF000000;
        final int WHITE = 0xFFFFFFFF;
        BufferedImage image = null;
        try {
            Map<EncodeHintType, String> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            //hints.put(EncodeHintType.MARGIN,"2");
            BitMatrix bitMatrix = new MultiFormatWriter()
                    .encode(url, BarcodeFormat.QR_CODE, 400, 400, hints);

            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
                }
            }

            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }

}

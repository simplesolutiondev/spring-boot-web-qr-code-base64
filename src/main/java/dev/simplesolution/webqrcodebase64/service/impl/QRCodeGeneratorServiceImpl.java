package dev.simplesolution.webqrcodebase64.service.impl;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import dev.simplesolution.webqrcodebase64.service.QRCodeGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class QRCodeGeneratorServiceImpl implements QRCodeGeneratorService {

    private Logger logger = LoggerFactory.getLogger(QRCodeGeneratorServiceImpl.class);

    @Override
    public String generateQrCodeBase64(String qrCodeContentToGenerate, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContentToGenerate, BarcodeFormat.QR_CODE, width, height);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
            String qrCodeBase64 = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            return qrCodeBase64;
        } catch (WriterException ex) {
            logger.error("Error during generate QR Code", ex);
        } catch (IOException ex) {
            logger.error("Error during generate QR Code", ex);
        }
        return null;
    }

}

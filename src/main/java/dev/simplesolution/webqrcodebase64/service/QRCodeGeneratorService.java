package dev.simplesolution.webqrcodebase64.service;

public interface QRCodeGeneratorService {
    String generateQrCodeBase64(String qrCodeContentToGenerate, int width, int height);
}
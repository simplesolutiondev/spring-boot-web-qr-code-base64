package dev.simplesolution.webqrcodebase64.controller;

import dev.simplesolution.webqrcodebase64.service.QRCodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QRCodeController {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    @Autowired
    private QRCodeGeneratorService qrCodeGeneratorService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/generateQrCode")
    public String generateQrCode(String contentToGenerate, Model model) {
        String qrCodeBase64 = qrCodeGeneratorService.generateQrCodeBase64(contentToGenerate, WIDTH, HEIGHT);
        model.addAttribute("qrCodeBase64", qrCodeBase64);
        return "qr-code";
    }
}

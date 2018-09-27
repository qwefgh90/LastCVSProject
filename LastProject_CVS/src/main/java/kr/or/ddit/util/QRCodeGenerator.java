package kr.or.ddit.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
	
	//폴더만들기 
	// 절대경로만든다음에 ++ 편의점 (사업자번호) 로 폴더만들어서
    private static final String QR_CODE_IMAGE_PATH = "D:\\최종프\\barcodeImg\\SUPPLY-8ee74b0a-48dd-49a9-9de2-5d6e3891d638.jpg"; //생성될 파일경로와 이름을 결정

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
    	
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        try {
            generateQRCodeImage("SUPPLY-8ee74b0a-48dd-49a9-9de2-5d6e3891d638", 350, 350, QR_CODE_IMAGE_PATH);  //첫번째 요소에 생성할 요소를 넣는다.
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }        
    }
    
}
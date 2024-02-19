package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(ExchangeRateTest.TestChecker.class)
class ExchangeRateTest {
    static ArrayList reportObjects=new ArrayList<>();

    private ExchangeRate exchangeRate;



    @Test
    void addExchangeRate() {
    }

    @Test
    void getExchangeRate() {
    }
    @AfterAll
    public static void afterAll(){
    try (
        PDDocument document = new PDDocument()) {
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 750);
            float lineHeight = 18;

            for (int i = 0; i < reportObjects.size(); i++) {
                ReportObject reportObject = (ReportObject) reportObjects.get(i);
                String line = "Status: " + reportObject.getStatus() +
                        " | Method Name: " + reportObject.getMethodName()  +
                        " | Error Message: " + reportObject.getErrorMessage()  ;

                contentStream.showText(line);
                contentStream.newLineAtOffset(0, -lineHeight);
            }

            contentStream.endText();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try {
            document.save("./test_report2.pdf");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("PDF generated successfully.");

    } catch (IOException e) {
        e.printStackTrace();
    }

//Excel Reader
    String filePath = "./curency.xlsx";
try(
    FileInputStream fileInputStream = new FileInputStream(filePath);
    Workbook workbook = new XSSFWorkbook(fileInputStream)
){
        Sheet sheet = workbook.getSheetAt(0);
        for (int rowIndex = 1 ; rowIndex <= sheet.getLastRowNum() ; rowIndex++){
            Row row = sheet.getRow(rowIndex);

            String baseCurrency   = row.getCell(0).getStringCellValue();
            String targetCurrency = row.getCell(1).getStringCellValue();
            double exchangevalue = row.getCell(2).getNumericCellValue();

            //assertEquals(exchangevalue, exchangeRate.getExchangeRate(baseCurrency, targetCurrency));

        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }
    //Interceptor
    public static class TestChecker implements AfterTestExecutionCallback {

        @Override
        public void afterTestExecution(ExtensionContext context) {
            int statusCode;
            String errorMessage;

            if (context.getExecutionException().isPresent()) {
              statusCode = 500;
              errorMessage = context.getExecutionException().get().getMessage(); // Get the error message
            } else {
                // Test passed
              statusCode = 200;
             errorMessage = null;
            }
            String methodName = context.getRequiredTestMethod().getName();
            ReportObject reportObject=new ReportObject(statusCode,errorMessage,methodName);
            reportObjects.add(reportObject);
        }
    }
}
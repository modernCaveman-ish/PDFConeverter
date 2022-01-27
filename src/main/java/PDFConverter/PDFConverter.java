package PDFConverter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import java.io.*;


public class PDFConverter {

    private void generateHTMLFromPDF(String filename) {
        try {
            PDDocument pdf = PDDocument.load(new File(filename));
            Writer output = new PrintWriter("src/output/pdf.html", "utf-8");
            new PDFDomTree().writeText(pdf, output);
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private static void generatePDFFromHTML(String filename) {
            try {
                Document document = new Document();
                PdfWriter writer = PdfWriter.getInstance(document,
                        new FileOutputStream("src/output/html.pdf"));
                document.open();
                XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                        new FileInputStream(filename));
                document.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


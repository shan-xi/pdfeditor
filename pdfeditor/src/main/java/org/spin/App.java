package org.spin;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.UnitValue;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String inputPdfFilePath = "E42110100_B_SHEET_COVER_CARIAD_HCP5_GEN_2_20230817.pdf"; // Replace with the path to your input PDF file
        String outputPdfFilePath = "E42110100_B_SHEET_COVER_CARIAD_HCP5_GEN_2_20230817-1.pdf"; // Replace with the path for the output PDF file
        String imagePath = "white_rectangle.jpg"; // Replace with the path to your image file

        try {
            // Load the existing PDF
            PdfDocument pdfDocument = new PdfDocument(new PdfReader(inputPdfFilePath), new PdfWriter(outputPdfFilePath));

            // Create a Document instance for adding content
            Document document = new Document(pdfDocument);

            // Load the image
            Image image1 = new Image(ImageDataFactory.create(imagePath));
            Image image2 = new Image(ImageDataFactory.create(imagePath));

            // Set the size and position of the image on the page
            float imageWidth1 = 195f; // Replace with your desired image width
            float imageHeight1 = 58f; // Replace with your desired image height
            float xPosition1 = 2995f; // Replace with your desired X position
            float yPosition1 = 253f; // Replace with your desired Y position

            float imageWidth2 = 145f; // Replace with your desired image width
            float imageHeight2 = 58f; // Replace with your desired image height
            float xPosition2 = 3194f; // Replace with your desired X position
            float yPosition2 = 253f; // Replace with your desired Y position

            image1.setWidth(UnitValue.createPointValue(imageWidth1));
            image1.setHeight(UnitValue.createPointValue(imageHeight1));
            image1.setFixedPosition(xPosition1, yPosition1);

            image2.setWidth(UnitValue.createPointValue(imageWidth2));
            image2.setHeight(UnitValue.createPointValue(imageHeight2));
            image2.setFixedPosition(xPosition2, yPosition2);

            // Add the image to a specific page (e.g., page 1)
            document.add(image1);
            document.add(image2);

            // Close the document
            document.close();

            System.out.println("Image added successfully to the PDF.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

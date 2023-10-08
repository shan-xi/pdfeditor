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
            Image image = new Image(ImageDataFactory.create(imagePath));

            // Set the size and position of the image on the page
            float imageWidth = 195f; // Replace with your desired image width
            float imageHeight = 58f; // Replace with your desired image height
            float xPosition = 2995f; // Replace with your desired X position
            float yPosition = 253f; // Replace with your desired Y position

            image.setWidth(UnitValue.createPointValue(imageWidth));
            image.setHeight(UnitValue.createPointValue(imageHeight));
            image.setFixedPosition(xPosition, yPosition);

            // Add the image to a specific page (e.g., page 1)
            document.add(image);

            // Close the document
            document.close();

            System.out.println("Image added successfully to the PDF.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

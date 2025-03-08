package com.restaurant.util;


import com.restaurant.model.vo.OrderRecommendation;
import com.restaurant.model.vo.ProductRecommendation;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class PdfGenerator {

    public static byte[] generateOrderRecommendationPdf(OrderRecommendation recommendation) throws Exception {
        // Instances required to create the PDF
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // PDF header
        document.add(new Paragraph("Order Recommendation") // PDF title
                .setBold() // Set the title in bold
                .setFontSize(16)); // Set the title font size to 16
        document.add(new Paragraph("Date: " + recommendation.getDate()).setFontSize(12)); // Add the current date
        document.add(new Paragraph("\nRecommended Products:").setBold().setFontSize(14)); // Add a subtitle

        // Create a table with recommended products
        float[] columnWidths = {200f, 100f, 100f, 200f}; // Column sizes
        Table table = new Table(columnWidths); // Create the table
        table.addHeaderCell(new Cell().add(new Paragraph("Product Name").setBold())); // Create the first column
        table.addHeaderCell(new Cell().add(new Paragraph("Current Stock").setBold())); // Create the second column
        table.addHeaderCell(new Cell().add(new Paragraph("Recommended Quantity").setBold())); // Create the third column
        table.addHeaderCell(new Cell().add(new Paragraph("Available Suppliers").setBold())); // Create the fourth column

        // Add recommended products
        for (ProductRecommendation product : recommendation.getProducts()) { // Iterate through recommended products
            table.addCell(new Cell().add(new Paragraph(product.getProductName()))); // Add the product name
            table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getCurrentStock())))); // Add the current stock of the product
            table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getRecommendedQuantity())))); // Add the recommended quantity
            // Load the product's suppliers
            String suppliers = "";
            for (String s : product.getSuppliersName()) {
                suppliers += s + "\n";
            }
            table.addCell(new Cell().add(new Paragraph(suppliers))); // Add the product's suppliers
        }

        document.add(table); // Add the table to the PDF
        document.close(); // Close the document to finalize the content

        // Return the generated PDF as a byte array
        return outputStream.toByteArray();
    }
}



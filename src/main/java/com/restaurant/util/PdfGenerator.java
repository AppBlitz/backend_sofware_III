package com.restaurant.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.restaurant.dto.product.ProductExpiration;
import com.restaurant.model.vo.OrderRecommendation;
import com.restaurant.model.vo.ProductRecommendation;

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
        float[] columnWidths = { 200f, 100f, 100f, 200f }; // Column sizes
        Table table = new Table(columnWidths); // Create the table
        table.addHeaderCell(new Cell().add(new Paragraph("Product Name").setBold())); // Create the first column
        table.addHeaderCell(new Cell().add(new Paragraph("Current Stock").setBold())); // Create the second column
        table.addHeaderCell(new Cell().add(new Paragraph("Recommended Quantity").setBold())); // Create the third column
        table.addHeaderCell(new Cell().add(new Paragraph("Available Suppliers").setBold())); // Create the fourth column

        // Add recommended products
        for (ProductRecommendation product : recommendation.getProducts()) { // Iterate through recommended products
            table.addCell(new Cell().add(new Paragraph(product.getProductName()))); // Add the product name
            table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getCurrentStock())))); // Add the current
                                                                                                     // stock of the
                                                                                                     // product
            table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getRecommendedQuantity())))); // Add the
                                                                                                            // recommended
                                                                                                            // quantity
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

    public static byte[] expirationProducts(ArrayList<ProductExpiration> products) throws Exception {
        // Instancias necesarias para crear el PDF
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Encabezado del PDF
        document.add(new Paragraph("Products Expiration") // Título del PDF
                .setBold() // Colocar en negrita
                .setFontSize(16)); // Tamaño de la fuente 16

        document.add(new Paragraph("\nList of Products:").setBold().setFontSize(14)); // Subtítulo

        // Crear una tabla con los productos
        float[] columnWidths = { 200f, 200f }; // Tamaños de las columnas: Nombre, Fecha de expiración
        Table table = new Table(columnWidths); // Crear la tabla
        table.addHeaderCell(new Cell().add(new Paragraph("Product Name").setBold())); // Encabezado columna 1
        table.addHeaderCell(new Cell().add(new Paragraph("Expiration Date").setBold())); // Encabezado columna 2

        // Agregar los productos a la tabla
        for (ProductExpiration product : products) { // Iterar a través de la lista de productos
            //
            table.addCell(new Cell().add(new Paragraph(product.nameProduct()))); // Nombre del producto
            table.addCell(new Cell().add(new Paragraph(product.dateEXpiration().toString()))); // Fecha de expiración
        }

        document.add(table); // Agregar la tabla al PDF
        document.close(); // Cerrar el documento para finalizar el contenido

        // Retornar el PDF generado como un arreglo de bytes
        return outputStream.toByteArray();
    }

}

package com.restaurant.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.restaurant.dto.product.ProductExpiration;
import com.restaurant.model.document.Menu;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.OrderRecommendation;
import com.restaurant.model.vo.ProductRecommendation;
import com.restaurant.util.interfaces.PdfGeneratosInter;

@Component
public class PdfGenerator implements PdfGeneratosInter {

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

        // Add recommended products
        if (recommendation.getProducts().isEmpty()) {
            table.addCell(new Cell().add(new Paragraph(("no hay recomendacion de pedido por fabricar"))));
        } else {
            table.addHeaderCell(new Cell().add(new Paragraph("Product Name").setBold())); // Create the first column
            table.addHeaderCell(new Cell().add(new Paragraph("Current Stock").setBold())); // Create the second column
            table.addHeaderCell(new Cell().add(new Paragraph("Recommended Quantity").setBold())); // Create the third
                                                                                                  // column
            table.addHeaderCell(new Cell().add(new Paragraph("Available Suppliers").setBold())); // Create the fourth
                                                                                                 // column

            for (ProductRecommendation product : recommendation.getProducts()) { // Iterate through recommended products
                table.addCell(new Cell().add(new Paragraph(product.getProductName()))); // Add the product name
                table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getCurrentStock())))); // Add the
                                                                                                         // current
                // stock of the
                // product
                table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getRecommendedQuantity())))); // Add
                                                                                                                // the
                // recommended
                // quantity
                // Load the product's suppliers
                String suppliers = "";
                if (product.getSuppliersName().isEmpty()) {
                    suppliers = "no hay proveedores disponibles \n SE REQUIERE VERIFICAR ESTADO DE PRODUCTO";
                } else {
                    for (String s : product.getSuppliersName()) {
                        suppliers += s + "\n";
                    }
                }
                table.addCell(new Cell().add(new Paragraph(suppliers))); // Add the product's suppliers
            }
        }
        document.add(table); // Add the table to the PDF
        document.close(); // Close the document to finalize the content

        // Return the generated PDF as a byte array
        return outputStream.toByteArray();
    }

    public static byte[] expirationProducts(ArrayList<ProductExpiration> products) throws Exception {
        // Instancias necesarias para com.crear el PDF
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

    @Override
    public byte[] createInvoice(ArrayList<Menu> listMenus) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Título de la factura
        document.add(new Paragraph("Invoice")
                .setBold()
                .setFontSize(16)
                .setTextAlignment(TextAlignment.CENTER));

        // Definir estructura de la tabla
        float[] columnWidths = { 200F, 100F, 100F };
        Table table = new Table(columnWidths);

        // Encabezados de la tabla
        table.addHeaderCell(new Cell().add(new Paragraph("Recipe name").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Price").setBold()));
        table.addHeaderCell(new Cell().add(new Paragraph("Quantity").setBold()));

        double total = 0.0;
        double taxRate = 0.19;

        // Rellenar filas de la tabla
        for (Menu item : listMenus) {
            double price = item.getPrice();
            double quantity = item.getAmount();

            table.addCell(new Cell().add(new Paragraph(nameRecipe(item.getMenuItems())))); // Nombre de la receta
            table.addCell(new Cell().add(new Paragraph(String.format("$%.2f", price)))); // Precio
            table.addCell(new Cell().add(new Paragraph(String.valueOf(quantity)))); // Cantidad
            total += quantity * price;
        }

        // Agregar la tabla al documento
        document.add(table);

        // Calcular impuestos y total
        double tax = total * taxRate;
        double totalWithTax = total + tax;

        // Agregar detalles finales al documento
        document.add(new Paragraph("\n"));
        document.add(new Paragraph(String.format("Subtotal: $%.2f", total))
                .setTextAlignment(TextAlignment.RIGHT));
        document.add(new Paragraph(String.format("Tax (19%%): $%.2f", tax))
                .setTextAlignment(TextAlignment.RIGHT));
        document.add(new Paragraph(String.format("Total: $%.2f", totalWithTax))
                .setBold()
                .setTextAlignment(TextAlignment.RIGHT));

        // Cerrar documento
        document.close();

        return outputStream.toByteArray();
    }

    public String nameRecipe(HashMap<String, Recipe> items) {
        String aux = "";
        for (String key : items.keySet()) {
            aux = items.get(key).getName();
        }
        return aux;

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;


public class PrintOrder {
    XWPFDocument document;
    File orderFile;
    String fileName;
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    DecimalFormat formatter = new DecimalFormat("###,###,###0");
//    File filefontTieuDe = new File("D:\\Workspace\\Work_desktop\\desktop\\BidaManagement\\src\\main\\java\\com\\mycompany\\bidamanagement\\font\\vuArialBold.ttf");
    String fontPathBold = "/Users/duc/NetBeansProjects/BidaManagement/src/main/java/com/mycompany/bidamanagement/font/vuArialBold.ttf"; // Replace with the path to your font file
//    PdfFont fontTieuDe1 = PdfFontFactory.createFont(fontPathBold, "Identity-H", true);
//    PdfFont fontTieuDe2 = PdfFontFactory.createFont(fontPathBold, "Identity-H", true);
//    PdfFont fontTieuDe3 = PdfFontFactory.createFont(fontPathBold, "Identity-H", true);
//    
    String fontPath = "/Users/duc/NetBeansProjects/BidaManagement/src/main/java/com/mycompany/bidamanagement/font/vuArial.ttf"; // Replace with the path to your font file
//    PdfFont fontNoiDung1  = PdfFontFactory.createFont(fontPath, "Identity-H", true);
//    PdfFont fonts[4]  = PdfFontFactory.createFont(fontPath, "Identity-H", true);
//    PdfFont fontNoiDung3  = PdfFontFactory.createFont(fontPath, "Identity-H", true);
    public PdfFont selectFont(String fontPath, String style, int size) {
        try {
            return PdfFontFactory.createFont(fontPath, style, true);
        } catch (IOException e) {
            System.out.println("Error loading font: " + e.getMessage());
            e.printStackTrace();
            // Handle the exception as needed
            return null;  // Return null or throw an exception based on your error handling strategy
        }
    }
    public PdfFont[] createFonts() {
        PdfFont[] fonts = new PdfFont[6];

        fonts[0] = selectFont(fontPathBold, "Identity-H", 16);
        fonts[1] = selectFont(fontPathBold, "Identity-H", 13);
        fonts[2] = selectFont(fontPathBold, "Identity-H", 12);
        fonts[3] = selectFont(fontPath, "Identity-H", 13);
        fonts[4] = selectFont(fontPath, "Identity-H", 12);
        fonts[5] = selectFont(fontPath, "Identity-H", 11);

    return fonts;
    }

    public PrintOrder() {
        document = new XWPFDocument();
        orderFile = new File("/Users/duc/Desktop/pdf/order.pdf");
    }

//    public void print(int id) throws Exception {
//        orderFile = new File("D:\\Desktop\\Order\\order-" + id + ".docx");
//        OrderDao orderDao = new OrderDao();
//        OrderItemDao orderItemDao = new OrderItemDao();
//        Order order = orderDao.get(id);
//        ArrayList<OrderItem> orderItems = orderItemDao.getByIdOrder(id);
//        print(order, orderItems);
//    }

    public File getOrderFile() {
        return orderFile;
    }

    public void setOrderFile(File orderFile) {
        this.orderFile = orderFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void createHeader(Document document, PdfFont[] fonts) {
        Paragraph prgTenHD = new Paragraph("Billard")
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(fonts[0])
                .setFontSize(16);
        document.add(prgTenHD);
        
        Paragraph prgDiachi = new Paragraph("Địa chỉ:")
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(fonts[4])
                .setFontSize(12);
        document.add(prgDiachi);
        
        Paragraph prgSDT = new Paragraph("Điện thoại:")
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(fonts[4])
                .setFontSize(12);
        document.add(prgSDT);
        
        Paragraph thanhngang = new Paragraph("-----------------------------------------------------------------")
                .setTextAlignment(TextAlignment.CENTER);
        document.add(thanhngang);
        
        Paragraph prgTieude = new Paragraph("HÓA ĐƠN")
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(fonts[0])
                .setMargins(0, 10, 0, 10);
        document.add(prgTieude);
        
        Paragraph prgDate = new Paragraph(dateFormat.format(currentDate))
                .setTextAlignment(TextAlignment.CENTER)
                .setFont(fonts[4])
                .setFontSize(12);
        document.add(prgDate);
    }

//    public void createHeaderInfo(BillItem order) {
//        XWPFParagraph paragraph;
//        XWPFRun run;
//        int fontSize = 12;
//        paragraph = document.createParagraph();
////        paragraph.setBorderBottom(Borders.BASIC_WIDE_MIDLINE);
////        paragraph.setBorderTop(Borders.BASIC_WIDE_MIDLINE);
////        paragraph.setBorderLeft(Borders.BASIC_WIDE_MIDLINE);
////        paragraph.setBorderRight(Borders.BASIC_WIDE_MIDLINE);
//        paragraph.setAlignment(ParagraphAlignment.LEFT);
//
//        run = paragraph.createRun();
//        run.setText("Tên nhân viên: ");
//        run.setFontSize(fontSize);
//        run = paragraph.createRun();
//        run.setBold(true);
////        run.setText(order.getEmployee().getName());
//        run.setText("Duc");
//        run.setFontSize(fontSize);
//        run.setColor("FF0000");
//        run.addBreak();
//
//        run = paragraph.createRun();
//        run.setText("Thời gian: ");
//        run.setFontSize(fontSize);
//        run = paragraph.createRun();
//        run.setBold(true);
//        run.setText(dateFormat.format(new Date(order.getOrderDate().getTime())));
//        run.setFontSize(fontSize);
//        run.setColor("FF0000");
//        run.addBreak();
//    }

    public void createOrderInfo(Document document, ArrayList<BillItem> billItems, PdfFont[] fonts) {
    Table tableHD = new Table(new float[]{250, 120, 90, 250});
    tableHD.setMinWidth(90);
    tableHD.setMarginTop(10);
    tableHD.setMarginBottom(5);

    Cell cellTDTenSP = new Cell().add(new Paragraph("Tên SP").setFont(fonts[2]));
    cellTDTenSP.setHorizontalAlignment(HorizontalAlignment.LEFT);
    cellTDTenSP.setVerticalAlignment(VerticalAlignment.MIDDLE);
    cellTDTenSP.setBorder(Border.NO_BORDER);
    cellTDTenSP.setBorderTop(new DashedBorder(1)); // Adjust thickness and gap as needed
    cellTDTenSP.setBorderBottom(new DashedBorder(1)); // Adjust thickness and gap as needed
    tableHD.addCell(cellTDTenSP);

    Cell cellTDDongia = new Cell().add(new Paragraph("Đơn giá").setFont(fonts[2]).setTextAlignment(TextAlignment.RIGHT));
    cellTDDongia.setHorizontalAlignment(HorizontalAlignment.CENTER);
    cellTDDongia.setVerticalAlignment(VerticalAlignment.MIDDLE);
    cellTDDongia.setBorder(Border.NO_BORDER);
    cellTDDongia.setBorderTop(new DashedBorder(1)); // Adjust thickness and gap as needed
    cellTDDongia.setBorderBottom(new DashedBorder(1)); // Adjust thickness and gap as needed
    tableHD.addCell(cellTDDongia);

    Cell cellTDSoluong = new Cell().add(new Paragraph("Số lượng").setFont(fonts[2]).setTextAlignment(TextAlignment.CENTER));
    cellTDSoluong.setHorizontalAlignment(HorizontalAlignment.CENTER);
    cellTDSoluong.setVerticalAlignment(VerticalAlignment.MIDDLE);
    cellTDSoluong.setBorder(Border.NO_BORDER);
    cellTDSoluong.setBorderTop(new DashedBorder(1)); // Adjust thickness and gap as needed
    cellTDSoluong.setBorderBottom(new DashedBorder(1)); // Adjust thickness and gap as needed
    tableHD.addCell(cellTDSoluong);

    Cell cellTDSotien = new Cell().add(new Paragraph("Thành tiền").setFont(fonts[2]).setTextAlignment(TextAlignment.RIGHT));
    cellTDSotien.setHorizontalAlignment(HorizontalAlignment.CENTER);
    cellTDSotien.setVerticalAlignment(VerticalAlignment.MIDDLE);
    cellTDSotien.setBorder(Border.NO_BORDER);
    cellTDSotien.setBorderTop(new DashedBorder(1)); // Adjust thickness and gap as needed
    cellTDSotien.setBorderBottom(new DashedBorder(1)); // Adjust thickness and gap as needed
    tableHD.addCell(cellTDSotien);


    


    for (BillItem billItem : billItems) {
        Cell cellTenSP = new Cell().add(new Paragraph(billItem.getProductName()).setFont(fonts[4]));
        cellTenSP.setHorizontalAlignment(HorizontalAlignment.LEFT);
        cellTenSP.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cellTenSP.setBorder(Border.NO_BORDER);
        cellTenSP.setBorderBottom(new DashedBorder(1));
        tableHD.addCell(cellTenSP);

        Cell cellDongia = new Cell().add(new Paragraph(formatter.format(billItem.getTotalPrice())).setTextAlignment(TextAlignment.RIGHT));
        cellDongia.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        cellDongia.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cellDongia.setBorder(Border.NO_BORDER);
        cellDongia.setBorderBottom(new DashedBorder(1));
        tableHD.addCell(cellDongia);

        Cell cellSoluong = new Cell().add(new Paragraph(String.valueOf(billItem.getQuantity())).setFont(fonts[4]).setTextAlignment(TextAlignment.CENTER));
        cellSoluong.setHorizontalAlignment(HorizontalAlignment.CENTER);
        cellSoluong.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cellSoluong.setBorder(Border.NO_BORDER);
        cellSoluong.setBorderBottom(new DashedBorder(1));
        tableHD.addCell(cellSoluong);

        Cell cellSotien = new Cell().add(new Paragraph(formatter.format(billItem.getTotalBill())).setTextAlignment(TextAlignment.RIGHT));
        cellSotien.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        cellSotien.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cellSotien.setBorder(Border.NO_BORDER);
        cellSotien.setBorderBottom(new DashedBorder(1));
        tableHD.addCell(cellSotien);
    }

    document.add(tableHD);
}


    public void createPaidInfo(Document document, ArrayList<BillItem> orderItems, PdfFont[] fonts) {
        Table tableTT = new Table(new float[]{250, 120, 90, 250});
        tableTT.setMinWidth(90);
        tableTT.setMarginTop(10);
        tableTT.setMarginBottom(5);

        Cell cellDTThanhtien = new Cell(1, 3).add(new Paragraph("Tổng cộng: ").setFont(fonts[2]).setTextAlignment(TextAlignment.RIGHT));
        cellDTThanhtien.setHorizontalAlignment(HorizontalAlignment.LEFT);
        cellDTThanhtien.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cellDTThanhtien.setMinHeight(20);
        cellDTThanhtien.setBorder(Border.NO_BORDER);
        tableTT.addCell(cellDTThanhtien);
         // Tính tổng tiền từ danh sách orderItems
        long totalMoney = 0;
        for (BillItem orderItem : orderItems) {
            totalMoney += orderItem.getTotalBill();
        }

        // Thêm cellThanhtien vào bảng với giá trị tổng tiền
        Cell cellThanhtien = new Cell().add(new Paragraph(formatter.format(totalMoney)).setTextAlignment(TextAlignment.RIGHT));
        cellThanhtien.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        cellThanhtien.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cellThanhtien.setMinHeight(20);
        cellThanhtien.setBorder(Border.NO_BORDER);
        tableTT.addCell(cellThanhtien);
        
        document.add(tableTT);
    }

    public void createFooter(Document document, PdfFont[] fonts) {
        
        Paragraph prg3 = new Paragraph("-----------------------------------------------------------------").setFont(fonts[4]);
        prg3.setTextAlignment(TextAlignment.CENTER);
        prg3.setMarginTop(30);
        document.add(prg3);
        
        Paragraph prg4 = new Paragraph("Cảm ơn và hẹn gặp lại!").setFont(fonts[2]);
        prg4.setTextAlignment(TextAlignment.CENTER);
        prg4.setMarginTop(30);
        document.add(prg4);
    }

    public void print(BillItem order, ArrayList<BillItem> orderItems) throws Exception {
        SimpleDateFormat dateFormatForFileName = new SimpleDateFormat("ddMMyyyy_HHmmss");
        // Create fonts
        PdfFont[] fonts = createFonts();
        // Create a PdfDocument instance
        try ( 
                PdfWriter writer = new PdfWriter("/Users/duc/Desktop/pdf/order - " + dateFormatForFileName.format(new Date()) + ".pdf")) {
   
            PdfDocument pdfDocument = new PdfDocument(writer);
            
            try ( 
                    Document document = new Document(pdfDocument, PageSize.A4)        
//        File pdfFile = new File("D:\\pdf\\order - " + dateFormatForFileName.format(order.getOrderDate()) + ".pdf");
//        PdfWriter pdfWriter = new PdfWriter(new FileOutputStream(pdfFile));
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            ) {
                createHeader(document, fonts);
//        createHeaderInfo(document, order);
           createOrderInfo(document, orderItems, fonts);
        createPaidInfo(document, orderItems, fonts);
        createFooter(document, fonts);
            }
        }
        try {
            File file = new File("/Users/duc/Desktop/pdf/order - " + dateFormatForFileName.format(new Date()) + ".pdf");

            if (!file.exists()) {
                System.out.println("File does not exist at the specified path.");
                return;
            }

            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop is not supported.");
                return;
            }

            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package cafeManagementSystem;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import common.OpenPdf;
import dao.BillDao;
import dao.CategoryDao;
import dao.ProductDao;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Bill;
import model.Product;
import model.Category;
import view.Welcome;
import model.User;

public class PlaceOrder extends javax.swing.JFrame {

    public int billId = 1;
    public double grandTotal = 0;
    public double productPrice = 0;
    public double productTotal = 0;
    public double Balance = 0;
    public double pay = 0;
    public static String userName;

    public PlaceOrder() {
        initComponents();
    }

    public PlaceOrder(String name) {
        initComponents();
        txtproductname.setEditable(false);
        txtprice.setEditable(false);
        txttotal.setEditable(false);
        btnaddtocart.setEnabled(false);
        btnbill.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userName = name;
    }

    public void productNameByCategory(String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }

    public void filterProductByname(String name, String category) {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDao.filterProductByname(name, category);
        Iterator<Product> itr = list.iterator();
        while (itr.hasNext()) {
            Product productObj = itr.next();
            dtm.addRow(new Object[]{productObj.getName()});
        }
    }

    public void clearProductFields() {
        txtproductname.setText("");
        txtprice.setText("");
        jSpinner1.setValue(1);
        txttotal.setText("");
        btnaddtocart.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtproductname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        btnclear = new javax.swing.JButton();
        btnaddtocart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        btnbill = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPay = new javax.swing.JTextField();
        txtgrandtotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 34, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Bill ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 113, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Category");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 113, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 156, 250, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Search");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 205, -1, -1));

        txtsearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 248, 250, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 314, 250, 357));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 113, -1, -1));

        txtproductname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtproductname, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 156, 250, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Price");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1025, 113, -1, -1));

        txtprice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1025, 156, 250, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Quantity");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 205, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Total");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1025, 205, -1, -1));

        txttotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        getContentPane().add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1025, 248, 250, -1));

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 248, 250, -1));

        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 297, -1, -1));

        btnaddtocart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnaddtocart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnaddtocart.setText("Add to Cart");
        btnaddtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddtocartActionPerformed(evt);
            }
        });
        getContentPane().add(btnaddtocart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1143, 291, -1, -1));

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "PRICE", "QUANTITY", "TOTAL"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 355, 578, 278));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText(" Total $");
        jLabel13.setMaximumSize(new java.awt.Dimension(64, 35));
        jLabel13.setMinimumSize(new java.awt.Dimension(64, 35));
        jLabel13.setPreferredSize(new java.awt.Dimension(64, 35));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 640, -1, 50));

        txtBalance.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtBalance.setText("000");
        getContentPane().add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 650, 90, -1));

        btnbill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnbill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btnbill.setText("Generate Bill & Print");
        btnbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbillActionPerformed(evt);
            }
        });
        getContentPane().add(btnbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 720, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("--");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Exchange bill $");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 650, -1, 30));

        txtPay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPayKeyReleased(evt);
            }
        });
        getContentPane().add(txtPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 650, 90, -1));

        txtgrandtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtgrandtotal.setText("000");
        getContentPane().add(txtgrandtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, 90, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText(" Pay $");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 650, -1, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Big background.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new Home(userName).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        billId = Integer.parseInt(BillDao.getId());
        jLabel15.setText(BillDao.getId());
        ArrayList<Category> list = CategoryDao.getAllRecorded();
        Iterator<Category> itr = list.iterator();
        while (itr.hasNext()) {
            Category categoryObj = itr.next();
            jComboBox1.addItem(categoryObj.getName());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        String name = txtsearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByname(name, category);
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index, 0).toString();
        Product product = ProductDao.getProductByname(productName);
        txtproductname.setText(product.getName());
        txtprice.setText(product.getPrice());
        jSpinner1.setValue(1);
        txttotal.setText(product.getPrice());

        productPrice = Double.parseDouble(product.getPrice());
        productTotal = Double.parseDouble(product.getPrice());
        btnaddtocart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        double quantity = Double.parseDouble(jSpinner1.getValue().toString());

        if (quantity < 1.0) {
            jSpinner1.setValue(1.0);
            quantity = 1.0;
        }
        productTotal = productPrice * quantity;
        String formattedTotal = String.format("%.2f", productTotal);
        txttotal.setText(formattedTotal);
    }//GEN-LAST:event_jSpinner1StateChanged

    public void balance() {
        grandTotal = Double.parseDouble(txtgrandtotal.getText());
        pay = Double.parseDouble(txtPay.getText());
        Balance = pay - grandTotal;
        txtBalance.setText(String.format("%.2f", Balance));
    }

    private void btnaddtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddtocartActionPerformed
        String name = txtproductname.getText();
        String price = txtprice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());

        String formattedProductTotal = String.format("%.2f", productTotal);
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();

        dtm.addRow(new Object[]{name, price, quantity, formattedProductTotal});

        grandTotal = grandTotal + productTotal;
        txtgrandtotal.setText(String.format("%.2f", grandTotal));
        clearProductFields();
        btnbill.setEnabled(true);
    }//GEN-LAST:event_btnaddtocartActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        clearProductFields();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbillActionPerformed
        balance();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todaydate = dFormat.format(date);
        SimpleDateFormat tFormat = new SimpleDateFormat("hh:mm a");
        String currentTime = tFormat.format(date);
        String total = String.format("%.2f", grandTotal);
        String Pay = String.format("%.2f", pay);
        String balance = String.format("%.2f", Balance);

        String createdBy = userName;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setDate(todaydate);
        bill.setTime(currentTime);
        bill.setTotal(total);
        bill.setPay(Pay);
        bill.setBalance(balance);
        bill.setCreatedBy(createdBy);
        BillDao.save(bill);

        //Creating document
        String path = "src/Transaction/";
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
//        try {
//            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
//            doc.open();
//
//            Paragraph cafeName = new Paragraph("Good Boys Cafe", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
//            cafeName.setAlignment(Element.ALIGN_CENTER);
//            doc.add(cafeName);
//
//            Paragraph cafeDetails = new Paragraph("123 Coffee Street, Brewtown\nContact: (855)16-303-887\n\n",
//            FontFactory.getFont(FontFactory.HELVETICA, 10));
//            cafeDetails.setAlignment(Element.ALIGN_CENTER);
//            doc.add(cafeDetails);
//
//            Paragraph starLine = new Paragraph("****************************************************************************************************************");
//            doc.add(starLine);
//
//            Paragraph paragraph3 = new Paragraph("\tBill ID: " + billId + "\nDate: " + todaydate + "\nTime: " + currentTime);
//            doc.add(paragraph3);
//            doc.add(starLine);
//
//            PdfPTable tbl = new PdfPTable(4);
//            tbl.addCell(createNoBorderCell("Name"));
//            tbl.addCell(createNoBorderCell("Price"));
//            tbl.addCell(createNoBorderCell("Quantity"));
//            tbl.addCell(createNoBorderCell("Total"));
//
//            for (int i = 0; i < jTable2.getRowCount(); i++) {
//                String n = jTable2.getValueAt(i, 0).toString();
//                String d = jTable2.getValueAt(i, 1).toString();
//                String r = jTable2.getValueAt(i, 2).toString();
//                String q = jTable2.getValueAt(i, 3).toString();
//
//                tbl.addCell(createNoBorderCell(n));
//                tbl.addCell(createNoBorderCell(d));
//                tbl.addCell(createNoBorderCell(r));
//                tbl.addCell(createNoBorderCell(q));
//            }
//
//            doc.add(tbl);
//            doc.add(starLine);
//            Paragraph paragraph4 = new Paragraph("\tSubtotal  : $" + total + "\nCash       : $" + Pay + "\nChange   : $" + balance);
//            paragraph4.setAlignment(Element.ALIGN_RIGHT);
//            doc.add(paragraph4);
//            doc.add(starLine);
//            Paragraph thanksMsg = new Paragraph("Thank you for visiting Mood Lift Cafe!\nWe hope to see you again soon.");
//            thanksMsg.setAlignment(Element.ALIGN_CENTER);
//            doc.add(thanksMsg);
//
//            Paragraph cutLine = new Paragraph("------------------------------------------------------------------------------------------------------------------------------");
//            cutLine.setAlignment(Element.ALIGN_CENTER);
//            doc.add(cutLine);
//            OpenPdf.openById(String.valueOf(billId));
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + billId + ".pdf"));
            doc.open();

            // Add title and cafe details
            doc.add(createParagraph("Encrypted Love Café", 22, Element.ALIGN_CENTER, true));
            doc.add(createParagraph("123 Coffee Street, Brewtown\nContact: (855)16-303-887\n", 14, Element.ALIGN_CENTER, false));
            doc.add(createParagraph("****************************************************************************************************************", 12, Element.ALIGN_CENTER, false));

            // Header Table
            String[][] data = {
                {"Bill ID:", String.valueOf(billId) , "Date:", todaydate},
                {"Employee:", createdBy, "Time:", currentTime}
            };
            int[] alignments = {Element.ALIGN_LEFT, Element.ALIGN_LEFT, Element.ALIGN_RIGHT, Element.ALIGN_RIGHT};
            float[] columnWidths = {1, 2, 2, 1};
            PdfPTable headerTable = createTableWithAlignment(data, alignments, columnWidths, 14);
            doc.add(headerTable);
            doc.add(createParagraph("****************************************************************************************************************", 12, Element.ALIGN_CENTER, false));

            // Item Table
            PdfPTable tbl = createTable(new String[][]{
                {"Name", "Price", "Quantity", "Total"}
            }, new float[]{1, 1, 1, 1});
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                tbl.addCell(createCell(jTable2.getValueAt(i, 0).toString(), 14, Element.ALIGN_CENTER));
                tbl.addCell(createCell(jTable2.getValueAt(i, 1).toString(), 14, Element.ALIGN_CENTER));
                tbl.addCell(createCell(jTable2.getValueAt(i, 2).toString(), 14, Element.ALIGN_CENTER));
                tbl.addCell(createCell(jTable2.getValueAt(i, 3).toString(), 14, Element.ALIGN_CENTER));
            }
            doc.add(tbl);
            doc.add(createParagraph("****************************************************************************************************************", 12, Element.ALIGN_CENTER, false));

            // Subtotal, Cash, Change
            doc.add(createParagraph(String.format("\tSubtotal  : $%.2f\nCash       : $%.2f\nChange   : $%.2f",
                    Double.valueOf(total),
                    Double.parseDouble(Pay),
                    Double.parseDouble(balance)),
                    14, Element.ALIGN_RIGHT, false));

            doc.add(createParagraph("****************************************************************************************************************", 12, Element.ALIGN_CENTER, false));

            // Thank You Note
            doc.add(createParagraph("Thank you for visiting Encrypted Love Café!\nWe hope to see you again soon.", 14, Element.ALIGN_CENTER, true));
            doc.add(createParagraph("----------------------------------------------------------------------------------------------------------------------------------", 12, Element.ALIGN_CENTER, false));

            OpenPdf.openById(String.valueOf(billId));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        doc.close();
        setVisible(false);
        new PlaceOrder(createdBy).setVisible(true);
    }//GEN-LAST:event_btnbillActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = jTable2.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal = grandTotal - Double.parseDouble(total);

            String formattedTotal = String.format("%.2f", grandTotal);
            txtgrandtotal.setText(formattedTotal);

            ((DefaultTableModel) jTable2.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPayKeyReleased
     balance();
    }//GEN-LAST:event_txtPayKeyReleased

    private PdfPCell createNoBorderCell(String content) {
        PdfPCell cell = new PdfPCell(new Phrase(content));
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
    
    private Paragraph createParagraph(String text, int fontSize, int alignment, boolean bold) {
        Font font = bold ? FontFactory.getFont(FontFactory.HELVETICA_BOLD, fontSize) : FontFactory.getFont(FontFactory.HELVETICA, fontSize);
        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(alignment);
        return paragraph;
    }
       
    private PdfPTable createTable(String[][] data, float[] columnWidths) throws DocumentException {
        PdfPTable table = new PdfPTable(columnWidths.length);
        table.setWidthPercentage(100);
        table.setWidths(columnWidths);
        for (String[] row : data) {
            for (String cell : row) {
                table.addCell(createCell(cell, 14, Element.ALIGN_CENTER));
            }
        }
        return table;
    }

    private PdfPCell createCell(String text, int fontSize, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text, FontFactory.getFont(FontFactory.HELVETICA, fontSize)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(alignment);
        return cell;
    }

    private PdfPTable createTableWithAlignment(String[][] data, int[] alignments, float[] columnWidths, int fontSize) throws DocumentException {
        PdfPTable table = new PdfPTable(data[0].length); // Number of columns
        table.setWidthPercentage(100); // Full width
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        table.setWidths(columnWidths);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                table.addCell(createAlignedCell(data[i][j], fontSize, alignments[j]));
            }
        }
        return table;
    }

    private PdfPCell createAlignedCell(String content, int fontSize, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(content, FontFactory.getFont(FontFactory.HELVETICA, fontSize)));
        cell.setBorder(Rectangle.NO_BORDER); // No border
        cell.setHorizontalAlignment(alignment); // Dynamic alignment
        return cell;
    }

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (userName == null) {
                    new Welcome().setVisible(true);
                } else {
                    new PlaceOrder().setVisible(true);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddtocart;
    private javax.swing.JButton btnbill;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtPay;
    private javax.swing.JTextField txtgrandtotal;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}

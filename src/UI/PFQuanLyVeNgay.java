/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import DAO.NhapXeDAO;
import DAO.TongVeDAO;
import DTO.NhapXeDTO;
import DTO.TongVeDTO;
import DTO.TongXeDTO;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class PFQuanLyVeNgay extends javax.swing.JPanel {

    DefaultTableModel tblModel = new DefaultTableModel();
    private String ma="";

    /**
     * Creates new form PFGiveCarBack
     */
    public PFQuanLyVeNgay(String maNV) {
        initComponents();
        setSize(1040, 545);
        ma=maNV;
        //showTable();
        loadTable();
        loadMave();
        //txtMaCu.setEnabled(false);
    }

//    private void showTable() {
//        tblModel.setColumnIdentifiers(new String[]{"Mã Vé"});
//        TableVeNgay.setModel(tblModel);
//    }

    public void loadTable() {
        ArrayList<NhapXeDTO> list = TongVeDAO.veXe();
        DefaultTableModel tblModel = (DefaultTableModel) TableTTXe.getModel();
        for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
                tblModel.removeRow(i);
        }
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMaVe();
            row[1] = list.get(i).getBienSo();
            row[2] = list.get(i).getLoaiXe();
            row[3] = list.get(i).getViTri();
            row[4] = list.get(i).getNgayGui();
            row[5] = list.get(i).getGioGui();
            row[6] = list.get(i).getNgayNhan();
            row[7] = list.get(i).getGioNhan();
            row[8] = list.get(i).getMaNV1();
            row[9] = list.get(i).getMaNV2();
            tblModel.addRow(row);
        }
    }

    private void loadMave() {
        ArrayList<String> list = TongVeDAO.LoadComboBoxMaVe();
        jComboBox3.removeAllItems();
        for (String item : list) {
            jComboBox3.addItem(item);
        }
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnThemVe = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableTTXe = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Thêm Thẻ ngày(Nhập số lượng):");

        btnThemVe.setBackground(new java.awt.Color(102, 102, 255));
        btnThemVe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemVe.setText("Thêm");
        btnThemVe.setBorder(null);
        btnThemVe.setBorderPainted(false);
        btnThemVe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemVe.setFocusPainted(false);
        btnThemVe.setName("btnThemVe"); // NOI18N
        btnThemVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemVeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemVeMouseExited(evt);
            }
        });
        btnThemVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Làm mới Thẻ Ngày Mã :");

        btnCapNhat.setBackground(new java.awt.Color(102, 102, 255));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCapNhat.setText("Reset");
        btnCapNhat.setBorder(null);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhat.setFocusable(false);
        btnCapNhat.setName("btnCapNhatVe"); // NOI18N
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseExited(evt);
            }
        });
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Quản Lý Thẻ Ngày");

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Làm mới");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TableTTXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã vé", "Biển Số Xe", "Loại xe", "Vị Trí", "Ngày Nhận", "Giờ Nhận", "Ngày Trả", "Giờ Trả", "MANV1", "MANV2"
            }
        ));
        jScrollPane1.setViewportView(TableTTXe);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Bảng Thẻ Ngày");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 75, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(38, 38, 38)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(432, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnThemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        try {
            Object selectedItem = jComboBox3.getSelectedItem();
            if (selectedItem != null) {
                String the = selectedItem.toString();
                TongVeDAO tv = new TongVeDAO();
                int response = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn reset không?",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    if (tv.reset(the) != 0) {
                        JOptionPane.showMessageDialog(this, "Reset thẻ thành công");
                        loadTable();
                        loadMave();
                    }
                    else 
                        JOptionPane.showMessageDialog(this, "Reset thẻ thất bại");
                }else if (response == JOptionPane.NO_OPTION) {
                } 
                
            }else
                JOptionPane.showMessageDialog(this, "Không có thẻ để reset!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               loadTable();
               loadMave();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThemVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVeActionPerformed
        // TODO add your handling code here:
        try {
            int soluong = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            TongVeDAO themve = new TongVeDAO();
            if (themve.themVe(soluong, ma) > 0) {
                  JOptionPane.showMessageDialog(this, "Thêm vé thành công!");
                  loadTable();
            } else {
                   JOptionPane.showMessageDialog(this, "Không thêm đc vé!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemVeActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void btnThemVeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemVeMouseEntered
        // TODO add your handling code here:
        
        btnThemVe.setFont(new Font(btnThemVe.getFont().getName(), Font.BOLD, btnThemVe.getFont().getSize()));
        btnThemVe.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnThemVeMouseEntered

    private void btnThemVeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemVeMouseExited
        // TODO add your handling code here:
        
        btnThemVe.setFont(new Font(btnThemVe.getFont().getName(), Font.PLAIN, btnThemVe.getFont().getSize()));
        btnThemVe.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnThemVeMouseExited

    private void btnCapNhatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseEntered
        // TODO add your handling code here:
       
        btnCapNhat.setFont(new Font(btnCapNhat.getFont().getName(), Font.BOLD, btnCapNhat.getFont().getSize()));
        btnCapNhat.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnCapNhatMouseEntered

    private void btnCapNhatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseExited
        // TODO add your handling code here:
        
        btnCapNhat.setFont(new Font(btnCapNhat.getFont().getName(), Font.PLAIN, btnCapNhat.getFont().getSize()));
        btnCapNhat.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCapNhatMouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        
        jButton1.setFont(new Font(jButton1.getFont().getName(), Font.BOLD, jButton1.getFont().getSize()));
        jButton1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        
        jButton1.setFont(new Font(jButton1.getFont().getName(), Font.PLAIN, jButton1.getFont().getSize()));
        jButton1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableTTXe;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThemVe;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}

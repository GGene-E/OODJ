/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

/**
 *
 * @author jonat
 */
public class panelCustomerView extends javax.swing.JPanel {

    /**
     * Creates new form panelOrderAdd
     */
    public panelCustomerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        txtCusSearch = new javax.swing.JTextField();
        btnCusSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblCustomerID = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblCustomerEmail = new javax.swing.JLabel();
        lblCustomerContact = new javax.swing.JLabel();
        lblCustomerAge = new javax.swing.JLabel();
        lblCusID = new javax.swing.JLabel();
        lblCusName = new javax.swing.JLabel();
        lblCusContact = new javax.swing.JLabel();
        lblCusEmail = new javax.swing.JLabel();
        lblCusAge = new javax.swing.JLabel();
        btnCusEdit = new javax.swing.JButton();
        btnCusDelete = new javax.swing.JButton();
        btnCusAdd = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Date Added"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCustomer);
        if (tblCustomer.getColumnModel().getColumnCount() > 0) {
            tblCustomer.getColumnModel().getColumn(0).setResizable(false);
            tblCustomer.getColumnModel().getColumn(1).setResizable(false);
            tblCustomer.getColumnModel().getColumn(2).setResizable(false);
        }

        txtCusSearch.setText("Search for Customer");

        btnCusSearch.setText("Search");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCustomerID.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerID.setText("Customer ID :");

        lblCustomerName.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerName.setText("Name :");

        lblCustomerEmail.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerEmail.setText("Email :");

        lblCustomerContact.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerContact.setText("Contact :");

        lblCustomerAge.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerAge.setText("Age :");

        lblCusID.setText("ID");

        lblCusName.setText("Name");

        lblCusContact.setText("Contact");

        lblCusEmail.setText("Email");

        lblCusAge.setText("Age");

        btnCusEdit.setText("Edit");

        btnCusDelete.setText("Delete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCustomerAge)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCustomerID)
                                .addComponent(lblCustomerName, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCustomerContact, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCustomerEmail, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCusID)
                            .addComponent(lblCusName)
                            .addComponent(lblCusContact)
                            .addComponent(lblCusEmail)
                            .addComponent(lblCusAge)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnCusEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCusDelete)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID)
                    .addComponent(lblCusID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerName)
                    .addComponent(lblCusName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerContact)
                    .addComponent(lblCusContact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerEmail)
                    .addComponent(lblCusEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerAge)
                    .addComponent(lblCusAge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCusDelete)
                    .addComponent(btnCusEdit))
                .addContainerGap())
        );

        btnCusAdd.setText("Add New Customer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCusSearch)
                    .addComponent(btnCusSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCusAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCusAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("View Customer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCusAdd;
    private javax.swing.JButton btnCusDelete;
    private javax.swing.JButton btnCusEdit;
    private javax.swing.JButton btnCusSearch;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCusAge;
    private javax.swing.JLabel lblCusContact;
    private javax.swing.JLabel lblCusEmail;
    private javax.swing.JLabel lblCusID;
    private javax.swing.JLabel lblCusName;
    private javax.swing.JLabel lblCustomerAge;
    private javax.swing.JLabel lblCustomerContact;
    private javax.swing.JLabel lblCustomerEmail;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtCusSearch;
    // End of variables declaration//GEN-END:variables
}

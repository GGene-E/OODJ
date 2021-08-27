/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class FrameLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrameLogin
     */
    
    int cartSource;
    int addOrderSource;
    PersonType userType;
    Person systemUser = new Person();
    // One Frame to handle Admin and Customer Logins.
    // Admin OR Customer object will be assigned to adminUser/customerUser
    Admin adminUser;
    Customer customerUser;
    
    public void refreshCustomerTable() // This method will be used to refresh customer tables
    {
        ArrayList<Customer> customerList = adminUser.getCustomerList();
        if(!customerList.isEmpty())
        {
            DefaultTableModel customerTable = (DefaultTableModel)tblCustomer.getModel();
            customerTable.setRowCount(0);
            for(Customer customerObject:customerList)
            {
                String[] customerDetails = new String[2];
                customerDetails[0] = customerObject.getPersonID();
                customerDetails[1] = customerObject.getName();
                customerTable.addRow(customerDetails);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR: Customer Database is detached or empty.");
        }
    }
    
    public void refreshOrderTable() // This method will be used to refresh order mades by users
    {
        ArrayList<Order> orderList = new ArrayList<Order>();
        String userID = "";
        if(userType == PersonType.ADMIN)
        {
            orderList = adminUser.getOrderListBasedOnID(adminUser.getPersonID());
            userID = adminUser.getPersonID();
        }
        else if(userType == PersonType.CUSTOMER)
        {
            orderList = customerUser.getOrderListBasedOnID(customerUser.getPersonID());
            userID = customerUser.getPersonID();
        }
        
        if(!orderList.isEmpty())
        {
            DefaultTableModel orderTable = (DefaultTableModel)tblOrder.getModel();
            orderTable.setRowCount(0);
            lblCusIDOrdView.setText(userID);
            lblOrderViewID.setText("");
            lblOrdViewTotal.setText("");
            for(Order orderObject:orderList)
            {
                String[] orderDetails = new String[4];
                orderDetails[0] = orderObject.getOrderID();
                orderDetails[1] = orderObject.getOrderDate().toString();
                orderDetails[2] = new DecimalFormat("##.##").format(orderObject.getGrandTotal());
                orderDetails[3] = orderObject.getOrderStatus().toString();
                orderTable.addRow(orderDetails);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "User has not ordered anything.");
        }
    }
    
    public void refreshProductTable() // This method will be used to refresh product table
    {
        ArrayList<Product> productList = adminUser.getProductList();
        if(!productList.isEmpty())
        {
            DefaultTableModel productTable = (DefaultTableModel)tblProduct.getModel();
            productTable.setRowCount(0);
            for(Product prod : productList)
            {
                String[] productDetails = new String[3];
                productDetails[0] = prod.getProductID();
                productDetails[1] = prod.getName();
                productDetails[2] = Integer.toString(prod.getStock());
                productTable.addRow(productDetails);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR: Product Database is detached or empty.");
        }  
    }
    
    public void refreshOrderingTable() // Loads Product Types into the Product Type Table
    {
        ArrayList<Product> productList = systemUser.getProductList();
        if(!productList.isEmpty())
        {          
            ArrayList<String> productTypeArray = new ArrayList<String>();
            for(Product productObject:productList)
            {
                if( !(productTypeArray.contains(productObject.getProductType())||
                        productObject.getProductStat() == productStatus.DISCONTINUED)) // Product is SALES and is not in the list
                {
                    productTypeArray.add(productObject.getProductType());
                }
            }
            
            if(!productTypeArray.isEmpty())
            {
                DefaultTableModel productTypeTable = (DefaultTableModel)tblProductType.getModel();
                productTypeTable.setRowCount(0);
                int count = 1;
                for(String productType:productTypeArray)
                {
                    String[] productDetails = new String[2];
                    productDetails[0] = Integer.toString(count);
                    productDetails[1] = productType;
                    productTypeTable.addRow(productDetails);
                    count = count + 1;
                }
                DefaultTableModel productItemTable = (DefaultTableModel)tblProductItem.getModel();
                productItemTable.setRowCount(0);
                
                lblProductName.setText("");
                lblProductPrice.setText("");
                lblProductQuantity.setText("");
                lblProductDescription.setText("");
                if(!btnCheckout.isEnabled()) // Re-enable cart buttons if its disabled for user's next order
                {
                    DefaultTableModel cartTable = (DefaultTableModel)tblCart.getModel();
                    cartTable.setRowCount(0);
                    lblGrandTotal.setText("0");
                    btnCheckout.setEnabled(true);
                    btnCartAdd.setEnabled(true);
                    btnCartRemove.setEnabled(true);
                    btnCartQtyAdd.setEnabled(true);
                    btnCartQtyDec.setEnabled(true); 
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ERROR: Failed to load product type list.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR: Customer Database is detached or empty.");
        }
    }
    
    public FrameLogin() {
        initComponents();
        systemUser.updateOrderStatus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgFragility = new javax.swing.ButtonGroup();
        rbgAddUser = new javax.swing.ButtonGroup();
        rbProductStatus = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        PanelLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnLoginRegister = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtLoginUsername = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        txtLoginPassword = new javax.swing.JPasswordField();
        PanelRegister = new javax.swing.JPanel();
        btnRegBack = new javax.swing.JButton();
        btnRegRegister = new javax.swing.JButton();
        lblAge = new javax.swing.JLabel();
        lblUsername1 = new javax.swing.JLabel();
        txtRegAge = new javax.swing.JTextField();
        txtRegUsername = new javax.swing.JTextField();
        lblRegister = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblContact = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtRegEmail = new javax.swing.JTextField();
        txtRegContact = new javax.swing.JTextField();
        txtRegName = new javax.swing.JTextField();
        lblPassword1 = new javax.swing.JLabel();
        txtRegPassword = new javax.swing.JTextField();
        pnlCustomerAdd = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnCusAddClear = new javax.swing.JButton();
        txtUserAddName = new javax.swing.JTextField();
        txtUserAddContact = new javax.swing.JTextField();
        txtUserAddEmail = new javax.swing.JTextField();
        txtUserAddAge = new javax.swing.JTextField();
        lblCustomerName = new javax.swing.JLabel();
        lblCustomerContact = new javax.swing.JLabel();
        lblCustomerEmail = new javax.swing.JLabel();
        lblCustomerAge = new javax.swing.JLabel();
        btnUserAddNew = new javax.swing.JButton();
        lblUsername2 = new javax.swing.JLabel();
        lblPassword2 = new javax.swing.JLabel();
        txtUserAddUsername = new javax.swing.JTextField();
        txtUserAddPassword = new javax.swing.JTextField();
        lblInstruction = new javax.swing.JLabel();
        rbAdmin = new javax.swing.JRadioButton();
        rbCustomer = new javax.swing.JRadioButton();
        lblTitleNewCustomer = new javax.swing.JLabel();
        pnlCustomerEdit = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnCusEditCancel = new javax.swing.JButton();
        txtCusEditName = new javax.swing.JTextField();
        txtCusEditContact = new javax.swing.JTextField();
        txtCusEditEmail = new javax.swing.JTextField();
        txtCusEditAge = new javax.swing.JTextField();
        lblCustomerName1 = new javax.swing.JLabel();
        lblCustomerContact1 = new javax.swing.JLabel();
        lblCustomerEmail1 = new javax.swing.JLabel();
        lblCustomerAge1 = new javax.swing.JLabel();
        btnCusEditSave = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblCustomerID = new javax.swing.JLabel();
        lblCustomerName2 = new javax.swing.JLabel();
        lblCustomerEmail2 = new javax.swing.JLabel();
        lblCustomerContact2 = new javax.swing.JLabel();
        lblCustomerAge2 = new javax.swing.JLabel();
        lblCusEditID = new javax.swing.JLabel();
        lblCusEditName = new javax.swing.JLabel();
        lblCusEditContact = new javax.swing.JLabel();
        lblCusEditEmail = new javax.swing.JLabel();
        lblCusEditAge = new javax.swing.JLabel();
        lblTitleEditCustomer = new javax.swing.JLabel();
        pnlCustomerView = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        txtCusSearch = new javax.swing.JTextField();
        btnCusSearch = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblCustomerID1 = new javax.swing.JLabel();
        lblCustomerName3 = new javax.swing.JLabel();
        lblCustomerEmail3 = new javax.swing.JLabel();
        lblCustomerContact3 = new javax.swing.JLabel();
        lblCustomerAge3 = new javax.swing.JLabel();
        lblCusViewID = new javax.swing.JLabel();
        lblCusViewName = new javax.swing.JLabel();
        lblCusViewContact = new javax.swing.JLabel();
        lblCusViewEmail = new javax.swing.JLabel();
        lblCusViewAge = new javax.swing.JLabel();
        btnCusViewEdit = new javax.swing.JButton();
        btnCusViewDelete = new javax.swing.JButton();
        busCusViewDetails = new javax.swing.JButton();
        btnCusViewAdd = new javax.swing.JButton();
        btnCusViewBack = new javax.swing.JButton();
        btnSearchRefresh = new javax.swing.JButton();
        lblTitleViewCustomer = new javax.swing.JLabel();
        pnlOrderAdd = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblProductQuantity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblProductPrice = new javax.swing.JLabel();
        lblProductDescription = new javax.swing.JLabel();
        lblQuantityToCart = new javax.swing.JLabel();
        btnAddQty = new javax.swing.JButton();
        btnNewOrdViewCart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblReduceQty = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        btnOrderAddBack = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblProductType = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblProductItem = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        pnlOrderCart = new javax.swing.JPanel();
        lblTitleCart = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnCartAdd = new javax.swing.JButton();
        btnCartRemove = new javax.swing.JButton();
        btnCartQtyAdd = new javax.swing.JButton();
        btnCartQtyDec = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        btnCheckout = new javax.swing.JButton();
        btnCartBack = new javax.swing.JButton();
        pnlOrderView = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        txtOrderSearch = new javax.swing.JTextField();
        btnViewOrderSearch = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        lblCustomerID2 = new javax.swing.JLabel();
        lblCustomerName4 = new javax.swing.JLabel();
        lblCustomerContact4 = new javax.swing.JLabel();
        lblCusIDOrdView = new javax.swing.JLabel();
        lblOrderViewID = new javax.swing.JLabel();
        lblOrdViewTotal = new javax.swing.JLabel();
        btnCancelOrder = new javax.swing.JButton();
        btnViewOrderItems = new javax.swing.JButton();
        btnCompleteOrder = new javax.swing.JButton();
        btnViewOrderNew = new javax.swing.JButton();
        btnViewOrderModify = new javax.swing.JButton();
        btnViewOrderBack = new javax.swing.JButton();
        lblTitleViewOrder = new javax.swing.JLabel();
        pnlOrderItem = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblOrderItem = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        lblOrdProdQuantity = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblProdID = new javax.swing.JLabel();
        lblOrdID5 = new javax.swing.JLabel();
        lblOrdID6 = new javax.swing.JLabel();
        lblOrdID7 = new javax.swing.JLabel();
        lblOrdProdName = new javax.swing.JLabel();
        lblOrdProdPrice = new javax.swing.JLabel();
        btnMinusQuantity = new javax.swing.JButton();
        btnAddQuantity = new javax.swing.JButton();
        lblOrdID8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblOrdID1 = new javax.swing.JLabel();
        lblOrdID = new javax.swing.JLabel();
        lblOrdDate = new javax.swing.JLabel();
        lblOrdID2 = new javax.swing.JLabel();
        lblOrdID9 = new javax.swing.JLabel();
        lblOrdID10 = new javax.swing.JLabel();
        lblGrandTotalOrd = new javax.swing.JLabel();
        lblOrdStatus = new javax.swing.JLabel();
        btnOrdItemBack = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        lblTitleOrderItems = new javax.swing.JLabel();
        pnlOrderViewItem = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblOrderItemView = new javax.swing.JTable();
        btnOrderViewItemBack = new javax.swing.JButton();
        lblTitleOrderItems1 = new javax.swing.JLabel();
        pnlProductAdd = new javax.swing.JPanel();
        lblTitleNewProduct = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNewProdName = new javax.swing.JTextField();
        cboNewProdType = new javax.swing.JComboBox<>();
        txtNewProdPrice = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNewProdQuantity = new javax.swing.JTextField();
        txtNewProdDescription = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnNewProdCancel = new javax.swing.JButton();
        btnNewProdAdd = new javax.swing.JButton();
        rbFragile = new javax.swing.JRadioButton();
        rbNonFragile = new javax.swing.JRadioButton();
        pnlProductEdit = new javax.swing.JPanel();
        lblTitleEditProduct = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblName2 = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblPrice2 = new javax.swing.JLabel();
        lblQuantity2 = new javax.swing.JLabel();
        cboEditProdType = new javax.swing.JComboBox<>();
        txtEditProdPrice = new javax.swing.JTextField();
        txtEditProdName = new javax.swing.JTextField();
        txtEditProdQuantity = new javax.swing.JTextField();
        txtEditProdDescription = new javax.swing.JTextField();
        rbDiscontinued = new javax.swing.JRadioButton();
        rbSale = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblEditProdID = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnEditProdSave = new javax.swing.JButton();
        btnEditProdBack = new javax.swing.JButton();
        pnlProductView = new javax.swing.JPanel();
        lblTitleProduct = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblProdName = new javax.swing.JLabel();
        lblProdType = new javax.swing.JLabel();
        lblProdQuantity = new javax.swing.JLabel();
        lblProdPrice = new javax.swing.JLabel();
        lblProdDesc = new javax.swing.JLabel();
        lblProductViewID = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblProdStatus = new javax.swing.JLabel();
        btnProdSearch = new javax.swing.JButton();
        txtProdSearch = new javax.swing.JTextField();
        btnProdAdd = new javax.swing.JButton();
        btnProdEdit = new javax.swing.JButton();
        btnProdEdit1 = new javax.swing.JButton();
        pnlAdminMenu = new javax.swing.JPanel();
        lblTitleAdminMenu = new javax.swing.JLabel();
        btnAdminLogout = new javax.swing.JButton();
        btnAdminManageOrder = new javax.swing.JButton();
        btnAdminCart = new javax.swing.JButton();
        btnManageProduct = new javax.swing.JButton();
        btnManageCustomer = new javax.swing.JButton();
        pnlCustomerMenu = new javax.swing.JPanel();
        lblTitleAdminMenu1 = new javax.swing.JLabel();
        btnCusCart = new javax.swing.JButton();
        btnCusPlaceOrder = new javax.swing.JButton();
        btnCusManageOrder = new javax.swing.JButton();
        btnCusLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        MainPanel.setLayout(new java.awt.CardLayout());

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLoginRegister.setText("Register");
        btnLoginRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginRegisterActionPerformed(evt);
            }
        });

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblUsername.setText("Username");

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword.setText("Pass");

        txtLoginUsername.setText("TP111111");

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblLogin.setText("Login");

        txtLoginPassword.setText("1111");
        txtLoginPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginPasswordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelLoginLayout = new javax.swing.GroupLayout(PanelLogin);
        PanelLogin.setLayout(PanelLoginLayout);
        PanelLoginLayout.setHorizontalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLoginLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoginRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                    .addGroup(PanelLoginLayout.createSequentialGroup()
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLoginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(txtLoginPassword))))
                .addContainerGap(279, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogin)
                .addGap(322, 322, 322))
        );
        PanelLoginLayout.setVerticalGroup(
            PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLoginLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lblLogin)
                .addGap(46, 46, 46)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addGap(18, 18, 18)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(PanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoginRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        MainPanel.add(PanelLogin, "login");

        btnRegBack.setText("Back");
        btnRegBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegBackActionPerformed(evt);
            }
        });

        btnRegRegister.setText("Register");
        btnRegRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegRegisterActionPerformed(evt);
            }
        });

        lblAge.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblAge.setText("Age :");

        lblUsername1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblUsername1.setText("Username :");

        lblRegister.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegister.setText("Register");

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEmail.setText("Email :");

        lblContact.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblContact.setText("Contact :");

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblName.setText("Name :");

        lblPassword1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword1.setText("Password :");

        javax.swing.GroupLayout PanelRegisterLayout = new javax.swing.GroupLayout(PanelRegister);
        PanelRegister.setLayout(PanelRegisterLayout);
        PanelRegisterLayout.setHorizontalGroup(
            PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegisterLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelRegisterLayout.createSequentialGroup()
                        .addComponent(btnRegBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelRegisterLayout.createSequentialGroup()
                        .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblUsername1))
                            .addComponent(lblPassword1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRegUsername)
                            .addComponent(txtRegEmail)
                            .addComponent(txtRegContact)
                            .addComponent(txtRegName)
                            .addComponent(txtRegPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRegAge, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(291, Short.MAX_VALUE))
            .addComponent(lblRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelRegisterLayout.setVerticalGroup(
            PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegisterLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblRegister)
                .addGap(18, 18, 18)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtRegName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContact)
                    .addComponent(txtRegContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtRegEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRegUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword1)
                    .addComponent(txtRegPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        MainPanel.add(PanelRegister, "registration");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCusAddClear.setText("Back");
        btnCusAddClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusAddClearActionPerformed(evt);
            }
        });

        lblCustomerName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCustomerName.setText("Name :");

        lblCustomerContact.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCustomerContact.setText("Contact :");

        lblCustomerEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCustomerEmail.setText("Email :");

        lblCustomerAge.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCustomerAge.setText("Age :");

        btnUserAddNew.setText("Add");
        btnUserAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAddNewActionPerformed(evt);
            }
        });

        lblUsername2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblUsername2.setText("Username :");

        lblPassword2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword2.setText("Password :");

        lblInstruction.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInstruction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstruction.setText("Enter User Details Below");

        rbgAddUser.add(rbAdmin);
        rbAdmin.setText("Admin");

        rbgAddUser.add(rbCustomer);
        rbCustomer.setText("Customer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUserAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCusAddClear, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rbAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rbCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblUsername2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCustomerContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCustomerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCustomerAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUserAddName, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(txtUserAddContact)
                                .addComponent(txtUserAddEmail)
                                .addComponent(txtUserAddAge, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUserAddUsername)
                                .addComponent(txtUserAddPassword)))))
                .addGap(222, 222, 222))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInstruction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(lblInstruction)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerName)
                    .addComponent(txtUserAddName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserAddContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerContact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerEmail)
                    .addComponent(txtUserAddEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserAddAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerAge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername2)
                    .addComponent(txtUserAddUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword2)
                    .addComponent(txtUserAddPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAdmin)
                    .addComponent(rbCustomer))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserAddNew)
                    .addComponent(btnCusAddClear))
                .addGap(46, 46, 46))
        );

        lblTitleNewCustomer.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleNewCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleNewCustomer.setText("New User");

        javax.swing.GroupLayout pnlCustomerAddLayout = new javax.swing.GroupLayout(pnlCustomerAdd);
        pnlCustomerAdd.setLayout(pnlCustomerAddLayout);
        pnlCustomerAddLayout.setHorizontalGroup(
            pnlCustomerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleNewCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(pnlCustomerAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCustomerAddLayout.setVerticalGroup(
            pnlCustomerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerAddLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleNewCustomer)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(pnlCustomerAdd, "customerAdd");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCusEditCancel.setText("Cancel");
        btnCusEditCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusEditCancelActionPerformed(evt);
            }
        });

        lblCustomerName1.setText("Name : ");

        lblCustomerContact1.setText("Contact :");

        lblCustomerEmail1.setText("Email : ");

        lblCustomerAge1.setText("Age :");

        btnCusEditSave.setText("Save");
        btnCusEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusEditSaveActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCustomerID.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerID.setText("Customer ID :");

        lblCustomerName2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerName2.setText("Name :");

        lblCustomerEmail2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerEmail2.setText("Email :");

        lblCustomerContact2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerContact2.setText("Contact :");

        lblCustomerAge2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerAge2.setText("Age :");

        lblCusEditID.setText("ID");

        lblCusEditName.setText("Name");

        lblCusEditContact.setText("Contact");

        lblCusEditEmail.setText("Email");

        lblCusEditAge.setText("Age");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCustomerAge2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCustomerID)
                        .addComponent(lblCustomerName2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCustomerContact2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCustomerEmail2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCusEditID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCusEditAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCusEditEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCusEditContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCusEditName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID)
                    .addComponent(lblCusEditID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerName2)
                    .addComponent(lblCusEditName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerContact2)
                    .addComponent(lblCusEditContact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerEmail2)
                    .addComponent(lblCusEditEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerAge2)
                    .addComponent(lblCusEditAge))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCusEditSave, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCusEditCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCustomerAge1)
                            .addComponent(lblCustomerEmail1)
                            .addComponent(lblCustomerContact1)
                            .addComponent(lblCustomerName1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCusEditAge, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCusEditName, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(txtCusEditContact)
                            .addComponent(txtCusEditEmail))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerName1)
                            .addComponent(txtCusEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerContact1)
                            .addComponent(txtCusEditContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerEmail1)
                            .addComponent(txtCusEditEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCustomerAge1)
                            .addComponent(txtCusEditAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCusEditSave)
                    .addComponent(btnCusEditCancel))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        lblTitleEditCustomer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitleEditCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleEditCustomer.setText("Edit Customer");

        javax.swing.GroupLayout pnlCustomerEditLayout = new javax.swing.GroupLayout(pnlCustomerEdit);
        pnlCustomerEdit.setLayout(pnlCustomerEditLayout);
        pnlCustomerEditLayout.setHorizontalGroup(
            pnlCustomerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleEditCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(pnlCustomerEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCustomerEditLayout.setVerticalGroup(
            pnlCustomerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerEditLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleEditCustomer)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.add(pnlCustomerEdit, "customerEdit");

        pnlCustomerView.setPreferredSize(new java.awt.Dimension(702, 395));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCustomerMouseReleased(evt);
            }
        });
        tblCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblCustomerKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblCustomer);
        if (tblCustomer.getColumnModel().getColumnCount() > 0) {
            tblCustomer.getColumnModel().getColumn(0).setResizable(false);
            tblCustomer.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblCustomer.getColumnModel().getColumn(1).setResizable(false);
        }

        txtCusSearch.setText("Search for Customer");

        btnCusSearch.setText("Search");
        btnCusSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusSearchActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCustomerID1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerID1.setText("Customer ID :");

        lblCustomerName3.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerName3.setText("Name :");

        lblCustomerEmail3.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerEmail3.setText("Email :");

        lblCustomerContact3.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerContact3.setText("Contact :");

        lblCustomerAge3.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        lblCustomerAge3.setText("Age :");

        lblCusViewID.setText("ID");

        lblCusViewName.setText("Name");

        lblCusViewContact.setText("Contact");

        lblCusViewEmail.setText("Email");

        lblCusViewAge.setText("Age");

        btnCusViewEdit.setText("Edit");
        btnCusViewEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusViewEditActionPerformed(evt);
            }
        });

        btnCusViewDelete.setText("Delete");
        btnCusViewDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusViewDeleteActionPerformed(evt);
            }
        });

        busCusViewDetails.setText("View");
        busCusViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busCusViewDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCustomerAge3)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCustomerID1)
                                .addComponent(lblCustomerName3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCustomerContact3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCustomerEmail3, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCusViewID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCusViewName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCusViewContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCusViewEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCusViewAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(busCusViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCusViewEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCusViewDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID1)
                    .addComponent(lblCusViewID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerName3)
                    .addComponent(lblCusViewName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerContact3)
                    .addComponent(lblCusViewContact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerEmail3)
                    .addComponent(lblCusViewEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerAge3)
                    .addComponent(lblCusViewAge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCusViewDelete)
                    .addComponent(btnCusViewEdit)
                    .addComponent(busCusViewDetails))
                .addContainerGap())
        );

        btnCusViewAdd.setText("Add New Customer");
        btnCusViewAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusViewAddActionPerformed(evt);
            }
        });

        btnCusViewBack.setText("Back");
        btnCusViewBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusViewBackActionPerformed(evt);
            }
        });

        btnSearchRefresh.setText("O");
        btnSearchRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSearchRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCusSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCusViewAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCusViewBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCusSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(btnSearchRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCusViewAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCusViewBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblTitleViewCustomer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitleViewCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleViewCustomer.setText("View Customer");

        javax.swing.GroupLayout pnlCustomerViewLayout = new javax.swing.GroupLayout(pnlCustomerView);
        pnlCustomerView.setLayout(pnlCustomerViewLayout);
        pnlCustomerViewLayout.setHorizontalGroup(
            pnlCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleViewCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCustomerViewLayout.setVerticalGroup(
            pnlCustomerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerViewLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(lblTitleViewCustomer)
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        MainPanel.add(pnlCustomerView, "customerView");

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblProductQuantity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Quantity :");

        lblProductPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblProductDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblProductDescription.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        lblProductDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblQuantityToCart.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblQuantityToCart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuantityToCart.setText("1");
        lblQuantityToCart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAddQty.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnAddQty.setText("+");
        btnAddQty.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddQty.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAddQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQtyActionPerformed(evt);
            }
        });

        btnNewOrdViewCart.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnNewOrdViewCart.setText("View Cart");
        btnNewOrdViewCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrdViewCartActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Item List");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Description");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product Type");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblReduceQty.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblReduceQty.setText("-");
        lblReduceQty.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblReduceQty.setMargin(new java.awt.Insets(0, 0, 0, 0));
        lblReduceQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblReduceQtyActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Item Details");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Price :");

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Name:");

        lblProductName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnOrderAddBack.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnOrderAddBack.setText("Back");
        btnOrderAddBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderAddBackActionPerformed(evt);
            }
        });

        tblProductType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductType.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProductType.getTableHeader().setReorderingAllowed(false);
        tblProductType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProductTypeMouseReleased(evt);
            }
        });
        tblProductType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProductTypeKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tblProductType);
        if (tblProductType.getColumnModel().getColumnCount() > 0) {
            tblProductType.getColumnModel().getColumn(0).setResizable(false);
            tblProductType.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblProductType.getColumnModel().getColumn(1).setResizable(false);
        }

        tblProductItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductItem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProductItem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProductItem.getTableHeader().setReorderingAllowed(false);
        tblProductItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProductItemMouseReleased(evt);
            }
        });
        tblProductItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProductItemKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tblProductItem);
        if (tblProductItem.getColumnModel().getColumnCount() > 0) {
            tblProductItem.getColumnModel().getColumn(0).setResizable(false);
            tblProductItem.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblProductItem.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewOrdViewCart, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lblProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(lblQuantityToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddQty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblReduceQty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblProductDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrderAddBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProductDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuantityToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReduceQty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewOrdViewCart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrderAddBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("New Order");

        javax.swing.GroupLayout pnlOrderAddLayout = new javax.swing.GroupLayout(pnlOrderAdd);
        pnlOrderAdd.setLayout(pnlOrderAddLayout);
        pnlOrderAddLayout.setHorizontalGroup(
            pnlOrderAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOrderAddLayout.setVerticalGroup(
            pnlOrderAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderAddLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(pnlOrderAdd, "orderAdd");

        lblTitleCart.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleCart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleCart.setText("Cart");

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "ID", "Item Name", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCart.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setResizable(false);
            tblCart.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblCart.getColumnModel().getColumn(1).setResizable(false);
            tblCart.getColumnModel().getColumn(1).setPreferredWidth(1);
            tblCart.getColumnModel().getColumn(2).setResizable(false);
            tblCart.getColumnModel().getColumn(3).setResizable(false);
            tblCart.getColumnModel().getColumn(3).setPreferredWidth(1);
            tblCart.getColumnModel().getColumn(4).setResizable(false);
            tblCart.getColumnModel().getColumn(4).setPreferredWidth(1);
        }

        btnCartAdd.setText("Add Item");
        btnCartAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartAddActionPerformed(evt);
            }
        });

        btnCartRemove.setText("Remove From Cart");
        btnCartRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartRemoveActionPerformed(evt);
            }
        });

        btnCartQtyAdd.setText("+");
        btnCartQtyAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCartQtyAdd.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCartQtyAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartQtyAddActionPerformed(evt);
            }
        });

        btnCartQtyDec.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCartQtyDec.setLabel("-");
        btnCartQtyDec.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCartQtyDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartQtyDecActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Quantity:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Grand Total: RM");

        lblGrandTotal.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblGrandTotal.setText("0");

        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnCartBack.setText("Back");
        btnCartBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrderCartLayout = new javax.swing.GroupLayout(pnlOrderCart);
        pnlOrderCart.setLayout(pnlOrderCartLayout);
        pnlOrderCartLayout.setHorizontalGroup(
            pnlOrderCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderCartLayout.createSequentialGroup()
                .addGroup(pnlOrderCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOrderCartLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlOrderCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCartAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCartRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderCartLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCartQtyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCartQtyDec, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCartBack, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTitleCart, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        pnlOrderCartLayout.setVerticalGroup(
            pnlOrderCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderCartLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleCart)
                .addGap(15, 15, 15)
                .addGroup(pnlOrderCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlOrderCartLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCartAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCartRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlOrderCartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCartQtyAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCartQtyDec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCartBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlOrderCartLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );

        MainPanel.add(pnlOrderCart, "orderCart");

        pnlOrderView.setPreferredSize(new java.awt.Dimension(673, 452));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Date Added", "Grand Total", "Order Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrder.getTableHeader().setReorderingAllowed(false);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblOrderMouseReleased(evt);
            }
        });
        tblOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblOrderKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
            tblOrder.getColumnModel().getColumn(2).setResizable(false);
            tblOrder.getColumnModel().getColumn(2).setPreferredWidth(1);
            tblOrder.getColumnModel().getColumn(3).setResizable(false);
        }

        txtOrderSearch.setText("Search for Order");

        btnViewOrderSearch.setText("Search");
        btnViewOrderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderSearchActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCustomerID2.setText("Customer ID :");

        lblCustomerName4.setText("Order ID :");

        lblCustomerContact4.setText("Total :");

        lblCusIDOrdView.setText("ID");

        lblOrderViewID.setText("ID");

        lblOrdViewTotal.setText("Price");

        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelOrder.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });

        btnViewOrderItems.setText("View Items");
        btnViewOrderItems.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewOrderItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderItemsActionPerformed(evt);
            }
        });

        btnCompleteOrder.setText("Complete Order");
        btnCompleteOrder.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCompleteOrder.setPreferredSize(new java.awt.Dimension(186, 30));
        btnCompleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCustomerID2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustomerName4)
                            .addComponent(lblCustomerContact4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblOrderViewID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOrdViewTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCusIDOrdView, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCompleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnViewOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID2)
                    .addComponent(lblCusIDOrdView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerName4)
                    .addComponent(lblOrderViewID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerContact4)
                    .addComponent(lblOrdViewTotal))
                .addGap(18, 18, 18)
                .addComponent(btnViewOrderItems, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnViewOrderNew.setText("Place New Order");
        btnViewOrderNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderNewActionPerformed(evt);
            }
        });

        btnViewOrderModify.setText("Modify Order");
        btnViewOrderModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderModifyActionPerformed(evt);
            }
        });

        btnViewOrderBack.setText("Back");
        btnViewOrderBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnViewOrderModify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewOrderNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewOrderSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOrderSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewOrderBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewOrderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewOrderNew, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewOrderModify, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewOrderBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblTitleViewOrder.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitleViewOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleViewOrder.setText("View Order");

        javax.swing.GroupLayout pnlOrderViewLayout = new javax.swing.GroupLayout(pnlOrderView);
        pnlOrderView.setLayout(pnlOrderViewLayout);
        pnlOrderViewLayout.setHorizontalGroup(
            pnlOrderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleViewOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOrderViewLayout.setVerticalGroup(
            pnlOrderViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleViewOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        MainPanel.add(pnlOrderView, "orderView");

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblOrderItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Quantity", "Price(Each)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrderItem.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrderItem.getTableHeader().setReorderingAllowed(false);
        tblOrderItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblOrderItemMouseReleased(evt);
            }
        });
        tblOrderItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblOrderItemKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tblOrderItem);
        if (tblOrderItem.getColumnModel().getColumnCount() > 0) {
            tblOrderItem.getColumnModel().getColumn(0).setResizable(false);
            tblOrderItem.getColumnModel().getColumn(1).setResizable(false);
            tblOrderItem.getColumnModel().getColumn(2).setResizable(false);
            tblOrderItem.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblOrdProdQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrdProdQuantity.setText("1");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblProdID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblOrdID5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID5.setText("Product ID:");

        lblOrdID6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID6.setText("Item Name:");

        lblOrdID7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID7.setText("Price:");

        lblOrdProdName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblOrdProdPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnMinusQuantity.setText("-");
        btnMinusQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusQuantityActionPerformed(evt);
            }
        });

        btnAddQuantity.setText("+");
        btnAddQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuantityActionPerformed(evt);
            }
        });

        lblOrdID8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID8.setText("Quantity:");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblOrdID1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID1.setText("Order ID:");

        lblOrdID2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID2.setText("Order Date:");

        lblOrdID9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID9.setText("Grand Total:");

        lblOrdID10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOrdID10.setText("Status:");

        lblGrandTotalOrd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblOrdStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblOrdID9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOrdID2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGrandTotalOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblOrdID10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrdStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblOrdID1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrdID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrdID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrdID1))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrdID2)
                    .addComponent(lblOrdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrdID9)
                    .addComponent(lblGrandTotalOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrdID10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrdStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOrdID5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrdID6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrdID7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrdID8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblOrdProdQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMinusQuantity))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lblProdID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblOrdProdName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblOrdProdPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrdID5)
                    .addComponent(lblProdID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrdID6)
                    .addComponent(lblOrdProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrdID7)
                    .addComponent(lblOrdProdPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrdID8)
                    .addComponent(lblOrdProdQuantity)
                    .addComponent(btnMinusQuantity)
                    .addComponent(btnAddQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addContainerGap())
        );

        btnOrdItemBack.setText("Back");
        btnOrdItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdItemBackActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Item");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrdItemBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrdItemBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblTitleOrderItems.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleOrderItems.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleOrderItems.setText("Order Items");

        javax.swing.GroupLayout pnlOrderItemLayout = new javax.swing.GroupLayout(pnlOrderItem);
        pnlOrderItem.setLayout(pnlOrderItemLayout);
        pnlOrderItemLayout.setHorizontalGroup(
            pnlOrderItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleOrderItems, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(pnlOrderItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOrderItemLayout.setVerticalGroup(
            pnlOrderItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrderItemLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleOrderItems)
                .addGap(5, 5, 5)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(pnlOrderItem, "orderItem");

        tblOrderItemView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Quantity", "Price(Each)", "Price(Total)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrderItemView.setRowSelectionAllowed(false);
        tblOrderItemView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOrderItemView.getTableHeader().setReorderingAllowed(false);
        tblOrderItemView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblOrderItemViewMouseReleased(evt);
            }
        });
        jScrollPane9.setViewportView(tblOrderItemView);
        if (tblOrderItemView.getColumnModel().getColumnCount() > 0) {
            tblOrderItemView.getColumnModel().getColumn(0).setResizable(false);
            tblOrderItemView.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblOrderItemView.getColumnModel().getColumn(1).setResizable(false);
            tblOrderItemView.getColumnModel().getColumn(2).setResizable(false);
            tblOrderItemView.getColumnModel().getColumn(2).setPreferredWidth(1);
            tblOrderItemView.getColumnModel().getColumn(3).setResizable(false);
            tblOrderItemView.getColumnModel().getColumn(3).setPreferredWidth(2);
            tblOrderItemView.getColumnModel().getColumn(4).setResizable(false);
            tblOrderItemView.getColumnModel().getColumn(4).setPreferredWidth(2);
        }

        btnOrderViewItemBack.setText("Back");
        btnOrderViewItemBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderViewItemBackActionPerformed(evt);
            }
        });

        lblTitleOrderItems1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleOrderItems1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleOrderItems1.setText("Order Items");

        javax.swing.GroupLayout pnlOrderViewItemLayout = new javax.swing.GroupLayout(pnlOrderViewItem);
        pnlOrderViewItem.setLayout(pnlOrderViewItemLayout);
        pnlOrderViewItemLayout.setHorizontalGroup(
            pnlOrderViewItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderViewItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrderViewItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrderViewItemBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addComponent(lblTitleOrderItems1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOrderViewItemLayout.setVerticalGroup(
            pnlOrderViewItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderViewItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitleOrderItems1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrderViewItemBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.add(pnlOrderViewItem, "orderViewItem");

        pnlProductAdd.setPreferredSize(new java.awt.Dimension(710, 422));

        lblTitleNewProduct.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleNewProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleNewProduct.setText("New Product");

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Name :");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Type :");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Price :");

        cboNewProdType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hammers", "Screws", "Bulbs", "Glass" }));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Quantity :");

        txtNewProdDescription.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Description");

        btnNewProdCancel.setText("Cancel");
        btnNewProdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProdCancelActionPerformed(evt);
            }
        });

        btnNewProdAdd.setText("Add");
        btnNewProdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProdAddActionPerformed(evt);
            }
        });

        rbgFragility.add(rbFragile);
        rbFragile.setText("Fragile");

        rbgFragility.add(rbNonFragile);
        rbNonFragile.setSelected(true);
        rbNonFragile.setText("Non-Fragile");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addComponent(btnNewProdAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewProdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNewProdDescription)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNewProdName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(cboNewProdType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNewProdPrice)
                                    .addComponent(txtNewProdQuantity)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(rbFragile)
                        .addGap(47, 47, 47)
                        .addComponent(rbNonFragile)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNewProdType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNewProdPrice)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewProdQuantity))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbFragile)
                    .addComponent(rbNonFragile))
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewProdDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewProdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewProdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout pnlProductAddLayout = new javax.swing.GroupLayout(pnlProductAdd);
        pnlProductAdd.setLayout(pnlProductAddLayout);
        pnlProductAddLayout.setHorizontalGroup(
            pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(pnlProductAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlProductAddLayout.setVerticalGroup(
            pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductAddLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleNewProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(pnlProductAdd, "productAdd");

        lblTitleEditProduct.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleEditProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleEditProduct.setText("Edit Product");

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName2.setText("Name :");

        lblType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblType.setText("Type :");

        lblPrice2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrice2.setText("Price :");

        lblQuantity2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuantity2.setText("Quantity :");

        cboEditProdType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hammers", "Screws", "Bulbs", "Glass" }));

        txtEditProdDescription.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        rbProductStatus.add(rbDiscontinued);
        rbDiscontinued.setText("Discontinued");

        rbProductStatus.add(rbSale);
        rbSale.setText("Up for Sale");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Description");

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblID.setText("Product ID:");

        lblEditProdID.setText("ID");

        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblStatus.setText("Status :");

        btnEditProdSave.setText("Save");
        btnEditProdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProdSaveActionPerformed(evt);
            }
        });

        btnEditProdBack.setText("Back");
        btnEditProdBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProdBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblQuantity2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbSale)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEditProdName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(cboEditProdType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEditProdPrice)
                                .addComponent(txtEditProdQuantity)
                                .addComponent(lblEditProdID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(rbDiscontinued)))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEditProdDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnEditProdSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditProdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(212, 212, 212))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblEditProdID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEditProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEditProdType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEditProdPrice)
                    .addComponent(lblPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditProdQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSale)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbDiscontinued)
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEditProdDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditProdSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditProdBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlProductEditLayout = new javax.swing.GroupLayout(pnlProductEdit);
        pnlProductEdit.setLayout(pnlProductEditLayout);
        pnlProductEditLayout.setHorizontalGroup(
            pnlProductEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlProductEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlProductEditLayout.setVerticalGroup(
            pnlProductEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductEditLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleEditProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(pnlProductEdit, "productEdit");

        lblTitleProduct.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleProduct.setText("Product");

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduct.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProductMouseReleased(evt);
            }
        });
        tblProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProductKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setResizable(false);
            tblProduct.getColumnModel().getColumn(1).setResizable(false);
            tblProduct.getColumnModel().getColumn(2).setResizable(false);
            tblProduct.getColumnModel().getColumn(2).setPreferredWidth(0);
        }

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Name :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Type :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Quantity :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Price :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Description");

        lblProdName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblProdType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblProdQuantity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblProdPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblProdDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProdDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblProductViewID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("ID :");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Price :");

        lblProdStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addComponent(lblProdDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProdType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProdName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProdQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProdPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProductViewID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProdStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductViewID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProdType, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProdQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProdPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProdStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProdDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnProdSearch.setText("Search");
        btnProdSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdSearchActionPerformed(evt);
            }
        });

        txtProdSearch.setText("Search for Product");

        btnProdAdd.setText("Add Products");
        btnProdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdAddActionPerformed(evt);
            }
        });

        btnProdEdit.setText("Edit Product");
        btnProdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdEditActionPerformed(evt);
            }
        });

        btnProdEdit1.setText("Back");
        btnProdEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdEdit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnProdAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProdSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProdSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProdEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnProdEdit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProdSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProdSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProdAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProdEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout pnlProductViewLayout = new javax.swing.GroupLayout(pnlProductView);
        pnlProductView.setLayout(pnlProductViewLayout);
        pnlProductViewLayout.setHorizontalGroup(
            pnlProductViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlProductViewLayout.setVerticalGroup(
            pnlProductViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductViewLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblTitleProduct)
                .addGap(5, 5, 5)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(pnlProductView, "productView");

        lblTitleAdminMenu.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleAdminMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleAdminMenu.setText("Admin Menu");

        btnAdminLogout.setText("Logout");
        btnAdminLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLogoutActionPerformed(evt);
            }
        });

        btnAdminManageOrder.setText("Manage Order");
        btnAdminManageOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminManageOrderActionPerformed(evt);
            }
        });

        btnAdminCart.setText("View Cart");
        btnAdminCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminCartActionPerformed(evt);
            }
        });

        btnManageProduct.setText("Manage Product");
        btnManageProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProductActionPerformed(evt);
            }
        });

        btnManageCustomer.setText("Manage Customer");
        btnManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAdminMenuLayout = new javax.swing.GroupLayout(pnlAdminMenu);
        pnlAdminMenu.setLayout(pnlAdminMenuLayout);
        pnlAdminMenuLayout.setHorizontalGroup(
            pnlAdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleAdminMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAdminMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlAdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminMenuLayout.createSequentialGroup()
                        .addComponent(btnManageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdminManageOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdminLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAdminMenuLayout.createSequentialGroup()
                        .addComponent(btnAdminCart, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnManageCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
        pnlAdminMenuLayout.setVerticalGroup(
            pnlAdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitleAdminMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnManageCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(btnAdminCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnManageProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(btnAdminLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdminManageOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        MainPanel.add(pnlAdminMenu, "adminMenu");

        lblTitleAdminMenu1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTitleAdminMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleAdminMenu1.setText("Customer Menu");

        btnCusCart.setText("View Cart");
        btnCusCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusCartActionPerformed(evt);
            }
        });

        btnCusPlaceOrder.setText("Place Order");
        btnCusPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusPlaceOrderActionPerformed(evt);
            }
        });

        btnCusManageOrder.setText("Manage Order");
        btnCusManageOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusManageOrderActionPerformed(evt);
            }
        });

        btnCusLogout.setText("Logout");
        btnCusLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCustomerMenuLayout = new javax.swing.GroupLayout(pnlCustomerMenu);
        pnlCustomerMenu.setLayout(pnlCustomerMenuLayout);
        pnlCustomerMenuLayout.setHorizontalGroup(
            pnlCustomerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitleAdminMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCustomerMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlCustomerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomerMenuLayout.createSequentialGroup()
                        .addComponent(btnCusManageOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCusLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCustomerMenuLayout.createSequentialGroup()
                        .addComponent(btnCusCart, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCusPlaceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pnlCustomerMenuLayout.setVerticalGroup(
            pnlCustomerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerMenuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitleAdminMenu1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCusCart, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(btnCusPlaceOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlCustomerMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCusManageOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(btnCusLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        MainPanel.add(pnlCustomerMenu, "customerMenu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginRegisterActionPerformed
        txtRegName.setText("");
        txtRegUsername.setText("");
        txtRegPassword.setText("");
        txtRegAge.setText("");
        txtRegContact.setText("");
        txtRegEmail.setText("");
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "registration");
    }//GEN-LAST:event_btnLoginRegisterActionPerformed

    private void btnRegBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegBackActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "login");
    }//GEN-LAST:event_btnRegBackActionPerformed

    private void btnOrderAddBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderAddBackActionPerformed
        // TODO add your handling code here:
        if(addOrderSource == 1)
        {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "customerMenu"); 
        }
        else if (addOrderSource == 2)
        {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "orderView");
        }
        else if (addOrderSource == 3)
        {
            cartSource = 1;
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "orderCart");
        }

    }//GEN-LAST:event_btnOrderAddBackActionPerformed

    private void btnAdminCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminCartActionPerformed
        // TODO add your handling code here:
        cartSource = 1;
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderCart");
    }//GEN-LAST:event_btnAdminCartActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String[] userDetail = systemUser.login(txtLoginUsername.getText().trim(), txtLoginPassword.getText().trim());
        if(userDetail.length > 0)
        {
            JOptionPane.showMessageDialog(null, "Login Successful.");
            if(PersonType.valueOf(userDetail[2]) == PersonType.ADMIN) // Admin User
            {
                adminUser = new Admin(userDetail[0], userDetail[1]);
                CardLayout card = (CardLayout)MainPanel.getLayout();
                card.show(MainPanel, "adminMenu");
                userType = PersonType.ADMIN;   
            }
            else if(PersonType.valueOf(userDetail[2]) == PersonType.CUSTOMER) // Customer User
            {
                customerUser = new Customer(userDetail[0], userDetail[1]);
                CardLayout card = (CardLayout)MainPanel.getLayout();
                card.show(MainPanel, "customerMenu");
                userType = PersonType.CUSTOMER;
            }
            txtLoginUsername.setText("");
            txtLoginPassword.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Incorrect Login Credentials.");
            txtLoginUsername.setText("");
            txtLoginPassword.setText("");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "customerView");

        // Reload Customer List
        refreshCustomerTable();
    }//GEN-LAST:event_btnManageCustomerActionPerformed

    private void btnManageProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProductActionPerformed
        // Brings up view product panel
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "productView");
        
        // Adds data into table
        refreshProductTable();
    }//GEN-LAST:event_btnManageProductActionPerformed

    private void btnAdminManageOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminManageOrderActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderView");
        refreshOrderTable();        
    }//GEN-LAST:event_btnAdminManageOrderActionPerformed

    private void btnAdminLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLogoutActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Confirm Logout?",
                "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION)
        {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "login");
            // Discard user's details and credentials
            userType = null;
            adminUser = null;
        }   
    }//GEN-LAST:event_btnAdminLogoutActionPerformed

    private void btnProdEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdEdit1ActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "adminMenu");
    }//GEN-LAST:event_btnProdEdit1ActionPerformed

    private void btnEditProdBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProdBackActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "productView");
        
        refreshProductTable();
    }//GEN-LAST:event_btnEditProdBackActionPerformed

    private void btnProdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdAddActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "productAdd");
    }//GEN-LAST:event_btnProdAddActionPerformed

    private void btnProdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdEditActionPerformed
        // TODO add your handling code here:
        if(tblProduct.getSelectedRow() >= 0)
        {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "productEdit");

            ArrayList<Product> prod2EditList = adminUser.search(lblProductViewID.getText(), null);
            Product prod2Edit = prod2EditList.get(0);

            //Set old information in text fields
            lblEditProdID.setText(prod2Edit.getProductID());
            txtEditProdName.setText(prod2Edit.getName());
            txtEditProdPrice.setText(Double.toString(prod2Edit.getProductPrice()));
            txtEditProdQuantity.setText(Integer.toString(prod2Edit.getStock()));
            txtEditProdDescription.setText(prod2Edit.getDescription());
            cboEditProdType.setName(prod2Edit.getProductType());
            if (prod2Edit.getProductStat() == productStatus.SALE)
            {
                rbSale.setSelected(true);
            }
            else
            {
                rbDiscontinued.setSelected(true);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select Row from Table");
        }
    }//GEN-LAST:event_btnProdEditActionPerformed

    private void btnNewProdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProdCancelActionPerformed
        // TODO add your handling code here: 
        txtNewProdPrice.setText("");
        txtNewProdName.setText("");
        txtNewProdDescription.setText("");
        txtNewProdQuantity.setText("");
        cboNewProdType.setSelectedItem("Hammers");
        
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "productView");
        refreshProductTable();
    }//GEN-LAST:event_btnNewProdCancelActionPerformed

    private void btnOrdItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdItemBackActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderView");
    }//GEN-LAST:event_btnOrdItemBackActionPerformed

    private void btnViewOrderNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderNewActionPerformed
        // TODO add your handling code here:
        refreshOrderingTable();
        addOrderSource = 2;
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderAdd");
    }//GEN-LAST:event_btnViewOrderNewActionPerformed

    private void btnViewOrderModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderModifyActionPerformed
        // TODO add your handling code here:
        if(tblOrder.getRowCount() != 0)
        {
            if(tblOrder.getSelectedRow() >= 0)
            {
                String orderID = tblOrder.getValueAt(tblOrder.getSelectedRow(), 0).toString();
                Order orderObject = systemUser.search(orderID);
                if(!(LocalDate.now().compareTo(orderObject.getOrderDate())> 2))
                {
                    lblOrdID.setText(orderObject.getOrderID());
                    lblOrdDate.setText(orderObject.getOrderDate().toString());
                    lblGrandTotalOrd.setText(Double.toString(orderObject.getGrandTotal()));
                    lblOrdStatus.setText(orderObject.getOrderStatus().toString());
                    String[] idList = orderObject.getItemList().split("\\.");
                    String[] quantityList = orderObject.getQuantityList().split("\\.");
                    DefaultTableModel orderItemTable = (DefaultTableModel)tblOrderItem.getModel();
                    orderItemTable.setRowCount(0);
                    for(int index = 0; index < idList.length; index++)
                    {
                        Product productObject = systemUser.view(idList[index], null);
                        String[] productDetail = new String[4];
                        productDetail[0] = productObject.getProductID();
                        productDetail[1] = productObject.getName();
                        productDetail[2] = quantityList[index];
                        productDetail[3] = Double.toString(productObject.getProductPrice());
                        orderItemTable.addRow(productDetail);
                    }
                    CardLayout card = (CardLayout)MainPanel.getLayout();
                    card.show(MainPanel, "orderItem");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You cant modify orders that are older than 2 days.");
                }
 
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a row.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Customer has not place an order.");
        }
    }//GEN-LAST:event_btnViewOrderModifyActionPerformed

    private void btnNewOrdViewCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrdViewCartActionPerformed
        // TODO add your handling code here:
        cartSource = 2;
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderCart");
    }//GEN-LAST:event_btnNewOrdViewCartActionPerformed

    private void btnCusViewBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusViewBackActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "adminMenu");
    }//GEN-LAST:event_btnCusViewBackActionPerformed

    private void btnCusViewAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusViewAddActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "customerAdd");
    }//GEN-LAST:event_btnCusViewAddActionPerformed

    private void btnCusViewEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusViewEditActionPerformed
        // TODO add your handling code here:
        
        if(tblCustomer.getSelectedRow() >= 0)
        {
            String edittedID = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString();
            edittedID = edittedID.toLowerCase().trim();
            // Get Customer
            Customer edittedCustomer = adminUser.view(edittedID);
            if(edittedCustomer != null)
            {
                lblCusEditID.setText(edittedCustomer.getPersonID());
                lblCusEditName.setText(edittedCustomer.getName());
                lblCusEditContact.setText(edittedCustomer.getContact());
                lblCusEditEmail.setText(edittedCustomer.getEmail());
                lblCusEditAge.setText(Integer.toString(edittedCustomer.getAge()));
                CardLayout card = (CardLayout)MainPanel.getLayout();
                card.show(MainPanel, "customerEdit");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Customer not found.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row in the Customer Table.");
        }
    }//GEN-LAST:event_btnCusViewEditActionPerformed

    private void btnCusEditCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusEditCancelActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "customerView");
    }//GEN-LAST:event_btnCusEditCancelActionPerformed

    private void btnCusAddClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusAddClearActionPerformed
        // TODO add your handling code here:
        txtUserAddName.setText("");
        txtUserAddContact.setText("");
        txtUserAddEmail.setText("");
        txtUserAddAge.setText("");
        txtUserAddUsername.setText("");
        txtUserAddPassword.setText("");
        rbgAddUser.clearSelection();
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "customerView");
    }//GEN-LAST:event_btnCusAddClearActionPerformed

    private void btnCartBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartBackActionPerformed
        // TODO add your handling code here:
        if (cartSource == 1)
        {
            if(userType == PersonType.ADMIN)
            {
                CardLayout card = (CardLayout)MainPanel.getLayout();
                card.show(MainPanel, "adminMenu");
            }
            else if (userType == PersonType.CUSTOMER)
            {
                CardLayout card = (CardLayout)MainPanel.getLayout();
                card.show(MainPanel, "customerMenu");
            }
        }
        else
        {
            refreshOrderingTable();
            addOrderSource = 2;
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "orderAdd");
        }
    }//GEN-LAST:event_btnCartBackActionPerformed

    private void btnCusCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusCartActionPerformed
        // TODO add your handling code here:
        cartSource = 1;
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderCart");
    }//GEN-LAST:event_btnCusCartActionPerformed

    private void btnViewOrderBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderBackActionPerformed
        // TODO add your handling code here:
        if(userType == PersonType.ADMIN) //User is admin
        {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "adminMenu");
        }
        else if (userType == PersonType.CUSTOMER)//User is Customer
        {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "customerMenu");
        }
    }//GEN-LAST:event_btnViewOrderBackActionPerformed

    private void btnCusPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusPlaceOrderActionPerformed
        // TODO add your handling code here:
        refreshOrderingTable();
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderAdd");
        addOrderSource = 1;
    }//GEN-LAST:event_btnCusPlaceOrderActionPerformed

    private void btnCusManageOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusManageOrderActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderView");
        refreshOrderTable();  
    }//GEN-LAST:event_btnCusManageOrderActionPerformed

    private void btnCusLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusLogoutActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Confirm Logout?",
                "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION)
        {
            CardLayout card = (CardLayout)MainPanel.getLayout();
            card.show(MainPanel, "login");
            // Discard user's details and credentials
            userType = null;
            customerUser = null;
        }   
    }//GEN-LAST:event_btnCusLogoutActionPerformed

    private void btnNewProdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProdAddActionPerformed
        //If textfield is blank, stop
        if(txtNewProdPrice.getText().isBlank() || txtNewProdName.getText().isBlank() || 
                txtNewProdDescription.getText().isBlank() || txtNewProdQuantity.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Please Enter All Information");
        }
        else if(txtNewProdPrice.getText().contains(",") || txtNewProdName.getText().contains(",") ||
                txtNewProdDescription.getText().contains(",") || txtNewProdQuantity.getText().contains(","))
        {
            JOptionPane.showMessageDialog(null, "Inputs cannot contain commas (,).");
        }
        else
        {
            //Construct file operator
            Admin admin = new Admin();
            
            try{
                //Prepare variables
                double price = Double.parseDouble(txtNewProdPrice.getText());
                String type = cboNewProdType.getSelectedItem().toString();
                productStatus sale = productStatus.SALE;
                String name = txtNewProdName.getText();
                String desc = txtNewProdDescription.getText();
                boolean frag = rbFragile.isSelected();
                int stock = Integer.parseInt(txtNewProdQuantity.getText());
                
                //Call file operator method
                admin.add(price, type, sale, name, desc, frag, stock);
                JOptionPane.showMessageDialog(null, "Item Successfully Added");
                
                txtNewProdPrice.setText("");
                txtNewProdName.setText("");
                txtNewProdDescription.setText("");
                txtNewProdQuantity.setText("");
                cboNewProdType.setSelectedItem("Hammers");
            } 
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Please Enter Numbers for Price and Quantity.");
            }
        }
        
        
    }//GEN-LAST:event_btnNewProdAddActionPerformed

    private void btnRegRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegRegisterActionPerformed
        // TODO add your handling code here:
        if(txtRegName.getText().isBlank() || txtRegContact.getText().isBlank() || 
           txtRegEmail.getText().isBlank() || txtRegAge.getText().isBlank() || 
           txtRegUsername.getText().isBlank() || txtRegPassword.getText().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
        }
        else if(txtRegName.getText().contains(",") || txtRegContact.getText().contains(",") ||
                txtRegEmail.getText().contains(",") || txtRegAge.getText().contains(",") ||
                txtRegUsername.getText().contains(",") || txtRegPassword.getText().contains(","))
        {
            JOptionPane.showMessageDialog(null, "Inputs cannot contain commas (,).");
        }
        else
        {
            try
            {
                String name = txtRegName.getText().trim();
                String username = txtRegUsername.getText().trim();
                String password = txtRegPassword.getText().trim();
                int age = Integer.parseInt(txtRegAge.getText().trim());
                String contact = txtRegContact.getText().trim();
                String email = txtRegEmail.getText().trim();
                Customer customerObject = new Customer(name, username, password, age, contact, email);
                System.out.println("asd");
                Boolean state = systemUser.add(customerObject);
                if(state) // True = writes to file
                {
                    JOptionPane.showMessageDialog(null, "Successfully registered.");
                    btnRegBack.doClick();
                }
                else if (!state)// Invalid Password
                {
                    JOptionPane.showMessageDialog(null, "Username is taken. Please choose another username.");
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Please fill in numeric values in the age field.");
            }
        }
    }//GEN-LAST:event_btnRegRegisterActionPerformed

    private void btnUserAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddNewActionPerformed
        // TODO add your handling code here:
        if(txtUserAddName.getText().isBlank() || txtUserAddContact.getText().isBlank() || 
           txtUserAddEmail.getText().isBlank() || txtUserAddAge.getText().isBlank() || 
           txtUserAddUsername.getText().isBlank() || txtUserAddPassword.getText().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
        }
        else if(txtUserAddName.getText().contains(",") || txtUserAddContact.getText().contains(",") ||
                txtUserAddEmail.getText().contains(",") || txtUserAddAge.getText().contains(",") ||
                txtUserAddUsername.getText().contains(",") || txtUserAddPassword.getText().contains(","))
        {
            JOptionPane.showMessageDialog(null, "Inputs cannot contain commas (,).");
        }
        else
        {
            if(rbAdmin.isSelected())
            {
                try
                {
                    String name = txtUserAddName.getText().trim();
                    String username = txtUserAddUsername.getText().trim();
                    String password = txtUserAddPassword.getText().trim();
                    int age = Integer.parseInt(txtUserAddAge.getText().trim());
                    String contact = txtUserAddContact.getText().trim();
                    String email = txtUserAddEmail.getText().trim();
                    Admin adminObject = new Admin(name, username, password, age, contact, email);
                    Boolean state = adminObject.add(adminObject);
                    if(state) // True = writes to file
                    {
                        JOptionPane.showMessageDialog(null, "Successfully added admin.");
                        txtUserAddName.setText("");
                        txtUserAddUsername.setText("");
                        txtUserAddPassword.setText("");
                        txtUserAddAge.setText("");
                        txtUserAddContact.setText("");
                        txtUserAddEmail.setText("");

                        rbgAddUser.clearSelection();
                        CardLayout card = (CardLayout)MainPanel.getLayout();
                        card.show(MainPanel, "customerView");
                        refreshCustomerTable();
                    }
                    else if (!state)// Invalid Password
                    {
                        JOptionPane.showMessageDialog(null, "Username is taken. Please choose another username.");
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please fill in numeric values in the age field.");
                }
            }
            else if(rbCustomer.isSelected())
            {
                try
                {
                    String name = txtUserAddName.getText().trim();
                    String username = txtUserAddUsername.getText().trim();
                    String password = txtUserAddPassword.getText().trim();
                    int age = Integer.parseInt(txtUserAddAge.getText().trim());
                    String contact = txtUserAddContact.getText().trim();
                    String email = txtUserAddEmail.getText().trim();
                    Customer customerObject = new Customer(name, username, password, age, contact, email);
                    Boolean state = customerObject.add(customerObject);
                    if(state) // True = writes to file
                    {
                        JOptionPane.showMessageDialog(null, "Successfully added customer.");
                        txtUserAddName.setText("");
                        txtUserAddUsername.setText("");
                        txtUserAddPassword.setText("");
                        txtUserAddAge.setText("");
                        txtUserAddContact.setText("");
                        txtUserAddEmail.setText("");
                        
                        rbgAddUser.clearSelection();
                        CardLayout card = (CardLayout)MainPanel.getLayout();
                        card.show(MainPanel, "customerView");
                        refreshCustomerTable();
                    }
                    else if (!state)// Invalid Password
                    {
                        JOptionPane.showMessageDialog(null, "Username is taken. Please choose another username.");
                    }
                }
                catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Please fill in numeric values in the age field.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a radiobutton.");
            }        
        }
    }//GEN-LAST:event_btnUserAddNewActionPerformed

    private void btnCartAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartAddActionPerformed
        // TODO add your handling code here:
        refreshOrderingTable();
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderAdd");
        addOrderSource = 3;

    }//GEN-LAST:event_btnCartAddActionPerformed

    private void busCusViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busCusViewDetailsActionPerformed
        // TODO add your handling code here:
        // Get Customer ID & Format Search ID
        if(tblCustomer.getSelectedRow() >= 0)
        {
            String searchedID = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString();
            searchedID = searchedID.toLowerCase().trim();
            // Get Customer
            Customer viewedCustomer = adminUser.view(searchedID);
            if(viewedCustomer != null)
            {
                lblCusViewID.setText(viewedCustomer.getPersonID());
                lblCusViewName.setText(viewedCustomer.getName());
                lblCusViewContact.setText(viewedCustomer.getContact());
                lblCusViewEmail.setText(viewedCustomer.getEmail());
                lblCusViewAge.setText(Integer.toString(viewedCustomer.getAge()));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Customer not found.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row in the Customer Table.");
        }
    }//GEN-LAST:event_busCusViewDetailsActionPerformed

    private void btnCusSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusSearchActionPerformed
        // TODO add your handling code here:
        if(!(txtCusSearch.getText().isBlank() || txtCusSearch.getText().toLowerCase().trim().equals("search for customer")))
        {
            String searchParameter = txtCusSearch.getText();
            searchParameter = searchParameter.toLowerCase().trim();
            ArrayList<Customer> matchedCustomer = adminUser.search(searchParameter, null, null);
            if(!matchedCustomer.isEmpty())
            {
                DefaultTableModel customerTable = (DefaultTableModel)tblCustomer.getModel();
                customerTable.setRowCount(0);
                for(Customer customerObject:matchedCustomer)
                {
                    String[] customerDetails = new String[2];
                    customerDetails[0] = customerObject.getPersonID();
                    customerDetails[1] = customerObject.getName();
                    customerTable.addRow(customerDetails);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "0 Search results.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter Customer ID or Name into the Search Field.");
        }
        

    }//GEN-LAST:event_btnCusSearchActionPerformed

    private void btnCusEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusEditSaveActionPerformed
        // TODO add your handling code here:
        if(txtCusEditName.getText().isBlank() || txtCusEditContact.getText().isBlank() ||
                txtCusEditEmail.getText().isBlank() || txtCusEditAge.getText().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
        }
        else
        {
            try
            {
                Boolean check = false;
                String customerID = lblCusEditID.getText();
                String name = txtCusEditName.getText().trim();
                String contact = txtCusEditContact.getText().trim();
                String email = txtCusEditEmail.getText().trim();
                int age = Integer.parseInt(txtCusEditAge.getText().trim());
                Customer edittedCustomer = new Customer(customerID, name, contact, email, age);
                check = adminUser.edit(edittedCustomer); //HERE
                if(check == true)
                {
                    JOptionPane.showMessageDialog(null, "Customer details are saved.");
                }
                txtCusEditName.setText("");
                txtCusEditContact.setText("");
                txtCusEditEmail.setText("");
                txtCusEditAge.setText("");
                
                CardLayout card = (CardLayout)MainPanel.getLayout();
                card.show(MainPanel, "customerView");
                refreshCustomerTable();
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Please enter your age in numbers.");
            }
        }
    }//GEN-LAST:event_btnCusEditSaveActionPerformed

    private void btnCusViewDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusViewDeleteActionPerformed
        // TODO add your handling code here:
        if(tblCustomer.getSelectedRow() >= 0)
        {
            Boolean status = false;
            String customerID = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString();
            String customerName = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 1).toString();
            int choice = JOptionPane.showConfirmDialog(null, String.format("Confirm delete?\nCustomer ID: %s\nName: %s", customerID,customerName),
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION)
            {
                status = adminUser.delete(customerID);
            }
            if(status) // Status is TRUE
            {
                JOptionPane.showMessageDialog(null, "Customer Data has been completely deleted.");
                refreshCustomerTable();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row in the Customer Table.");
        }
    }//GEN-LAST:event_btnCusViewDeleteActionPerformed

    private void btnProdSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdSearchActionPerformed
        if(txtProdSearch.getText().isBlank())
        {
            // Refreshes the Product Table
            refreshProductTable();
        }
        else if(!txtProdSearch.getText().toLowerCase().trim().equals("search for product"))
        {
            String searchParameter = txtProdSearch.getText();
            searchParameter = searchParameter.toLowerCase().trim();
            ArrayList<Product> matchedProd = adminUser.search(searchParameter, null);
            if(!matchedProd.isEmpty())
            {
                DefaultTableModel productTable = (DefaultTableModel)tblProduct.getModel();
                productTable.setRowCount(0);
                for(Product productObject: matchedProd)
                {
                    String[] productDetails = new String[3];
                    productDetails[0] = productObject.getProductID();
                    productDetails[1] = productObject.getName();
                    productDetails[2] = Integer.toString(productObject.getStock());
                    productTable.addRow(productDetails);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "0 Search results.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter Product ID or Name into the Search Field.");
        }        
    }//GEN-LAST:event_btnProdSearchActionPerformed

    private void btnEditProdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProdSaveActionPerformed
        if(txtEditProdName.getText().isBlank() || txtEditProdPrice.getText().isBlank() ||
                txtEditProdQuantity.getText().isBlank() || txtEditProdDescription.getText().isBlank())
        {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
        }
        else if(txtEditProdName.getText().contains(",") || txtEditProdPrice.getText().contains(",") ||
                txtEditProdQuantity.getText().contains(",") || txtEditProdDescription.getText().contains(","))
        {
            JOptionPane.showMessageDialog(null, "Inputs cannot contain commas (,).");
        }
        else
        {   
            try
            {
                ArrayList<Product> prod2EditList = adminUser.search(lblProductViewID.getText(), null);
                Product prod2Edit = prod2EditList.get(0);
                // Create New Product Object
                if (rbDiscontinued.isSelected())
                {
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Confirm to Discontinue Product?");
                    if (dialogResult == JOptionPane.YES_OPTION)
                    {
                        prod2Edit.setProductStat(productStatus.DISCONTINUED);
                        boolean check = adminUser.editProd(prod2Edit);
                        if (check == true)
                        {
                            JOptionPane.showMessageDialog(null, "Successfully Updated");

                            txtEditProdName.setText("");
                            txtEditProdPrice.setText("");
                            txtEditProdQuantity.setText("");
                            txtEditProdDescription.setText("");
                            rbSale.setSelected(true);
                            
                            // Bring users to product table and refreshes the product table
                            // To display updated product details
                            CardLayout card = (CardLayout)MainPanel.getLayout();
                            card.show(MainPanel, "productView");
                            refreshProductTable();
                        }
                    }
                }
                else
                {
                    prod2Edit.setProductStat(productStatus.SALE);
                    prod2Edit.setName(txtEditProdName.getText().trim());
                    prod2Edit.setProductPrice(Double.parseDouble(txtEditProdPrice.getText().trim()));
                    prod2Edit.setStock(Integer.parseInt(txtEditProdQuantity.getText().trim()));
                    prod2Edit.setDescription(txtEditProdDescription.getText().trim());
                    prod2Edit.setProductType(cboEditProdType.getSelectedItem().toString().trim());
                    
                    boolean check = adminUser.editProd(prod2Edit);
                    if (check == true)
                    {
                        JOptionPane.showMessageDialog(null, "Successfully Updated");

                        txtEditProdName.setText("");
                        txtEditProdPrice.setText("");
                        txtEditProdQuantity.setText("");
                        txtEditProdDescription.setText("");
                        rbSale.setSelected(true);

                        // Brings up Product Panel and refreshes the Product Table
                        // to show users the updated product details
                        CardLayout card = (CardLayout)MainPanel.getLayout();
                        card.show(MainPanel, "productView");
                        refreshProductTable();
                    }
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Please enter Price and Quantity in numbers.");
            }
            
            
        }   
    }//GEN-LAST:event_btnEditProdSaveActionPerformed

    private void btnSearchRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRefreshActionPerformed
        // TODO add your handling code here:
        refreshCustomerTable();
        txtCusSearch.setText("");
    }//GEN-LAST:event_btnSearchRefreshActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
        if(tblCart.getRowCount() == 0) // Cart is empty
        {
            JOptionPane.showMessageDialog(null, "Cart is empty. Unable to checkout.");
        }
        else // Cart has product
        {
            Boolean orderPlaced = false; // Confirmation that order has been placed > True = success
            Boolean quantityUpdate = false; // Confirmation that quantity has been updated > True = success
            String productIDList = tblCart.getValueAt(0, 1) .toString(); // Initialize ID List with first Item ID in the Cart Table
            String productQuantityList = tblCart.getValueAt(0, 3).toString(); // Initialize Quantity List with first Item Quantity in the Cart Table
            for(int row = 1; row < tblCart.getRowCount(); row++)
            {
                productIDList = String.format("%s.%s", productIDList, tblCart.getValueAt(row,1).toString());
                productQuantityList = String.format("%s.%s", productQuantityList, tblCart.getValueAt(row,3).toString());
            }
            Double grandTotal = Double.parseDouble(lblGrandTotal.getText());
            OrderStatus orderStatus = OrderStatus.ONGOING;
            if(userType == PersonType.ADMIN)
            {
                Order orderObject = new Order(adminUser.getPersonID(), orderStatus, grandTotal,
                productIDList, productQuantityList);
                orderPlaced = adminUser.add(orderObject);
                quantityUpdate = systemUser.updateProductQuantity(productIDList, productQuantityList);
            }
            else if (userType == PersonType.CUSTOMER)
            {
                Order orderObject = new Order(customerUser.getPersonID(), orderStatus, grandTotal,
                productIDList, productQuantityList);
                orderPlaced = customerUser.add(orderObject);
                quantityUpdate = systemUser.updateProductQuantity(productIDList, productQuantityList);
            }
            if(orderPlaced && quantityUpdate)
            {
                JOptionPane.showMessageDialog(null, "Order placed.");
                btnCheckout.setEnabled(false);
                btnCartAdd.setEnabled(false);
                btnCartRemove.setEnabled(false);
                btnCartQtyAdd.setEnabled(false);
                btnCartQtyDec.setEnabled(false);
                cartSource = 1;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Unexpected error occured. Please contact an admin.");
            }
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        if(!lblProductQuantity.getText().isBlank() && tblProductItem.getSelectedRow() >= 0)
        {
            if(Integer.parseInt(lblProductQuantity.getText()) > 0)
            {
                ArrayList<String> cartID = new ArrayList<String>(); // Get all Product ID in the JTable
                for(int row = 0; row < tblCart.getRowCount(); row++)
                {
                    cartID.add(tblCart.getValueAt(row, 1).toString());
                }

                if(cartID.contains(tblProductItem.getValueAt(tblProductItem.getSelectedRow(), 0))) // Product is already in the cart
                {
                    String matchingProductID = tblProductItem.getValueAt(tblProductItem.getSelectedRow(), 0).toString();
                    for(int row = 0; row < tblCart.getRowCount(); row++)
                    {
                        if(tblCart.getValueAt(row,1).toString().equals(matchingProductID))
                        {
                            int cartQuantity = Integer.parseInt(tblCart.getValueAt(row, 3).toString());
                            String newQuantity = Integer.toString(cartQuantity + Integer.parseInt(lblQuantityToCart.getText()));
                            tblCart.setValueAt(newQuantity, row, 3);

                            int productQuantity = Integer.parseInt(lblProductQuantity.getText()) - Integer.parseInt(lblQuantityToCart.getText());
                            lblProductQuantity.setText(Integer.toString(productQuantity));
                        }
                    }
                }
                else // Product is not in the cart
                {
                    String[] addedProduct = new String[5];
                    addedProduct[0] = Integer.toString(tblCart.getRowCount() + 1);
                    addedProduct[1] = tblProductItem.getValueAt(tblProductItem.getSelectedRow(), 0).toString();
                    addedProduct[2] = tblProductItem.getValueAt(tblProductItem.getSelectedRow(), 1).toString();
                    addedProduct[3] = lblQuantityToCart.getText();
                    addedProduct[4] = lblProductPrice.getText();
                    DefaultTableModel cartTable = (DefaultTableModel)tblCart.getModel();
                    cartTable.addRow(addedProduct);
                    int productQuantity = Integer.parseInt(lblProductQuantity.getText()) - Integer.parseInt(lblQuantityToCart.getText());
                    lblProductQuantity.setText(Integer.toString(productQuantity));
                }

                // Adds the price to the grand total
                double grandTotal = Double.parseDouble(lblGrandTotal.getText());
                double productPrice = Double.parseDouble(lblProductPrice.getText());
                int quantity = Integer.parseInt(lblQuantityToCart.getText());
                grandTotal = grandTotal + (productPrice*quantity);
                lblGrandTotal.setText(new DecimalFormat("##.##").format(grandTotal));
                lblQuantityToCart.setText("1");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a product item.");
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnAddQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQtyActionPerformed
        // TODO add your handling code here:
        if(tblProductItem.getSelectedRow() >= 0 && !(lblProductName.getText().trim().isBlank()))
        {
            int maxQuantity = Integer.parseInt(lblProductQuantity.getText());
            int currentQuantity = Integer.parseInt(lblQuantityToCart.getText());
            if(currentQuantity<maxQuantity)
            {
                int quantity = currentQuantity + 1;
                lblQuantityToCart.setText(Integer.toString(quantity));
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a product item.");
        }

        
    }//GEN-LAST:event_btnAddQtyActionPerformed

    private void lblReduceQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblReduceQtyActionPerformed
        // TODO add your handling code here:
        int currentQuantity = Integer.parseInt(lblQuantityToCart.getText());
        if(currentQuantity > 1)
        {
            currentQuantity = currentQuantity - 1;
            lblQuantityToCart.setText(Integer.toString(currentQuantity));
        }
    }//GEN-LAST:event_lblReduceQtyActionPerformed

    private void btnCartRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartRemoveActionPerformed
        // TODO add your handling code here:
            int choice = JOptionPane.showConfirmDialog(null, "Confirm Remove from Cart?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION)
            {
                double quantity = Double.parseDouble(tblCart.getValueAt(tblCart.getSelectedRow(), 3).toString());
                double price = Double.parseDouble(tblCart.getValueAt(tblCart.getSelectedRow(), 4).toString());
                price = price*quantity;
                double grandTotal = Double.parseDouble(lblGrandTotal.getText());
                grandTotal = grandTotal - price;
                lblGrandTotal.setText(new DecimalFormat("##.##").format(grandTotal));
                
                DefaultTableModel cartTable = (DefaultTableModel)tblCart.getModel();
                cartTable.removeRow(tblCart.getSelectedRow());
            }
    }//GEN-LAST:event_btnCartRemoveActionPerformed

    private void btnCartQtyAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartQtyAddActionPerformed
        // TODO add your handling code here:
        if(tblCart.getSelectedRow() >= 0)
        {
            String productID = tblCart.getValueAt(tblCart.getSelectedRow(), 1).toString();
            int currentQuantity = Integer.parseInt(tblCart.getValueAt(tblCart.getSelectedRow(), 3).toString());
            int maxQuantity = 0;
            ArrayList<Product> productList = systemUser.getProductList();
            for(Product productObject:productList)
            {
                if(productObject.getProductID().equals(productID))
                {
                    maxQuantity = productObject.getStock();
                }
            }
            if(currentQuantity < maxQuantity)
            {
                currentQuantity = currentQuantity + 1;
                tblCart.setValueAt(currentQuantity, tblCart.getSelectedRow(), 3);
                double currentGrandTotal = Double.parseDouble(lblGrandTotal.getText());
                double productPrice = Double.parseDouble(tblCart.getValueAt(tblCart.getSelectedRow(), 4).toString());
                currentGrandTotal = currentGrandTotal + productPrice;
                lblGrandTotal.setText(new DecimalFormat("##.##").format(currentGrandTotal));
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a cart item.");
        }
    }//GEN-LAST:event_btnCartQtyAddActionPerformed

    private void btnCartQtyDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartQtyDecActionPerformed
        // TODO add your handling code here:
        if(tblCart.getSelectedRow() >= 0)
        {
            String productID = tblCart.getValueAt(tblCart.getSelectedRow(), 1).toString();
            int currentQuantity = Integer.parseInt(tblCart.getValueAt(tblCart.getSelectedRow(), 3).toString());
            int maxQuantity = 0;
            ArrayList<Product> productList = systemUser.getProductList();
            for(Product productObject:productList)
            {
                if(productObject.getProductID().equals(productID))
                {
                    maxQuantity = productObject.getStock();
                }
            }
            if(currentQuantity <= maxQuantity && currentQuantity > 1)
            {
                currentQuantity = currentQuantity - 1;
                tblCart.setValueAt(currentQuantity, tblCart.getSelectedRow(), 3);
                double currentGrandTotal = Double.parseDouble(lblGrandTotal.getText());
                double productPrice = Double.parseDouble(tblCart.getValueAt(tblCart.getSelectedRow(), 4).toString());
                currentGrandTotal = currentGrandTotal - productPrice;
                lblGrandTotal.setText(new DecimalFormat("##.##").format(currentGrandTotal));
            } 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a cart item.");
        }
    }//GEN-LAST:event_btnCartQtyDecActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(tblOrderItem.getSelectedRow() >= 0)
        {
            int choice = JOptionPane.showConfirmDialog(null, "Confirm Remove from Order?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION)
            {
                double quantity = Double.parseDouble(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 2).toString());
                double price = Double.parseDouble(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 3).toString());
                price = price*quantity;
                double grandTotal = Double.parseDouble(lblGrandTotalOrd.getText());
                grandTotal = grandTotal - price;
                lblGrandTotalOrd.setText(new DecimalFormat("##.##").format(grandTotal));
                
                DefaultTableModel orderItemTable = (DefaultTableModel)tblOrderItem.getModel();
                orderItemTable.removeRow(tblOrderItem.getSelectedRow());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select an order item.");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tblProductItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductItemMouseReleased
        if(tblProductItem.getSelectedRow() >= 0)
        {
            String searchedID = tblProductItem.getValueAt(tblProductItem.getSelectedRow(), 0).toString();
            Product viewedProduct = systemUser.view(searchedID, null);
            lblProductName.setText(viewedProduct.getName());
            lblProductPrice.setText(Double.toString(viewedProduct.getProductPrice()));
            lblProductQuantity.setText(Integer.toString(viewedProduct.getStock()));
            lblProductDescription.setText(viewedProduct.getDescription());
            
            String productID = viewedProduct.getProductID();
            for(int row = 0; row < tblCart.getRowCount(); row++)
            {
                if(productID.equals(tblCart.getValueAt(row, 1).toString()))
                {
                    int currentQuantity = Integer.parseInt(lblProductQuantity.getText());
                    int cartQuantity = Integer.parseInt(tblCart.getValueAt(row, 3).toString());
                    currentQuantity = currentQuantity - cartQuantity;
                    lblProductQuantity.setText(Integer.toString(currentQuantity));
                }
                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a product item.");
        }
    }//GEN-LAST:event_tblProductItemMouseReleased

    private void tblProductTypeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductTypeMouseReleased
        String productType = tblProductType.getValueAt(tblProductType.getSelectedRow(), 1).toString();
        ArrayList<Product> productList = systemUser.getProductBasedOnType(productType);
        if(!productList.isEmpty())
        {
            ArrayList<String[]> productDetailList = new ArrayList<String[]>();
            for(Product productObject:productList)
            {
                String[] productDetail = new String[4];
                productDetail[0] = productObject.getProductID();
                productDetail[1] = productObject.getName();
                productDetail[2] = Double.toString(productObject.getProductPrice());
                productDetail[3] = Integer.toString(productObject.getStock());

                productDetailList.add(productDetail);
            }
            DefaultTableModel productItemTable = (DefaultTableModel)tblProductItem.getModel();
            productItemTable.setRowCount(0);
            for(String[] productDetail:productDetailList)
            {
                productItemTable.addRow(productDetail);
            }
            
            lblProductName.setText("");
            lblProductPrice.setText("");
            lblProductQuantity.setText("");
            lblProductDescription.setText("");
            lblQuantityToCart.setText("1");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ERROR: No product found with the corresponding type.");
        }
    }//GEN-LAST:event_tblProductTypeMouseReleased

    private void tblProductMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseReleased
        if(tblProduct.getSelectedRow() >= 0)
        {
            String searchedID = tblProduct.getValueAt(tblProduct.getSelectedRow(), 0).toString();
            searchedID = searchedID.toLowerCase().trim();
            // Get Product
            Product viewedProd = adminUser.view(searchedID, null);
            if(viewedProd != null)
            {
                lblProductViewID.setText(viewedProd.getProductID());
                lblProdName.setText(viewedProd.getName());
                lblProdType.setText(viewedProd.getProductType());
                lblProdPrice.setText(Double.toString(viewedProd.getProductPrice()));
                lblProdDesc.setText(viewedProd.getDescription());
                lblProdQuantity.setText(Integer.toString(viewedProd.getStock()));
                lblProdStatus.setText(viewedProd.getProductStat().toString());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Product not found.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row in the Product Table.");
        }
    }//GEN-LAST:event_tblProductMouseReleased

    private void tblOrderItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderItemMouseReleased
        lblProdID.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 0).toString());
        lblOrdProdName.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 1).toString());
        lblOrdProdQuantity.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 2).toString());
        lblOrdProdPrice.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tblOrderItemMouseReleased

    private void btnAddQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuantityActionPerformed
        // TODO add your handling code here:
        if(!lblProdID.getText().isBlank()) // User hasn't selected any product
        {
            Product selectedProduct = systemUser.view(lblProdID.getText(), null);
            int availableQuantity = selectedProduct.getStock(); // Get Quantity from Product.txt
            int currentQuantity = Integer.parseInt(lblOrdProdQuantity.getText()); // Get Quantity shown to the user
            int orderQuantity = 0; // Get the quantity as stored in Order.txt
            
            // This is to ensure users are unable to order over the available quantity
            
            Order orderDetail = systemUser.search(lblOrdID.getText());
            String[] idList = orderDetail.getItemList().split("\\.");
            String[] quantityList = orderDetail.getQuantityList().split("\\.");
            for(int index = 0; index < idList.length; index++)
            {
                if(lblProdID.getText().equals(idList[index]))
                {
                    orderQuantity = Integer.parseInt(quantityList[index]);
                }
            }
            
            availableQuantity = availableQuantity - (currentQuantity - orderQuantity);
            if(availableQuantity > 0)
            {
                lblOrdProdQuantity.setText(Integer.toString(currentQuantity + 1));
                tblOrderItem.setValueAt(currentQuantity+1, tblOrderItem.getSelectedRow(), 2);
                double price = Double.parseDouble(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 3).toString());
                double newGrandTotal = Double.parseDouble(lblGrandTotalOrd.getText()) + price;
                lblGrandTotalOrd.setText(new DecimalFormat("##.##").format(newGrandTotal));
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row in the Order Table.");
        }
    }//GEN-LAST:event_btnAddQuantityActionPerformed

    private void btnMinusQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusQuantityActionPerformed
        if(!lblProdID.getText().isBlank())
        {
            int currentQuantity = Integer.parseInt(lblOrdProdQuantity.getText());
            if(currentQuantity > 1)
            {
                lblOrdProdQuantity.setText(Integer.toString(currentQuantity - 1));
                tblOrderItem.setValueAt(currentQuantity-1, tblOrderItem.getSelectedRow(), 2);
                double price = Double.parseDouble(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 3).toString());
                double newGrandTotal = Double.parseDouble(lblGrandTotalOrd.getText()) - price;
                lblGrandTotalOrd.setText(new DecimalFormat("##.##").format(newGrandTotal));
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row in the Order Table.");
        }
    }//GEN-LAST:event_btnMinusQuantityActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Confirm Modifying your Order?",
                "Confirm Order Modify", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION)
        {
            String orderID = lblOrdID.getText();
            String grandTotal = lblGrandTotalOrd.getText();
            String productList = tblOrderItem.getValueAt(0, 0).toString();
            String quantityList = tblOrderItem.getValueAt(0, 2).toString();
            OrderStatus orderStatus = OrderStatus.valueOf(lblOrdStatus.getText()); 
            for(int row = 1; row < tblOrderItem.getRowCount(); row++)
            {
                productList = String.format("%s.%s", productList, tblOrderItem.getValueAt(row, 0));
                quantityList = String.format("%s.%s", quantityList, tblOrderItem.getValueAt(row, 2));
            }
            Order edittedOrder = new Order(orderID, Double.parseDouble(grandTotal), productList, quantityList, orderStatus);
            Boolean status = systemUser.edit(edittedOrder);
            if(status)
            {
                JOptionPane.showMessageDialog(null, "Your order has been successfully updated.");
            }
        }   
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnViewOrderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderSearchActionPerformed
        // TODO add your handling code here:
        if(txtOrderSearch.getText().isBlank() || 
                txtOrderSearch.getText().equals("Search for Order"))
        {
            if(userType.equals(PersonType.ADMIN))
            {
                refreshOrderTable();
                txtOrderSearch.setText("");
            }
            else if (userType.equals(PersonType.CUSTOMER))
            {
                refreshOrderTable();
                txtOrderSearch.setText("");
            }
        }
        else
        {
            Order searchedOrder = systemUser.search(txtOrderSearch.getText().trim().toUpperCase());
            if(!(searchedOrder == null))
            {
                DefaultTableModel orderTable = (DefaultTableModel)tblOrder.getModel();
                orderTable.setRowCount(0);
                String[] orderDetails = new String[4];
                orderDetails[0] = searchedOrder.getOrderID();
                orderDetails[1] = searchedOrder.getOrderDate().toString();
                orderDetails[2] = Double.toString(searchedOrder.getGrandTotal());
                orderDetails[3] = searchedOrder.getOrderStatus().toString();
                orderTable.addRow(orderDetails);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Order not found.");
            }
        }
    }//GEN-LAST:event_btnViewOrderSearchActionPerformed

    private void tblCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseReleased
        String searchedID = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString();
        searchedID = searchedID.toLowerCase().trim();
        // Get Customer
        Customer viewedCustomer = adminUser.view(searchedID);
        if(viewedCustomer != null)
        {
            lblCusViewID.setText(viewedCustomer.getPersonID());
            lblCusViewName.setText(viewedCustomer.getName());
            lblCusViewContact.setText(viewedCustomer.getContact());
            lblCusViewEmail.setText(viewedCustomer.getEmail());
            lblCusViewAge.setText(Integer.toString(viewedCustomer.getAge()));
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Customer not found.");
        }
    }//GEN-LAST:event_tblCustomerMouseReleased

    private void tblOrderItemViewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderItemViewMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblOrderItemViewMouseReleased

    private void btnOrderViewItemBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderViewItemBackActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderView");
    }//GEN-LAST:event_btnOrderViewItemBackActionPerformed

    private void tblOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseReleased
        // TODO add your handling code here:
        lblOrderViewID.setText(tblOrder.getValueAt(tblOrder.getSelectedRow(), 0).toString());
        lblOrdViewTotal.setText(tblOrder.getValueAt(tblOrder.getSelectedRow(), 2).toString());
        OrderStatus orderStatus = OrderStatus.valueOf(tblOrder.getValueAt(tblOrder.getSelectedRow(), 3).toString());
        if(orderStatus.equals(OrderStatus.CANCELLED) || orderStatus.equals(OrderStatus.COMPLETED))
        {
            btnViewOrderModify.setEnabled(false);
            btnCancelOrder.setEnabled(false);
        }
        else if(orderStatus.equals(OrderStatus.ONGOING))
        {
            btnViewOrderModify.setEnabled(true);
            btnCancelOrder.setEnabled(true);
        }
    }//GEN-LAST:event_tblOrderMouseReleased

    private void txtLoginPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginPasswordKeyReleased
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String[] userDetail = systemUser.login(txtLoginUsername.getText().trim(), txtLoginPassword.getText().trim());
            if(userDetail.length > 0)
            {
                JOptionPane.showMessageDialog(null, "Login Successful.");
                if(PersonType.valueOf(userDetail[2]) == PersonType.ADMIN) // Admin User
                {
                    adminUser = new Admin(userDetail[0], userDetail[1]);
                    CardLayout card = (CardLayout)MainPanel.getLayout();
                    card.show(MainPanel, "adminMenu");
                    userType = PersonType.ADMIN;   
                }
                else if(PersonType.valueOf(userDetail[2]) == PersonType.CUSTOMER) // Customer User
                {
                    customerUser = new Customer(userDetail[0], userDetail[1]);
                    CardLayout card = (CardLayout)MainPanel.getLayout();
                    card.show(MainPanel, "customerMenu");
                    userType = PersonType.CUSTOMER;
                }
                txtLoginUsername.setText("");
                txtLoginPassword.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Login Credentials.");
                txtLoginUsername.setText("");
                txtLoginPassword.setText("");
                txtLoginUsername.requestFocusInWindow();
                
            }   
        }
    }//GEN-LAST:event_txtLoginPasswordKeyReleased

    private void tblCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCustomerKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            String searchedID = tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString();
            searchedID = searchedID.toLowerCase().trim();
            // Get Customer
            Customer viewedCustomer = adminUser.view(searchedID);
            if(viewedCustomer != null)
            {
                lblCusViewID.setText(viewedCustomer.getPersonID());
                lblCusViewName.setText(viewedCustomer.getName());
                lblCusViewContact.setText(viewedCustomer.getContact());
                lblCusViewEmail.setText(viewedCustomer.getEmail());
                lblCusViewAge.setText(Integer.toString(viewedCustomer.getAge()));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Customer not found.");
            }
        }
    }//GEN-LAST:event_tblCustomerKeyReleased

    private void tblProductTypeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductTypeKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            String productType = tblProductType.getValueAt(tblProductType.getSelectedRow(), 1).toString();
            ArrayList<Product> productList = systemUser.getProductBasedOnType(productType);
            if(!productList.isEmpty())
            {
                ArrayList<String[]> productDetailList = new ArrayList<String[]>();
                for(Product productObject:productList)
                {
                    String[] productDetail = new String[4];
                    productDetail[0] = productObject.getProductID();
                    productDetail[1] = productObject.getName();
                    productDetail[2] = Double.toString(productObject.getProductPrice());
                    productDetail[3] = Integer.toString(productObject.getStock());

                    productDetailList.add(productDetail);
                }
                DefaultTableModel productItemTable = (DefaultTableModel)tblProductItem.getModel();
                productItemTable.setRowCount(0);
                for(String[] productDetail:productDetailList)
                {
                    productItemTable.addRow(productDetail);
                }

                lblProductName.setText("");
                lblProductPrice.setText("");
                lblProductQuantity.setText("");
                lblProductDescription.setText("");
                lblQuantityToCart.setText("1");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ERROR: No product found with the corresponding type.");
            }
        }
    }//GEN-LAST:event_tblProductTypeKeyReleased

    private void tblProductItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductItemKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(tblProductItem.getSelectedRow() >= 0)
            {
                String searchedID = tblProductItem.getValueAt(tblProductItem.getSelectedRow(), 0).toString();
                Product viewedProduct = systemUser.view(searchedID, null);
                lblProductName.setText(viewedProduct.getName());
                lblProductPrice.setText(Double.toString(viewedProduct.getProductPrice()));
                lblProductQuantity.setText(Integer.toString(viewedProduct.getStock()));
                lblProductDescription.setText(viewedProduct.getDescription());

                String productID = viewedProduct.getProductID();
                for(int row = 0; row < tblCart.getRowCount(); row++)
                {
                    if(productID.equals(tblCart.getValueAt(row, 1).toString()))
                    {
                        int currentQuantity = Integer.parseInt(lblProductQuantity.getText());
                        int cartQuantity = Integer.parseInt(tblCart.getValueAt(row, 3).toString());
                        currentQuantity = currentQuantity - cartQuantity;
                        lblProductQuantity.setText(Integer.toString(currentQuantity));
                    }

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a product item.");
            }
        }
    }//GEN-LAST:event_tblProductItemKeyReleased

    private void tblOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblOrderKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            lblOrderViewID.setText(tblOrder.getValueAt(tblOrder.getSelectedRow(), 0).toString());
            lblOrdViewTotal.setText(tblOrder.getValueAt(tblOrder.getSelectedRow(), 2).toString());
            OrderStatus orderStatus = OrderStatus.valueOf(tblOrder.getValueAt(tblOrder.getSelectedRow(), 3).toString());
            if(orderStatus.equals(OrderStatus.CANCELLED) || orderStatus.equals(OrderStatus.COMPLETED))
            {
                btnViewOrderModify.setEnabled(false);
                btnCancelOrder.setEnabled(false);
            }
            else if(orderStatus.equals(OrderStatus.ONGOING))
            {
                btnViewOrderModify.setEnabled(true);
                btnCancelOrder.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tblOrderKeyReleased

    private void tblOrderItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblOrderItemKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            lblProdID.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 0).toString());
            lblOrdProdName.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 1).toString());
            lblOrdProdQuantity.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 2).toString());
            lblOrdProdPrice.setText(tblOrderItem.getValueAt(tblOrderItem.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_tblOrderItemKeyReleased

    private void tblProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(tblProduct.getSelectedRow() >= 0)
            {
                String searchedID = tblProduct.getValueAt(tblProduct.getSelectedRow(), 0).toString();
                searchedID = searchedID.toLowerCase().trim();
                // Get Product
                Product viewedProd = adminUser.view(searchedID, null);
                if(viewedProd != null)
                {
                    lblProductViewID.setText(viewedProd.getProductID());
                    lblProdName.setText(viewedProd.getName());
                    lblProdType.setText(viewedProd.getProductType());
                    lblProdPrice.setText(Double.toString(viewedProd.getProductPrice()));
                    lblProdDesc.setText(viewedProd.getDescription());
                    lblProdQuantity.setText(Integer.toString(viewedProd.getStock()));
                    lblProdStatus.setText(viewedProd.getProductStat().toString());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Product not found.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a row in the Product Table.");
            }
        }
    }//GEN-LAST:event_tblProductKeyReleased

    private void btnCompleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteOrderActionPerformed
        // TODO add your handling code here:
        if(!lblOrderViewID.getText().isBlank())
        {
            int choice = JOptionPane.showConfirmDialog(null, "Confirm Cancel?",
                "Confirm Cancel", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION)
            {
                Boolean updateStatus = false; // Ensure there are changes
                Boolean overwriteStatus = false; // Ensure the changes are written
                Order updatedOrder = new Order();
                String orderID = lblOrderViewID.getText();
                String userID = lblCusIDOrdView.getText();
                ArrayList<Order> orderList = systemUser.getOrderListBasedOnID(userID);
                for(Order orderObject:orderList)
                {
                    if(orderObject.getOrderID().equals(orderID))
                    {
                        updatedOrder = orderObject;
                        updatedOrder.setOrderStatus(OrderStatus.COMPLETED);
                        updateStatus = true;
                    }
                }
                if(updateStatus)
                {
                    overwriteStatus = systemUser.edit(updatedOrder);
                }
                if(updateStatus && overwriteStatus)
                {
                    JOptionPane.showMessageDialog(null, "Your order has been set to completed.");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Your order failed to update. Please contact an admin.");
                }
            }
        }
    }//GEN-LAST:event_btnCompleteOrderActionPerformed

    private void btnViewOrderItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderItemsActionPerformed
        if(tblOrder.getRowCount() != 0)
        {
            if(tblOrder.getSelectedRow() >= 0)
            {
                String orderID = tblOrder.getValueAt(tblOrder.getSelectedRow(), 0).toString();
                Order orderObject = systemUser.search(orderID);
                String[] idList = orderObject.getItemList().split("\\.");
                String[] quantityList = orderObject.getQuantityList().split("\\.");

                DefaultTableModel orderItemViewTable = (DefaultTableModel)tblOrderItemView.getModel();
                orderItemViewTable.setRowCount(0);
                for(int index = 0; index < idList.length; index++)
                {
                    Product productObject = systemUser.view(idList[index], null);
                    String[] productDetail = new String[5];
                    productDetail[0] = productObject.getProductID();
                    productDetail[1] = productObject.getName();
                    productDetail[2] = quantityList[index];
                    productDetail[3] = Double.toString(productObject.getProductPrice());
                    productDetail[4] = new DecimalFormat("##.##").format(productObject.getProductPrice()*Integer.parseInt(quantityList[index]));
                    orderItemViewTable.addRow(productDetail);
                }
                CardLayout card = (CardLayout)MainPanel.getLayout();
                card.show(MainPanel, "orderItem");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a row.");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Customer has not place an order.");
        }
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "orderViewItem");
    }//GEN-LAST:event_btnViewOrderItemsActionPerformed

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
        // TODO add your handling code here:
        if(tblOrder.getSelectedRow() >= 0)
        {
            String orderID = tblOrder.getValueAt(tblOrder.getSelectedRow(), 0).toString(); // Search ID
            Order orderSelected = systemUser.search(orderID); // Get Order to check Date
            if(!(LocalDate.now().compareTo(orderSelected.getOrderDate()) > 3)) // Less than 3 days order
            {
                int choice = JOptionPane.showConfirmDialog(null, "Confirm Cancel?",
                    "Confirm Cancel", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION)
                {
                    Boolean status = systemUser.delete(orderID); // Delete
                    if(status)
                    {
                        JOptionPane.showMessageDialog(null, "Your order has been cancelled.");
                        refreshOrderTable(); // Refresh the appearance of the order
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Your order failed to cancel. Please contact admin");
                    }
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You cant cancel order older than 3 days.");
        }
    }//GEN-LAST:event_btnCancelOrderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JPanel PanelRegister;
    private javax.swing.JButton btnAddQty;
    private javax.swing.JButton btnAddQuantity;
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnAdminCart;
    private javax.swing.JButton btnAdminLogout;
    private javax.swing.JButton btnAdminManageOrder;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnCartAdd;
    private javax.swing.JButton btnCartBack;
    private javax.swing.JButton btnCartQtyAdd;
    private javax.swing.JButton btnCartQtyDec;
    private javax.swing.JButton btnCartRemove;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnCompleteOrder;
    private javax.swing.JButton btnCusAddClear;
    private javax.swing.JButton btnCusCart;
    private javax.swing.JButton btnCusEditCancel;
    private javax.swing.JButton btnCusEditSave;
    private javax.swing.JButton btnCusLogout;
    private javax.swing.JButton btnCusManageOrder;
    private javax.swing.JButton btnCusPlaceOrder;
    private javax.swing.JButton btnCusSearch;
    private javax.swing.JButton btnCusViewAdd;
    private javax.swing.JButton btnCusViewBack;
    private javax.swing.JButton btnCusViewDelete;
    private javax.swing.JButton btnCusViewEdit;
    private javax.swing.JButton btnEditProdBack;
    private javax.swing.JButton btnEditProdSave;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginRegister;
    private javax.swing.JButton btnManageCustomer;
    private javax.swing.JButton btnManageProduct;
    private javax.swing.JButton btnMinusQuantity;
    private javax.swing.JButton btnNewOrdViewCart;
    private javax.swing.JButton btnNewProdAdd;
    private javax.swing.JButton btnNewProdCancel;
    private javax.swing.JButton btnOrdItemBack;
    private javax.swing.JButton btnOrderAddBack;
    private javax.swing.JButton btnOrderViewItemBack;
    private javax.swing.JButton btnProdAdd;
    private javax.swing.JButton btnProdEdit;
    private javax.swing.JButton btnProdEdit1;
    private javax.swing.JButton btnProdSearch;
    private javax.swing.JButton btnRegBack;
    private javax.swing.JButton btnRegRegister;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchRefresh;
    private javax.swing.JButton btnUserAddNew;
    private javax.swing.JButton btnViewOrderBack;
    private javax.swing.JButton btnViewOrderItems;
    private javax.swing.JButton btnViewOrderModify;
    private javax.swing.JButton btnViewOrderNew;
    private javax.swing.JButton btnViewOrderSearch;
    private javax.swing.JButton busCusViewDetails;
    private javax.swing.JComboBox<String> cboEditProdType;
    private javax.swing.JComboBox<String> cboNewProdType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblCusEditAge;
    private javax.swing.JLabel lblCusEditContact;
    private javax.swing.JLabel lblCusEditEmail;
    private javax.swing.JLabel lblCusEditID;
    private javax.swing.JLabel lblCusEditName;
    private javax.swing.JLabel lblCusIDOrdView;
    private javax.swing.JLabel lblCusViewAge;
    private javax.swing.JLabel lblCusViewContact;
    private javax.swing.JLabel lblCusViewEmail;
    private javax.swing.JLabel lblCusViewID;
    private javax.swing.JLabel lblCusViewName;
    private javax.swing.JLabel lblCustomerAge;
    private javax.swing.JLabel lblCustomerAge1;
    private javax.swing.JLabel lblCustomerAge2;
    private javax.swing.JLabel lblCustomerAge3;
    private javax.swing.JLabel lblCustomerContact;
    private javax.swing.JLabel lblCustomerContact1;
    private javax.swing.JLabel lblCustomerContact2;
    private javax.swing.JLabel lblCustomerContact3;
    private javax.swing.JLabel lblCustomerContact4;
    private javax.swing.JLabel lblCustomerEmail;
    private javax.swing.JLabel lblCustomerEmail1;
    private javax.swing.JLabel lblCustomerEmail2;
    private javax.swing.JLabel lblCustomerEmail3;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerID1;
    private javax.swing.JLabel lblCustomerID2;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerName1;
    private javax.swing.JLabel lblCustomerName2;
    private javax.swing.JLabel lblCustomerName3;
    private javax.swing.JLabel lblCustomerName4;
    private javax.swing.JLabel lblEditProdID;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblGrandTotalOrd;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInstruction;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblOrdDate;
    private javax.swing.JLabel lblOrdID;
    private javax.swing.JLabel lblOrdID1;
    private javax.swing.JLabel lblOrdID10;
    private javax.swing.JLabel lblOrdID2;
    private javax.swing.JLabel lblOrdID5;
    private javax.swing.JLabel lblOrdID6;
    private javax.swing.JLabel lblOrdID7;
    private javax.swing.JLabel lblOrdID8;
    private javax.swing.JLabel lblOrdID9;
    private javax.swing.JLabel lblOrdProdName;
    private javax.swing.JLabel lblOrdProdPrice;
    private javax.swing.JLabel lblOrdProdQuantity;
    private javax.swing.JLabel lblOrdStatus;
    private javax.swing.JLabel lblOrdViewTotal;
    private javax.swing.JLabel lblOrderViewID;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblPrice2;
    private javax.swing.JLabel lblProdDesc;
    private javax.swing.JLabel lblProdID;
    private javax.swing.JLabel lblProdName;
    private javax.swing.JLabel lblProdPrice;
    private javax.swing.JLabel lblProdQuantity;
    private javax.swing.JLabel lblProdStatus;
    private javax.swing.JLabel lblProdType;
    private javax.swing.JLabel lblProductDescription;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JLabel lblProductQuantity;
    private javax.swing.JLabel lblProductViewID;
    private javax.swing.JLabel lblQuantity2;
    private javax.swing.JLabel lblQuantityToCart;
    private javax.swing.JButton lblReduceQty;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitleAdminMenu;
    private javax.swing.JLabel lblTitleAdminMenu1;
    private javax.swing.JLabel lblTitleCart;
    private javax.swing.JLabel lblTitleEditCustomer;
    private javax.swing.JLabel lblTitleEditProduct;
    private javax.swing.JLabel lblTitleNewCustomer;
    private javax.swing.JLabel lblTitleNewProduct;
    private javax.swing.JLabel lblTitleOrderItems;
    private javax.swing.JLabel lblTitleOrderItems1;
    private javax.swing.JLabel lblTitleProduct;
    private javax.swing.JLabel lblTitleViewCustomer;
    private javax.swing.JLabel lblTitleViewOrder;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JLabel lblUsername2;
    private javax.swing.JPanel pnlAdminMenu;
    private javax.swing.JPanel pnlCustomerAdd;
    private javax.swing.JPanel pnlCustomerEdit;
    private javax.swing.JPanel pnlCustomerMenu;
    private javax.swing.JPanel pnlCustomerView;
    private javax.swing.JPanel pnlOrderAdd;
    private javax.swing.JPanel pnlOrderCart;
    private javax.swing.JPanel pnlOrderItem;
    private javax.swing.JPanel pnlOrderView;
    private javax.swing.JPanel pnlOrderViewItem;
    private javax.swing.JPanel pnlProductAdd;
    private javax.swing.JPanel pnlProductEdit;
    private javax.swing.JPanel pnlProductView;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbCustomer;
    private javax.swing.JRadioButton rbDiscontinued;
    private javax.swing.JRadioButton rbFragile;
    private javax.swing.JRadioButton rbNonFragile;
    private javax.swing.ButtonGroup rbProductStatus;
    private javax.swing.JRadioButton rbSale;
    private javax.swing.ButtonGroup rbgAddUser;
    private javax.swing.ButtonGroup rbgFragility;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblOrderItem;
    private javax.swing.JTable tblOrderItemView;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblProductItem;
    private javax.swing.JTable tblProductType;
    private javax.swing.JTextField txtCusEditAge;
    private javax.swing.JTextField txtCusEditContact;
    private javax.swing.JTextField txtCusEditEmail;
    private javax.swing.JTextField txtCusEditName;
    private javax.swing.JTextField txtCusSearch;
    private javax.swing.JTextField txtEditProdDescription;
    private javax.swing.JTextField txtEditProdName;
    private javax.swing.JTextField txtEditProdPrice;
    private javax.swing.JTextField txtEditProdQuantity;
    private javax.swing.JPasswordField txtLoginPassword;
    private javax.swing.JTextField txtLoginUsername;
    private javax.swing.JTextField txtNewProdDescription;
    private javax.swing.JTextField txtNewProdName;
    private javax.swing.JTextField txtNewProdPrice;
    private javax.swing.JTextField txtNewProdQuantity;
    private javax.swing.JTextField txtOrderSearch;
    private javax.swing.JTextField txtProdSearch;
    private javax.swing.JTextField txtRegAge;
    private javax.swing.JTextField txtRegContact;
    private javax.swing.JTextField txtRegEmail;
    private javax.swing.JTextField txtRegName;
    private javax.swing.JTextField txtRegPassword;
    private javax.swing.JTextField txtRegUsername;
    private javax.swing.JTextField txtUserAddAge;
    private javax.swing.JTextField txtUserAddContact;
    private javax.swing.JTextField txtUserAddEmail;
    private javax.swing.JTextField txtUserAddName;
    private javax.swing.JTextField txtUserAddPassword;
    private javax.swing.JTextField txtUserAddUsername;
    // End of variables declaration//GEN-END:variables
}

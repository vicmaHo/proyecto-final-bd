/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Victor
 */
public class VistaLogin extends javax.swing.JFrame {
    // Mover la ventana a traves de coordenadas
    int xMouse, yMouse;
    
    

    /**
     * Creates new form VistaLogin
     */
    public VistaLogin() {
        initComponents();
        setInitialFocus();
        setLocationRelativeTo(null);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void setInitialFocus() {
        // Puedes establecer el foco en un botón, etiqueta o cualquier otro componente que no sea un campo de texto
        pnHeader.requestFocusInWindow();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBg = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        lbtTitle = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbPass = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JPanel();
        btnLoginLB = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JPanel();
        lbExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        pnBg.setBackground(new java.awt.Color(255, 255, 255));
        pnBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setForeground(new java.awt.Color(204, 204, 204));
        txtUsername.setText("Ingrese su nombre de usuario");
        txtUsername.setBorder(null);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsernameMousePressed(evt);
            }
        });
        pnBg.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 280, 30));

        lbtTitle.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        lbtTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtTitle.setText("INICIAR SESIÓN");
        pnBg.add(lbtTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 460, -1));

        lbUsername.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbUsername.setText("NOMBRE DE USUARIO");
        pnBg.add(lbUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));
        pnBg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 290, 10));

        lbPass.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbPass.setText("CONTRASEÑA");
        pnBg.add(lbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));
        pnBg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 290, 10));

        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("********");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        pnBg.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 290, 30));

        btnLogin.setBackground(new java.awt.Color(35, 230, 249));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLoginLB.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnLoginLB.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginLB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLoginLB.setText("INGRESAR");
        btnLoginLB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginLBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginLBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginLBMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLoginLayout = new javax.swing.GroupLayout(btnLogin);
        btnLogin.setLayout(btnLoginLayout);
        btnLoginLayout.setHorizontalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnLoginLB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnLoginLayout.setVerticalGroup(
            btnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLoginLB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnBg.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 130, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnBg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 460, -1));

        pnHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnHeaderMouseDragged(evt);
            }
        });
        pnHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnHeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));

        lbExit.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lbExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbExit.setText("X");
        lbExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnExitLayout = new javax.swing.GroupLayout(btnExit);
        btnExit.setLayout(btnExitLayout);
        btnExitLayout.setHorizontalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
        btnExitLayout.setVerticalGroup(
            btnExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeaderLayout.createSequentialGroup()
                .addGap(0, 428, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnBg.add(pnHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        System.exit(0);
        //this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lbExitMouseClicked

    private void pnHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnHeaderMousePressed

    private void pnHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x- xMouse,y- yMouse);
           
    }//GEN-LAST:event_pnHeaderMouseDragged

    private void lbExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseEntered
        btnExit.setBackground(Color.red);
        lbExit.setForeground(Color.white);
    }//GEN-LAST:event_lbExitMouseEntered

    private void lbExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseExited
        btnExit.setBackground(Color.white);
        lbExit.setForeground(Color.black);
    }//GEN-LAST:event_lbExitMouseExited

    private void btnLoginLBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginLBMouseEntered
        btnLogin.setBackground(new Color(162,231 , 249));
    }//GEN-LAST:event_btnLoginLBMouseEntered

    private void btnLoginLBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginLBMouseExited
        btnLogin.setBackground(new Color(35, 230, 249));
    }//GEN-LAST:event_btnLoginLBMouseExited

    private void txtUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMousePressed
        if (txtUsername.getText().equals("Ingrese su nombre de usuario")){
            txtUsername.setText("");
            txtUsername.setForeground(Color.black);
        }
        if(String.valueOf(txtPassword.getPassword()).isEmpty()){
            txtPassword.setText("********");
            txtPassword.setForeground(Color.gray);
        }
       
        
    }//GEN-LAST:event_txtUsernameMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if(String.valueOf(txtPassword.getPassword()).equals("********")){
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);
        }
        if(txtUsername.getText().isEmpty()){
            txtUsername.setText("Ingrese su nombre de usuario");
            txtUsername.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    private void btnLoginLBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginLBMouseClicked
        //javax.swing.JOptionPane.showMessageDialog(this, "Usuario: "+ txtUsername.getText() + "\nContraseña: " + String.valueOf(txtPassword.getPassword()), "Datos", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnLoginLBMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnExit;
    private javax.swing.JPanel btnLogin;
    public javax.swing.JLabel btnLoginLB;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lbtTitle;
    private javax.swing.JPanel pnBg;
    private javax.swing.JPanel pnHeader;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

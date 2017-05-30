/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailyreg.view;

import dailyreg.logic.Archivo;
import dailyreg.logic.DropExcel;
import dailyreg.logic.Información;
import dailyreg.logic.Semana;
import dailyreg.logic.Sistema;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan
 */
public class DRHome extends javax.swing.JFrame {
    
    DropExcel de;
    ArrayList<Información> info = new ArrayList<Información>();
    public static Sistema objeto2=new Sistema();
    Archivo archivo=new Archivo(objeto2);
    
    public void cargararchivo(){
       try {
           Sistema temp = archivo.cargar();
           if (temp != null) {
               objeto2 = temp;
           }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al Cargar el Archivo ("+ex.getMessage()+").", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(this, "Error al Cargar el Archivo 2 "+ex.getMessage()+").", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al Cargar el Archivo 3 "+ex.getMessage()+").", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
     
    }
    /**
     * Creates new form DRHome
     */
    public DRHome() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        de = new DropExcel(tablaDatos);
        JFRAME();
        cargararchivo();
        listar();
        listarTabla();
    }
    
    public void listar(){
        if (objeto2.listarSemanas() != null) {
            for (int i = 0; i < objeto2.listarSemanas().size(); i++) {
                comboSemana.addItem(objeto2.listarSemanas().get(i).getNombre());
            }
        }
        
        if (objeto2.listarDependencias()!= null) {
            for (int i = 0; i < objeto2.listarDependencias().size(); i++) {
                comboDependencia.addItem(objeto2.listarDependencias().get(i).getNombre());
            }
        }
    }
    
    public void listarTabla(){
        info = objeto2.listarInfo();
        if (info != null) {
            Object datos[][] = new Object[info.size()][6];
            String titulos[] = {"Nombre", "Dependencia", "Semana", "Flexible", "Hora Inicio Promedio"};
            for (int i = 0; i < info.size(); i++) {
                datos[i][0] = info.get(i).getNombre_persona();
                datos[i][1] = info.get(i).getDependencia();
                datos[i][2] = info.get(i).getNombre_semana();
                if(info.get(i).isFlexible()) datos[i][3] = "Si"; else datos[i][3] = "No";
                datos[i][4] = info.get(i).getH_in();
            }
            DefaultTableModel Tabla = new DefaultTableModel(datos, titulos);
            tablaInfo.setModel(Tabla);
        }
    }
    
    public void listarTablaFilter(){
        if(comboSemana.getSelectedItem() == null || comboDependencia.getSelectedItem() == null){
            
        }else{
         String s = comboSemana.getSelectedItem().toString(), d = comboDependencia.getSelectedItem().toString();
         info = objeto2.listarInfo(s, d);
            if (info != null) {
                Object datos[][] = new Object[info.size()][6];
                String titulos[] = {"Nombre", "Dependencia", "Semana", "Flexible", "Hora Inicio Promedio"};
                for (int i = 0; i < info.size(); i++) {
                    datos[i][0] = info.get(i).getNombre_persona();
                    datos[i][1] = info.get(i).getDependencia();
                    datos[i][2] = info.get(i).getNombre_semana();
                    if(info.get(i).isFlexible()) datos[i][3] = "Si"; else datos[i][3] = "No";
                    datos[i][4] = info.get(i).getH_in();
                }
                DefaultTableModel Tabla = new DefaultTableModel(datos, titulos);
                tablaInfo.setModel(Tabla);
            }   
        }
    }
    
    public void JFRAME() {
        try {
            /*confirmacion de salida*/
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener( new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);//hacemos visible el frame
        }catch (Exception e) {
        }
    }
    
    public void confirmarSalida(){
        int i =JOptionPane.showConfirmDialog(this,"¿Está seguro que desea salir del programa?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(i==0){
            try {
            archivo.setSystem(objeto2);
            archivo.guardar();        
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al Guardar el Archivo "+ ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }  
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

        jPanel3 = new javax.swing.JPanel();
        tabAgregarDatos = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaInfo = new javax.swing.JTable();
        comboSemana = new javax.swing.JComboBox<>();
        comboDependencia = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoID = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filtre un resultado de búsqueda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaInfo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaInfo);
        if (tablaInfo.getColumnModel().getColumnCount() > 0) {
            tablaInfo.getColumnModel().getColumn(0).setResizable(false);
        }

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnTodos.setText("Mostrar Todo");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFiltrar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFiltrar)
                        .addComponent(btnTodos)))
                .addContainerGap())
        );

        tabAgregarDatos.addTab("Visualizar información", jPanel2);

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Arrastre aquí el archivo de excel"
            }
        ));
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaDatos);
        if (tablaDatos.getColumnModel().getColumnCount() > 0) {
            tablaDatos.getColumnModel().getColumn(0).setResizable(false);
        }

        btnAdd.setText("Agregar Información de Semana");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Semana:");

        jLabel2.setText("Identificador:");

        campoID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoIDKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoID)
                    .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabAgregarDatos.addTab("Agregar datos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabAgregarDatos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabAgregarDatos)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String nombre_semana = campoNombre.getText();
        String id_semana = campoID.getText();
        if(tablaDatos.getValueAt(0, 0) == null){
            JOptionPane.showMessageDialog(this, "Arrastre primero un archivo de excel con información válida.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }else{
            if(id_semana.isEmpty() || nombre_semana.isEmpty()){
                JOptionPane.showMessageDialog(this, "Complete todos los campos requeridos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                int idsem = Integer.parseInt(campoID.getText());
                if(objeto2.verficarSemana(idsem, nombre_semana)){
                    int filas = tablaDatos.getRowCount();
                    int columns = tablaDatos.getColumnCount();
                    for(int i = 0; i < filas; i++){
                       objeto2.addInfo(tablaDatos.getValueAt(i, 0).toString(), i, idsem, tablaDatos.getValueAt(i, 1).toString(), 
                               tablaDatos.getValueAt(i, 2).toString(), tablaDatos.getValueAt(i, 3).toString(), 
                               tablaDatos.getValueAt(i, 4).toString(), nombre_semana);
                       objeto2.addDependencia(tablaDatos.getValueAt(i, 1).toString());
                    }
                    JOptionPane.showMessageDialog(this, "Información agregada con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    listar();
                }else{
                    JOptionPane.showMessageDialog(this, "Ya existe un grupo de ifnromación con el mismo nombre o identificador", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
//            String original = "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýÿ";
//            // Cadena de caracteres ASCII que reemplazarán los originales.
//            String ascii = "AAAAAAACEEEEIIIIDNOOOOOOUUUUYBaaaaaaaceeeeiiiionoooooouuuuyy";
//            String output = tablaDatos.getValueAt(tablaDatos.getSelectedRow(), tablaDatos.getSelectedColumn()).toString();
//            for (int i = 0; i < original.length(); i++) {
//                // Reemplazamos los caracteres especiales.
//
//                output = output.replace(original.charAt(i), ascii.charAt(i));
//
//            }
//            System.out.println(tablaDatos.getValueAt(tablaDatos.getSelectedRow(), tablaDatos.getSelectedColumn()).toString());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void campoIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIDKeyTyped
        Consume(evt);
        if(campoID.getText().length()==10){
            evt.consume();
        }
    }//GEN-LAST:event_campoIDKeyTyped

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        listarTablaFilter();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        listarTabla();
    }//GEN-LAST:event_btnTodosActionPerformed
    
    private void Consume(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if(c < '0' || c > '9'){
            evt.consume();
        }
    }
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
            java.util.logging.Logger.getLogger(DRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DRHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DRHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JComboBox<String> comboDependencia;
    private javax.swing.JComboBox<String> comboSemana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabAgregarDatos;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTable tablaInfo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajflex;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;
import pruebajflex.Token;

/**
 *
 * @author jesfrin
 */
public class FramePrincipal extends javax.swing.JFrame {

    private UndoManager editManager;
    private File rutaDeArchivo;
    private boolean archivoEstaGuardado;
    private boolean seHaTerminadoElAnalisis;
    private ArrayList<Lexema> listaDeLexemas;

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        editManager = new UndoManager();
        rutaDeArchivo = null;
        seHaTerminadoElAnalisis = false;
        listaDeLexemas = new ArrayList<>();
        initComponents();
        oyenteDeEdicion();
        accionAlCerrar();
        this.estadoGuardadoLabel.setText("SIN GUARDAR");
    }

    private String Copiar;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoSinAnalizarTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoAnalizadoTextArea = new javax.swing.JTextArea();
        erroresLabel = new javax.swing.JLabel();
        analisisCompletoLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        erroresTextArea = new javax.swing.JTextArea();
        numeroDeFilaLabel = new javax.swing.JLabel();
        numeroDeColumnaLabel = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        analizarButton = new javax.swing.JButton();
        reporteDeTokensButton = new javax.swing.JButton();
        nuevoAnalisisButton = new javax.swing.JButton();
        estLabel = new javax.swing.JLabel();
        estadoGuardadoLabel = new javax.swing.JLabel();
        archivoActualLabel = new javax.swing.JLabel();
        archActualLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        miMenuBar = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        cargarArchivoMenuItem = new javax.swing.JMenuItem();
        guardarMenuItem = new javax.swing.JMenuItem();
        guardarComoMenuItem = new javax.swing.JMenuItem();
        nuevoMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        copiarMenuItem = new javax.swing.JMenuItem();
        pegarMenuItem = new javax.swing.JMenuItem();
        deshacerMenuItem = new javax.swing.JMenuItem();
        rehacerMenuItem = new javax.swing.JMenuItem();
        informacionMenu = new javax.swing.JMenu();
        acercaDeMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoSinAnalizarTextArea.setColumns(20);
        textoSinAnalizarTextArea.setRows(5);
        textoSinAnalizarTextArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textoSinAnalizarTextAreaCaretUpdate(evt);
            }
        });
        textoSinAnalizarTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoSinAnalizarTextAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(textoSinAnalizarTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );

        textoAnalizadoTextArea.setEditable(false);
        textoAnalizadoTextArea.setColumns(20);
        textoAnalizadoTextArea.setRows(5);
        jScrollPane2.setViewportView(textoAnalizadoTextArea);

        erroresLabel.setText("Errores analisis lexico:");

        analisisCompletoLabel.setText("Analisis lexico:");

        erroresTextArea.setColumns(20);
        erroresTextArea.setRows(5);
        jScrollPane3.setViewportView(erroresTextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(analisisCompletoLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(erroresLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(analisisCompletoLabel)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(erroresLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        numeroDeFilaLabel.setText("#Fila:");

        numeroDeColumnaLabel.setText("#Columna:");

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        analizarButton.setText("Analisis lexico");
        analizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(analizarButton);

        reporteDeTokensButton.setText("Reporte de tokens");
        reporteDeTokensButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteDeTokensButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(reporteDeTokensButton);

        nuevoAnalisisButton.setText("Nuevo Analisis");
        nuevoAnalisisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoAnalisisButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(nuevoAnalisisButton);

        estLabel.setText("Estado:");

        archivoActualLabel.setText("Archivo actual:");

        jButton1.setText("Analisis sintactico");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        archivoMenu.setText("Archivo");

        cargarArchivoMenuItem.setText("Abrir archivo");
        cargarArchivoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(cargarArchivoMenuItem);

        guardarMenuItem.setText("Guardar");
        guardarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(guardarMenuItem);

        guardarComoMenuItem.setText("Guardar como");
        guardarComoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(guardarComoMenuItem);

        nuevoMenuItem.setText("Nuevo");
        nuevoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(nuevoMenuItem);

        miMenuBar.add(archivoMenu);

        jMenu2.setText("Edicion");

        copiarMenuItem.setText("Copiar");
        copiarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(copiarMenuItem);

        pegarMenuItem.setText("Pegar");
        pegarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(pegarMenuItem);

        deshacerMenuItem.setText("Deshacer");
        deshacerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deshacerMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(deshacerMenuItem);

        rehacerMenuItem.setText("Rehacer");
        rehacerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rehacerMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(rehacerMenuItem);

        miMenuBar.add(jMenu2);

        informacionMenu.setText("Informacion");

        acercaDeMenuItem.setText("Acerca de ");
        acercaDeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeMenuItemActionPerformed(evt);
            }
        });
        informacionMenu.add(acercaDeMenuItem);

        miMenuBar.add(informacionMenu);

        setJMenuBar(miMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroDeFilaLabel)
                            .addComponent(numeroDeColumnaLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(estLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estadoGuardadoLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(archivoActualLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(archActualLabel))
                            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numeroDeFilaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numeroDeColumnaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estLabel)
                            .addComponent(estadoGuardadoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(archivoActualLabel)
                            .addComponent(archActualLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(309, 309, 309))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarButtonActionPerformed
        String texto = this.textoSinAnalizarTextArea.getText();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aun no existe texto por analizar");
        } else {
            boolean hayErrores = false;
            boolean seguir = true;
            Lexer analizador = new Lexer(new StringReader(texto));
            while (seguir) {
                try {
                    Token miToken = analizador.yylex();
                    if (miToken == null) {
                        seguir = false;
                        this.seHaTerminadoElAnalisis = true;
                        break;
                    }
                    switch (miToken) {
                        case ERROR:
                            this.textoAnalizadoTextArea.append(escribirDatosDeAnalisisLexico(analizador.getLexemaActual()));
                            hayErrores=true;
                            listaDeLexemas = new ArrayList<>();
                            break;
                        default:
                            this.textoAnalizadoTextArea.append(escribirDatosDeAnalisisLexico(analizador.getLexemaActual()));
                            if (!hayErrores) {
                                listaDeLexemas.add(analizador.getLexemaActual());
                            }
                            break;
                    }
                } catch (IOException e) {
                    seguir = false;
                    break;
                }
            }
        }
        
        for (Lexema listaDeLexema : listaDeLexemas) {
            System.out.println("Token:"+listaDeLexema.getLexema());   
        }

    }//GEN-LAST:event_analizarButtonActionPerformed

    private void cargarArchivoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoMenuItemActionPerformed
        //http://www.decodigo.com/java-leer-un-archivo-de-texto
        abrirArchivo();
    }//GEN-LAST:event_cargarArchivoMenuItemActionPerformed

    private void nuevoAnalisisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoAnalisisButtonActionPerformed
        if (seHaTerminadoElAnalisis) {
            this.textoAnalizadoTextArea.setText("");
            this.erroresTextArea.setText("");
            this.seHaTerminadoElAnalisis = false;
            this.listaDeLexemas = new ArrayList<>();
        } else {
            JOptionPane.showMessageDialog(this, "Aun no se ha analizado, o se esta en ese proceso");
        }
    }//GEN-LAST:event_nuevoAnalisisButtonActionPerformed

    private void textoSinAnalizarTextAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textoSinAnalizarTextAreaCaretUpdate
        int pos = evt.getDot(); //mira los pasos del puntero
        try {
            int fila = textoSinAnalizarTextArea.getLineOfOffset(pos) + 1; //devuelve la fila
            int columna = pos - textoSinAnalizarTextArea.getLineStartOffset(fila - 1) + 1; //devuelve la columna
            this.numeroDeColumnaLabel.setText("#Columna:" + " " + columna + "");
            this.numeroDeFilaLabel.setText("#Fila:" + " " + fila);

        } catch (BadLocationException exc) {
        }
    }//GEN-LAST:event_textoSinAnalizarTextAreaCaretUpdate

    private void guardarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMenuItemActionPerformed
        guardarArchivo();
    }//GEN-LAST:event_guardarMenuItemActionPerformed

    private void copiarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copiarMenuItemActionPerformed
        this.textoSinAnalizarTextArea.copy();
    }//GEN-LAST:event_copiarMenuItemActionPerformed

    private void pegarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegarMenuItemActionPerformed
        this.textoSinAnalizarTextArea.paste();
    }//GEN-LAST:event_pegarMenuItemActionPerformed

    private void deshacerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deshacerMenuItemActionPerformed
        if (editManager.canUndo()) {
            editManager.undo();
        }
    }//GEN-LAST:event_deshacerMenuItemActionPerformed

    private void rehacerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rehacerMenuItemActionPerformed
        if (editManager.canRedo()) {
            editManager.redo();
        }
    }//GEN-LAST:event_rehacerMenuItemActionPerformed

    private void nuevoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoMenuItemActionPerformed
        if (!this.archivoEstaGuardado) {
            int opcion = JOptionPane.showConfirmDialog(this, "Desea guardar el archivo actual");
            switch (opcion) {
                //Case -1 cerro la ventana
                case 0://Acepta guardar el archivo
                    guardarArchivo();
                    this.textoSinAnalizarTextArea.setText("");
                    this.archivoEstaGuardado = false;
                    this.estadoGuardadoLabel.setText("SIN GUARDAR");
                    this.rutaDeArchivo = null;
                    this.archActualLabel.setText("");
                    break;
                case 1:
                    //No desea guardar el archivo
                    this.textoSinAnalizarTextArea.setText("");
                    this.archivoEstaGuardado = false;
                    this.estadoGuardadoLabel.setText("SIN GUARDAR");
                    this.rutaDeArchivo = null;
                    this.archActualLabel.setText("");
                    break;
                //case 2://Cancelo la opcion
            }
        } else {
            JOptionPane.showMessageDialog(this, "El archivo actual ya ha sido guardado");
        }

    }//GEN-LAST:event_nuevoMenuItemActionPerformed

    private void guardarComoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoMenuItemActionPerformed
        try {
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();
            if (guarda != null) {
                //Eliminar el archivo actual
                FileWriter save = new FileWriter(guarda);//guardamos el archivo
                save.write(textoSinAnalizarTextArea.getText());
                save.close();
                JOptionPane.showMessageDialog(null,
                        "El archivo se a guardado Exitosamente",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
                rutaDeArchivo = guarda;
                this.archivoEstaGuardado = true;
                this.estadoGuardadoLabel.setText("GUARDADO");
                this.archActualLabel.setText(buscarNombreDeArchivo(rutaDeArchivo));

            }//Al ser archivo nullo no realizara accion
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha guardado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_guardarComoMenuItemActionPerformed

    private void textoSinAnalizarTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoSinAnalizarTextAreaKeyPressed
        this.archivoEstaGuardado = false;
        this.estadoGuardadoLabel.setText("SIN GUARDAR");
    }//GEN-LAST:event_textoSinAnalizarTextAreaKeyPressed

    private void reporteDeTokensButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteDeTokensButtonActionPerformed

        if (listaDeLexemas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se puede crear el reporte");
        } else {
            JOptionPane.showMessageDialog(this, "Se pude crear el reporte");
            listadoDeTokensJDialog nuevoReporte = new listadoDeTokensJDialog(this,true, this.listaDeLexemas);
            nuevoReporte.setVisible(true);
        }
    }//GEN-LAST:event_reporteDeTokensButtonActionPerformed

    private void acercaDeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeMenuItemActionPerformed
        JOptionPane.showMessageDialog(this,
                "Universidad de Sancarlos De Guatemala" + "\n"
                + "Ingenieria en Ciencias y sistemas" + "\n"
                + "Desarrollador:Jesfrin Jesser Gonzale Fuentes" + "\n"
                + "Carnet:201630978");
    }//GEN-LAST:event_acercaDeMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AnalizadorSintactico.realizarAnalisisSintactico(listaDeLexemas);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void accionAlCerrar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
        } catch (Exception e) {
        }
    }

    private void confirmarSalida() {
        if (archivoEstaGuardado == false) {
            int opcion = JOptionPane.showConfirmDialog(this, "Desea guardar los cambios en el archivo");
            if (opcion == 0) {
                guardarArchivo();
                System.exit(0);
            } else if (opcion == 1) {
                System.exit(0);
            } else {//Cerro o dio cancelar, sin acciones

            }
        } else {
            System.exit(0);
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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acercaDeMenuItem;
    private javax.swing.JLabel analisisCompletoLabel;
    private javax.swing.JButton analizarButton;
    private javax.swing.JLabel archActualLabel;
    private javax.swing.JLabel archivoActualLabel;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenuItem cargarArchivoMenuItem;
    private javax.swing.JMenuItem copiarMenuItem;
    private javax.swing.JMenuItem deshacerMenuItem;
    private javax.swing.JLabel erroresLabel;
    private javax.swing.JTextArea erroresTextArea;
    private javax.swing.JLabel estLabel;
    private javax.swing.JLabel estadoGuardadoLabel;
    private javax.swing.JMenuItem guardarComoMenuItem;
    private javax.swing.JMenuItem guardarMenuItem;
    private javax.swing.JMenu informacionMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuBar miMenuBar;
    private javax.swing.JButton nuevoAnalisisButton;
    private javax.swing.JMenuItem nuevoMenuItem;
    private javax.swing.JLabel numeroDeColumnaLabel;
    private javax.swing.JLabel numeroDeFilaLabel;
    private javax.swing.JMenuItem pegarMenuItem;
    private javax.swing.JMenuItem rehacerMenuItem;
    private javax.swing.JButton reporteDeTokensButton;
    private javax.swing.JTextArea textoAnalizadoTextArea;
    private javax.swing.JTextArea textoSinAnalizarTextArea;
    // End of variables declaration//GEN-END:variables

    public String escribirDatosDeAnalisisLexico(Lexema lexemaActual) {
        return "Fila:" + lexemaActual.getFila() + " " + "Columna:" + lexemaActual.getColumna() + " " + "Lexema:" + lexemaActual.getLexema() + " " + "Token:" + lexemaActual.getToken() + "\n";
    }

    public void escribirAnalisis(String textoAnalizado) {
        this.textoAnalizadoTextArea.append(textoAnalizado);
    }

    public void escribirError(String textoAnalizado) {
        this.erroresTextArea.append(textoAnalizado);
    }

    public void oyenteDeEdicion() {
        textoSinAnalizarTextArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                editManager.addEdit(e.getEdit());
            }
        });
    }

    public void llamarFileChosserNuevoArchivo() throws Exception {
        File rutaAnterior = rutaDeArchivo;
        String texto = "";
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);
        this.rutaDeArchivo = file.getSelectedFile();
        if (rutaDeArchivo != null) {
            this.textoSinAnalizarTextArea.setText("");
            FileReader archivos = new FileReader(this.rutaDeArchivo);
            BufferedReader lee = new BufferedReader(archivos);
            while ((texto = lee.readLine()) != null) {
                this.textoSinAnalizarTextArea.append(texto + "\n");
            }
            lee.close();
            this.archivoEstaGuardado = false;
            this.estadoGuardadoLabel.setText("SIN GUARDAR");
            this.archActualLabel.setText(buscarNombreDeArchivo(rutaDeArchivo));
        } else {//Cancelo la accion
            rutaDeArchivo = rutaAnterior;
            if (rutaDeArchivo == null) {
                this.archActualLabel.setText("");
            } else {
                this.archActualLabel.setText(buscarNombreDeArchivo(rutaDeArchivo));

            }
        }

    }

    public void abrirArchivo() {
        try {
            if (this.archivoEstaGuardado) {
                JOptionPane.showMessageDialog(this, "El archivo ya habia sido guardado");
                llamarFileChosserNuevoArchivo();
            } else {
                int opcion = JOptionPane.showConfirmDialog(this, "Desea guardar el archivo actual?");
                switch (opcion) {
                    //Case -1 cerro la ventana
                    case 0://Acepta guardar el archivo
                        guardarArchivo();
                        llamarFileChosserNuevoArchivo();
                        break;
                    case 1:
                        //No desea guardar el archivo
                        llamarFileChosserNuevoArchivo();
                        break;
                    //case 2://Cancelo la opcion
                }
            }
            this.archivoEstaGuardado = false;
            this.estadoGuardadoLabel.setText("SIN GUARDAR");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Existio un problema al intentarl leer el archivo");
        }

    }

    public void guardarArchivo() {
        if (this.archivoEstaGuardado) {
            JOptionPane.showMessageDialog(this, "Archivo guardado");
        } else {
            try {
                if (rutaDeArchivo == null) {
                    String nombre = "";
                    JFileChooser file = new JFileChooser();
                    file.showSaveDialog(this);
                    rutaDeArchivo = file.getSelectedFile();

                    if (rutaDeArchivo != null) {
                        FileWriter save = new FileWriter(rutaDeArchivo);//guardamos el archivo
                        save.write(textoSinAnalizarTextArea.getText());
                        save.close();
                        JOptionPane.showMessageDialog(null,
                                "El archivo se a guardado Exitosamente",
                                "Información", JOptionPane.INFORMATION_MESSAGE);
                        this.archivoEstaGuardado = true;
                        this.estadoGuardadoLabel.setText("GUARDADO");
                        this.archActualLabel.setText(buscarNombreDeArchivo(rutaDeArchivo));
                    } else {//Si rutaDeArchivo es null la accion sera cancelada
                        this.archivoEstaGuardado = false;
                        this.estadoGuardadoLabel.setText("SIN GUARDAR");
                        this.archActualLabel.setText("");
                    }
                } else {
                    FileWriter save = new FileWriter(rutaDeArchivo);//guardamos el archivo
                    save.write(textoSinAnalizarTextArea.getText());
                    save.close();
                    JOptionPane.showMessageDialog(null,
                            "El archivo se a guardado Exitosamente",
                            "Información", JOptionPane.INFORMATION_MESSAGE);
                    this.archivoEstaGuardado = true;
                    this.estadoGuardadoLabel.setText("GUARDADO");
                    this.archActualLabel.setText(buscarNombreDeArchivo(rutaDeArchivo));
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Su archivo no se ha guardado",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    public String buscarNombreDeArchivo(File ruta) {
        String[] divRuta = ruta.toString().split("/");
        String nombreDeArchivo = divRuta[divRuta.length - 1];
        return nombreDeArchivo;
    }

    public void setSeHaTerminadoElAnalisis(boolean seHaTerminadoElAnalisis) {
        this.seHaTerminadoElAnalisis = seHaTerminadoElAnalisis;
    }

}
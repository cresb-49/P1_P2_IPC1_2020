/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto2.gui;

import com.carlos.proyecto2.Casillas.CasillaPropiedad;
import com.carlos.proyecto2.Casillas.CasillaPropiedadEstacion;
import com.carlos.proyecto2.Casillas.CasillaPropiedadLugar;
import com.carlos.proyecto2.Casillas.CasillaPropiedadServicioBasico;
import com.carlos.proyecto2.Casillas.Casillas;
import com.carlos.proyecto2.Jugador.Jugador;
import com.carlos.proyecto2.Jugador.ListaJugadores;
import com.carlos.proyecto2.Tablero.Tablero;
import javax.swing.JOptionPane;

/**
 *
 * @author benjamin
 */
public class EditorDeJugadoresJDialog extends javax.swing.JDialog{
    private ListaJugadores jugadoresCargados;
    private int numeroDeJugadoresConfigurados;
    private float dineroInicialJugadores;
    private Tablero tableroCargado;
    /**
     * Creates new form EditorDeJugadoresJDialog
     */
    public EditorDeJugadoresJDialog(java.awt.Frame parent, boolean modal,ListaJugadores jugadoresCargados,Tablero tableroCargado,int jugadoresC,float dineroInicialJugadores) {
        super(parent,"Editor de jugadores", modal);
        this.tableroCargado=tableroCargado;
        this.jugadoresCargados=jugadoresCargados;
        this.numeroDeJugadoresConfigurados=jugadoresC;
        this.dineroInicialJugadores=dineroInicialJugadores;
        initComponents();
        cargarDatos();
        valorLabel(this.numeroDeJugadoresConfigurados);
        cambiosEnOpciones();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        System.out.println(this.jugadoresCargados.jugadoresIngresados());        
    }
    /**
     * SE CARGAN LOS DAROS EN LOS ELEMENTOS VISUALES
     */
    private void cargarDatos(){
        JugadoresjComboBox.removeAllItems();
        JugadoresjComboBox.addItem("");
        Jugador temporal=jugadoresCargados.getRaiz();
        JugadoresjComboBox.addItem(temporal.getNombreJugador());
        temporal=temporal.getJugadorSiguiente();
        while(temporal!=jugadoresCargados.getRaiz()){
            JugadoresjComboBox.addItem(temporal.getNombreJugador());
            temporal=temporal.getJugadorSiguiente();
        }
        
    }
    
    private void valorLabel(int opcion){
        if(opcion==2){
            jLabel4.setText("2");
        }
        if(opcion==3){
            jLabel4.setText("3");
        }
        if(opcion==4){
            jLabel4.setText("4");
        }
        if(opcion==5){
            jLabel4.setText("5");
        }
        if(opcion==6){
            jLabel4.setText("6");
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

        jLabel2 = new javax.swing.JLabel();
        NombreJugadorjTextField = new javax.swing.JTextField();
        ValidarCambiosjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        EliminarjButton = new javax.swing.JButton();
        AgregarjButton = new javax.swing.JButton();
        JugadoresjComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel2.setText("Nombre del jugador");

        ValidarCambiosjButton.setText("Validar Cambios");
        ValidarCambiosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidarCambiosjButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugadores De La Partida");

        EliminarjButton.setText("Eliminar");
        EliminarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarjButtonActionPerformed(evt);
            }
        });

        AgregarjButton.setText("Agregar");
        AgregarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarjButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de jugadores configurados para la partida:");

        jLabel4.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ValidarCambiosjButton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(NombreJugadorjTextField)
                            .addComponent(JugadoresjComboBox, 0, 145, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EliminarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgregarjButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JugadoresjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(EliminarjButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarjButton)
                    .addComponent(jLabel2)
                    .addComponent(NombreJugadorjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ValidarCambiosjButton)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * VALIDACION DE LOS JUGADORES DE ENTRADA
     * @param evt
     */
    private void ValidarCambiosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidarCambiosjButtonActionPerformed
        
        int ingresados = this.jugadoresCargados.jugadoresIngresados();
        if(ingresados==this.numeroDeJugadoresConfigurados)
        {
            JOptionPane.showMessageDialog(this, "Los datos son correctos","Campos correctos",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Datos erroneos no concuerdan la cantidad de jugadores","Error de validacion",JOptionPane.INFORMATION_MESSAGE);
        }
        cargarDatos();
    }//GEN-LAST:event_ValidarCambiosjButtonActionPerformed
    /**
     * INGRESO DE JUGADOR NUEVO EN LA LISTA
     * @param evt
     */
    private void AgregarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarjButtonActionPerformed
        // TODO add your handling code here:
        if(!NombreJugadorjTextField.getText().equals("")){
            if(!this.jugadoresCargados.buscarJugador(NombreJugadorjTextField.getText())){
                Jugador temporal = new Jugador(NombreJugadorjTextField.getText(), this.dineroInicialJugadores);
                this.jugadoresCargados.agregar(temporal);
                JOptionPane.showMessageDialog(this, "Jugador Ingresado exitosamente", "Ingresado", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Nombre de jugador ya ingresado", "Error", JOptionPane.WARNING_MESSAGE);
                
            }
        }
        cambiosEnOpciones();
        cargarDatos();
    }//GEN-LAST:event_AgregarjButtonActionPerformed
    /**
     * ELIMINACION DE UN JUGADOR
     * @param evt
     */
    private void EliminarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarjButtonActionPerformed
        // TODO add your handling code here:
        String nombreJugadorEliminar = (String)JugadoresjComboBox.getSelectedItem();
        Casillas temporal= this.tableroCargado.getCasillasDelTablero().getRaiz();
        //BUSCAMOS SI EL JUGADOR ERA DUENO DE ALGUNA PROPIEDAD Y REINICIAMOS LAS PORPIEDADES
        for (int i = 0; i < 40; i++) {
            if((temporal instanceof CasillaPropiedadLugar)||(temporal instanceof CasillaPropiedadEstacion)||(temporal instanceof CasillaPropiedadServicioBasico))
            {
                if(temporal instanceof CasillaPropiedadLugar){
                    CasillaPropiedadLugar temporal2 = (CasillaPropiedadLugar)temporal;
                    if(temporal2.getJugadorDuenio().equals(nombreJugadorEliminar)){
                        temporal2.setJugadorDuenio("");
                        temporal2.setEstadoHipoteca(false);
                        temporal2.setCantidadCasas(0);
                        temporal2.setCantidadHoteles(0);
                        
                    }
                }
                if(temporal instanceof CasillaPropiedadEstacion){
                    CasillaPropiedadEstacion temporal2 = (CasillaPropiedadEstacion)temporal;
                    if(temporal2.getJugadorDuenio().equals(nombreJugadorEliminar)){
                        temporal2.setJugadorDuenio("");
                        temporal2.setEstadoHipoteca(false);
                    }
                }
                if(temporal instanceof CasillaPropiedadServicioBasico){
                    CasillaPropiedadServicioBasico temporal2 = (CasillaPropiedadServicioBasico)temporal;
                    if(temporal2.getJugadorDuenio().equals(nombreJugadorEliminar)){
                        temporal2.setJugadorDuenio("");
                        temporal2.setEstadoHipoteca(false);
                    }
                }
            }
            temporal=temporal.getCasillaSiguiente();
        }
        jugadoresCargados.eliminar(nombreJugadorEliminar);
        cambiosEnOpciones();
        cargarDatos();
        
    }//GEN-LAST:event_EliminarjButtonActionPerformed
    /**
     * SEGUN EL TIPO DE CONFIGURACION SE PUEDE HABILITAR LA OPCION DE ELIMINAR JUGADOR O AGREGAR JUGADOR
     */
    private void cambiosEnOpciones(){
        int ingresados = this.jugadoresCargados.jugadoresIngresados();
        if(ingresados<this.numeroDeJugadoresConfigurados){
            AgregarjButton.setEnabled(true);
        }
        else
        {
            AgregarjButton.setEnabled(false);
        }
        if(ingresados>this.numeroDeJugadoresConfigurados){
            EliminarjButton.setEnabled(true);
        }
        else
        {
            EliminarjButton.setEnabled(false);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarjButton;
    private javax.swing.JButton EliminarjButton;
    private javax.swing.JComboBox<String> JugadoresjComboBox;
    private javax.swing.JTextField NombreJugadorjTextField;
    private javax.swing.JButton ValidarCambiosjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}

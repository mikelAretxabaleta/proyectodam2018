package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaEquiposModel extends AbstractTableModel {

    private String[] columnas = {"Nombre", "Codigo", "Ganados", "Empatados", "perdidos"};

    private int viaje;
    private List<Equipo> equipos;

    public TablaEquiposModel() {
        this.viaje = -1;
        equipos = new ArrayList<Equipo>();
    }

    public TablaEquiposModel(int jugador) throws SQLException, ClassNotFoundException {
        this.viaje = viaje;
        equipos = EquiposVer.equipos();
    }

    public void actualizarLista() throws SQLException, ClassNotFoundException {

        equipos.clear();
        equipos = EquiposVer.equipos();

    }

    @Override
    public int getRowCount() {
        return equipos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Equipo e = equipos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return e.getNombreequi();
            case 1:
                return e.getCodigoequi();
            case 2:
                return e.getGanandos();
            case 3:
                return e.getEmpates();
            case 4:
                return e.getPerdidos();

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}
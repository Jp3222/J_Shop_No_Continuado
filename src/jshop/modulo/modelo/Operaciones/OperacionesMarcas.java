/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo.modelo.Operaciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jshop.modulo.modelo.Const;
import jshop.modulo.modelo.Objetos.OMarcas;

/**
 *
 * @author jp
 */
public class OperacionesMarcas extends Operaciones implements Funciones {

    private final String TABLA = "marcas";
    private final String[] CAMPOS = Const.getBD_MARCAS();

    @Override
    public boolean agregar(String[] o) {
        return super.add(TABLA, CAMPOS, o);
    }

    @Override
    public boolean remover(String where) {
        return super.remove(TABLA, where);
    }

    @Override
    public boolean actualizar(String campos[], String valores[], String where) {
        return super.update(TABLA, campos, valores, where);
    }

    @Override
    public boolean actualizar(String campo, String valor, String where) {
        return super.update(TABLA, campo, valor, where);
    }

    @Override
    public ArrayList<OMarcas> getLista(String where) {
        try {
            ResultSet rs = super.get(TABLA, "*", where);
            ArrayList<OMarcas> lista = new ArrayList<>();
            int i;
            while (rs.next()) {
                i = 0;
                String[] o = new String[CAMPOS.length];
                for (String campo : CAMPOS) {
                    o[i] = rs.getString(campo);
                }
                OMarcas p = new OMarcas(o);
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public OMarcas getObjeto(String where) {
        try {
            ResultSet rs = super.get(TABLA, "*", where);

            if (rs.next()) {
                int i = 0;
                String[] o = new String[CAMPOS.length];
                for (String campo : CAMPOS) {
                    o[i] = rs.getString(campo);
                }
                OMarcas p = new OMarcas(o);
                return p;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}

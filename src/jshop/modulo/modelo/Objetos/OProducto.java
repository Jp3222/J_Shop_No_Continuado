/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jshop.modulo.modelo.Objetos;

/**
 * @author juan pablo Clase que abstrae y contiene la informacion de los
 * productos de la base de datos a un objeto
 */
public class OProducto extends Objeto {

    private String clave, nombre, contenido, udm, img;
    private int marca;
    private double precio;

    public OProducto(String[] info) {
        super(info);
        this.clave = info[1];
        this.nombre = info[2];
        this.marca = Integer.parseInt(info[3]);
        this.contenido = info[4];
        this.udm = info[5];
        this.precio = Double.parseDouble(info[6]);
        this.img = info[7];
    }

    public OProducto() {
        super(null);
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUdm() {
        return udm;
    }

    public void setUdm(String udm) {
        this.udm = udm;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean getExiste() {
        return existe;
    }

    @Override
    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    @Override
    public String[] getValores() {
        return valores;
    }

    @Override
    public void setValores(String[] valores) {
        this.valores = valores;
        this.id = Integer.parseInt(valores[0]);
        this.clave = valores[1];
        this.nombre = valores[2];
        this.marca = Integer.parseInt(valores[3]);
        this.contenido = valores[4];
        this.udm = valores[5];
        this.precio = Double.parseDouble(valores[6]);
        this.img = valores[7];
    }

}

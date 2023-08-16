/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author igorf
 */
public class Veiculo {
    
    private int idVeiculo;
    private String marca;
    private String modelo;

    public Veiculo() {
        this.idVeiculo = 0 ;
        this.marca = "";
        this.modelo = "";
        
        
    }

    public Veiculo(int idVeiculo, String marca, String modelo) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    
    
}

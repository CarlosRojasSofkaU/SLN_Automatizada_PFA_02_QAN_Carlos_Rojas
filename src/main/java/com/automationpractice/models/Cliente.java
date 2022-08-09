package com.automationpractice.models;

import lombok.Data;

@Data
public class Cliente {
    private String email;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String diaNacimiento;
    private String mesNacimiento;
    private String anoNacimiento;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String celular;
    private String estado;
    private String mensajeContactanos;
    private String pedidoReferenciaContactanos;
    private String temaContactanos;
    private Double totalOrderPrice;
}

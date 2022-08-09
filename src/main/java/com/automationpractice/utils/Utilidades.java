package com.automationpractice.utils;

import com.automationpractice.models.Cliente;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static com.automationpractice.utils.Constantes.*;

public class Utilidades {
    public static Cliente generarCliente(String lenguaje, String pais, String dominioCorreo) {

        Faker faker = Faker.instance(
                new Locale(lenguaje, pais),
                new Random()
        );

        Cliente cliente = new Cliente();
        cliente.setEmail(
                faker.name()
                        .username()
                        .concat(dominioCorreo)
                        .replace(CARACTER_ESPACIO, CARACTER_VACIO)
        );

        cliente.setNombre(faker.name().firstName());
        cliente.setApellido(faker.name().lastName());
        cliente.setContrasena(faker.number().digits(8));
        cliente.setDiaNacimiento(String.valueOf(faker.number().numberBetween(1, 28)));
        cliente.setMesNacimiento(String.valueOf(faker.number().numberBetween(1, 12)));
        cliente.setAnoNacimiento(String.valueOf(faker.number().numberBetween(1980, 2003)));

        cliente.setDireccion(faker.address().fullAddress());
        cliente.setCiudad(faker.address().city());
        cliente.setCodigoPostal(faker.address().zipCode());
        cliente.setCelular(
                String.valueOf(
                                faker
                                        .number()
                                        .numberBetween(300000000, 399999999))
                        .concat(
                                String.valueOf(
                                        faker.number()
                                                .numberBetween(1, 9)
                                )
                        )
        );
        cliente.setEstado(ESTADO_POR_DEFECTO);
        cliente.setMensajeContactanos(MENSAJE_POR_DEFECTO_CLIENTE);
        cliente.setPedidoReferenciaContactanos(String.valueOf(faker.number().numberBetween(100000, 999999)));
        cliente.setTemaContactanos(TEMA_POR_DEFECTO_CLIENTE);

        return cliente;
    }
}

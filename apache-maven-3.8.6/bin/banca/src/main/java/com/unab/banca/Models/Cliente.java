package com.unab.banca.Models;

import java.io.Serializable;

//import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//import com.nestor.banca.Validation.ValidationHandler;
//import com.nestor.banca.Models.Error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @NotEmpty(message = "El Id es Obligatorio...")
    @Column(name = "id_cliente")
    private String id_cliente;
    @NotEmpty(message = "El Nombre es Obligatorio...")
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    @NotEmpty(message = "La Clave es Obligatoria...")
    @Size(min = 4, max = 8, message = "La Clave debe estar entre cuatro y ocho caracteres")
    @Column(name = "clave_cliente")
    private String clave_cliente;

    @Override
    public String toString() {
        return "Cliente [clave_cliente=" + clave_cliente + ", id_cliente=" + id_cliente + ", nombre_cliente="
                + nombre_cliente + "]";
    }
    
}
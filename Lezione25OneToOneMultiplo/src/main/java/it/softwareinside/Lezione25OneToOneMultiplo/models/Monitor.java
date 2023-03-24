package it.softwareinside.Lezione25OneToOneMultiplo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Monitor {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @NotBlank(message = "la marca non può essere vuota o nulla")
    private String marca;
    @NotNull(message = "I pollici non possono essere null")
    private double pollici;

    public Monitor(String marca, double pollici){
        setMarca(marca);
        setPollici(pollici);
    }
}

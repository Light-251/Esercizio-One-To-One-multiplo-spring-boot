package it.softwareinside.Lezione25OneToOneMultiplo.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Computer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @NotBlank(message = "la marca non può essere vuota o nulla")
    private String marca;
    @NotNull(message = "il prezzo non può essere nullo")
    private double prezzo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monitor_id")
    private Monitor monitor;

    public Computer(String marca, double prezzo, Monitor monitor) {
        setMarca(marca);
        setPrezzo(prezzo);
        setMonitor(monitor);
    }
}

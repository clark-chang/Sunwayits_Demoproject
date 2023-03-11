package com.example.Demoproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="COIN")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@JsonPropertyOrder
        ({
        "Id",
        "Time",
        "Disclaimer",
        "Chartname",
        "Coinchinesename",
        "Bpi",
        "Code",
        "Symbol",
        "Rate",
        "Description",
        "Ratefloat"
        })
public class Coin {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Time;
    private String Disclaimer;
    private String Chartname;
    private String Coinchinesename;
    private String Bpi;
    private String Code;
    private String Symbol;
    private String Rate;
    private String Description;
    private double Ratefloat;
}

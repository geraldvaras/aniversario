package com.grupolainmaculada.aniversario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombres;
    private String apellidos;

    @Column(name = "empresanombre")
    private String empresaNombre;
    @Column(name = "empresacodigo")
    private Integer empresaCodigo;

    @Column(name = "centrocosto")
    private String centroCosto;

    @NotNull
    @Size(min=4, max=12)
    @Column(name = "numerodocumento")
    private String numeroDocumento;

    @Column(name = "anioevento")
    private String anioEvento;

    @Column(name = "descripcionevento")
    private String descripcionEvento;

    @Column(name = "tipoinvitado")
    private String tipoInvitado;

    private Boolean asistio;

    @Column(name = "fechahoraingreso")
    private LocalDateTime fechaHoraIngreso;

    @Column(name = "registradopor")
    private String registradoPor;
}

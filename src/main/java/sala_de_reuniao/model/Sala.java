package sala_de_reuniao.model;

import javax.persistence.*;

@Entity
@Table(name = "sala_de_encontro")
public class Sala {

    private long id;
    private String nomeDaSala;
    private String dataDaReserva;
    private String horarioInicio;
    private String horarioFinal;

    public Sala() {}

    public Sala(long id, String nomeDaSala, String dataDaReserva, String horarioInicial, String horarioFinal) {
        this.id = id;
        this.nomeDaSala = nomeDaSala;
        this.dataDaReserva = dataDaReserva;
        this.horarioInicio = horarioInicial;
        this.horarioFinal = horarioFinal;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nome", nullable = false)
    public String getNomeDaSala() {
        return nomeDaSala;
    }

    public void setNomeDaSala(String nomeDaSala) {
        this.nomeDaSala = nomeDaSala;
    }

    @Column(name = "data", nullable = false)
    public String getDataDaReserva() {
        return dataDaReserva;
    }

    public void setDataDaReserva(String dataDaReserva) {
        this.dataDaReserva = dataDaReserva;
    }

    @Column(name = "inicio", nullable = false)
    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    @Column(name = "fim", nullable = false)
    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    @Override
    public String toString() {
        return "Sala: " + this.nomeDaSala +
                "\nData da reserva: " + this.dataDaReserva +
                "\nHorário de Início: " + this.horarioInicio +
                "Horário do final: " + this.horarioFinal;

    }
}
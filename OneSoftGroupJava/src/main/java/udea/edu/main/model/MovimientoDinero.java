package udea.edu.main.model;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="Movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long monto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado usuario;

    public MovimientoDinero() {

    }

    public MovimientoDinero(long monto, String concepto, Empleado empleado) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return usuario;
    }

    public void setEmpleado(Empleado empleado) {
        this.usuario = empleado;
    }
}

 /* private float monto_movimiento;
    private String concepto_movimiento;

    public MovimientoDinero(float monto_movimiento, String concepto_movimiento) {
        this.monto_movimiento = monto_movimiento;
        this.concepto_movimiento = concepto_movimiento;
    }

    public float getMonto_movimiento() {
        return monto_movimiento;
    }

    public void setMonto_movimiento(float monto_movimiento) {
        this.monto_movimiento = monto_movimiento;
    }

    public String getConcepto_movimiento() {
        return concepto_movimiento;
    }

    public void setConcepto_movimiento(String concepto_movimiento) {
        this.concepto_movimiento = concepto_movimiento;
    }
    */


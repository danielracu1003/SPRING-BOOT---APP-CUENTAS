package gm.cuentas.controlador;

import gm.cuentas.modelo.cuenta;
import gm.cuentas.servicio.CuentaServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexControlador {

    @Autowired
    CuentaServicio cuentaServicio;
    private List<cuenta> cuentas;
    private cuenta cuentaSeleccionada;

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @PostConstruct
    public void init() {

        cargarDatos();
    }

    public void cargarDatos() {
        this.cuentas = cuentaServicio.ListarCuentas();
        cuentas.forEach((Cuenta) -> logger.info(Cuenta.toString()));
    }

    public void agregarCuenta() {
        logger.info("Se crear objeto cuentaSeleccionada para el caso de agregar");
        this.cuentaSeleccionada = new cuenta();
    }

    public void guardarCuenta() {
        logger.info("Cuenta a guardar: " + this.cuentaSeleccionada);
        //Agregar
        if (this.cuentaSeleccionada.getIdcuenta() == null) {
            this.cuentaServicio.guardarCuenta(this.cuentaSeleccionada);
            this.cuentas.add(this.cuentaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta Agregada"));
        } else {//Modificar ()Update)
            this.cuentaServicio.guardarCuenta(this.cuentaSeleccionada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cuenta Actualizada"));
        }

        //Oultamos la ventana
        PrimeFaces.current().executeScript("PF('ventanaModalCuenta')");
        //Actualizar la tabla
        PrimeFaces.current().ajax().update("forma-cuentas:mensajes", "forma-cuentas:cuentas-tabla");
        //reset
        this.cuentaSeleccionada = null;
    }

}


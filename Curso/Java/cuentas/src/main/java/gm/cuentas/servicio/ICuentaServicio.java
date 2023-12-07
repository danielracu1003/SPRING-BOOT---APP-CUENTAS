package gm.cuentas.servicio;

import gm.cuentas.modelo.cuenta;

import java.util.List;

public interface ICuentaServicio {
    public List<cuenta> ListarCuentas();

    public cuenta buscarCuentaPorId(Integer idCuenta);

    public void guardarCuenta(cuenta Cuenta);

    public void eliminarCuenta(cuenta Cuenta);
}


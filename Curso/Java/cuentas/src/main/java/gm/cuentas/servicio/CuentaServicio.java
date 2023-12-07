package gm.cuentas.servicio;

import gm.cuentas.modelo.cuenta;
import gm.cuentas.repositorio.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServicio implements ICuentaServicio {

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    @Override
    public List<cuenta> ListarCuentas() {
        return cuentaRepositorio.findAll();
    }

    @Override
    public cuenta buscarCuentaPorId(Integer idCuenta) {
        cuenta Cuenta = cuentaRepositorio.findById(idCuenta).orElse(null);
        return Cuenta;
            }

    @Override
    public void guardarCuenta(cuenta Cuenta) {
        cuentaRepositorio.save(Cuenta);

    }

    @Override
    public void eliminarCuenta(cuenta Cuenta) {
        cuentaRepositorio.delete(Cuenta);

    }
}

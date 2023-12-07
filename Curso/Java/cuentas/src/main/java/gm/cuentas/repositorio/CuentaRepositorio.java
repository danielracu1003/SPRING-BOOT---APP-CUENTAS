package gm.cuentas.repositorio;

import gm.cuentas.modelo.cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepositorio extends JpaRepository<cuenta, Integer> {
}

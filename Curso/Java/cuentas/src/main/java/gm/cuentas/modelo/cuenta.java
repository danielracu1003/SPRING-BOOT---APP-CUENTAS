package gm.cuentas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idcuenta;
    String nombre;
    String tipoCuenta;
    Double saldo;

  }

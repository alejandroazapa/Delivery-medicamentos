package pe.edu.upeu.deliverymedicamentos.repository;

import pe.edu.upeu.deliverymedicamentos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}


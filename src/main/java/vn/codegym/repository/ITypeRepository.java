package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.Product;
import vn.codegym.entity.Type;

public interface ITypeRepository extends JpaRepository<Type, Long> {
}

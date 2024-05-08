package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.entity.Product;
import vn.codegym.entity.Type;

import java.util.List;

public interface ITypeService {
    List<Type> findAll();
    Page<Type> findAll(Pageable pageable);
    void save(Type type);

    void update(long id,Type type);
    void remove(long id);
}

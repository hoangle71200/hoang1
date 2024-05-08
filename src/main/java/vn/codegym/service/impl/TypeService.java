package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.entity.Product;
import vn.codegym.entity.Type;
import vn.codegym.repository.IProductRepository;
import vn.codegym.repository.ITypeRepository;
import vn.codegym.service.IProductService;
import vn.codegym.service.ITypeService;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository typeRepository;
    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Page<Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public void update(long id, Type type) {
        typeRepository.save(type);
    }

    @Override
    public void remove(long id) {
        typeRepository.deleteById(id);
    }
}

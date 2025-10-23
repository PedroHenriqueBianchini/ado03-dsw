package br.com.carstore.carstore.service;

import br.com.carstore.carstore.dao.CarJpaDAO;
import br.com.carstore.carstore.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarJpaDAO carJpaDao;

    public CarServiceImpl(CarJpaDAO carJpaDao) {
        this.carJpaDao = carJpaDao;
    }

    @Override
    public List<CarDTO> findAll() {
        return carJpaDao.findAll();
    }

    @Override
    public void save(CarDTO carDTO) {
        carJpaDao.save(carDTO);
    }

    @Override
    public void deleteById(int id) {
        carJpaDao.deleteById(id);
    }

    @Override
    public void update(int id, CarDTO carDTO) {
        carJpaDao.update(id, carDTO);
    }

    @Override
    public CarDTO findById(int id) {
        return carJpaDao.findById(id);
    }
}
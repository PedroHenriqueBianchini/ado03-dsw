package br.com.carstore.carstore.dao;

import br.com.carstore.carstore.entity.CarEntity;
import br.com.carstore.carstore.model.CarDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CarJpaDAO {

    @PersistenceContext
    private EntityManager em;

    public List<CarDTO> findAll() {
        List<CarEntity> list = em.createQuery("SELECT c FROM CarEntity c", CarEntity.class)
                .getResultList();
        return list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void save(CarDTO dto) {
        CarEntity e = new CarEntity();
        e.setName(dto.getName());
        e.setColor(dto.getColor());

        em.persist(e);
        dto.setId(e.getId());
    }

    public void deleteById(int id) {
        CarEntity e = em.find(CarEntity.class, id);
        if (e != null) {
            em.remove(e);
        }
    }

    public void update(int id, CarDTO dto) {
        CarEntity e = em.find(CarEntity.class, id);
        if (e != null) {
            e.setName(dto.getName());
            e.setColor(dto.getColor());
            em.merge(e);
        }
    }

    public CarDTO findById(int id) {
        CarEntity e = em.find(CarEntity.class, id);
        return e != null ? toDto(e) : null;
    }

    private CarDTO toDto(CarEntity e) {
        CarDTO d = new CarDTO();
        d.setId(e.getId());
        d.setName(e.getName());
        d.setColor(e.getColor());
        return d;
    }
}
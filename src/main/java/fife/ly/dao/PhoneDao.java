package fife.ly.dao;

import fife.ly.entity.Phone;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PhoneDao {
    List<Phone> findAll();
}

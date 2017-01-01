package com.santy.model.mydata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MyDataService {

    @Autowired
    MyDataRepository myDataRepository;

    public List<MyData> findAll() {
        return myDataRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }
}

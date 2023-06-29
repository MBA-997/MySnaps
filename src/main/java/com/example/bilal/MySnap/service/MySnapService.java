package com.example.bilal.MySnap.service;

import com.example.bilal.MySnap.model.MySnap;
import com.example.bilal.MySnap.repository.MySnapRepository;
import org.springframework.stereotype.Service;

//@Component
@Service
public class MySnapService {

    private final MySnapRepository mySnapRepository;

    public MySnapService(MySnapRepository mySnapRepository) {
        this.mySnapRepository = mySnapRepository;
    }

    public Iterable<MySnap> get(){
        return mySnapRepository.findAll();
    }

    public MySnap get(Integer id){
        return mySnapRepository.findById(id).orElse(null);
    }

    public void remove(Integer id){
        mySnapRepository.deleteById(id);
    }

    public MySnap put(String fileName, String contentType, byte[] data){
        MySnap mySnap = new MySnap();

        mySnap.setContentType(contentType);
        mySnap.setFileName(fileName);
        mySnap.setData(data);

        mySnapRepository.save(mySnap);

        return mySnap;
    }
}

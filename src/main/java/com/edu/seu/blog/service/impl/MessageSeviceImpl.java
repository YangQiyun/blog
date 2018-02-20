package com.edu.seu.blog.service.impl;

import com.edu.seu.blog.dataobject.Total;
import com.edu.seu.blog.repository.TotalRepository;
import com.edu.seu.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MessageSeviceImpl implements MessageService{

    @Autowired
    private TotalRepository totalRepository;

    @Override
    public String getAboutMe() {
        return getTotal().getAboutMe();
    }

    @Override
    public Integer getHomeArtId() {
        return getTotal().getHomeId();
    }

    @Cacheable(cacheNames="Total",key = "#root.methodName")
    public Total getTotal(){
        return totalRepository.findAll().get(0);
    }
}

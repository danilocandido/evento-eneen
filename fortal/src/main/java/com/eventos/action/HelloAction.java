package com.eventos.action;

import javax.persistence.EntityManager;

import org.mentawai.core.BaseAction;

import com.eventos.util.JpaUtil;

//  http://localhost:8080/fortal/
public class HelloAction extends BaseAction{

	public String hi() {
		
		EntityManager manager = JpaUtil.getEntityManager();
		
        String msg = input.getString("msg");
        
        if (isEmpty(msg)) {
            msg = "Why you did not type anything?";
        }
        
        output.setValue("msg", msg);
        
        return SUCCESS;
    }
}

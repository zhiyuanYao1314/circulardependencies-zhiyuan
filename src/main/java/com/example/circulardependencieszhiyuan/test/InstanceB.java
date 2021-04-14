package com.example.circulardependencieszhiyuan.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xsls on 2019/5/29.
 */
@Component
public class InstanceB  {


    @Autowired
//    private InstanceA instanceA;
    private IApi instanceA;


    public IApi getInstanceA() {
        return instanceA;
    }


    public void setInstanceA(InstanceA instanceA) {
        this.instanceA = instanceA;
    }

    public InstanceB(InstanceA instanceA) {
        this.instanceA = instanceA;
    }


    public InstanceB() {
        System.out.println("InstanceB实例化");
    }

    @Override
    public String toString() {
        return "InstanceB{" +
                "instanceA=" + instanceA +
                '}';
    }
}

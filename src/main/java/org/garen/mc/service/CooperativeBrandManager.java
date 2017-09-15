package org.garen.mc.service;

import org.garen.mc.mybatis.domain.CooperativeBrand;
import org.garen.mc.mybatis.service.CommonsService;
import org.garen.mc.swagger.model.SuccessModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylm on 2017/9/15.
 */
@Service
public class CooperativeBrandManager extends  BaseManage<Integer>{
    @Override
    public <T, Q> CommonsService<T, Q, Integer> getService() {
        return null;
    }

    public SuccessModel getAll() {
        List<CooperativeBrand> cooperativeBrands=new ArrayList<>();
        cooperativeBrands.add(new CooperativeBrand());
        return  new SuccessModel().message(GET_ALL_SUCCESS).data(cooperativeBrands);
    }
}

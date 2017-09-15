package org.garen.mc.service;

import org.garen.mc.mybatis.domain.PartnerLinks;
import org.garen.mc.mybatis.service.CommonsService;
import org.garen.mc.mybatis.service.PartnerLinksService;
import org.garen.mc.swagger.model.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylm on 2017/9/15.
 */
@Service
public class PartnerLinksManager extends BaseManage<Integer> {
    @Autowired
    private PartnerLinksService partnerLinksService;
    @Override
    public <T, Q> CommonsService<T, Q, Integer> getService() {
        return partnerLinksService;
    }

    public SuccessModel getAll() {
        List<PartnerLinks> partnerLinksList=new ArrayList<>();
        partnerLinksList.add(new PartnerLinks());
        return new SuccessModel().message(GET_ALL_SUCCESS).data(partnerLinksList);
    }
}

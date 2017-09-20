package org.garen.mc.swagger.api;



import io.swagger.annotations.*;

import org.garen.mc.service.PartnerLinkManager;
import org.garen.mc.swagger.model.PartnerLink;
import org.garen.mc.swagger.model.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-18T23:23:41.235Z")

@Controller
public class PartnerLinkApiController implements PartnerLinkApi {
    @Autowired
    private PartnerLinkManager partnerLinkManager;


    public ResponseEntity<SuccessModel> deletePartnerLink(@ApiParam(value = "合作链接ID") @RequestParam(value = "id", required = false) Integer id) {
        SuccessModel successModel=partnerLinkManager.deletePartnerLink(id);
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getAll() {
        SuccessModel successModel=partnerLinkManager.getAll();
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByCode(@ApiParam(value = "合作链接编码") @RequestParam(value = "code", required = false) String code) {
        SuccessModel successModel=partnerLinkManager.getByCode(code);
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByName(@ApiParam(value = "合作链接名称") @RequestParam(value = "name", required = false) String name) {
        SuccessModel successModel=partnerLinkManager.getByName(name);
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "合作链接名称") @RequestParam(value = "name", required = false) String name) {
        SuccessModel successModel=partnerLinkManager.getByPage(start,length,name);
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getPartnerLink(@ApiParam(value = "合作链接ID") @RequestParam(value = "id", required = false) Integer id) {
        SuccessModel successModel=partnerLinkManager.getPartnerLink(id);
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> savePartnerLink(@ApiParam(value = "合作链接"  )  @Valid @RequestBody PartnerLink partnerLink) {
        SuccessModel successModel=partnerLinkManager.savePartnerLink(partnerLink);
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> updatePartnerLink(@ApiParam(value = "合作链接"  )  @Valid @RequestBody PartnerLink partnerLink) {
        SuccessModel successModel=partnerLinkManager.updatePartnerLink(partnerLink);
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

}

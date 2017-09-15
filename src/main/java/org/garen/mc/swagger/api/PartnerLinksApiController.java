package org.garen.mc.swagger.api;



import io.swagger.annotations.*;

import org.garen.mc.service.PartnerLinksManager;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T06:44:56.262Z")

@Controller
public class PartnerLinksApiController implements PartnerLinksApi {
    @Autowired
    private PartnerLinksManager partnerLinksManager;


    public ResponseEntity<SuccessModel> getpartnerLinks() {
        SuccessModel successModel=partnerLinksManager.getAll();
        return new ResponseEntity<SuccessModel>(successModel,HttpStatus.OK);
    }

}
package org.garen.mc.swagger.api;

import io.swagger.annotations.ApiParam;
import org.garen.mc.service.ArticleManager;
import org.garen.mc.swagger.model.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T09:10:53.583Z")

@Controller
public class ArticleApiController implements ArticleApi {
    @Autowired
    private ArticleManager articleManager;


    public ResponseEntity<SuccessModel> getHotByBoard(@ApiParam(value = "板块码") @RequestParam(value = "boardCode", required = false) String boardCode) {
        // do some magic!
        return new ResponseEntity<SuccessModel>(articleManager.getHotByBoard(boardCode),HttpStatus.OK);
    }

}

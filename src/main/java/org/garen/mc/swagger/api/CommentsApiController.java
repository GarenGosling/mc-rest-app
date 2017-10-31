package org.garen.mc.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.CommentManage;
import org.garen.mc.swagger.api.valid.CommentValid;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.Comment;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-31T02:32:35.317Z")

@Controller
public class CommentsApiController extends BaseModel implements CommentsApi {
    @Autowired
    private CommentManage commentManage;
    @Autowired
    private CommentValid commentValid;
    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteComment(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        int i=commentManage.deleteComment(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ),HttpStatus.OK);
    }

    /**
     * 分页查询
     * @param articleCode
     * @param start
     * @param length
     * @return
     */
    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "文章编码") @RequestParam(value = "articleCode", required = false) String articleCode,
        @ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length) {
        //业务
        Map page=commentManage.getByPage(start,length,articleCode);
        return new ResponseEntity<ResponseModel>(successModel("分页查询",page),HttpStatus.OK);
    }

    /**
     * 保存评论
     * @param comment
     * @return
     */
    public ResponseEntity<ResponseModel> saveComment(@ApiParam(value = "文章评论"  )  @Valid @RequestBody Comment comment) {
        //验证新增对象参数
        String msg = commentValid.savePartnerLinkValid(comment);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i=commentManage.saveComment(comment);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i),HttpStatus.OK);
    }

}

package org.garen.mc.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.mc.mybatis.domain.Author;
import org.garen.mc.remote.LoginManage;
import org.garen.mc.remote.dto.CommonResponse;
import org.garen.mc.remote.dto.LoginVo;
import org.garen.mc.service.ArticleManage;
import org.garen.mc.service.AuthorManage;
import org.garen.mc.swagger.api.valid.ArticleValid;
import org.garen.mc.swagger.model.Article;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.ResponseModel;
import org.garen.mc.util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-24T05:54:51.190Z")

@Controller
public class ArticlesApiController extends BaseModel implements ArticlesApi {
    @Autowired
    private ArticleValid articleValid;
    @Autowired
    private ArticleManage articleManage;
    @Autowired
    private LoginManage loginManage;
    @Autowired
    private AuthorManage authorManage;

    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteArticle(@ApiParam(value = "文章id",required=true ) @PathVariable("id") Long id,HttpServletRequest request) {
        Author author=authorManage.getAuthor(request);
        //验证文章是不是该作者的
        org.garen.mc.mybatis.domain.Article article1=articleManage.getById(id);
        if(author==null||!article1.getAuthorCode().equals(author.getCode()))
            return  new ResponseEntity<ResponseModel>(badRequestModel("文章不是你的，你无权删除"),HttpStatus.OK);

        //业务
        int i=articleManage.deleteCarousel(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 查询全部
     * @return
     */
    public ResponseEntity<ResponseModel> findALL() {
        //业务
        List<org.garen.mc.mybatis.domain.Article> articles=articleManage.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部",articles),HttpStatus.OK);
    }


    /**
     * id查询
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getArticle(@ApiParam(value = "文章id",required=true ) @PathVariable("id") Long id) {
        //验证
        String msg=articleValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.Article article=articleManage.getById(id);
        return new ResponseEntity<ResponseModel>(successModel("id查询",article),HttpStatus.OK);
    }

    /**
     * 统一查询
     * @param title
     * @param menuCode
     * @param subjectName
     * @param showDetail
     * @param orderBy
     * @param start
     * @param length
     * @return
     */
    public ResponseEntity<ResponseModel> findArticle(@ApiParam(value = "文章标题") @RequestParam(value = "title", required = false) String title,
                                                     @ApiParam(value = "菜单码，按照菜单码模糊查询文章菜单码全路径字段") @RequestParam(value = "menuCode", required = false) String menuCode,
                                                     @ApiParam(value = "专题名称，按照专题名称查询") @RequestParam(value = "subjectName", required = false) String subjectName,
                                                     @ApiParam(value = "是否显示文章详情，1显示，0不显示") @RequestParam(value = "showDetail", required = false) Integer showDetail,
                                                     @ApiParam(value = "排序字段") @RequestParam(value = "orderBy", required = false) String orderBy,
                                                     @ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                     @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length) {
        Map map=articleManage.findArticle(title,menuCode,subjectName,showDetail,orderBy,start,length);
        return new ResponseEntity<ResponseModel>(successModel("查询",map),HttpStatus.OK);
    }

    /**
     * 保存文章
     * @param article
     * @return
     */
    public ResponseEntity<ResponseModel> saveArticle(@ApiParam(value = "文章"  )  @Valid @RequestBody Article article, HttpServletRequest request) {
        Author author=authorManage.getAuthor(request);
        if(author==null)
            return  new ResponseEntity<ResponseModel>(badRequestModel("还未注册为作者"),HttpStatus.OK);
        //验证新增对象参数
        String msg = articleValid.saveArticleValid(article);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i=articleManage.saveArticle(article,author);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 修改文章
     * @param id
     * @param article
     * @return
     */
    public ResponseEntity<ResponseModel> updateArticle(@ApiParam(value = "文章id",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "文章"  )  @Valid @RequestBody Article article,HttpServletRequest request) {
        Author author=authorManage.getAuthor(request);
        //验证文章是不是该作者的
        org.garen.mc.mybatis.domain.Article article1=articleManage.getById(id);
        if(author==null||!article1.getAuthorCode().equals(author.getCode()))
            return  new ResponseEntity<ResponseModel>(badRequestModel("文章不是你的，你无权修改"),HttpStatus.OK);
        //验证新增对象参数
        String msg = articleValid.updateArticleValid(article);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i=articleManage.updateArticle(id,article);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }
}

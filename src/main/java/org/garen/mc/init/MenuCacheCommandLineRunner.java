package org.garen.mc.init;

import org.garen.mc.service.MenuManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 菜单启动添加缓存类
 *
 * @author yanglimou
 * @create 2017/11/9 23:44
 * @since v1.0
 */
@Component
public class MenuCacheCommandLineRunner implements CommandLineRunner{
    private Logger logger = LoggerFactory.getLogger(MenuCacheCommandLineRunner.class);
    @Autowired
    private MenuManage menuManage;
    @Override
    public void run(String... args) throws Exception {
        //一起动就将menu0加入到缓存中
        menuManage.getAndAddCacheByParencCode("0");
        logger.info("启动加入menu到缓存");
    }
}

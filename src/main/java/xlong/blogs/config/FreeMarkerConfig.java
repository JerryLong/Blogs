package xlong.blogs.config;

import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import xlong.blogs.model.tag.ArticleTagDirective;
import xlong.blogs.model.tag.CommonTagDirective;
import xlong.blogs.service.OptionsService;
import xlong.blogs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * <pre>
 *     FreeMarker配置
 * </pre>
 *
 */
@Slf4j
@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommonTagDirective commonTagDirective;

    @Autowired
    private ArticleTagDirective articleTagDirective;

    @PostConstruct
    public void setSharedVariable() {
        try {
            //自定义标签
            configuration.setSharedVariable("commonTag", commonTagDirective);
            configuration.setSharedVariable("articleTag", articleTagDirective);
            configuration.setSharedVariable("options", optionsService.findAllOptions());
            configuration.setSharedVariable("user", userService.findUser());
        } catch (TemplateModelException e) {
            log.error("自定义标签加载失败：{}", e.getMessage());
        }
    }
}

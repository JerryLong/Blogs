package xlong.blogs.web.controller.admin;

import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import xlong.blogs.model.dto.BlogConst;
import xlong.blogs.model.dto.JsonResult;
import xlong.blogs.model.enums.ResultCodeEnum;
import xlong.blogs.service.OptionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <pre>
 *     后台设置选项控制器
 * </pre>
 */
@Slf4j
@Controller
@RequestMapping("/admin/option")
public class OptionController {

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private Configuration configuration;

    /**
     * 请求跳转到option页面并完成渲染
     *
     * @return 模板路径admin/admin_option
     */
    @GetMapping
    public String options() {
        return "admin/admin_option";
    }

    /**
     * 保存设置选项
     *
     * @param options options
     * @return JsonResult
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public JsonResult saveOptions(@RequestParam Map<String, String> options) {
        try {
            optionsService.saveOptions(options);
            //刷新options
            configuration.setSharedVariable("options", optionsService.findAllOptions());
            BlogConst.OPTIONS.clear();
            BlogConst.OPTIONS = optionsService.findAllOptions();
            log.info("所保存的设置选项列表：" + options);
            return new JsonResult(ResultCodeEnum.SUCCESS.getCode(), "保存成功！");
        } catch (Exception e) {
            log.error("保存设置选项失败：{}", e.getMessage());
            return new JsonResult(ResultCodeEnum.FAIL.getCode(), "保存失败！");
        }
    }
}

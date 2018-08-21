package xlong.blogs.web.controller.api;

import xlong.blogs.model.domain.Post;
import xlong.blogs.model.dto.JsonResult;
import xlong.blogs.model.enums.PostTypeEnum;
import xlong.blogs.model.enums.ResponseStatusEnum;
import xlong.blogs.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *     页面API
 * </pre>
 *
 */
@RestController
@RequestMapping(value = "/api/pages")
public class ApiPageController {

    @Autowired
    private PostService postService;

    /**
     * 获取单个页面
     *
     * @param postId postId
     * @return JsonResult
     */
    @GetMapping(value = "/{postId}")
    public JsonResult pages(@PathVariable(value = "postId") Long postId) {
        Post post = postService.findByPostId(postId, PostTypeEnum.POST_TYPE_PAGE.getDesc());
        if (null != post) {
            return new JsonResult(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), post);
        } else {
            return new JsonResult(ResponseStatusEnum.NOTFOUND.getCode(), ResponseStatusEnum.NOTFOUND.getMsg());
        }
    }
}

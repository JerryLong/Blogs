package xlong.blogs.web.controller.api;

import xlong.blogs.model.domain.Post;
import xlong.blogs.model.dto.BlogConst;
import xlong.blogs.model.dto.JsonResult;
import xlong.blogs.model.enums.BlogPropertiesEnum;
import xlong.blogs.model.enums.PostStatusEnum;
import xlong.blogs.model.enums.PostTypeEnum;
import xlong.blogs.model.enums.ResponseStatusEnum;
import xlong.blogs.service.PostService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 *     文章API
 * </pre>
 *
 */
@RestController
@RequestMapping(value = "/api/posts")
public class ApiPostController {

    @Autowired
    private PostService postService;

    /**
     * 获取文章列表 分页
     *
     * @param page 页码
     * @return JsonResult
     */
    @GetMapping(value = "/page/{page}")
    public JsonResult posts(@PathVariable(value = "page") Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "postDate");
        Integer size = 10;
        if (!StringUtils.isBlank(BlogConst.OPTIONS.get(BlogPropertiesEnum.INDEX_POSTS.getProp()))) {
            size = Integer.parseInt(BlogConst.OPTIONS.get(BlogPropertiesEnum.INDEX_POSTS.getProp()));
        }
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<Post> posts = postService.findPostByStatus(PostStatusEnum.PUBLISHED.getCode(), PostTypeEnum.POST_TYPE_POST.getDesc(), pageable);
        if (null == posts) {
            return new JsonResult(ResponseStatusEnum.EMPTY.getCode(), ResponseStatusEnum.EMPTY.getMsg());
        }
        return new JsonResult(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), posts);
    }

    @GetMapping(value = "/hot")
    public JsonResult hotPosts() {
        List<Post> posts = postService.hotPosts();
        if (null != posts && posts.size() > 0) {
            return new JsonResult(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), posts);
        } else {
            return new JsonResult(ResponseStatusEnum.EMPTY.getCode(), ResponseStatusEnum.EMPTY.getMsg());
        }
    }

    /**
     * 获取单个文章信息
     *
     * @param postId 文章编号
     * @return JsonResult
     */
    @GetMapping(value = "/{postId}")
    public JsonResult posts(@PathVariable(value = "postId") Long postId) {
        Post post = postService.findByPostId(postId, PostTypeEnum.POST_TYPE_POST.getDesc());
        if (null != post) {
            return new JsonResult(ResponseStatusEnum.SUCCESS.getCode(), ResponseStatusEnum.SUCCESS.getMsg(), post);
        } else {
            return new JsonResult(ResponseStatusEnum.NOTFOUND.getCode(), ResponseStatusEnum.NOTFOUND.getMsg());
        }
    }
}

package xlong.blogs.web.interceptor;

import xlong.blogs.model.dto.BlogConst;
import xlong.blogs.model.enums.BlogPropertiesEnum;
import xlong.blogs.model.enums.TrueFalseEnum;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 *     API接口拦截器，用户可自己选择关闭或者开启
 * </pre>
 *
 */
@Component
public class ApiInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.equals(TrueFalseEnum.TRUE.getDesc(), BlogConst.OPTIONS.get(BlogPropertiesEnum.API_STATUS.getProp()))) {
            return true;
        }
        response.sendRedirect("/404");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

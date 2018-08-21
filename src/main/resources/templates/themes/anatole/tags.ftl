<#include "module/macro.ftl">
<#if tag??>
    <@head title="${tag.tagName} · ${options.blog_title?default('Blogs')}" keywords="${options.seo_keywords?default('Blogs')}" description="${options.seo_desc?default('Blogs')}"></@head>
<#else>
    <@head title="${options.blog_title?default('Blogs')}" keywords="${options.seo_keywords?default('Blogs')}" description="${options.seo_desc?default('Blogs')}"></@head>
</#if>
<#include "module/sidebar.ftl">
<style>
    .autopagerize_page_element a{
        text-decoration:none;
        padding: 1px 9px;
        margin: 9px 1px;
        line-height: 40px;
        white-space: nowrap;
        transition: .6s;
        opacity: .85;
    }

    .autopagerize_page_element a:hover{
        transition: .6s;
        opacity: 1;
        background: #FAFAFA;
        box-shadow: 0 2px 2px 0 rgba(0,0,0,.14), 0 3px 1px -2px rgba(0,0,0,.2), 0 1px 5px 0 rgba(0,0,0,.12);
    }
</style>
<div class="main">
    <#include "module/page-top.ftl">
    <div class="autopagerize_page_element">
        <div class="content">
                  <@commonTag method="tags">
            <#if tags?? && tags?size gt 0>
                <#list tags as tag>
                    <a href="/tags/${tag.tagUrl}/" style="font-size: 22.33px; color: #757575">${tag.tagName}</a>
                </#list>
            </#if>
        </@commonTag>

        
        </div>
    </div>
</div>
<@footer></@footer>
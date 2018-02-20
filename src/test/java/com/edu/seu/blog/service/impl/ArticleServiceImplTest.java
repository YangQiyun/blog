package com.edu.seu.blog.service.impl;

import com.edu.seu.blog.dataobject.ArticleInfo;
import com.edu.seu.blog.repository.ArticleInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {

    @Autowired
    private ArticleServiceImpl service;

    @Test
    public void findOne() {
        ArticleInfo result=service.findOne(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByArticleTypeLike() {
        List<String> typelist= Arrays.asList("类型");
        List<ArticleInfo> articleInfoList=service.findByArticleTypeLike(typelist);
        Assert.assertEquals(2,articleInfoList.size());
    }

    @Test
    public void save() {
       // ArticleInfo articleInfo=new ArticleInfo();
       // articleInfo.setArticleTitle("这个我觉得可以");
       // articleInfo.setArticleType("类型一");
       /* articleInfo.setArticleContent("<section>\n" +
                "\t\t\t\t\t\t\t\t\t<h3>Text</h3>\n" +
                "\t\t\t\t\t\t\t\t\t<p>This is <b>bold</b> and this is <strong>strong</strong>. This is <i>italic</i> and this is <em>emphasized</em>.\n" +
                "\t\t\t\t\t\t\t\t\tThis is <sup>superscript</sup> text and this is <sub>subscript</sub> text.\n" +
                "\t\t\t\t\t\t\t\t\tThis is <u>underlined</u> and this is code: <code>for (;;) { ... }</code>. Finally, <a href=\"#\">this is a link</a>.</p>\n" +
                "\t\t\t\t\t\t\t\t\t<hr />\n" +
                "\t\t\t\t\t\t\t\t\t<p>Nunc lacinia ante nunc ac lobortis. Interdum adipiscing gravida odio porttitor sem non mi integer non faucibus ornare mi ut ante amet placerat aliquet. Volutpat eu sed ante lacinia sapien lorem accumsan varius montes viverra nibh in adipiscing blandit tempus accumsan.</p>\n" +
                "\t\t\t\t\t\t\t\t\t<hr />\n" +
                "\t\t\t\t\t\t\t\t\t<h2>Heading Level 2</h2>\n" +
                "\t\t\t\t\t\t\t\t\t<h3>Heading Level 3</h3>\n" +
                "\t\t\t\t\t\t\t\t\t<h4>Heading Level 4</h4>\n" +
                "\t\t\t\t\t\t\t\t\t<hr />\n" +
                "\t\t\t\t\t\t\t\t\t<h4>Blockquote</h4>\n" +
                "\t\t\t\t\t\t\t\t\t<blockquote>Fringilla nisl. Donec accumsan interdum nisi, quis tincidunt felis sagittis eget tempus euismod. Vestibulum ante ipsum primis in faucibus vestibulum. Blandit adipiscing eu felis iaculis volutpat ac adipiscing accumsan faucibus. Vestibulum ante ipsum primis in faucibus lorem ipsum dolor sit amet nullam adipiscing eu felis.</blockquote>\n" +
                "\t\t\t\t\t\t\t\t\t<h4>Preformatted</h4>\n" +
                "\t\t\t\t\t\t\t\t\t<pre><code>i = 0;\n" +
                "\n" +
                "while (!deck.isInOrder()) {\n" +
                "  print 'Iteration ' + i;\n" +
                "  deck.shuffle();\n" +
                "  i++;\n" +
                "}\n" +
                "\n" +
                "print 'It took ' + i + ' iterations to sort the deck.';</code></pre>\n" +
                "\t\t\t\t\t\t\t\t</section>");*/

       // ArticleInfo result=service.save(articleInfo);
        //Assert.assertNotNull(result);

    }

    @Test
    public void findAll() {
        PageRequest request=new PageRequest(2,2);

        Page<ArticleInfo> articleInfoList=service.findList(request);
        long a=articleInfoList.getTotalElements();
        long b=articleInfoList.getTotalPages();
        Assert.assertEquals(0,articleInfoList.getContent().size());
    }
}
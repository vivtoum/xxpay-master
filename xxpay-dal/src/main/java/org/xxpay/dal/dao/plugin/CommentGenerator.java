package org.xxpay.dal.dao.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author dingzhiwei jmdhappy@126.com
 * @version V1.0
 * @Description: 生成model中，字段增加注释
 * @date 2017-07-05
 * @Copyright: www.xxpay.org
 */
public class CommentGenerator extends DefaultCommentGenerator {

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        super.addFieldComment(field, introspectedTable, introspectedColumn);
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            addJavadocTag(field, false);
            field.addJavaDocLine(" */");
        }
    }

}

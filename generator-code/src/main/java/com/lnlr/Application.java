package com.lnlr;

import com.lnlr.generator.GeneratorFactory;

/**
 * @author 雷洪飞 on 9:20 2018/1/10.
 * 代码自动生成，根据配置文件生成文件
 */
public class Application {
    public static void main(String[] args) throws Exception {
        GeneratorFactory factory = new GeneratorFactory();
        factory.genJaveTemplate();
    }
}
/**
 * 思路：
 * 1.连接数据库，获取到资源信息
 * <p>
 * 2.利用模板生成代码
 */

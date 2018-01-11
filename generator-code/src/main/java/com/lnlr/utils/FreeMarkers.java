package com.lnlr.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author 雷洪飞 on 14:23 2018/1/10.
 * desc
 */
public class FreeMarkers {
    private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);

    public FreeMarkers() {
    }

    public static String renderString(String templateString, Map<String, ?> model) {
        try {
            StringWriter result = new StringWriter();
            Template t = new Template("name", new StringReader(templateString), configuration);
            t.process(model, result);
            return result.toString();
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }

    public static String renderTemplate(Template template, Object model) {
        try {
            StringWriter result = new StringWriter();
            template.process(model, result);
            return result.toString();
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static Configuration buildConfiguration(String directory) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        Resource path = (new DefaultResourceLoader()).getResource(directory);
        cfg.setDirectoryForTemplateLoading(path.getFile());
        return cfg;
    }

    public static void main(String[] args) throws IOException {
    }

    static {
        configuration.setDefaultEncoding("UTF-8");
        configuration.setDateFormat("yyyy-MM-dd HH:mm:ss");
        configuration.setNumberFormat("#0.#");
    }
}

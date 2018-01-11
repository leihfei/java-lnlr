package com.lnlr.generator;

import com.lnlr.entity.Column;
import com.lnlr.entity.ModelObj;
import com.lnlr.entity.Table;
import com.lnlr.utils.FileType;
import com.lnlr.utils.FileUtils;
import com.lnlr.utils.FreeMarkers;
import com.lnlr.utils.Resources;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author 雷洪飞 on 12:53 2018/1/10.
 * 生成代码
 */
public class GeneratorCode extends AbstractGenerator implements Generator {

    /**
     * 描述省生成的文件相关信息
     */
    private FileType fileType;

    /**
     * 用于匹配是否为java文件
     */
    private final static String GEN_TYPE = ".java";


    public GeneratorCode() {

    }


    /**
     * 读取模板位置
     */
    private void getTemplatePath() throws IOException {
        this.setCfg();
        // 读取模板文件
        this.templatePath = StringUtils.replace(projectPath + "/src/main/resources/template", "/", File.separator);
        // 加载模板
        System.out.println("模板路径：" + this.templatePath);
        this.cfg.setDirectoryForTemplateLoading(new File(this.templatePath));
        // 将model设置新对象
        this.model = new HashMap();
        this.model.put("packageName", Resources.DEFAULT_PACKAGE);
        this.model.put("className", ModelObj.getInstance().getClassName());
        this.model.put("instanceName", StringUtils.uncapitalize(ModelObj.getInstance().getClassName()));
        this.model.put("pknEntity", ModelObj.getInstance().getEntityPackage());
        this.model.put("pknDAO", ModelObj.getInstance().getDaoPackage());
        this.model.put("pknService", ModelObj.getInstance().getServicePackage());
        this.model.put("pknServiceImpl", ModelObj.getInstance().getServiceImplPackage());
        this.model.put("pknController", ModelObj.getInstance().getControllerPackage());
        this.model.put("projectName", this.projectName);
        // 设置作者信息
        this.model.put("author", ModelObj.getInstance().getAuthor());
        this.model.put("tableIdType", ModelObj.getInstance().getTableIdType());
        this.model.put("mappingName", ModelObj.getInstance().getMappingName());

    }


    public GeneratorCode(FileType fileType) {
        this.fileType = fileType;
        // 赋值表名
        this.tableName = ModelObj.getInstance().getTableName();
        try {
            for (this.projectFile = (new DefaultResourceLoader()).getResource("").getFile();
                 !(new File(this.projectFile.getPath() + this.separator + "pom.xml")).exists();
                 this.projectFile = this.projectFile.getParentFile()) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.projectPath = this.projectFile.getAbsolutePath();
        // 对projectPath做处理
        this.javaResourcesPath = StringUtils.replace(projectPath + "/" + ModelObj.getInstance().getModuleName(), "/", this.separator);
        logger.info("javaResources Path: {}", this.javaResourcesPath);
        this.javaPath = StringUtils.replace(projectPath + "/" + ModelObj.getInstance().getModuleName(), "/", this.separator);
        logger.info("javaPath Path: {}", this.javaPath);
    }

    /**
     * 构造函数
     *
     * @param fileType    文件类型
     * @param projectPath 生成文件的根目录
     * @throws Exception
     */
    public GeneratorCode(FileType fileType, String projectPath) throws Exception {
        this(fileType);
        // 会读取模板文件，所以放到这个位置
        getTemplatePath();
        /**
         * 由于本项目的生成文件是需要在三个项目生成，所以projectFile必须由配置文件制定，否者使用这个代码即可
         */
        if (projectPath != null) {
            this.projectPath = projectPath;
        }
        // 对projectPath做处理
        this.javaResourcesPath = StringUtils.replace(projectPath + "/src/main/resources/", "/", this.separator);
        logger.info("javaResources Path: {}", this.javaResourcesPath);
        this.javaPath = StringUtils.replace(projectPath + "/src/main/java/", "/", this.separator);
        logger.info("javaPath Path: {}", this.javaPath);
    }

    public GeneratorCode(FileType fileType, String projectPath, String moduleType) throws Exception {
        this(fileType, projectPath);
        // 对projectPath做处理
        this.javaResourcesPath = StringUtils.replace(projectPath + "/" + ModelObj.getInstance().getModuleName() + moduleType + "/src/main/resources/", "/", this.separator);
        logger.info("javaResources Path: {}", this.javaResourcesPath);
        this.javaPath = StringUtils.replace(projectPath + "/" + ModelObj.getInstance().getModuleName() + moduleType + "/src/main/java/", "/", this.separator);
        logger.info("javaPath Path: {}", this.javaPath);
    }


    /**
     * 根据表名生成数据
     *
     * @param table
     * @throws Exception
     */
    @Override
    public void generator(Table table) throws Exception {
        this.model.put("tableName", table.getTableName().toLowerCase());
        this.model.put("columns", table.getColumns());
        this.model.put("moduleName", ModelObj.getInstance().getModuleName());

        /**
         * 需要得到生成的文件位置
         */
        this.handleSpecial(table.getColumns());
        Template template = this.cfg.getTemplate("tem" + this.separator + this.fileType.getTempleName());
        String content = FreeMarkers.renderTemplate(template, this.model);
        // 待写入的文件全路径
        String filePath;
        if (this.fileType.getPrefxxName().endsWith(GEN_TYPE)) {
            filePath = this.javaPath + fileType.getJavaStorePath() + this.separator + ModelObj.getInstance().getClassName() + this.fileType.getPrefxxName();
            FileUtils.writeFile(content, filePath);
            logger.info(this.fileType.getFileType() + ": {}", filePath);
        }
    }

    /**
     * 生成pom文件
     *
     * @throws Exception
     */
    public void generatePom() throws Exception {
        this.model.put("moduleName", ModelObj.getInstance().getModuleName());
        Template template = this.cfg.getTemplate("tem" + this.separator + this.fileType.getTempleName());
        String content = FreeMarkers.renderTemplate(template, this.model);
        String path = this.javaPath;
        path = path.substring(0, path.indexOf("src") - 1);
        String filePath = path + File.separator + this.fileType.getPrefxxName();
        FileUtils.writeFile(content, filePath);
        logger.info(this.fileType.getFileType() + ": {}", filePath);
    }


    @Override
    public void generator(List<Table> tables) throws Exception {

    }

    /**
     * 基本cfg配置
     */
    private void setCfg() {
        this.cfg = new Configuration(Configuration.VERSION_2_3_27);
        this.cfg.setDefaultEncoding("utf-8");
        this.cfg.setDateFormat("yyyy-MM-dd HH:mm:ss");
        this.cfg.setNumberFormat("#0.#");
    }

    /**
     * 取出列中特殊的数据类型，方便引入包和类型
     * @param columns
     */
    private void handleSpecial(List<Column> columns) {
        boolean hasDate = false;
        boolean hasDateTime = false;
        boolean hasBigDecimal = false;
        Iterator i$ = columns.iterator();
        while (i$.hasNext()) {
            Column column = (Column) i$.next();
            if (column.getJavaType().equals("LocalDateTime")) {
                hasDateTime = true;
            } else if (column.getJavaType().equals("BigDecimal")) {
                hasBigDecimal = true;
            } else if (column.getJavaType().equals("Date")) {
                hasDate = true;
            }
        }
        this.model.put("hasDateTime", hasDateTime);
        this.model.put("hasDate", hasDate);
        this.model.put("hasBigDecimal", hasBigDecimal);
    }
}

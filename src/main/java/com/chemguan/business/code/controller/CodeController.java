package com.chemguan.business.code.controller;


import com.chemguan.business.code.model.CodeSchema;
import com.chemguan.business.code.model.CodeTable;
import com.chemguan.business.code.service.CodeService;
import com.chemguan.business.dbutil.ServiceException;
import com.chemguan.business.dbutil.result.Result;
import com.chemguan.business.dbutil.result.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by sw on 18/10/8.
 */
@Controller
@RequestMapping("code")
public class CodeController {


    @Autowired
    private CodeService codeServiceImpl;

    /**
     * 连接数据库    schema
     * @param codeSchema
     * @return
     */
    @RequestMapping("connectDb")
    @ResponseBody
    public Result connectDb(CodeSchema codeSchema){
        List<CodeTable> result = codeServiceImpl.getCodeTablesBySchema(codeSchema);
        return ResultGenerator.genSuccessResult(result);
    }

    /**
     * 导出code package
     * @return
     */
    @RequestMapping(value = "constructCode")
    @ResponseBody
    public void constructCode(CodeSchema codeSchema, HttpServletResponse response) throws Exception {
        System.out.println(codeSchema);
        //ServletOutputStream out = null;
        //InputStream fin = null;
        //File file = null;
        String path = codeServiceImpl.generateCode(codeSchema);
        //System.out.println(path);
        /*try{
            if(null == path)
                return ;
            file = new File(path);
            //不存在
            if(null == file || !file.exists())
                return ;
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;filename=cyCode.zip");
            out = response.getOutputStream();
            fin = new FileInputStream(file);
            byte[] buffer = new byte[1024];//缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        }catch(Exception ex){
            throw new ServiceException("下载失败!");
        }finally{
            if(fin != null) fin.close();
            if(out != null) out.close();
            file.deleteOnExit();
        }*/
    }

}

package com.chemguan.business.code.service;



import com.chemguan.business.code.model.CodeSchema;
import com.chemguan.business.code.model.CodeTable;

import java.util.List;

/**
 * Created by sw on 18/10/8.
 */
public interface CodeService {


    /**
     * 获取 codesTable 通过 schema
     * @param schema
     * @return
     */
    public List<CodeTable> getCodeTablesBySchema(CodeSchema schema);

    /**
     * 构建代码库
     * @param codeSchema
     * @return
     */
    String generateCode(CodeSchema codeSchema) throws Exception;
}

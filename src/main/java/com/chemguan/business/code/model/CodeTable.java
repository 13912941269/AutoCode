package com.chemguan.business.code.model;

import com.chemguan.business.dbutil.DbColumnModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lcy on 17/7/1.
 *
 * code table
 */
@Data
@NoArgsConstructor
public class CodeTable implements Serializable {


    private static final long serialVersionUID = 1154645476624841358L;

    private String tableName;

    private List<DbColumnModel> listColum;
}

package com.fuyan.office_routine_ms.pojo;

import lombok.Data;

/**
 * 文件表
 */
@Data
public class Files {
    private Integer fileId;
    private String fileName;
    private String fileType;
    private String storageLocation;
    private Integer relatedTask;
    private String filePermission;
    private String filePublisher;
}

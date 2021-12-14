package com.test.solutions;

import java.io.Serializable;
import java.util.List;

public class RepositoryResponse implements Serializable {

    private List<RepositoryInfo> repositoryInfoList;

    public RepositoryResponse() {
    }

    public RepositoryResponse(List<RepositoryInfo> repositoryInfoList) {
        this.repositoryInfoList = repositoryInfoList;
    }

    public List<RepositoryInfo> getRepositoryInfoList() {
        return repositoryInfoList;
    }

    public void setRepositoryInfoList(List<RepositoryInfo> repositoryInfoList) {
        this.repositoryInfoList = repositoryInfoList;
    }
}

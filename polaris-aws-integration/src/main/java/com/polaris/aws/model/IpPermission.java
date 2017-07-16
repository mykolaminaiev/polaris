package com.polaris.aws.model;

import java.util.List;

/**
 * Created by Serhii_Nosko on 2016.
 */
public class IpPermission {

    private String ipProtocol;

    private Integer fromPort;

    private Integer toPort;

    private List<String> rangesList;

    public IpPermission(String ipProtocol, Integer fromPort, Integer toPort, List<String> rangesList) {
        this.ipProtocol = ipProtocol;
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.rangesList = rangesList;
    }

    public String getIpProtocol() {
        return ipProtocol;
    }

    public Integer getFromPort() {
        return fromPort;
    }

    public Integer getToPort() {
        return toPort;
    }

    public List<String> getRangesList() {
        return rangesList;
    }
}

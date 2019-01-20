package org.sot.models.wrappers;

import java.util.List;

/**
 *
 * @author Jordan
 */
public class PointComponentsRequest {

    private String pointId;
    private List<String> sensorsId;
    private List<String> controlBoardsId;

    public PointComponentsRequest() {
    }
    
    public PointComponentsRequest(String pointId, List<String> sensorsId, List<String> controlBoardsId) {
        this.pointId = pointId;
        this.sensorsId = sensorsId;
        this.controlBoardsId = controlBoardsId;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public List<String> getSensorsId() {
        return sensorsId;
    }

    public void setSensorsId(List<String> sensorsId) {
        this.sensorsId = sensorsId;
    }

    public List<String> getControlBoardsId() {
        return controlBoardsId;
    }

    public void setControlBoardsId(List<String> controlBoardsId) {
        this.controlBoardsId = controlBoardsId;
    }

}

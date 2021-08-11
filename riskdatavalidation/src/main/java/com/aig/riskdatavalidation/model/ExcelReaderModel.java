package com.aig.riskdatavalidation.model;

public class ExcelReaderModel {

    public String v2Xpath;
    public String v4keyPath;
    public String v4Xpath;
    public String formula;

    public String getV2Xpath() {
        return v2Xpath;
    }

    public void setV2Xpath(String v2Xpath) {
        this.v2Xpath = v2Xpath;
    }

    public String getV4keyPath() {
        return v4keyPath;
    }

    public void setV4keyPath(String v4keyPath) {
        this.v4keyPath = v4keyPath;
    }

    public String getV4Xpath() {
        return v4Xpath;
    }

    public void setV4Xpath(String v4Xpath) {
        this.v4Xpath = v4Xpath;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    @Override
    public String toString() {
        return "ExcelReaderModel{" +
                "v2Xpath='" + v2Xpath + '\'' +
                ", v4keyPath='" + v4keyPath + '\'' +
                ", v4Xpath='" + v4Xpath + '\'' +
                ", formula='" + formula + '\'' +
                '}';
    }
}

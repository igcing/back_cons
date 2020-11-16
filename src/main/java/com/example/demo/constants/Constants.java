package com.example.demo.constants;

public class Constants{
    public final static String ID_REGION = "7";
    public final static String TAG_REGION = "reg_id";
    public final static String EXPREG_CLEAN_ID = "( {0,1}(selected){0,1}>(.*?)<\\/option>)";
    public final static String EXPREG_CLEAN_VALUE = "(<option value='(.*?)'( selected){0,}>)?";
    public final static String EXPREG_CLEAN_SELECT=  "( selected>){0,1}>{0,1}";
    public final static String EXPREG_CLEAN_VALEU_EQUAL = "value=";
    public final static String TAG_OPEN_OPTION="<option";
    public final static String TAG_CLOSE_OPTION = "</option>";
    public final static String ENDPOINT_COMUNA_CONTROLLER = "/search/comuna";
    public final static String ENDPOINT_FARMACIA_CONTROLLER = "/search/farmacia/";
    public final static String ENDPOINT_FARMACIA_FILTER = "/{idRegion}/filter";
}